package com.sport.common.baidu;

import com.baidu.aip.ocr.AipOcr;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: OpenMain
 * @description: 基于百度AI识别封装的操作  识别
 * @author: Feri(邢朋辉)
 * @create: 2020-07-29 17:08
 */
@Slf4j
public class OcrUtil {
    //设置APPID/AK/SK
    public static final String APP_ID = "21864047";
    public static final String API_KEY = "dAGwTVPxT7Z8eZ32kBm4bYVW";
    public static final String SECRET_KEY = "y0fMiblBdnGbC7UHTESAo7PXuweUvBEE";

    private static AipOcr ocr;
    static {
        ocr=new AipOcr(APP_ID,API_KEY,SECRET_KEY);
    }
    //身份证识别
    public static Map<String, String> idcard(byte[] data){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "true");
        JSONObject res = ocr.idcard(data, "front", options);

        HashMap<String, String> map = new HashMap<>();
        if("normal".equals(res.getString("image_status"))){
            String cardNo = res.getJSONObject("words_result").getJSONObject("公民身份号码").getString("words");
            String name = res.getJSONObject("words_result").getJSONObject("姓名").getString("words");

            map.put("cardNo", cardNo);
            map.put("name", name);

            return map;
        }else {
            log.error("身份证识别识别："+res.getString("image_status"));
            return null;
        }
    }

    //营业执照识别
    public static String busine(byte[] data){
        JSONObject res=ocr.businessLicense(data, new HashMap<>());
        return res.getJSONObject("words_result").getJSONObject("证件编号").getString("words");
    }

}
