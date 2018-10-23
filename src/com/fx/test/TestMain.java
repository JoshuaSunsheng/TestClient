package com.fx.test;

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


public class TestMain {
    public static final String MARK1 = new Character((char) 0x01).toString(); // :
    public static final String MARK2 = new Character((char) 0x02).toString(); // ,

    static boolean isTest = false;
//    private static String testUrl = "http://wx.dianpayer.com/gateway.do";
    private static String testUrl = "http://localhost:9088/gateway.do";
//    private static String testUrl = "http://localhost:9089/gateway.do";
//    private static String testUrl = "http://localhost:9087/new_gateway.do";
//    private static String testUrl1 = "http://localhost:7000/gateway.do";
    //	private static String testUrl1 = "http://192.168.2.18:8081/gateway.do";
//    static String scUrl1 = "https://m.dianpayer.com/gateway.do";
//    static String scUrl1 = "https://app.monkeysluck.com/gateway.do";
//    static String scUrl1 = "https://wenotice.mpay.cn/gateway.do";
    	static String scUrl1 = "https://app.dianpayer.com/gateway.do";
    //
    public static void main(String[] args) throws IOException,
            GeneralSecurityException, JSONException {

        System.out.println(MARK1);
        System.out.println(MARK2);
        System.out.println("=========");
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

//微信测试 - df - 个体户黄昌可
            partnerId = "111222333444555";
            signKey = "99988888812121255544";
            encKey = "111222333444555666777888";
            merchantId = "99911010019";


            //益鑫科技有限公司
//            partnerId = "100029000000354";
//            signKey = "OVHDyEwoAkjQ9A9MIpMo";
//            encKey = "GFChiyGMZpNN8fiCr7WbsZSM";
//            merchantId = "900029000000354";

            //9087 N2
//            partnerId = "100000000000000";
//            signKey = "h7jjcXPx7n2bmtK7L3mb";
//            encKey = "PzBpCDXBmx2icEeJ7i8baz32";
//            merchantId = "99911010019";

            //900039100000214

            notifyUrl = "https://www.baidu.com";

            url1 = testUrl;
        } else {
            notifyUrl = "https://www.baidu.com/";
            url1 = scUrl1;

            //珠海公交通达卡
            partnerId = "900058500008422";
            signKey = "6GcfhseCTqADko5TsrqX";
            encKey = "IlT6381nh4CpLXpnnkngMoJa";
            merchantId = "900058500008422";

            //点付-2.1-华臻
//            partnerId = "568733000061521";
//            signKey = "ff1472d81ad98a14ed3e";
//            encKey = "b93219eca4540076fe931e06";
//            merchantId = "900033300006152";


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

        //福建紫银天下电子商务有限公司
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


        }
//
//        String aa = Base64.encode(bb.getBytes("utf-8"));
//        System.out.println(aa);
        // 微信支付推送订单
        pushOrder(partnerId, signKey, encKey, merchantId, notifyUrl, url1);

        // 微信支付查询订单
        //queryOrder(partnerId,signKey,encKey,merchantId,url1);

        // 通知商户交易
        //notifyMerchant(partnerId,signKey,encKey,merchantId,notifyUrl);

        //3des解密
        //String src ="lGc5cefVKR6Rww78L9BvpMdJsaqfxt1AHjUVwNAPwuZpyRKqLBENBrC7Yds47Sobd3dBu9DcWwJ3xk8E+qvcJAaOTNx1ooylEvvqbcTfqsO3Zqw5jY3tFfkhxJfzpBUJGj3Pg7xEwZ+lYIFPFS0S/R8vZDNO4f4uTK/X4Qd3a9GTzrSYdswNtNHnWUR+J7jrjWoi8YYXfrt88zj8IUCgo65l3ik8Up7dZsj9fu3QdOSCYoYGTNO/dacTGG/6tND/xo/QRGRV+fHzYY/RKPSiOfGH5zX3vVtsRhwicWydECoGVuN/TluUiQbbldycBQbf";
        //decrypt(src,"piuyklj1209865kzJiop1286");

        //3des加密
        //{"merchantId":"900058400000169","merchantName":"pay","orderId":"20160515232303839945310001","amount":2,"orderNo":"2016051500012415","codeStr":"weixin://wxpay/bizpayurl?pr=VzPgpdw","tradeStatus":3,"errCode":"00","errCodeDes":"支付成功"};
        //src = "{\"merchantId\":\"900058400000169\",\"merchantName\":\"pay\",\"orderId\":\"20160515232303839945310001\",\"amount\":2,\"orderNo\":\"2016051500012415\",\"codeStr\":\"weixin://wxpay/bizpayurl?pr=VzPgpdw\",\"tradeStatus\":3,\"errCode\":\"00\",\"errCodeDes\":\"支付成功\"}";
        //encrypt(src,"piuyklj1209865kzJiop1286");
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


