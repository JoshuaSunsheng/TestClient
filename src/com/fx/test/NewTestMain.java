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


public class NewTestMain {


    static boolean isTest = true;
//    private static String testUrl = "http://wx.dianpayer.com/gateway.do";
//    private static String testUrl = "http://localhost:9088/gateway.do";
//    private static String testUrl = "http://localhost:9089/gateway.do";
//    private static String testUrl = "http://localhost:9087/new_gateway.do";
//    private static String testUrl = "http://localhost:9087/v2/refund/normal";
    private static String testUrl = "http://localhost:9087/service/refund";
//    private static String testUrl = "http://192.168.2.86:9087/service/refund";
//    private static String testUrl = "http://localhost:9087/query/payment";
//    private static String testUrl = "http://localhost:9087/bill/list4Buyer";
//    private static String testUrl = "http://localhost:9087/bill/list";
//    private static String testUrl = "http://localhost:9087/query/paymentSearch";
//    private static String testUrl = "http://localhost:9087/query/paymentSearch";
//    private static String testUrl = "http://localhost:9089/new_gateway.do";
//    private static String testUrl = "http://localhost:9090/d/gateway/";
//    private static String testUrl = "http://180.168.215.67:8089/d/gateway/";
//    private static String testUrl = "https://mastercard.mpay.cn/d/gateway/";
//    private static String testUrl = "http://wx.dianpayer.com:8089/d/gateway/";
//    private static String testUrl1 = "http://localhost:7000/gateway.do";
    //	private static String testUrl1 = "http://192.168.2.18:8081/gateway.do";
//    static String scUrl1 = "https://m.dianpayer.com/gateway.do";
//    static String scUrl1 = "https://app.monkeysluck.com/gateway.do";
//    static String scUrl1 = "https://wenotice.mpay.cn/gateway.do";
//    static String scUrl1 = "https://wenotice.mpay.cn/new_gateway.do";
//    	static String scUrl1 = "https://app.dianpayer.com/gateway.do";
    	static String scUrl1 = "https://pay.foreseenewmedia.com/new_gateway.do";
//    	static String scUrl1 = "https://newep.bhecard.com:8080/v2/refund/normal";
//    private static String scUrl1 = "https://mastercard.mpay.cn/d/gateway/";

    //    	static String scUrl1 = "http://httpslb-1872591155.cn-northwest-1.elb.amazonaws.com.cn:81/new_gateway.do";
    //
    public static void main(String[] args) throws IOException,
            GeneralSecurityException, JSONException {
        OuterPushOrder();


    }

