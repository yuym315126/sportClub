package com.sport.common.util;

import java.util.Random;

/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-28 17:15
 */
public class NumUtil {
    /**
     * 生成指定位数的随机数字
     * @param len 位数*/
    public static int createNum(int len){
        Random random=new Random();
        //len ==4  1000-9999
        //0-8999 -->0-9000
        int max=(int)(Math.pow(10,len)- Math.pow(10,len-1));

        return random.nextInt(max)+(int) Math.pow(10,len-1);
    }
}
