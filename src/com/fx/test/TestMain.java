package com.fx.test;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap; 
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.fx.test.HttpUtils;
import com.fx.test.MD5;
import com.fx.test.SymmtricCryptoUtil;


public class TestMain {


    private static String url = "http://mtest.dianpayer.com:8088/gateway.do";
    //static String url1 = "https://m.dianpayer.com/gateway.do";
    static String url1 = "http://localhost:7000/gateway.do";


    public static void main(String[] args) throws IOException, GeneralSecurityException, JSONException {
    	//微信支付推送订单
    	pushOrder();

       /* String partnerId = "999999000000011";
        String signKey = "12ejiofaioumghoaiuid";
        String encKey = "adf924jmvbjwuoeriuywpxcf";
        String version = "2.1";
        String serviceType = "testCard";*/

        /**
         * 请求业务参数
         */
       /* Map<String, String> request = new HashMap<String, String>(1);
        StringBuilder outSb = new StringBuilder();

        request(partnerId,
                url1,
                serviceType,
                encKey,
                signKey,
                version,
                request,
                outSb);

        System.out.println(outSb.toString());*/
    }


    public static int request(String partnerId,
                              String url,
                              String serviceType,
                              String encKey,
                              String signKey,
                              String version,
                              Map request,
                              StringBuilder outSb) throws UnsupportedEncodingException, GeneralSecurityException, JSONException {


        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("random", "1213");
        treeMap.put("version", version);
        treeMap.put("encoding", "utf-8");
        treeMap.put("partnerId", partnerId);
        treeMap.put("service_type", serviceType);
 //encoding=utf-8&partnerId=111222333444555&random=1213&request_json=eThK6E7jc2Y=&service_type=pushOrder&version=2.1&99988888812121255544
 //encoding=utf-8&partnerId=111222333444555&payType=wx&random=1213&request_json=eThK6E7jc2Y=&service_type=pushOrder&version=2.1&99988888812121255544
        JSONObject jsonObject = new JSONObject();

        for (Object key : request.keySet()) {

            if (request.get(key) != null) {
                jsonObject.put(key.toString(), request.get(key).toString());
            }
        }

        String resultStr = jsonObject.toString();
        String tmp = decryptOrEncrypt(resultStr, encKey, true, "utf-8");
        treeMap.put("request_json", tmp);
        treeMap.put("sign", getSignData(treeMap, signKey));
        return HttpUtils.sendRequest(url, treeMap, outSb);
    }

    public static String decryptOrEncrypt(String data, String key, boolean isEnc, String charset)
            throws UnsupportedEncodingException, GeneralSecurityException {

        return SymmtricCryptoUtil.decryptOrEncrypt(data, key,
                isEnc, charset);


    }

    public static String getSignData(TreeMap<String, String> treeMap, String signKey) {
        Set<String> keySet = treeMap.keySet();
        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            if (!key.equalsIgnoreCase("sign")) {
                String value = treeMap.get(key);
                if (StringUtils.isNotBlank(value))
                    sb.append(key).append("=").append(value).append("&");
            }
        }
        sb.append(signKey);
        String str = sb.toString();
        System.out.println(str);
        return MD5.md5Encode(str, "utf-8");

    }

    /**
     * 测试系统接口
     * 测试接口
     */
    public static void test() {
        Map<String, String> request = new HashMap<String, String>();
        request.put("encoding", "utf-8");
        request.put("partnerId", "123456123456789");
        request.put("random", "979");
        request.put("request_json", "/rlZt9RkL8s=");
        request.put("service_type", "testCard");
        request.put("sign", "bdb257d4b0e43af615f80842f9008200");
        request.put("version", "2.1");

        StringBuilder outSb = new StringBuilder();
        HttpUtils.sendRequest(url1, request, outSb);

        System.out.println(outSb.toString());

    }
    
    
    /**
     * 微信支付测试系统接口
     * 测试接口
     * @throws GeneralSecurityException 
     * @throws UnsupportedEncodingException 
     * @throws JSONException 
     */
    public static void pushOrder() throws JSONException, UnsupportedEncodingException, GeneralSecurityException {
    	System.out.println ("abc");
    	String partnerId = "111222333444555";
        String signKey = "99988888812121255544";
        String encKey = "111222333444555666777888";
        String version = "2.1";
        String serviceType = "pushOrder";
          
        /**
         * 请求业务参数
         */
        Map<String, String> request = new HashMap<String, String>();
 
        request.put("amount", "150");
        request.put("payType", "wx");
        request.put("orderId", System.currentTimeMillis()+"");
        request.put("businessTime", System.currentTimeMillis()+"");
        request.put("notifyUrl", "http://localhost:7000");
        request.put("orderDesc", "微信支付订单");
        request.put("merchantId", "99911010019");
        request.put("merchantName", "微信机构");
        StringBuilder outSb = new StringBuilder();

        request(partnerId,
                url1,
                serviceType,
                encKey,
                signKey,
                version,
                request,
                outSb);

        System.out.println(outSb.toString());

    }
    

    /**
     * 生成随机串
     *
     * @param len
     * @return
     */
    public static String genRandomStr(int len) {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        //  ascii  数字 [48-57]  字母  [65-90] [97-122]
        for (int i = 0; i < len; i++) {
            int r = Math.abs(random.nextInt(128));
            char c = 0;
            if (r < 58) {
                c = (char) (r % 10 + 48);
            } else if (r < 91) {
                c = (char) (r % 26 + 65);
            } else {
                c = (char) (r % 26 + 97);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