    public static void OuterPushOrder() throws JSONException, UnsupportedEncodingException, GeneralSecurityException, UnknownHostException {
        //        long number1 = 3500;
//        String str1 = String.format("%08d", number1);
//
//        System.out.println("java补空格后字符串的长度:"+String.format("%1$-35s","a").length());
//        System.out.println("java补空格后字符串:"+String.format("%1$-35s","a"));
//        String.format("%1$-35s","a");
//        System.out.println("str=" + str1);
//		StaticTest test1 = new StaticTest();
//		StaticTest test2 = new StaticTest();
//
//		System.out.println(test1.i++);
//		System.out.println(test2.i);
//
//		System.out.println(new Date());
//
//		Properties p = System.getProperties();
//		p.list(System.out);
//		System.out.println("--- Memory Usage:");
//		Runtime rt = Runtime.getRuntime();
//		System.out.println("Total Memory = "
//							+ rt.totalMemory()
//							+  "Free Memrory = "
//							+ rt.freeMemory());

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

//            --2018060108538266383877610  1212740501201806011007410181
            // --100000000003451   余额支付  天津航空有限责任公司（B2C）  5fg94881da3bedb1fb1934bd1bab4de144ca4e0c9d1fgcg18c23d25add6756g2
            //天津航空有限责任公司（B2C）   余额支付
//            partnerId = "100000000003451";
//            signKey = "5fg94881da3bedb1fb1934bd1bab4de144ca4e0c9d1fgcg18c23d25add6756g2";
//            encKey = "GFChiyGMZpNN8fiCr7WbsZSM";
//            merchantId = "100000000003451";

//            --2018060144280212  100000000080004
            //--100000000080004   网银支付  北京首都航空有限公司（团队国际）  5d30f15d8d36ed0fd7dgd583bfe4aa2e9cgde5f14827bf24bgf7824g9d445eee
            //北京首都航空有限公司（团队国际）  网银支付
//            partnerId = "100000000080004";
//            signKey = "5d30f15d8d36ed0fd7dgd583bfe4aa2e9cgde5f14827bf24bgf7824g9d445eee";
//            encKey = "GFChiyGMZpNN8fiCr7WbsZSM";
//            merchantId = "100000000080004";

            //900029000002554
            partnerId = "900029000002554";
            signKey = "CyVZmE9mtbNdhrStA8UH";
            encKey = "6E12Dhbq9M7Fk3MhyfMZ6dmm";
            merchantId = "900029000002554";

            //新接口测试 N2
//            partnerId = "100000000000000";
//            signKey = "h7jjcXPx7n2bmtK7L3mb";
//            encKey = "PzBpCDXBmx2icEeJ7i8baz32";
//            merchantId = "99911010019";

//            //eps 新接口测试
//            partnerId = "123456123456789";
//            signKey = "Pc4sfVLqyRSeLHwHzGXF";
//            encKey = "kcwgyVnerkRzLpOPwNnKRKx6";
//            merchantId = "123456123456789";

            //900039100000214

            notifyUrl = "https://www.baidu.com";

            url1 = testUrl;
        } else {
            notifyUrl = "https://www.baidu.com/";
            url1 = scUrl1;

            //珠海公交通达卡
//            partnerId = "900058500008422";
//            signKey = "6GcfhseCTqADko5TsrqX";
//            encKey = "IlT6381nh4CpLXpnnkngMoJa";
//            merchantId = "900058500008422";

            //微收单-点付
//            partnerId = "100000000000000";
//            signKey = "m1e4UDeIn6oBamvp79bk";
//            encKey = "WgUIMjbHCcxiUgAtbZFR2TlK";
//            merchantId = "900029000000225";

            //微收单-易生测试
            partnerId = "900029000021348";
            signKey = "GqiuuE9HbPRsqdqHsZvJ";
            encKey = "WgUIMjbHCcxiUgAtbZFR2TlK";
            merchantId = "900029000021348";


            //上海矿迪-测试专用
//            partnerId = "900029000007658";
//            signKey = "Y8xfpTZb656v7O0xhJKT";
//            encKey = "9sC4ujBOL6L6pqnIw3rZhwsf";
//            merchantId = "900029000007658";

//            partnerId = "031000000000005";
//            signKey = "pioiklkdfaso1lajf112";
//            encKey = "p1p2ol123123laikskldflkm";
//            merchantId = "900012700000669";

//            partnerId = "021888888888888";
//            signKey = "hyabcd2k1Lhj2lviil9s";
//            encKey = "1234kim5ty7895kzJiop3698";
//            merchantId = "900000000000255";

//            partnerId = "900052800006779";
//            signKey = "mUXaNOs8mgwyMKaiPn4T";
//            encKey = "rsw9zkj2QJE4qz0cBDyzhyvU";
//            merchantId = "900052800006779";

        //点付-福建紫银天下电子商务有限公司
//            partnerId = "900040500008268";
//            signKey = "Qj89Gug6NhPWBCSZXOoR";
//            encKey = "FC4ZetijLSmkx5iqRP3WufM8";
//            merchantId = "900040500008268";
//
//            partnerId = "900034140001834";
//            signKey = "MOiLRamADhvLQ9xzM4td";
//            encKey = "LZLEIQkL18AexWQfb9w2yxO6";
//            merchantId = "900034140001834";

//            partnerId = "900029000000233";
//            signKey = "M8Udy0aqliFwiU8siYrW";
//            encKey = "3WZWZ7ddq1wrbboIvdSRJex0";
//            merchantId = "900029000000233";

//            partnerId = "900029000002508";
//            signKey = "DOk41x9A6nMZ4wVZQAiu";
//            encKey = "9gQuHIX4bcZUoBg68fV2Q6YF";
//            merchantId = "900029000002508";

            //snappay 测试机构
//            partnerId = "900010000018650";
//            signKey = "HKEg0kKWU9nEWFZQPkhQ";
//            encKey = "WVImeEQBuvRNG5OX2T0b4zLZ";
//            merchantId = "900010000018650";

            //snappay FoodyMart
//            partnerId = "900010000018964";
//            signKey = "TLoyhbC45hfpR5xp37TK";
//            encKey = "WVImeEQBuvRNG5OX2T0b4zLZ";
//            merchantId = "900010000018964";

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

            //聚财通科技（北京）有限公司
//            partnerId = "900010000022125";
//            signKey = "g6h9dYNqOSCYbusxAY2H";
//            encKey = "XatuZnWGEmB6jObMFDPkXTWe";
//            merchantId = "900010000022125";

            //snappay 安大略大学
//            partnerId = "900010000018650";
//            signKey = "HKEg0kKWU9nEWFZQPkhQ";
//            encKey = "WVImeEQBuvRNG5OX2T0b4zLZ";
//            merchantId = "900010000018650";

//            //易通融信
//            partnerId = "900039300021362";
//            signKey = "sGsW7c1VSH0L5b2teQ6y";
//            encKey = "iGFKit9dWkLw9QZzsDXjh6tY";
//            merchantId = "900039300021362";


            //微收单-环球
//            partnerId = "900058100021343";
//            signKey = "9o1CasuiLpLGDQp7t4tw";
//            encKey = "9DICi0Tk3lffE37ufFKgChya";
//            merchantId = "900000000021546";


            //微收单-沈阳速鹰体育用品有限公司

//            partnerId = "900022100000482";
//            signKey = "4iaTHtgETJoTc0rkCDBv";
//            encKey = "MlKMFFLt2eDjNFyPGHWTGpZz";
//            merchantId = "900022100000482";


            //eps-正式

//            partnerId = "100064100008610";
//            signKey = "oRIqVg73Bed2YJ1bb7VK";
//            encKey = "WuoJMQiudH1lPi41HMH841zf";
//            merchantId = "100064100008610";

            //网络支付系统
//            partnerId = "900029000000354";
//            signKey = "h7jjcXPx7n2bmtK7L3mb";
//            encKey = "GFChiyGMZpNN8fiCr7WbsZSM";
//            merchantId = "900029000000354";

        }
        // 微信支付推送订单
        pushOrder(partnerId, signKey, encKey, merchantId, notifyUrl, url1);

