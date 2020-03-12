package com.education.system_edu.shiro;

import com.education.system_edu.mapper.ConnectUserAndRoleMapper;
import com.education.system_edu.mapper.SysNodeMapper;
import com.education.system_edu.mapper.SysPermissionMapper;
import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Resource
    UserMapper userMapper;
    @Resource
    ConnectUserAndRoleMapper connectUserAndRoleMapper;
    @Resource
    SysNodeMapper sysNodeMapper;
    @Resource
    SysPermissionMapper sysPermissionMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        System.out.println("—————————————————shiro验证域启动—————————————————");
        System.out.println("进行验证域==》" + token);
        System.out.println("—————————————————shiro验证域启动—————————————————");
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //2. 从 UsernamePasswordToken 中来获取 username
        String userLoginCode = usernamePasswordToken.getUsername();
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        UserExample userForSearch = new UserExample();
        userForSearch.createCriteria().andLoginCodeEqualTo(userLoginCode);

        User user = null;

        List<User> users = userMapper.selectByExample(userForSearch);
        if (users.size() != 0) {
            user = users.get(0);
            System.out.println("User存在 ");
        }
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常

        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.

        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo

        if (null != user) {
            //以下信息是从数据库中获取的.
            //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
            Object principal = user;
            //2). credentials: 密码.
            Object credentials = user.getPassword();
            //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
            String realmName = getName();
            //4). 盐值.
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getCode());
            return new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        }
        return null;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("—————————————————shiro授权启动—————————————————");
        /**
         * //1. 从 PrincipalCollection 中来获取登录用户的信息,这里是LoginCode
         *
         *         String principal = (String) principalCollection.getPrimaryPrincipal();
         */
        //现在改为User
        User principal = (User) principalCollection.getPrimaryPrincipal();
        //2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
        //(1).获取用户
        UserExample userForSearch = new UserExample();
        userForSearch.createCriteria().andLoginCodeEqualTo(principal.getLoginCode());
        User user = userMapper.selectByExample(userForSearch).get(0);
        //(2).获取角色
        ConnectUserAndRoleExample connectUserAndRoleForSearch = new ConnectUserAndRoleExample();
        connectUserAndRoleForSearch.createCriteria().andUseCodeEqualTo(user.getCode()).andSysRoleNodeTypeEqualTo((short) 1);
        List<ConnectUserAndRole> connectUserAndRoles = connectUserAndRoleMapper.selectByExample(connectUserAndRoleForSearch);
        SysNodeExample sysNodeForSearch;
        Set<String> roles = new HashSet<>();//装载所有角色名的集合
        List<SysNode> sysNodeRoles = new ArrayList<>();//装载所有角色的集合
        for (ConnectUserAndRole connectUserAndRole : connectUserAndRoles) {
            sysNodeForSearch = new SysNodeExample();
            sysNodeForSearch.createCriteria().andCodeEqualTo(connectUserAndRole.getSysRoleNodeCode());
            List<SysNode> sysNodeRolesForSearch = sysNodeMapper.selectByExample(sysNodeForSearch);
            if (null != sysNodeRolesForSearch) {
                sysNodeRoles.addAll(sysNodeRolesForSearch);
                //(3).放入set
                for (SysNode sysNodeRole : sysNodeRolesForSearch) {
                    roles.add(sysNodeRole.getName());
                    System.out.println("授权获取到的role==》" + sysNodeRole.getName());
                }
            }

        }
        //4. 设置权限属性
        Set<String> permissions = new HashSet<>();
        //(1).获取权限
        SysPermissionExample sysPermissionForSearch;
        for (SysNode sysNodeRole : sysNodeRoles) {
            sysPermissionForSearch = new SysPermissionExample();
            sysPermissionForSearch.createCriteria().andRoleCodeEqualTo(sysNodeRole.getName());
            List<SysPermission> sysPermissions = sysPermissionMapper.selectByExample(sysPermissionForSearch);
            if (sysPermissions.size() > 0) {
                for (SysPermission sysPermission : sysPermissions) {
                    permissions.add(sysPermission.getName());
                    System.out.println("授权获取到的Permission==》" + sysPermission.getName());
                }
            }

        }
        //3. 创建 SimpleAuthorizationInfo, 并设置其 roles 属性.
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        //(2).权限加入info
        simpleAuthorizationInfo.setStringPermissions(permissions);
        //5. 返回 SimpleAuthorizationInfo 对象.
        System.out.println("—————————————————shiro授权启动—————————————————");
        return simpleAuthorizationInfo;
    }


    //shiro加密策略
    public void addMd5CredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

}
