package com.education.system_edu.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class EncryptionUtils {
    /**
     * 加密
     * @param hashAlgorithmName 加密方式
     * @param password 密码
     * @param salt 盐值
     * @return
     */
    public static Object encryption(String hashAlgorithmName,Object password,Object salt){
        int hasIterations = 1024;
        return new SimpleHash(hashAlgorithmName,password,salt,hasIterations);
    }

    public static void main(String[] args) {
        System.out.println(encryption("MD5","123456","20000000"));
    }
}
