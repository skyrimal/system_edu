package com.education.system_edu.utils;

import java.util.UUID;

/**
 * 生成UU3D的Code
 */
public class UU3D {
    public static String uu3d(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