        // 微信支付查询订单
//        queryOrder(partnerId,signKey,encKey,merchantId,url1);

        // 通知商户交易
        //notifyMerchant(partnerId,signKey,encKey,merchantId,notifyUrl);

        //test();
        //计算签名
        //md5Encode("encoding=utf-8&errMsg=通知交易&partnerId=075582134702815&random=p1UoVK5B6V&respCode=00&result_json=lGc5cefVKR6Rww78L9BvpMdJsaqfxt1AHjUVwNAPwuZpyRKqLBENBrC7Yds47Sobd3dBu9DcWwJ3xk8E+qvcJAaOTNx1ooylEvvqbcTfqsO3Zqw5jY3tFfkhxJfzpBUJGj3Pg7xEwZ+lYIFPFS0S/R8vZDNO4f4uTK/X4Qd3a9GTzrSYdswNtNHnWUR+J7jrjWoi8YYXfrt88zj8IUCgo65l3ik8Up7dZsj9fu3QdOSCYoYGTNO/dacTGG/6tND/xo/QRGRV+fHzYY/RKPSiOfGH5zX3vVtsRhwicWydECoGVuN/TluUiQbbldycBQbf&service_type=notify&version=2.1&adhlfj2P1Lgjilmiilwr");
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
        TreeMap<String, String> treeMap = new TreeMap<String, String>();


