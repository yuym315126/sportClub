package com.sport.common.util;

import java.util.Random;

/**
 * @program: voter
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-17 12:14
 */
public class FileUtil {
    public static String rename(String fn){
        if(StringUtil.isnoEmpty(fn)){
            if(fn.length()>30){
                fn=fn.substring(fn.length()-30);
            }
            fn=System.currentTimeMillis()+"_"+new Random().nextInt(1000)+"_"+fn;
            return fn;
        }else {
            return null;
        }
    }
}
