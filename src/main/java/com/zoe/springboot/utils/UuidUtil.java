package com.zoe.springboot.utils;

import java.util.UUID;

/**
 * Created by zoe on 2017/12/2.
 */
public class UuidUtil {

    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
