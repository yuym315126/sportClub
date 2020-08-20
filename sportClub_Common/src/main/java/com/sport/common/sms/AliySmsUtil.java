package com.sport.common.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: OpenMain
 * @description: 基于阿里云的短信发送
 * @author: Feri(邢朋辉)
 * @create: 2020-07-28 17:01
 */
@Slf4j
public class AliySmsUtil {
    private static String key="LTAI4FzVhyrQc8eKH4ifkE1A";
    private static String keysecret="zGUzvaDe6MeLEv4QeABML1ypEn3p22";
    /**
     * 注册验证码
     * @param phone 手机号
     * @param code 验证码*/
    public static boolean sendSmsCode(String phone, int code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                key, keysecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "噔噔验证");
        request.putQueryParameter("TemplateCode", "SMS_199220602");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info(response.getData());
            return true;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 登录验证码
     * @param phone 手机号
     * @param code 验证码
     */
    public static boolean sendSmsLoginCode(String phone, int code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                key, keysecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "噔噔验证");
        request.putQueryParameter("TemplateCode", "SMS_199220821");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info(response.getData());
            return true;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 密码找回验证码
     * @param phone 手机号
     * @param code 验证码*/
    public static boolean sendSmsFindCode(String phone, int code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                key, keysecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "噔噔验证");
        request.putQueryParameter("TemplateCode", "SMS_199195836");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info(response.getData());
            return true;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }

}
