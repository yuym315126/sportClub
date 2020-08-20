package com.sport.common.baidu;

import com.baidu.aip.contentcensor.AipContentCensor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: OpenMain
 * @description: 敏感过滤  审核
 * @author: Feri(邢朋辉)
 * @create: 2020-07-28 19:52
 */
@Slf4j
public class CensorUtil {
    //设置APPID/AK/SK
    public static final String APP_ID = "21698519";
    public static final String API_KEY = "GLWnvESGVbkXIAdme2GXabYc";
    public static final String SECRET_KEY = "T1et7B05QTVNpFijXXiE4ulPM6f3Sc2h";

    private static AipContentCensor contentCensor;
    static {
        contentCensor=new AipContentCensor(APP_ID,API_KEY,SECRET_KEY);
    }
    /**
     * 实现文本敏感词过滤
     * @param msg 需要审核的文本内容
     * */
    public static boolean checkText(String msg){
        if(msg!=null && msg.length()>0) {
            JSONObject response = contentCensor.textCensorUserDefined(msg);
            log.info("文本审核结果："+response.getString("conclusion"));
            if(response.getInt("conclusionType")==1){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }
    /**
     * 图片 审核
     * @param data 图片的内容*/
    public static boolean checkImg(byte[] data){
        if(data!=null && data.length>0){
            JSONObject object=contentCensor.imageCensorUserDefined(data,null);
            log.info("图像审核结果："+object.getString("conclusion"));
            if(object.getInt("conclusionType")==1){
                return true;
            }else {
                return false;
            }
        }else {
            return true;
        }
    }



    public static void main(String[] args) throws IOException {
        String str="免费翻墙";
        System.out.println(checkText(str));
        FileInputStream fis=new FileInputStream(new File("H:\\图片\\Feri交流圈.png"));
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] arr=new byte[1024];
        int len;
        while ((len=fis.read(arr))!=-1){
            baos.write(arr,0,len);
        }
        System.out.println("图片审核---"+checkImg(baos.toByteArray()));

    }
}
