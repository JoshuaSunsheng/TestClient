package com.fx.test;

import com.gd.magic.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class SnapPayTestMain {


    static boolean isTest = true;
//    private static String testUrl = "http://wx.dianpayer.com/gateway.do";
//    private static String testUrl = "http://localhost:9088/gateway.do";
//    private static String testUrl = "http://localhost:9089/gateway.do";
//    private static String testUrl = "http://localhost:9087/new_gateway.do";
    private static String testUrl = "http://localhost:9089/new_gateway.do";
//    private static String testUrl = "http://localhost:9090/d/gateway/";
//    private static String testUrl = "http://180.168.215.67:8089/d/gateway/";
//    static String scUrl1 = "https://wenotice.mpay.cn/gateway.do";
//    static String scUrl1 = "https://wenotice.mpay.cn/new_gateway.do";
    	static String scUrl1 = "https://pay.foreseenewmedia.com/new_gateway.do";
//    private static String scUrl1 = "https://mastercard.mpay.cn/d/gateway/";

    //    	static String scUrl1 = "http://httpslb-1872591155.cn-northwest-1.elb.amazonaws.com.cn:81/new_gateway.do";
    //
    public static void main(String[] args) throws IOException,
            GeneralSecurityException, JSONException {
        OuterPushOrder();


    }

    public static void OuterPushOrder() throws JSONException, UnsupportedEncodingException, GeneralSecurityException, UnknownHostException {

        String partnerId = "";
        String signKey = "";
        String encKey = "";
        String merchantId = "";
        String notifyUrl = "";
        String url1 = "";

        if (isTest) {
            /*
			* 测试二
			* */
//			notifyUrl = "https://www.baidu.com/";
//			url1 = testUrl;
//			partnerId = "021888888888888";
//			signKey = "hyabcd2k1Lhj2lviil9s";
//			encKey = "1234kim5ty7895kzJiop3698";
//			merchantId = "900000000000255";

//            partnerId = "999001000131111";
//            signKey = "uJZN6wompvR8SpzMIUUX";
//            encKey = "1M2gjsuRhwbbONHR2d3nIlgO";
//            merchantId = "999001000131111";

            //微信支付
//            partnerId = "111222333444555";
//            signKey = "99988888812121255544";
//            encKey = "111222333444555666777888";
//            merchantId = "99911010019";


            //益鑫科技有限公司
//            partnerId = "900029000000354";
//            signKey = "h7jjcXPx7n2bmtK7L3mb";
//            encKey = "GFChiyGMZpNN8fiCr7WbsZSM";
//            merchantId = "900029000000354";


            //900029000002554
//            partnerId = "900029000002554";
//            signKey = "CyVZmE9mtbNdhrStA8UH";
//            encKey = "6E12Dhbq9M7Fk3MhyfMZ6dmm";
//            merchantId = "900029000002554";

            //新接口测试 N2
            partnerId = "100000000000000";
            signKey = "h7jjcXPx7n2bmtK7L3mb";
            encKey = "PzBpCDXBmx2icEeJ7i8baz32";
            merchantId = "99911010019";

            notifyUrl = "https://www.baidu.com";

            url1 = testUrl;
        } else {
            notifyUrl = "https://www.baidu.com/";
            url1 = scUrl1;


            //微收单-易生测试
            partnerId = "900029000021348";
            signKey = "GqiuuE9HbPRsqdqHsZvJ";
            encKey = "WgUIMjbHCcxiUgAtbZFR2TlK";
            merchantId = "900029000021348";



            //snappay 高
            partnerId = "900049100018639";
            signKey = "VALocjLCQ12WoLeVy1lr";
            encKey = "rkf0fPQFOHmEBFbreiMjXhIi";
            merchantId = "900049100018639";

            //snappay snappay
            partnerId = "900010000018964";
            signKey = "GeEhADcZl75ycvV80yuQ";
            encKey = "rkf0fPQFOHmEBFbreiMjXhIi";
            merchantId = "900010000018964";


            //snappay 安大略大学
//            partnerId = "900010000018650";
//            signKey = "HKEg0kKWU9nEWFZQPkhQ";
//            encKey = "WVImeEQBuvRNG5OX2T0b4zLZ";
//            merchantId = "900010000018650";

        }
        // 微信支付推送订单
        pushOrder(partnerId, signKey, encKey, merchantId, notifyUrl, url1);

        // 微信支付查询订单
//        queryOrder(partnerId,signKey,encKey,merchantId,url1);

        // 通知商户交易
        //notifyMerchant(partnerId,signKey,encKey,merchantId,notifyUrl);

    }

    /**
     * @param src
     * @throws IOException
     * @throws GeneralSecurityException
     * @throws JSONException
     */
    public static void md5Encode(String src) throws IOException,
            GeneralSecurityException, JSONException {
        String tmp = MD5.md5Encode(src, "utf-8");
        System.out.println(tmp);
    }

    /**
     * 3des
     * 解密
     *
     * @param src
     * @param key
     */
    public static void decrypt(String src, String key) throws IOException,
            GeneralSecurityException, JSONException {
        String tmp = decryptOrEncrypt(src, key, false, "utf-8");
        System.out.println(tmp);
    }

    /**
     * 3des
     * 加密
     *
     * @param src
     * @param key
     */
    public static void encrypt(String src, String key) throws IOException,
            GeneralSecurityException, JSONException {
        String tmp = decryptOrEncrypt(src, key, true, "utf-8");
        System.out.println(tmp);
    }


    public static int request(String partnerId, String url, String serviceType,
                              String encKey, String signKey, String version, Map request,
                              StringBuilder outSb, int type) throws UnsupportedEncodingException,
            GeneralSecurityException, JSONException {

        request.put("sign", calcSign(request, signKey, 1));

        System.out.println(request);
        System.out.println(url);
        return HttpUtils.sendRequest(url, request, outSb);
    }

    public static String decryptOrEncrypt(String data, String key,
                                          boolean isEnc, String charset) throws UnsupportedEncodingException,
            GeneralSecurityException {

        return SymmtricCryptoUtil.decryptOrEncrypt(data, key, isEnc, charset);
    }

    public static Map<String, String> paraFilter(Map<String, String> stringMap) {
        HashMap result = new HashMap(stringMap.size());
        if(stringMap != null && stringMap.size() > 0) {
            Iterator i$ = stringMap.keySet().iterator();

            while(i$.hasNext()) {
                String key = (String)i$.next();
                String value = (String)stringMap.get(key);
                if(value != null && !value.equals("") && !"null".equals(value) && !key.equalsIgnoreCase("sign") && !key.equalsIgnoreCase("sign_type")) {
                    result.put(key, value);
                }
            }

            return result;
        } else {
            return result;
        }
    }

    public static String calcSign(Map<String, String> sPara, String key, int type) {
        Map request = paraFilter(sPara);
        String prestr = createLinkString(request);

        prestr = prestr + key;

//        prestr= "amount=1&business_time=2017-12-12 05:38:57&input_charset=UTF-8&merchant_id=900010000018650&notify_url=http://pay.snappay.ca/notifyurl&order_desc=iPhone&order_id=RbtKtvRzkSKNCYgUxLDTtPP73&partner=900010000018650&pay_type=aliPay&service=push&version=N2HKEg0kKWU9nEWFZQPkhQ";

        System.out.println(String.format("[signData] [%s]", new Object[]{prestr}));
        String mysign = "";
        if(type == 1) {
            mysign = DigestUtils.md5Hex(prestr);
        } else if(type == 3) {
            mysign = DigestUtils.shaHex(prestr);
        } else {
            System.out.println(type + " not support sign_type!");
        }

        return mysign;
    }

    public static String createLinkString(Map<String, String> params) {
        ArrayList keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        StringBuilder builder = new StringBuilder();

        int end;
        for(end = 0; end < keys.size(); ++end) {
            String key = (String)keys.get(end);
            String value = (String)params.get(key);
            builder.append(String.format("%s=%s&", new Object[]{key, value}));
        }

        end = builder.length();
        end = end > 0?end - 1:end;
        return builder.substring(0, end);
    }

    public static String getSignData(TreeMap<String, String> treeMap,
                                     String signKey) {
        Set<String> keySet = treeMap.keySet();
        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            if (!key.equalsIgnoreCase("sign")) {
                String value = treeMap.get(key);
                if (StringUtils.isNotBlank(value)){
                    sb.append(key).append("=").append(value).append("&");
                }
            }
        }
//        sb.append(signKey);
        String str = sb.toString();
        if(treeMap.get("version") == "N2"){
            str = str.substring(0, str.length()-1);
        }
        str = str + signKey;

        System.out.println("sgin data -->" + str);
        String ret = MD5.md5Encode(str, "utf-8");
        System.out.println("sgin value-->" + ret);
        // String aaa
        // ="encoding=utf-8&partnerId=111222333444555&random=dd8c0547a9f84e90ad8a94348b24c9fc&request_json=UjiMadoVstTz2BFqL6xLwwuRihkXGEUjltJRATATLperke1sdopahyMedGz1xhOOA3MYFHTZmDyFnWCew24jFAwQVmBxn59Q9kym23OrP2nCg72xF5Crpmcfk2eBre50btzoofwljwrGcnBZEf0Iy6sH53MsrT9je4JXhqs15VSrUIzIjJ7dWrS7GaWmqC5Whr+tnxzE7P3jkZsjSNYyglU3JK2uQaJtxTV4EdiUG0wUejW9h3C5RPAaquQ/WMbF70Fx+TIzug/clSficVZ9Yb6Lm8IG/fsNH1Xqw8fnilVcPf78ceOs/3ZCpIKru3suFUGoMieDCBbC3qDYT2JALQ==&service_type=pushOrder&version=2.1&99988888812121255544";
        // System.out.println(MD5.md5Encode(aaa, "utf-8"));
        return ret;
    }

    /**
     * 测试系统接口 测试接口
     */
    public static void test() {

//
//		Map<String, String> request = new HashMap<String, String>();
//		request.put("encoding", "utf-8");
//		request.put("partnerId", "123456123456789");
//		request.put("random", "979");
//		request.put("request_json", "/rlZt9RkL8s=");
//		request.put("service_type", "testCard");
//		request.put("sign", "bdb257d4b0e43af615f80842f9008200");
//		request.put("version", "2.1");
//
//		StringBuilder outSb = new StringBuilder();
//		HttpUtils.sendRequest(testUrl, request, outSb);
//
//		System.out.println(outSb.toString());

    }

    /**
     * 微信支付测试系统接口 测试接口
     *
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     * @throws JSONException
     */
    public static void notifyMerchant(String partnerId, String signKey,
                                      String encKey, String merchantId, String notifyUrl)
            throws JSONException, UnsupportedEncodingException,
            GeneralSecurityException {
        System.out.println("notifyMerchant begin");
        String version = "2.1";
        String serviceType = "notify";
        /**
         * 请求业务参数
         */
        Map<String, String> request = new HashMap<String, String>();

        request.put("amount", "2");
        request.put("orderNo", "2016051500012415");
        request.put("codeStr", "weixin://wxpay/bizpayurl?pr=VzPgpdw");
        request.put("tradeStatus", "3");
        request.put("errCode", "00");
        request.put("errCodeDes", "支付成功");
        request.put("orderId", "20160515232303839945310001");
        request.put("merchantId", merchantId);
        request.put("merchantName", "pay");
        StringBuilder outSb = new StringBuilder();

        request(partnerId, notifyUrl, serviceType, encKey, signKey, version,
                request, outSb, 1);

        System.out.println("notifyMerchant end:" + outSb.toString());
    }

    static String prefix = "result_json=";

    /**
     * 微信支付测试系统接口 测试接口
     *
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     * @throws JSONException
     */
    public static void pushOrder(String partnerId, String signKey,
                                 String encKey, String merchantId, String notifyUrl, String url1)
            throws JSONException, UnsupportedEncodingException,
            GeneralSecurityException, UnknownHostException {
        System.out.println("pushOrder begin");
        String version = "N2";
        String serviceType = "pushOrder";

        /**
         * 请求业务参数
         */
        Map<String, String> request = new HashMap<String, String>();
        request.put("amount", "100");
//        request.put("payType", "wxAPP");
//        request.put("payType", "wxBarCodePay");
        request.put("pay_type", "wxNativePay");
//        request.put("payType", "wxJsPay");
//        request.put("payType", "aliBarCodePay");
//        request.put("payType", "aliJsPay");
//        request.put("payType", "wxH5");
//        request.put("payType", "aliPay");
//        request.put("payType", "aliWebPay");
//        request.put("payType", "aliPayN");
//		request.put("payType", "jsPay");

        System.out.println("本机的IP = " + InetAddress.getLocalHost());
        request.put("order_id", "demo" + System.currentTimeMillis()  + "");
////        request.put("orderId", "2915139115291431513911529143");
        request.put("business_time", "2019-05-07 15:35:00");
        request.put("notify_url", notifyUrl);
        request.put("frontUrl", "https://m.dianpayer.com/wechat/index.htm");
        request.put("order_desc", "Echannell");
        request.put("merchant_id", merchantId);
//        request.put("sub_merchant_id", "900029000000354");
////        request.put("openId", "oJxeIwIDaAuRRwr0_l0ZYKpbZL6w");
        request.put("input_charset", "UTF-8");
        request.put("partner", partnerId);
        request.put("sign_type", "MD5");
        request.put("version", version);
        request.put("service", "push");

      StringBuilder outSb = new StringBuilder();
        request(partnerId, url1, serviceType, encKey, signKey, version,
                request, outSb, 0);
        System.out.println("--------------------");

        System.out.println(outSb.toString());
        System.out.println(url1);

        String res = outSb.toString();
        System.out.println("res:" + res);

    }


    private static void barCodePay(String partnerId, Map<String, String> request, SortedMap<String, String> sParaTemp,  String authCode) {
        sParaTemp.put("service", "barCodePay");
        sParaTemp.put("_input_charset", "UTF-8");
        sParaTemp.put("partner", partnerId);
        sParaTemp.put("sign_type", "MD5");
        sParaTemp.put("amount", "1");
        sParaTemp.put("order_id", "demo" + System.currentTimeMillis() + "");
        sParaTemp.put("business_time", "2017-12-07 15:35:00");
        sParaTemp.put("notify_url", request.get("notifyUrl"));
        sParaTemp.put("order_desc", request.get("orderDesc"));
        sParaTemp.put("merchant_id", partnerId);
//        {"subject":"充值"," apptype":"2",
//                "appname": "王者荣耀",
//                "appid": "com.tencent.tmgp.sgame"}
//        sParaTemp.put("appType", "2");
//        sParaTemp.put("appName", "王者荣耀");
//        sParaTemp.put("appId", "com.tencent.tmgp.sgame");
        //        request.put("payType", "wxBarCodePay");
//        sParaTemp.put("pay_type", "wxNativePay");
//        sParaTemp.put("pay_type", "aliBarCodePay");
        sParaTemp.put("pay_type", "unionBarCodePay");
        sParaTemp.put("authCode", authCode);
    }


    /**
     * 微信支付测试系统接口 订单查询接口
     *
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     * @throws JSONException
     */
    public static void queryOrder(String partnerId, String signKey,
                                  String encKey, String merchantId, String url1)
            throws JSONException, UnsupportedEncodingException,
            GeneralSecurityException {
        System.out.println("queryOrder begin");
        String version = "N2";
        String serviceType = "queryOrder";
        /**
         * 请求业务参数
         */
        Map<String, String> request = new HashMap<String, String>();

        request.put("orderId", System.currentTimeMillis() + "" + System.currentTimeMillis() + "");
        request.put("orderNo", System.currentTimeMillis() + "" + System.currentTimeMillis() + "");
        request.put("merchantId", merchantId);

        StringBuilder outSb = new StringBuilder();
        request(partnerId, url1, serviceType, encKey, signKey, version,
                request, outSb, 0);
        System.out.println(outSb.toString());
    }

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final AtomicInteger atomicInteger = new AtomicInteger(1000000);

    /**
     * 获取同一秒钟 生成的订单号连续
     *
     * @param no
     *            数据中心编号
     * @return 同一秒内订单连续的编号
     */
    public static synchronized String getOrderNoByAtomic(String no) {
        atomicInteger.getAndIncrement();
        int i = atomicInteger.get();
        String date = simpleDateFormat.format(new Date());
        return no + date + i;
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
        // ascii 数字 [48-57] 字母 [65-90] [97-122]
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