        if(version == "N2") {
            treeMap = (TreeMap<String, String>) request;
            treeMap.put("sign", calcSign(request, signKey, 1));
            System.out.println("sign: "+ treeMap.get("sign"));
        }
        else if(request.get("version") != "N2"){

            treeMap.put("random", genRandomStr(5));
            treeMap.put("version", version);
            treeMap.put("encoding", "utf-8");
            // 当等于1时是通知交易
            if (type == 1) {
                treeMap.put("errMsg", "通知交易");
                treeMap.put("respCode", "00");
            }
            treeMap.put("partnerId", partnerId);
            treeMap.put("service_type", serviceType);

            JSONObject jsonObject = new JSONObject();

            for (Object key : request.keySet()) {
                if (request.get(key) != null) {
                    jsonObject.put(key.toString(), request.get(key).toString());
                }
            }

            String resultStr = jsonObject.toString();
            System.out.println(resultStr);
            String tmp = decryptOrEncrypt(resultStr, encKey, true, "utf-8");
            System.out.println(tmp);

            // 当等于1时是通知交易
            if (type == 1) {
                treeMap.put("result_json", tmp);
            } else {
                treeMap.put("request_json", tmp);
            }
            treeMap.put("sign", getSignData(treeMap, signKey));

        }

        System.out.println(treeMap);
        System.out.println(url);

//        Map baseReq = new HashMap();
//        baseReq.put("doctor_id","11");
//        baseReq.put("patient_id", "11");
//        baseReq.put("patientName","T01014");//预下单
//        baseReq.put("cureTime", "2017-09-04");
//        baseReq.put("flag", "1");
//        baseReq.put("mobile", "1888888888");
//
//        url = "http://www.hatbrand.cn/thinkcmf/Info/addAppointment";
        return HttpUtils.sendRequest(url, treeMap, outSb);
//        return 1;
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


        List list = new LinkedList();
        list.add("hello");
        list.add("world");
        System.out.println("list: " + list.size());

        Random r = new Random();
        int rand = r.nextInt(list.size());
        System.out.println("rand: " + rand);


        /**
         * 请求业务参数
         */
        Map<String, String> request = new HashMap<String, String>();
        request.put("amount", "100");
//        request.put("payType", "qqPay");
//        request.put("payType", "jdPay");
//        request.put("payType", "kjPayC");
//        request.put("payType", "kjPayOpen");
//        request.put("payType", "kjPayOpenC");
//        request.put("payType", "kjPay2");
//        request.put("payType", "kjPay3");
//        request.put("payType", "kjPayDirect");
//        request.put("payType", "kjPay");
//        request.put("payType", "wxAPP");
//        request.put("payType", "wxBarCodePay");
//        request.put("payType", "wxNativePay");
//        request.put("payType", "wxJsPay");
//        request.put("payType", "aliBarCodePay");
//        request.put("payType", "aliJsPay");
//        request.put("payType", "wxH5");
//        request.put("payType", "aliPay");
//        request.put("payType", "aliWebPay");
//        request.put("payType", "aliPayN");
//		request.put("payType", "jsPay");
		request.put("payType", "kjPay");
//		request.put("payType", "netPay");
        JSONObject json=new JSONObject();
        json.put("bankCode", "CMB");
//        request.put("mExtraMap","{'bankCode':'ABCQBY'}");
//        request.put("mExtraMap","{'isCombine':'true'}");

            System.out.println("本机的IP = " + InetAddress.getLocalHost());
//
//
//        request.put("orderId", "demo" + System.currentTimeMillis()  + "");
////        request.put("orderId", "2915139115291431513911529143");
//        request.put("businessTime", System.currentTimeMillis() + "");
        request.put("notifyUrl", notifyUrl);
        request.put("frontUrl", "https://m.dianpayer.com/wechat/index.htm");
        request.put("orderDesc", "Echannell");
//        request.put("merchantId", merchantId);
////        request.put("subMchId", "900029000000354");
////        request.put("openId", "oJxeIwIDaAuRRwr0_l0ZYKpbZL6w");
////        request.put("subMchId", "900010000000240");
//        request.put("merchantName", "微信机构");
//        StringBuilder outSb = new StringBuilder();
//        System.out.println(outSb.toString());
//        System.out.println("--------------------");

/**********************************************************************************************************************/
        //把请求参数打包成数组
        SortedMap<String, String> sParaTemp = new TreeMap<String, String>();


