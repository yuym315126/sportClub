package com.sport.common.until;

import java.util.UUID;


public class TokenUtil {
    /**
     * 用于生成一个令牌，保证唯一性
     * @param uid 编号
     * @return String类型,UUID
     */
    public static String createToken(int uid){
        return UUID.randomUUID().toString().replaceAll("-","")+"_"+uid;
    }
}
