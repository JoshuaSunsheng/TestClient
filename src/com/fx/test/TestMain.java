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

	static boolean isTest = true;
	private static String testUrl = "http://mtest.dianpayer.com:8088/gateway.do";
	private static String testUrl1 = "http://localhost:7000/gateway.do";
	static String scUrl1 = "https://app.dianpayer.com/gateway.do";

	public static void main(String[] args) throws IOException,
			GeneralSecurityException, JSONException {
		String partnerId = "";
		String signKey = "";
		String encKey = "";
		String merchantId = "";
		String notifyUrl = "";
		String url1 = "";

		if (isTest) {
			partnerId = "111222333444555";
			signKey = "99988888812121255544";
			encKey = "111222333444555666777888";
			merchantId = "99911010019";
			notifyUrl = "www.baidu.com";
			url1 = testUrl;
		} else {
//			partnerId = "888222333777555";
//			signKey = "wxJzhWif2u91Mi1280pk1";
//			encKey = "9asdf14qwe51636wxzf68123";
//			merchantId = "900047550000160";
			notifyUrl = "http://gw.3yzf.com/notifys/DianpayerWx21/BankNotify.aspx";
			url1 = scUrl1;
			partnerId = "075582134702815";
			signKey = "adhlfj2P1Lgjilmiilwr";
			encKey = "piuyklj1209865kzJiop1286";
			merchantId = "900058400000169";
		}

		// 微信支付推送订单
		//pushOrder(partnerId, signKey, encKey, merchantId, notifyUrl, url1);
		// 微信支付查询订单
		//queryOrder(partnerId,signKey,encKey,merchantId,url1);

		// 通知商户交易
		notifyMerchant(partnerId,signKey,encKey,merchantId,notifyUrl);

		//3des解密
		String src ="lGc5cefVKR6Rww78L9BvpMdJsaqfxt1AHjUVwNAPwuZpyRKqLBENBrC7Yds47Sobd3dBu9DcWwJ3xk8E+qvcJAaOTNx1ooylEvvqbcTfqsO3Zqw5jY3tFfkhxJfzpBUJGj3Pg7xEwZ+lYIFPFS0S/R8vZDNO4f4uTK/X4Qd3a9GTzrSYdswNtNHnWUR+J7jrjWoi8YYXfrt88zj8IUCgo65l3ik8Up7dZsj9fu3QdOSCYoYGTNO/dacTGG/6tND/xo/QRGRV+fHzYY/RKPSiOfGH5zX3vVtsRhwicWydECoGVuN/TluUiQbbldycBQbf";
		//decrypt(src,"piuyklj1209865kzJiop1286");
		
		//3des加密
		//{"merchantId":"900058400000169","merchantName":"pay","orderId":"20160515232303839945310001","amount":2,"orderNo":"2016051500012415","codeStr":"weixin://wxpay/bizpayurl?pr=VzPgpdw","tradeStatus":3,"errCode":"00","errCodeDes":"支付成功"};
		src = "{\"merchantId\":\"900058400000169\",\"merchantName\":\"pay\",\"orderId\":\"20160515232303839945310001\",\"amount\":2,\"orderNo\":\"2016051500012415\",\"codeStr\":\"weixin://wxpay/bizpayurl?pr=VzPgpdw\",\"tradeStatus\":3,\"errCode\":\"00\",\"errCodeDes\":\"支付成功\"}";
		//encrypt(src,"piuyklj1209865kzJiop1286");
		//test();
		//计算签名
		//md5Encode("encoding=utf-8&errMsg=通知交易&partnerId=075582134702815&random=p1UoVK5B6V&respCode=00&result_json=lGc5cefVKR6Rww78L9BvpMdJsaqfxt1AHjUVwNAPwuZpyRKqLBENBrC7Yds47Sobd3dBu9DcWwJ3xk8E+qvcJAaOTNx1ooylEvvqbcTfqsO3Zqw5jY3tFfkhxJfzpBUJGj3Pg7xEwZ+lYIFPFS0S/R8vZDNO4f4uTK/X4Qd3a9GTzrSYdswNtNHnWUR+J7jrjWoi8YYXfrt88zj8IUCgo65l3ik8Up7dZsj9fu3QdOSCYoYGTNO/dacTGG/6tND/xo/QRGRV+fHzYY/RKPSiOfGH5zX3vVtsRhwicWydECoGVuN/TluUiQbbldycBQbf&service_type=notify&version=2.1&adhlfj2P1Lgjilmiilwr");
	}
	 
	/**
	 * 
	 * @param src
	 * @throws IOException
	 * @throws GeneralSecurityException
	 * @throws JSONException
	 */
	public static void md5Encode(String src) throws IOException,
			GeneralSecurityException, JSONException {
		String tmp =  MD5.md5Encode(src,"utf-8");
		System.out.println(tmp);
	}
	
	/**
	 * 3des
	 * 解密
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

		// encoding=utf-8&partnerId=111222333444555&random=1213&request_json=eThK6E7jc2Y=&service_type=pushOrder&version=2.1&99988888812121255544
		// encoding=utf-8&partnerId=111222333444555&payType=wx&random=1213&request_json=eThK6E7jc2Y=&service_type=pushOrder&version=2.1&99988888812121255544
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
		treeMap.put("result_json", tmp);
		treeMap.put("sign", getSignData(treeMap, signKey));
		return HttpUtils.sendRequest(url, treeMap, outSb);
	}

	public static String decryptOrEncrypt(String data, String key,
			boolean isEnc, String charset) throws UnsupportedEncodingException,
			GeneralSecurityException {

		return SymmtricCryptoUtil.decryptOrEncrypt(data, key, isEnc, charset);
	}

	public static String getSignData(TreeMap<String, String> treeMap,
			String signKey) {
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
		Map<String, String> request = new HashMap<String, String>();
		request.put("encoding", "utf-8");
		request.put("partnerId", "123456123456789");
		request.put("random", "979");
		request.put("request_json", "/rlZt9RkL8s=");
		request.put("service_type", "testCard");
		request.put("sign", "bdb257d4b0e43af615f80842f9008200");
		request.put("version", "2.1");

		StringBuilder outSb = new StringBuilder();
		HttpUtils.sendRequest(testUrl, request, outSb);

		System.out.println(outSb.toString());

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

		System.out.println("notifyMerchant end:"+outSb.toString());
	}

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
			GeneralSecurityException {
		System.out.println("pushOrder begin");
		String version = "2.1";
		String serviceType = "pushOrder";

		/**
		 * 请求业务参数
		 */
		Map<String, String> request = new HashMap<String, String>();

		request.put("amount", "100");
		request.put("payType", "wx");
		request.put("orderId", System.currentTimeMillis() + "");
		request.put("businessTime", System.currentTimeMillis() + "");
		request.put("notifyUrl", notifyUrl);
		request.put("orderDesc", "微信支付订单");
		request.put("merchantId", merchantId);
		request.put("merchantName", "微信机构");
		StringBuilder outSb = new StringBuilder();

		request(partnerId, url1, serviceType, encKey, signKey, version,
				request, outSb, 0);

		System.out.println(outSb.toString());
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

		request.put("orderId", System.currentTimeMillis() + "");
		request.put("orderNo", System.currentTimeMillis() + "");
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