        //新网支 - 新无卡 - 直接支付下单 - 收银台接口
//        directPay(partnerId, request, sParaTemp);

        //  新网支-新无卡 直接支付确认 收银台接口
//        directPayConfirm(partnerId, request, sParaTemp, "demo1551417050710");

        //  新网支-新无卡 协议支付认证 收银台接口
//        agreementPayValidateAccount(partnerId, request, sParaTemp, "agreementPayValidateAccount");

        //  新网支-新无卡 协议支付签约 收银台接口   6217001210092281920
//        agreementPayBind(partnerId, request, sParaTemp, "agreementPayBind", "demo1551842018953", "182889");

        //  新网支-新无卡 协议支付消费 收银台接口
//        agreementPay(partnerId, request, sParaTemp, "agreementPay", "EP0000000129");

        //  新网支-条码支付 收银台接口
//        barCodePay(partnerId, request, sParaTemp, "6226307700457293990");

        //        request.put("mExtraMap", "{'subPayType':'directPay', 'name': '苏孙生', 'idNo':'350426199003043599', 'acc':'377155021512782', 'cvv':'427', 'validityDate':'1812', 'mobile':'13764610737', 'phoneNumber':'13764610737', 'bankCode': '305', 'feeRate': '0.55', 't0Fee':'100','smsCode':'412492', 'phoneToken':'ME20171117160919502497','settlementAcc':'6226097800343163','mchtFullName':'测试商户号','mchtName':'测试商户号','mchtAddress':'上海市普陀区江宁路111号','bankCode':'301','branchName':'上海建设银行北新泾支行','province':'上海市','city':'上海市', 'isCombine':'true'}");


        //网支系统 获取对账 老网支接口
        //{"partner":"900029000002554","tradeType":"5","startDate":"20180601","endDate":"20180701","status":"1"}
//        sParaTemp.put("_input_charset", "UTF-8");
//        sParaTemp.put("version", "N2");
//        sParaTemp.put("partner",partnerId);
////        sParaTemp.put("service", ""); //对账文件获取
////        sParaTemp.put("service", "bill_list"); //对账文件获取
//        sParaTemp.put("trade_type", "1"); //1 支付 2 退款 5 充值
//        sParaTemp.put("seller_no", partnerId);
//        sParaTemp.put("start_date", "20180601");
//        sParaTemp.put("end_date", "20180701");
//        sParaTemp.put("status", "1");


        //网支系统退款 refund 老网支接口
        网支系统退款Refund老网支接口(partnerId, request, sParaTemp);


        //query
//        sParaTemp.put("input_charset", "UTF-8");
//        sParaTemp.put("partner",partnerId);
//        sParaTemp.put("sign_type", "MD5");
//        sParaTemp.put("amount", "10");sParaTemp.put("return_type", "xml");
//        sParaTemp.put("out_trade_no",  "1537326394282");
//        sParaTemp.put("trade_no", request.get("merchantId"));




//        sParaTemp.put("business_time", "2017-12-07 15:35:00");
//        sParaTemp.put("notify_url", request.get("notifyUrl"));
//        sParaTemp.put("order_desc", request.get("orderDesc"));
//        sParaTemp.put("sub_merchant_id", "99911010019");




//        request.put("mExtraMap", "{'subPayType':'directPay', 'name': '苏孙生', 'idNo':'350426199003043599', 'acc':'377155021512782', 'cvv':'427', 'validityDate':'1812', 'mobile':'13764610737', 'phoneNumber':'13764610737', 'bankCode': '305', 'feeRate': '0.55', 't0Fee':'100','smsCode':'412492', 'phoneToken':'ME20171117160919502497','settlementAcc':'6226097800343163','mchtFullName':'测试商户号','mchtName':'测试商户号','mchtAddress':'上海市普陀区江宁路111号','bankCode':'301','branchName':'上海建设银行北新泾支行','province':'上海市','city':'上海市', 'isCombine':'true'}");


/*eNett*********************************************************************************************************************/
//        SortedMap<String, String> sParaTemp = getENettSortedMap(partnerId);
/*eNett*********************************************************************************************************************/
        StringBuilder outSb = new StringBuilder();
        request(partnerId, url1, serviceType, encKey, signKey, version,
                sParaTemp, outSb, 0);
        System.out.println("--------------------");

