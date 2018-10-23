package com.fx.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class OnlineDemos {
	
	
	
	
	private static String TMK = "6E0DF145E63E3E4675F275942AD97C83";
	
	
	public static void main(String[] args) throws Exception {
		Map<String, String> dataMap = new HashMap<String, String>();
		
		dataMap.put("pan", "6214920205187642");//6212260200006861575  827110070110953 6225758209488955 6214920205187642
//		dataMap.put("pan", "6225758209488955");//借记卡
		dataMap.put("phone", "18500369569");
		dataMap.put("amount", "2");
		// 编码格式
		dataMap.put("encoded", "UTF-8");
		dataMap.put("trano", "HF1000000002064");
		dataMap.put("dmnum", "100004");
		dataMap.put("msgtype", "H197");
		dataMap.put("settletype", "D1");
		dataMap.put("name", "姓名");

		dataMap.put("stan","P" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));


//		{"msgtype":"H197","pan":"4392260802157618","name":"黄昌可","phone":"13764610737","encoded":"UTF-8","trano":"HF1000000002064","dmnum":"100004","stan":"2915114902352761511490235276","amount":"13764610737","settletype":"D1","signature":"0b72763942c20e1cc09c921c7b2a3dc3"} [JuhePayService.getSMSCode]


		dataMap.put("signature", getSignature(dataMap, TMK));// 签名
		String str = send(dataMap);
//		JSONObject jsonObject = JSONObject.fromObject(str);
	}
	
	public static String getSignature(Map<String, String> dataMap, String tmk)
			throws Exception {
		Map<String, String> map = new TreeMap<String, String>();
		map.putAll(dataMap);
		StringBuffer mabStr = new StringBuffer();
		for (String key : map.keySet()) { // 拼接计算签名的字符串
			if (!"signature".equals(key)) {
				mabStr.append(key);
				mabStr.append("=");
				mabStr.append(map.get(key));
				mabStr.append("&");
			}
		}
		String mab = mabStr.toString();
		mab = mab.substring(0, mab.length() - 1);
		return encryptMD5(mab, tmk, "UTF-8"); // MD5加密得到签名字符串
	}
	

	private static String send(Map<String, String> dataMap) throws Exception{
		String dataStr = changeMapToJson(dataMap);
		System.out.println("请求明文包："+dataMap);
		dataStr = encryptBase64(dataStr, "UTF-8");
		dataStr = connServer(dataStr);
		System.out.println(dataStr);
		return dataStr;
	}
	
	public static String decipherBase64(String dataStr, String encoded)
			throws Exception {
		try {
			byte[] b = null;
			BASE64Decoder decoder = new BASE64Decoder();
			b = decoder.decodeBuffer(dataStr);
			return new String(b, encoded);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public static String encryptBase64(String dataStr, String encoded)
			throws Exception {
		try {
			byte[] b = null;
			String s = null;
			b = dataStr.getBytes(encoded);
			if (b != null) {
				s = new BASE64Encoder().encode(b);
			}
			s = s.replace("\r", "");
			s = s.replace("\n", "");
			return s;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public static String changeMapToJson(Map<String, String> map)
			throws Exception {
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString(); // 将MAP对象转为JSON字符串
	}
	
	/**
	 ********************************************************* .<br>
	 * [方法] encryptMD5 <br>
	 * [描述] MD5加密-得到MD5加密字符串 <br>
	 * [参数] 要加密的字符串、密钥、编码格式 <br>
	 * [返回] String <br>
	 * [时间] 2014-11-30 下午4:07:57 <br>
	 ********************************************************* .<br>
	 */
	public static String encryptMD5(String dataStr, String tmk, String encoded) throws Exception{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(dataStr.getBytes(encoded));
			StringBuffer result=new StringBuffer();
			byte[] temp = md5.digest(tmk.getBytes(encoded));
			for (int i = 0; i < temp.length; i++) {
				result.append(Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6));
			}
			return result.toString();
	}


	public static String byte2HexStr(byte[] b) throws Exception {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			hs = appendFields(hs,
					(stmp.length() == 1) ? appendFields("0", stmp)
							: stmp);
		}
		return hs.toUpperCase();
	}
	public static String connServer(String data) {
		OutputStream os = null;
		InputStream is = null;
		Socket socket = null;
		try {
			socket = new Socket("115.182.226.206" , 19009);
			socket.setSoTimeout(20000);
			os = socket.getOutputStream();
			is = socket.getInputStream();
			System.out.println("请求原包String："+data);

			byte[] by = hexStr2Bytes(str2HexStr(data)); //传入数据
			byte[] dateh = shortToBytes((short) (by.length));  
			byte[] true_body = assemble(dateh,by);  
			System.out.println("请求原包："+byte2HexStr(true_body));
			os.write(true_body);
			os.flush();
			byte[] lenbtyte = new byte[4];
			is.read(lenbtyte, 0, 4);
			int resplen = Integer.parseInt(new String(lenbtyte, "UTF-8"));
			byte[] pack = new byte[resplen];
			int trueLen  = is.read(pack, 0, resplen);
			while (trueLen < resplen){
				trueLen += is.read(pack, trueLen, resplen-trueLen);
			}
			String dataStr = new String(pack, "UTF-8");
			String s = decipherBase64(dataStr, "UTF-8");
			System.out.println("s: " + s);
			return dataStr;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeIO(socket, is, os);
		}
		return null;
	}
	
	public static String str2HexStr(String str) throws UnsupportedEncodingException {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes("GBK");
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
		}
		return sb.toString();
	}
	public static byte[] hexStr2Bytes(String src) throws Exception {
		int m = 0, n = 0;
		int l = src.length() / 2;
		byte[] ret = new byte[l];
		for (int i = 0; i < l; i++) {
			m = i * 2 + 1;
			n = m + 1;
			ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
		}
		return ret;
	}

	private static byte uniteBytes(String src0, String src1) throws Exception {
		byte b0 = Byte.decode("0x" + src0).byteValue();
		b0 = (byte) (b0 << 4);
		byte b1 = Byte.decode("0x" + src1).byteValue();
		byte ret = (byte) (b0 | b1);
		return ret;
	}
	

	public static byte[] shortToBytes(short val) {
		byte[] b = new byte[2];
		for (int i = 0; i < 2; i++) {
			b[i] = (byte) (val >>> (8 - i * 8));
		}
		return b;
	}
	
	public static byte[] assemble(byte[]... b) throws Exception {
		int length = 0;
		for (byte[] bl : b) {
			if (bl != null)
				length += bl.length;
		}
		byte[] data = new byte[length];
		int count = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] != null) {
				System.arraycopy(b[i], 0, data, count, b[i].length);
				count += b[i].length;
			}
		}
		return data;
	}
	
	protected static void closeIO(Socket socket, InputStream input, OutputStream output) {
		try {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String appendFields(Object ... params) {
		StringBuffer sbf = new StringBuffer();
		for (Object str : params) {
			sbf.append(str);
		}
		return sbf.toString();
	}
	
}
