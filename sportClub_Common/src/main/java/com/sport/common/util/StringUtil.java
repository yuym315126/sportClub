package com.sport.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-28 20:09
 */
public class StringUtil {
    /**
     * 校验字符串
     * @param strs 待校验的内容
     * @return  非空：true 有空：false*/
    public static boolean isnoEmpty(String... strs){
        boolean r=true;
        for(String s:strs){
            if(s==null || s.length()==0){
                r=false;
                break;
            }
        }
        return r;
    }

    /**
     * 校验手机号是否合法
     * @param phone 手机号
     * @return true 合法   false 不合法
     */
    public static boolean checkPhone(String phone){
        String strPhone = phone.replace(" ", "");

        if(null==strPhone || !isnoEmpty(strPhone)){
            return false;
				/*^匹配开始地方$匹配结束地方，[3|4|5|7|8]选择其中一个{4,8},\d从[0-9]选择
				{4,8}匹配次数4~8	，java中/表示转义，所以在正则表达式中//匹配/,/匹配""*/
            //验证手机号码格式是否正确
        }else if(!strPhone.matches("^1[3|4|5|7|8][0-9]\\d{4,8}$")){
            //System.out.println("手机号输入有误，请重新输入");
            return false;
        }else{
            //System.out.println("恭喜您中奖了");
            return true;
        }

    }

    /**
     * 去除字符串中的引号
     * @param str 原字符串
     * @return 去掉引号后的字符串
     */
    public static String removeQuotationMarks(String str){
        return str.replace("\"","");
    }

    /**
     * 校验密码是否合法 (8-20位  必须包含字母数字)
     * @param password
     * @return
     */
    public static boolean checkPwd(String password) {
        Pattern Password_Pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(.{8,20})$");

        Matcher matcher = Password_Pattern.matcher(password);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }



    /**
     * 处理从redis中取的格式违规的json  去除前后引号  去除转义斜杠
     * @param workerStr
     * @return
     */
    public static String jsonHandle(String workerStr) {
        workerStr=workerStr.substring(1,workerStr.length()-1);
        workerStr=workerStr.replace("\\","");
        return workerStr;
    }
}
