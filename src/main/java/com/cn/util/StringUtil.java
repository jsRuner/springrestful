package com.cn.util;

public class StringUtil {
    public static Boolean isNotEmpty(String str){
        return (null==str || "".equals(str))?false:true;
    }
}