        System.out.println(outSb.toString());
        System.out.println(url1);

        String res = outSb.toString();
//        String res = "encoding=utf-8&errMsg=调用成功&partnerId=900029000000233&random=mrtsc&respCode=00&result_json=ADyGFRfXF/LftIWx7bDn/ZkT5vDSIuIEfTW7tVhgaPXUInkToRPaBA==&service_type=findAccBalance&sign=b7a5c0f2bf7fe6230c05c745560528f3&signMethod=MD5&version=2.1";

        System.out.println("res:" + res);
//        String[] aa = res.split("&");
//        //解密报文
//        for (String b : aa) {
//            int n = b.indexOf(prefix);
//            if (n != -1) {
//                String src = b.substring(n + prefix.length());
//                try {
//                    System.out.println("src:" + src);
//
//                    System.out.println(SymmtricCryptoUtil.tDecryptBase64(encKey, src));
//                    break;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//
//            }
//        }

    }

    public static void 网支系统退款Refund老网支接口(String partnerId, Map<String, String> request, SortedMap<String, String> sParaTemp) {
        sParaTemp.put("input_charset", "UTF-8");
        sParaTemp.put("partner",partnerId);
        sParaTemp.put("sign_type", "MD5");
        sParaTemp.put("amount", "0.01");
        sParaTemp.put("return_type", "json");
        sParaTemp.put("out_trade_no",   getOrderNoByAtomic("") );
//        sParaTemp.put("out_trade_no",  "1542865900721"); //System.currentTimeMillis()+ ""
        sParaTemp.put("merchant_id", request.get("merchantId"));
//        sParaTemp.put("orig_out_trade_no", "00370003378291801800605160187100"); //netBank
//        sParaTemp.put("orig_out_trade_no", "2018060114615570");
//        sParaTemp.put("orig_out_trade_no", "00370003378291801800605160187100");
        ArrayList aa = new ArrayList();
        aa.add("2018060114615570");
        aa.add("00370003378291801800605160187100");
        Random rnd = new Random();
        int bb = rnd.nextInt(2);
        sParaTemp.put("orig_out_trade_no", (String) aa.get(bb));
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

    private static void directPayConfirm(String partnerId, Map<String, String> request, SortedMap<String, String> sParaTemp, String order_id) {
        sParaTemp.put("service", "directPayConfirm");
        sParaTemp.put("_input_charset", "UTF-8");
        sParaTemp.put("partner",partnerId);
        sParaTemp.put("merchant_id", partnerId);

        sParaTemp.put("sign_type", "MD5");
        sParaTemp.put("amount", "1");
//        sParaTemp.put("order_id", "demo1548664293456");
        sParaTemp.put("order_id", order_id);
        sParaTemp.put("business_time", "2017-12-07 15:35:00");
        sParaTemp.put("notify_url", request.get("notifyUrl"));
        sParaTemp.put("order_desc", request.get("orderDesc"));
        sParaTemp.put("name", "苏孙生");
        sParaTemp.put("id_no", "350426199003043599");
        sParaTemp.put("acc", "6212261001076259461");
        sParaTemp.put("mobile", "13764610737");
        sParaTemp.put("sms_code", "975831");
    }

    private static void directPay(String partnerId, Map<String, String> request, SortedMap<String, String> sParaTemp) {
        sParaTemp.put("service", "directPay");
        sParaTemp.put("_input_charset", "UTF-8");
        sParaTemp.put("partner",partnerId);
        sParaTemp.put("sign_type", "MD5");
        sParaTemp.put("amount", "1");
        sParaTemp.put("order_id", "demo" + System.currentTimeMillis()+ "");
        sParaTemp.put("business_time", "2017-12-07 15:35:00");
        sParaTemp.put("notify_url", request.get("notifyUrl"));
        sParaTemp.put("order_desc", request.get("orderDesc"));
        sParaTemp.put("merchant_id", partnerId);

//        直接支付触发短信-成功-作为“直接支付”原交易
//        1、测试场景：作为“直接支付”原交易
//        2、操作步骤：
//        1）手输中国银联测试专用卡IT02卡号：6224243000000011
//        2）输入身份证件信息：310115197803261111，持卡人姓名：com，手机号：13222222222
//        3）金额：5000.03元
//        4）选择触发短信验证码，系统发起交易
//        sParaTemp.put("name", "com");
//        sParaTemp.put("id_no", "310115197803261111");
//        sParaTemp.put("acc", "6224243000000011");
//        sParaTemp.put("mobile", "13222222222");
        sParaTemp.put("name", "苏孙生");
        sParaTemp.put("id_no", "350426199003043599");
//        sParaTemp.put("acc", getEncode("6226097800343163")); //招商
//        sParaTemp.put("acc", getEncode("6212261001076259461"));   //工商
        sParaTemp.put("acc", getEncode("6217001210092281920")); //建设
        sParaTemp.put("bank_code", "105");//建设
        sParaTemp.put("mobile", "13764610737");
    }

    public static void agreementPayBind(String partnerId, Map<String, String> request, SortedMap<String, String> sParaTemp, String opt, String orig_out_trade_no, String smsCode) {
        agreementPayValidateAccount(partnerId, request, sParaTemp, opt);
        sParaTemp.put("sms_code", smsCode);
        sParaTemp.put("orig_out_trade_no", orig_out_trade_no);
    }

    private static void agreementPayValidateAccount(String partnerId, Map<String, String> request, SortedMap<String, String> sParaTemp, String opt) {
        sParaTemp.put("service", opt);
        sParaTemp.put("_input_charset", "UTF-8");
        sParaTemp.put("partner",partnerId);
        sParaTemp.put("sign_type", "MD5");
        sParaTemp.put("merchant_id", partnerId);
//        1、测试场景：作为“协议支付”第一笔原交易。2、操作步骤：
//        1）手输中国银联测试专用卡IT05卡号：6212143000000000037
//        2）输入军官证信息：00111208，持卡人姓名：俹燚揞，手机号：13222222222
//        3）金额可选上送，若上送金额=100
//        sParaTemp.put("name", getEncode("com"));
//        sParaTemp.put("id_no", getEncode("310115197803261111"));
//        sParaTemp.put("acc", getEncode("6212143000000000037"));
//        sParaTemp.put("mobile", getEncode("13222222222"));

        sParaTemp.put("name", getEncode("苏孙生"));
        sParaTemp.put("id_no", getEncode("350426199003043599"));
//        sParaTemp.put("acc", getEncode("6226097800343163")); //招商
//        sParaTemp.put("bank_code", "102");//工商
//        sParaTemp.put("acc", getEncode("6212261001076259461"));   //工商
        //        sParaTemp.put("bank_code", "105");//建设
//        sParaTemp.put("acc", getEncode("6217001210092281920")); //建设

        sParaTemp.put("bank_code", "305");//民生
        sParaTemp.put("acc", getEncode("6226190202039008"));   //民生
        sParaTemp.put("mobile", getEncode("13764610737"));
        sParaTemp.put("out_trade_no", "demo" + System.currentTimeMillis()+ "");
    }

    private static String getEncode(String data){
        return StringUtil.bytesToHexStr(DesUtil.desEncode(data, "VntassPfhRL9HCKO5ExOIrrt"));
    }

    private static void agreementPay(String partnerId, Map<String, String> request, SortedMap<String, String> sParaTemp, String opt, String signNo) {
        sParaTemp.put("service", opt);
        sParaTemp.put("_input_charset", "UTF-8");
        sParaTemp.put("partner",partnerId);
        sParaTemp.put("out_trade_no","agreementPay" + System.currentTimeMillis()+ "");
        sParaTemp.put("business_time", "2017-12-07 15:35:00");
        sParaTemp.put("notify_url", request.get("notifyUrl"));
        sParaTemp.put("order_desc", request.get("orderDesc"));
        sParaTemp.put("sign_type", "MD5");
        sParaTemp.put("merchant_id", partnerId);
        sParaTemp.put("amount", "1");
        sParaTemp.put("sign_no", signNo);
    }

    //get eNett map
    private static SortedMap<String, String> getENettSortedMap(String partnerId) {

//        <param extends="activationDate"/>
//        <param extends="expiryDate"/>
//        <param extends="maximumAuthorisationAmount"/>
//        <param extends="multiUseClosePercentage"/>
//        <param extends="merchantCategoryName"/>
//        <param extends="integratorReference"/>
//        <param extends="notes"/>


        //把请求参数打包成数组
        SortedMap<String, String> sParaTemp = new TreeMap<String, String>();
        sParaTemp.put("input_charset", "UTF-8");
        sParaTemp.put("version", "N2");
        sParaTemp.put("sign_type", "MD5");
        sParaTemp.put("partner",partnerId);
        sParaTemp.put("service", "issueVAN");
//        sParaTemp.put("service", "amendVAN");
//        sParaTemp.put("service", "cancelVAN");
//        sParaTemp.put("service", "getVANDetails");
//        sParaTemp.put("service", "push");
//        sParaTemp.put("service", "refund");


        sParaTemp.put("activationDate", "2018-04-15 15:24:63");
        sParaTemp.put("expiryDate", "2019-10-13 15:24:63");
        sParaTemp.put("maximumAuthorisationAmount", "10050");
        sParaTemp.put("multiUseClosePercentage", "100");
        sParaTemp.put("merchantCategoryName", "AIRLINE");
        sParaTemp.put("countryCode", "HK");
        sParaTemp.put("currencyCode", "USD");
        sParaTemp.put("fundingCurrencyCode", "USD");
        sParaTemp.put("integratorReference", "demo" + System.currentTimeMillis()  + "");
        sParaTemp.put("integratorReference", "demo1522401171741");
        sParaTemp.put("cancelReasonStr", "Booking_Cancelled");
        sParaTemp.put("virtualAccountNumber", "5533979484871058");
        sParaTemp.put("notes", "001， Check-in date：2018/1/30， City：New York， Supplier：ABC， OP：OP1， Country：US");
        sParaTemp.put("userReferences", "{\n" +
                "            \"UserReference1\": \"001\",\n" +
//                "            \"UserReference1\": \"002\",\n" +
                "            \"UserReference2\": \"你好2018/1/30\",\n" +
//                "            \"UserReference2\": \"2018/2/15\",\n" +
                "            \"UserReference3\": \"New York\",\n" +
//                "            \"UserReference3\": \"New York\",\n" +
                "            \"UserReference4\": \"ABC\",\n" +
//                "            \"UserReference4\": \"ABC\",\n" +
                "            \"CustomUserReference5\": \"OP1\",\n" +
//                "            \"CustomUserReference5\": \"OP2\",\n" +
                "            \"CustomUserReference6\": \"US\",\n" +
//                "            \"CustomUserReference6\": \"US\",\n" +
                "            \"CustomUserReference7\": \"30\"\n" +
//                "            \"CustomUserReference7\": \"70\"\n" +
                "        }");


//        ①团号：001， Check-in date：2018/1/30， City：New York， Supplier：ABC， OP：OP1， Country：US， 金额：30
//        ②团号：002， Check-in date：2018/2/15， City：New York， Supplier：ABC， OP：OP2， Country：US， 金额：70
        return sParaTemp;
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
