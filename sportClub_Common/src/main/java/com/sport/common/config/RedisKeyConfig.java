package com.sport.common.config;

/**
 * @program: voter
 * @description:设置登录令牌在redis中存储的有效期
 */
public class RedisKeyConfig {
    //用户令牌
    public static final String PHONE_TOKEN_USER="dengdeng:user:phone:";//令牌后面追加手机号 值存储令牌
    public static final String TOKEN_USER="dengdeng:user:token:";//后面追加令牌 值存储用户信息

    // 跑男令牌
    public static final String PHONE_TOKEN_WORKER="dengdeng:worker:phone:";//令牌后面追加手机号 值存储令牌
    public static final String TOKEN_WORKER="dengdeng:worker:token:";//后面追加令牌 值存储用户信息

    // 账号冻结
    public static final String PHONE_FOR="dengdeng:for:phone:";//后面跟手机号 冻结的账号
    //记录登录输错的手机号，在10分钟内有效期，只要次数超过三次name就会将手机号进行封号处理
    public static final String PHONE_ERROR="dengdeng:error:phone:";//后面跟手机号和时间戳

    //有效期
    public static final int TOKEN_TIME=30*60*60; //令牌有效期 单位秒
    public static final int TOKENFOR_TIME=30*60; //冻结账号 单位秒
    public static final int PHONERROR_TIME=10*60; //错误的有效期 单位秒
}
