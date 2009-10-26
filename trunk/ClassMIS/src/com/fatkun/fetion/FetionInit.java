package com.fatkun.fetion;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 飞信初始化
 * @author Fatkun http://www.fatkun.com
 *
 */
class FetionInit {
	String sipc_proxy = "", ssi_app_sign_in = "", ssi_app_sign_out = "", uri = "", sid = "";
	static String sysConfigUrl = "http://nav.fetion.com.cn/nav/getsystemconfig.aspx";

	// 正则得到匹配的内容
	public static ArrayList<String> centerStr(String sourceStr, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(sourceStr);
		ArrayList<String> list = new ArrayList<String>();
		if (matcher.find())
			for (int i = 0; i <= matcher.groupCount(); i++)
				list.add(matcher.group(i));
		return list;
	}

	public String postUrl(String urlStr, String sendData) throws IOException {
		URL url;
		String htmlData = "";
		url = new URL(urlStr);
		String content = sendData;

		URLConnection uc = url.openConnection();
		// 表明程序必须把名称/值对输出到服务器程序资源
		uc.setDoOutput(true);
		uc.setUseCaches(false);
		uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// 设置Content-Type头部指示指定URL已编码数据的窗体MIME类型
		uc.setRequestProperty("Content-Length", "" + content.length());
		HttpURLConnection hc = (HttpURLConnection) uc;
		hc.setRequestMethod("POST");

		// 发送内容
		OutputStream os = uc.getOutputStream();
		os.write(content.getBytes());
		os.close();

		// 从服务器程序资源输入和显示内容
		InputStream is = uc.getInputStream();
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(is, "ISO_8859_1"));
		StringBuffer sb = new StringBuffer();
		String tempStr;
		while ((tempStr = bufReader.readLine()) != null) {
			sb.append(tempStr).append("\r\n");
		}
		is.close();
		bufReader.close();
		htmlData = new String(sb.toString().getBytes("ISO_8859_1"), "utf-8");
		return htmlData;
	}

	// 初始化
	public ArrayList<String> InitAction(String phone, String passwd) throws IOException {
		String loginResult,sidResult;
		String sysConfigArg = "<config><user mobile-no=\"" + phone
				+ "\" /><client type=\"PC\" version=\"3.3.0370\" platform=\"W5.1\" /><servers version=\"0\" /><service-no version=\"12\" /><parameters version=\"15\" /><hints version=\"13\" /><http-applications version=\"14\" /><client-config version=\"17\" /></config>";

		ArrayList<String> loginInfo = new ArrayList<String>();

		loginResult = postUrl(sysConfigUrl, sysConfigArg);
		sipc_proxy = centerStr(loginResult, "<sipc-proxy>(.*?)</sipc-proxy>").get(1);
		ssi_app_sign_in = centerStr(loginResult, "<ssi-app-sign-in>(.*?)</ssi-app-sign-in>").get(1);
		ssi_app_sign_out = centerStr(loginResult, "<ssi-app-sign-out>(.*?)</ssi-app-sign-out>").get(1);
		ssi_app_sign_in = ssi_app_sign_in.replace("https", "http");
		
		sidResult = postUrl(ssi_app_sign_in, "mobileno=" + phone + "&pwd=" + passwd + "");
		sid = centerStr(sidResult, "<user uri=\"sip:([0-9]+)@fetion.com.cn;p=[0-9]+\"").get(1);

		loginInfo.add(sipc_proxy);
		loginInfo.add(ssi_app_sign_in);
		loginInfo.add(ssi_app_sign_out);
		loginInfo.add(sid);
		
		System.out.println(loginResult);
		System.out.println(sidResult);
		System.out.println(loginInfo);
		return loginInfo;
	}

}