        if(request.get("version") != "N2"){

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

        }else {
            treeMap = (TreeMap<String, String>) request;
            treeMap.put("sign", calcSign(request, signKey, 1));

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
        String version = "2.1";
        String serviceType = "pushOrder";


        List list = new LinkedList();
        list.add("hello");
        list.add("world");
        System.out.println("list: " + list.size());

        java.util.Random r = new java.util.Random();
        int rand = r.nextInt(list.size());
        System.out.println("rand: " + rand);



        Date date = new Date();
        String fcDate = new SimpleDateFormat("'0'yyDDD").format(date); //julianDateString

        System.out.println("fcDate: "+ fcDate);

        /**
         * 请求业务参数
         */
        Map<String, String> request = new HashMap<String, String>();
        request.put("amount", "23");
//        request.put("payType", "qqPay");
//        request.put("payType", "jdPay");
//        request.put("payType", "kjPayC");
//        request.put("payType", "kjPayOpen");
//        request.put("payType", "kjPayOpenC");
//        request.put("payType", "kjPayDirect");
//        request.put("payType", "kjPay");
//        request.put("payType", "wx");
//        request.put("payType", "wxBarCodePay");
        //request.put("payType", "aliBarCodePay");
//        request.put("payType", "aliJsPay");
//        request.put("payType", "wxH5");
//        request.put("payType", "aliPay");
		request.put("payType", "jsPay");
//		request.put("payType", "kjPay");
//		request.put("payType", "netPay");
        JSONObject json=new JSONObject();
        json.put("bankCode", "CMB");
//        request.put("mExtraMap","{'bankCode':'ABCQBY'}");
        request.put("mExtraMap","{'isCombine':'true'}");

            System.out.println("本机的IP = " + InetAddress.getLocalHost());

//                name              : name,
//                idNo              : idNo,
//                acc               : acc,
//                cvv               : cvv,
//                validityDate      : validityDate,
//                mobile            : mobile,
//                bankCode          : creditBankCode,
//                settlementBankCode: debitBankCode,
//                settlementAcc     : inAcc,

//        request.put("mExtraMap","{'bankCode':'ICBC','subPayType':'creditCard'}");

        request.put("orderId", System.currentTimeMillis() + "" +System.currentTimeMillis() + "");
//        request.put("orderId", "15125413718681512541371868");
        request.put("businessTime", System.currentTimeMillis() + "");
        request.put("notifyUrl", notifyUrl);
//        request.put("frontUrl", "https://m.dianpayer.com/wechat/index.htm");
        request.put("orderDesc", "Echannell");
        request.put("merchantId", merchantId);
//        request.put("subMchId", "900029000000354");
//        request.put("openId", "oJxeIwIDaAuRRwr0_l0ZYKpbZL6w");
//        request.put("subMchId", "900010000000240");
        request.put("merchantName", "微信机构");
        StringBuilder outSb = new StringBuilder();
        System.out.println(outSb.toString());
        System.out.println("--------------------");



        //把请求参数打包成数组
//        SortedMap<String, String> sParaTemp = new TreeMap<String, String>();
//        sParaTemp.put("input_charset", "UTF-8");
//        sParaTemp.put("version", "N2");
//        sParaTemp.put("partner",partnerId);
//        sParaTemp.put("service", "push");
//        sParaTemp.put("sign_type", "MD5");
//
//        sParaTemp.put("amount", request.get("amount"));
//        sParaTemp.put("pay_type", request.get("payType"));
//        sParaTemp.put("order_id", request.get("orderId"));
//        sParaTemp.put("business_time", "2017-09-04 15:35:00");
//        sParaTemp.put("notify_url", request.get("notifyUrl"));
//        sParaTemp.put("order_desc", request.get("orderDesc"));
//        sParaTemp.put("merchant_id", request.get("merchantId"));




        request(partnerId, url1, serviceType, encKey, signKey, version,
                request, outSb, 0);
        System.out.println("--------------------");

        System.out.println(outSb.toString());
        System.out.println(url1);

        String res = outSb.toString();
//        String res = "encoding=utf-8&errMsg=调用成功&partnerId=900029000000233&random=mrtsc&respCode=00&result_json=ADyGFRfXF/LftIWx7bDn/ZkT5vDSIuIEfTW7tVhgaPXUInkToRPaBA==&service_type=findAccBalance&sign=b7a5c0f2bf7fe6230c05c745560528f3&signMethod=MD5&version=2.1";
        System.out.println("res:" + res);
        String[] aa = res.split("&");
        //解密报文
        for (String b : aa) {
            int n = b.indexOf(prefix);
            if (n != -1) {
                String src = b.substring(n + prefix.length());
                try {
                    System.out.println("src:" + src);

                    System.out.println(SymmtricCryptoUtil.tDecryptBase64(encKey, src));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        }

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
        String version = "2.1";
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
