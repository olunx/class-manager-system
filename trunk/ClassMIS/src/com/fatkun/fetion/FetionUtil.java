package com.fatkun.fetion;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FetionUtil {
	private final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
	private static FetionUtil instance;

	public static FetionUtil getInstance() {
		return instance == null ? new FetionUtil() : instance;
	}

	// 正则得到匹配的内容
	public ArrayList<String> centerStr(String sourceStr, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(sourceStr);
		ArrayList<String> list = new ArrayList<String>();
		if (matcher.find())
			for (int i = 0; i <= matcher.groupCount(); i++)
				list.add(matcher.group(i));
		return list;
	}

	// 计算response
	public String getResponseStr(String _sid, String _passwd, String _domain, String _nonce, String _cnonce) {
		String md5Str = ":" + _nonce + ":" + _cnonce;
		String md5Str2 = _sid + ":" + _domain + ":" + _passwd;
		String H1 = computeH1(md5Str2, md5Str);
		md5Str = "REGISTER:" + _sid;
		String H2 = MD5Encode(md5Str);
		md5Str = H1 + ":" + _nonce + ":" + H2;
		return MD5Encode(md5Str);
	}

	public String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return (new StringBuilder()).append(hexDigits[d1]).append(hexDigits[d2]).toString();
	}

	public String MD5Encode(String origin) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(origin.getBytes("utf-8")));
		} catch (Exception ex) {
		}
		return resultString;
	}

	public String computeH1(String s1, String s2) {
		String res = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte key[] = md.digest(s1.getBytes("utf-8"));
			byte ss[] = s2.getBytes("utf-8");
			byte t[] = new byte[key.length + ss.length];
			for (int i = 0; i < key.length; i++)
				t[i] = key[i];

			for (int i = 0; i < ss.length; i++)
				t[key.length + i] = ss[i];

			res = byteArrayToHexString(md.digest(t));
		} catch (Exception e) {
		}
		return res;
	}
	
	/**
	 * 构建发送指令
	 * 
	 * @param cmd
	 * @param fields
	 * @param args
	 * @return
	 */
	public String buildSIPPRequest(String cmd, String[] fields, String args) {
		StringBuffer sb = new StringBuffer();
		sb.append(cmd).append(" fetion.com.cn SIP-C/2.0").append("\r\n");
		for (int i = 0; i < fields.length; i++) {
			sb.append(fields[i]).append("\r\n");
		}
		sb.append("I: 1").append("\r\n").append("Q: 1 ").append(cmd).append("\r\n");
		if (!args.equals("")) {
			try {
				sb.append("L: ").append(args.getBytes("UTF-8").length).append("\r\n\r\n").append(args);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			sb.append("\r\n");
		}
//		System.out.println("[SEND]>>>>>>=================================");
//		System.out.println(sb.toString());
//		System.out.println("=============================================");
		return sb.toString();
	}
}
