package com.owner.core.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import net.sf.json.xml.XMLSerializer;
import sun.misc.BASE64Encoder;


/**
 * 公共工具类
 * 
 * 作者  Xu Shuai 
 * 版本  1.0 
 * 日期  2015年12月16日
 */
public class CommonUtil {
	// 日志信息
		final static Logger log = LoggerFactory.getLogger(CommonUtil.class);
		/**
		 * 是否为空
		 * 
		 * @param obj
		 * @return
		 */
		public static boolean isEmpty(Object obj) {
			if (obj == null) {
				return true;
			}
			if (obj instanceof String) {
				if (((String) obj).length() == 0) {
					return true;
				}
			} else if (obj instanceof Collection) {
				if (((Collection) obj).size() == 0) {
					return true;
				}
			} else if (obj instanceof Map) {
				if (((Map) obj).size() == 0) {
					return true;
				}
			}
			return false;
		}
		
		public static boolean  isNotEmpty(Object obj) {
			return !isEmpty(obj);
		}

		/**
		 * 将数组对象转换成List集合
		 * @param params
		 * @return
		 */
		public static List<String> arrayTransList(String params[]){
			List<String> list = new ArrayList<String>();
			if(params != null){
				for(String param : params){
					list.add(param);
				}
			}
			
			return list;
		}

		/**
		 * 判断是否是数字类型
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isNumeric(String str) {
			Pattern pattern = Pattern.compile("[0-9]*");
			return pattern.matcher(str).matches();
		}

		/**
		 * 是否是double类型的数据
		 * 
		 * @param str
		 * @return
		 */
		public static boolean isDouble(String str) {
			Pattern pattern = Pattern.compile("\\d+\\.\\d+");
			return pattern.matcher(str).matches();
		}

		/**
		 * 获取随机数
		 */
		public static String getRandomNumber(int count) {
			StringBuffer sb = new StringBuffer();
			String base = "0123456789";
			Random random = new Random();
			for (int i = 0; i < count; i++) {
				int number = random.nextInt(base.length());
				sb.append(base.charAt(number));
			}
			return sb.toString();
		}

		/**
		 * 校验json格式的正确性
		 * 
		 * @param para
		 * @return
		 */
		public static boolean validJsonFormat(String para) {
			boolean flag = false;
			try {
				// 获取的json字符串

				JSONObject.fromObject(para);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}

		/*
		 * 获取随机字符
		 */
		public static String getRandomCode(int count) {
			StringBuffer sb = new StringBuffer();
			String base = "23456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKMNPQRSTUVWXYZ0";
			Random random = new Random();
			for (int i = 0; i < count; i++) {
				int number = random.nextInt(base.length());
				sb.append(base.charAt(number));
			}
			return sb.toString();
		}

		public static Double getObjToDouble(Object obj) {
			Double d = 0D;
			if (!CommonUtil.isEmpty(CommonUtil.getObjToString(obj))) {
				d = Double.valueOf(CommonUtil.getObjToString(obj));
			}
			return d;
		}

		/**
		 * 过滤 SQL 查询条件
		 * 
		 * @param str
		 * @return
		 */
		public static String SqlReplace(String str) {
			if (str == null) {
				return "";
			}
			return str.replaceAll("'", "''");
		}

		/**
		 * 将对象转化为字符串
		 * 
		 * @param obj
		 * @return
		 */
		public static String getObjToString(Object obj) {
			if (isEmpty(obj)) {
				return "";
			}
			return obj.toString();
		}


		/** 获得IP地址 */
		public static String getIp(HttpServletRequest request) {
			String ip = request.getRemoteAddr();// IP
			try {
				if (ip.equals("127.0.0.1")) {
					InetAddress inet = InetAddress.getLocalHost();
					ip = inet.getHostAddress();
				}
			} catch (Exception e) {

				return "";
			}
			return ip;
		}

		/**
		 * 是否是EMAIL格式
		 * 
		 * @param email
		 * @return
		 */
		public static boolean isEmail(String email) {
			/** EMAIL 格式正则 */
			String mailRegx = "[\\w\\.\\_\\-]+@(\\w+.)+[a-zA-Z]{2,3}";
			Pattern pattern = Pattern.compile(mailRegx);
			Matcher m = pattern.matcher(email.toLowerCase());
			if (m.matches()) {
				return true;
			}
			return false;
		}

		/**
		 * 校验url是否符合规范
		 * 
		 * @param url
		 * @return
		 */
		public static boolean isUrl(String url) {
			// 判断是否是带http，https、ftp请求的url地址
			Pattern pattern = Pattern
					.compile(
							"^(http|https|ftp|www|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$",
							Pattern.CASE_INSENSITIVE);
			Matcher m = pattern.matcher(url);
			if (m.matches()) {
				return true;
			}
			return false;
		}

		/**
		 *获取页面json中的值
		 */
		public static String itemJson(String json, String keyastr) {
			String jsonValue = "";
			if (!isEmpty(json)) {
				// 转义模板字段
				net.sf.json.JSONObject js = net.sf.json.JSONObject.fromObject(json);
				// 判断json中是否存在
				if (js.containsKey(keyastr)) {
					jsonValue = js.getString(keyastr);
				}
			}
			return jsonValue;
		}

		/**
		 * 分包截取集合数据
		 * 
		 * @param list
		 *            :要分包的集合需要强制转化为list
		 * @param sertNum
		 *            :分包阀值
		 * @return
		 */
		public static Object getSubList(Object list, int sertNum) {
			List<Object> data = (List<Object>) list;
			// 最后的集合
			List<List<Object>> dataList = new ArrayList<List<Object>>();
			// 数据条数
			int dataSize = data.size();
			// 当前是第几条
			int nowIndex = 0;
			// 是否继续循环
			boolean isNext = true;
			while (isNext) {
				int nextIndex = nowIndex + sertNum;
				if (nextIndex >= dataSize) {
					nextIndex = dataSize;
					isNext = false;
				}
				// 增加到集合数据中
				dataList.add(data.subList(nowIndex, nextIndex));
				nowIndex = nextIndex;
			}
			return dataList;
		}

		/**
		 * 根据列名获取拼接插入表的头部
		 * 
		 * @param fields
		 * @return
		 */
		public static String getSqlHead(String tableName, String[] fields) {
			// 拼接头部
			StringBuffer sqlHead = new StringBuffer("INSERT INTO " + tableName
					+ "(");
			for (int i = 0; i < fields.length; i++) {
				String field = fields[i];
				sqlHead.append(field);
				if (i < fields.length - 1) {
					sqlHead.append(",");
				}
			}
			sqlHead.append(") values ");
			return sqlHead.toString();
		}

		/**
		 * 两个时间之间的天数 ,如果前者小于后者，那么返回0
		 * 
		 * @param date1
		 *            :开始时间
		 * @param date2
		 *            :结束时间
		 * @return
		 */
		public static long getComputeDays(Date date1, Date date2) {
			if (date1.compareTo(date2) >= 0) {
				return (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
			}
			return 0;
		}


		/**
		 * 将xml转为json字符串
		 * 
		 * @param xml
		 * @return
		 */
		public static JSONObject getXmlToJson(String xml) {
			String jsonStr = "";
			try {
				XMLSerializer xmlSerializer = new XMLSerializer();
				JSON json = xmlSerializer.read(xml);
				jsonStr = json.toString(1);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("-------" + xml, e.fillInStackTrace());
			}
			JSONObject jsonObj = null;
			// 如果正常
			if (!CommonUtil.isEmpty(jsonStr)) {
				jsonObj = JSONObject.fromObject(jsonStr);
			}
			return jsonObj;
		}

		/**
		 * 将xml字符串转为Document对象
		 * 
		 * @param xml
		 * @return
		 */
		public static Document getXmlToDoc(String xml) {
			Document doc = null;
			try {
				doc = DocumentHelper.parseText(xml);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("-------" + xml, e.fillInStackTrace());
			}
			return doc;
		}
		
		/**
		 * 两位小数点
		 * 
		 * @param value
		 * @return
		 */
		public static String getTwoDecimal(String value) {
			DecimalFormat df = new DecimalFormat("#.00");
			double doubleValue = Double.parseDouble(value);
			return df.format(doubleValue);
		}

		/**
		 * 处理json的key对于的value值
		 * 
		 * @param jsonObj
		 * @param key
		 * @return
		 */
		public static String getJsonValByKey(JSONObject jsonObj, String key) {
			if (!isEmpty(jsonObj.get(key))) {
				return jsonObj.getString(key);
			}
			return "";
		}

		/**
		 * 将对象转化为int
		 * 
		 * @param obj
		 * @return
		 */
		public static Integer getObjToInteger(Object obj) {
			if (isEmpty(obj)) {
				return 0;
			}
			return Integer.valueOf(getObjToString(obj));
		}

		/**
		 * 转为BigDecimal
		 * @param str
		 * @return
		 */
		public static BigDecimal getStringToBigDecimal(String str) {
			if (str == null) {
				return new BigDecimal("0");
			}
			BigDecimal bd=new BigDecimal(str);
			return bd;
		}

		/**
		 * 将对象转化为int
		 * @param obj
		 * @param defval 默认值
		 * @return
		 */
		public static Integer getObjToInt(Object obj,int defval) {
			if (isEmpty(obj)) {
				return defval;
			}
			return Integer.valueOf(getObjToString(obj));
		}
		
		public static boolean isStringEmpty(String str) {
			return null == str || "".equals(str.trim());
		}

		 /** 
	     * 从json HASH表达式中获取一个map，该map支持嵌套功能 
	     * 形如：{"id" : "johncon", "name" : "小强"} 
	     * 注意commons-collections版本，必须包含org.apache.commons.collections.map.MultiKeyMap 
	     * @param object 
	     * @return 
	     */  
	    public static Map getMapFromJson(String jsonString) {  
	        setDataFormat2JAVA();  
	        JSONObject jsonObject = JSONObject.fromObject(jsonString);  
	        Map map = new HashMap();  
	        for(Iterator iter = jsonObject.keys(); iter.hasNext();){  
	            String key = (String)iter.next();  
	            map.put(key, jsonObject.get(key));  
	        }  
	        return map;  
	    }  
	    
	    private static void setDataFormat2JAVA(){  
	        //设定日期转换格式  
	        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));  
	    } 
	    
	    /**
	     * 删除Html标签
	     * 
	     * @param inputString
	     * @return
	     */
	    public static String htmlRemoveTag(String inputString) {
	        if (inputString == null)
	            return null;
	        String htmlStr = inputString; // 含html标签的字符串
	        String textStr = "";
	        java.util.regex.Pattern p_script;
	        java.util.regex.Matcher m_script;
	        java.util.regex.Pattern p_style;
	        java.util.regex.Matcher m_style;
	        java.util.regex.Pattern p_html;
	        java.util.regex.Matcher m_html;
	        try {
	            //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
	            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; 
	            //定义style的正则表达式{或<style [^="">]*?>[\\s\\S]*?<\\/style>
	            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; 
	            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
	            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
	            m_script = p_script.matcher(htmlStr);
	            htmlStr = m_script.replaceAll(""); // 过滤script标签
	            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
	            m_style = p_style.matcher(htmlStr);
	            htmlStr = m_style.replaceAll(""); // 过滤style标签
	            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
	            m_html = p_html.matcher(htmlStr);
	            htmlStr = m_html.replaceAll(""); // 过滤html标签
	            textStr = htmlStr;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return textStr;// 返回文本字符串
	    }
	    
	    public static String getDateToStringYMD(Date date){
	    	//消息体
			String dateStr = "";
			   Calendar cal = Calendar.getInstance();
			   cal.setTime(date);
			    int day = cal.get(Calendar.DATE);
			    int month = cal.get(Calendar.MONTH) + 1;
			    int year = cal.get(Calendar.YEAR);
			    dateStr=year+"年"+month+"月"+day+"日";
	    	return dateStr;
	    }
	    
	    /**
		 * 获取tomcat的temp目录
		 * @return [tomcat_set_path]\temp
		 */
		public static String getTomcatTempFolder()
		{
			// 创建tomcat bin目录对象
			File binPath = new File(".");
			// tomcat目录
			String tomcatPath;
			
			try 
			{
				// 获取tomcat目录
				tomcatPath = new File(binPath.getCanonicalPath()).getParent();
			} 
			catch (IOException e) {
				e.printStackTrace();
				return "";
			}
			// 拼接tomcat temp目录
			StringBuffer parentPath = new StringBuffer(tomcatPath); 
//			parentPath.append(PubConstants.TOMCAT_TEMP_FOLDER);
			
			return parentPath.toString();
		}
		
		/**
		* TextArea文本转换为Html:写入数据库时使用
		* @author zhengxingmiao
		* @param str
		* @return
		*/
		public static String Text2Html(String str) {
			if (str == null) {
			return "";
			}else if (str.length() == 0) {
			return "";
			}
			str = str.replaceAll("\n", "</p><p>");
			str = str.replaceAll("\r", "");
			return str;
		}
		/**
		* Html转换为TextArea文本:编辑时拿来做转换
		* @author zhengxingmiao
		* @param str
		* @return
		*/
		public static String Html2Text(String str) {
			if (str == null) {
			return "";
			}else if (str.length() == 0) {
			return "";
			}
			str = str.replaceAll("<br/>", "\n");
			str = str.replaceAll("<br/>", "\r");
			return str;
		}
		/**
		 * 开始日期后加2015-08-25 00:00:00
		 * @return
		 */
		public static String getFormatStartTime(String str){
			String returnStr = "";
			if (isDate(str)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					returnStr = sdf.format(sdf.parse(str));
					returnStr = returnStr + " 00:00:00";
				} catch (ParseException e) {
					e.printStackTrace();
					return returnStr;
				}
			}
			return returnStr;
		}
		/**
		 * 结束日期后加2015-08-25 23:59:59
		 * @return
		 */
		public static String getFormatEndTime(String str){
			String returnStr = "";
			if (isDate(str)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					returnStr = sdf.format(sdf.parse(str));
					returnStr = returnStr + " 23:59:59";
				} catch (ParseException e) {
					e.printStackTrace();
					return returnStr;
				}
			}
			return returnStr;
		}
		/**
		 * 校验是否为日期
		 * @param str
		 * @return
		 */
		public static boolean isDate(String str) {
			java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
			try {
			    java.util.Date date = df.parse(str);
			} catch (Exception ex) {
			    return false;
			} // end try - catch
			return true;
		}
		
		/**
		 * 从parameterMap中获得Key对应的值
		 * @param paramMap 类型为String,String[]
		 * @param key  Map中的键
		 * @return Map中key对应的键值
		 */
		public static String getParamterMapValue(Map<String, String[]> paramMap, String key){
			String value = "";
			if (paramMap.containsKey(key)) {
				value = paramMap.get(key)[0];
			}
			return value;
		}
		/**
		 * MD5加密
		 * @param str
		 * @return
		 */
		public static String encryptMD5(String str) {
			if (str != null) {
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					BASE64Encoder bEncoder = new BASE64Encoder();
					str = bEncoder.encode(md.digest(str.getBytes()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return str;
		}
		public static void main(String[] args) {
			System.out.println(encryptMD5("bdmp2015"));
		}
		/**
		 * 把时间格式变为yyyy-MM-DD形式
		 * @param str
		 * @return
		 */
		public static String dateFormat(String str,int flag){//str是要进行变化的时间格式,i代表转化的是yyyy,yyy-MM,yyyy-MM-DD,0,1,2
			if(isEmpty(str))//避免数据是空的出现的问题
			{
				return str;
			}
			String newStr;
			newStr = str.replace(" ", "");
			StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < newStr.length();i++) {
            	char c = newStr.charAt(i);
            	if(c < '0' || c > '9')
            	{
            		c = '-';
            	}
            	stringBuffer.append(c);
            }
            String[] string = stringBuffer.toString().split("-");
            StringBuffer sBuffer = new StringBuffer();
			if(flag == 0)
			{
				if(str.length() < 4)//如果长度小于4那么说明这个时间格式不对
				{
					return null;
				}else {
					return str.substring(0, 4);//截取前4位作为年返回
				}
			}
			else if(flag == 1)//转化为yyyy-MM
			{
	            if(string.length == 1) {
	            	int len = string[0].length();
	            	if(len ==5)
	            	{
	            		sBuffer.append(string[0].substring(0, 4));
	            		sBuffer.append("-0");
	            		sBuffer.append(string[0].substring(4, 5));
	            	}
	            	else if(len == 6){
	            		sBuffer.append(string[0].substring(0, 4));
	            		sBuffer.append("-");
	            		sBuffer.append(string[0].substring(4, 6));
	            	}else if(len == 8){
	            		sBuffer.append(string[0].substring(0, 4));
	            		sBuffer.append("-");
	            		sBuffer.append(string[0].substring(4, 6));
	            	}
	            	else {
	            		return null;
	            	}
	            }
	            else 
	            {
	            	sBuffer.append(string[0]);
	            	sBuffer.append("-");
	            	if(string[1].length() == 1)
	            	{
	            		sBuffer.append("0"+string[1]);	
	            	}
	            	else {
	            		sBuffer.append(string[1]);	
	            	}
	            }
	            Pattern pattern = Pattern.compile("^[1-9]\\d{3}(\\-|\\/|\\.)(0[1-9]|1[0-2])$");
	            Matcher matcher = pattern.matcher(sBuffer.toString());
	            boolean rs = matcher.matches();//用正则表达式去验证
	            if(rs == true)
	            {
	            	return sBuffer.toString();
	            }
	            else {
	            	return null;
	            }
	            
			}
			else {
				if(string.length == 1) {
            		sBuffer.append(string[0].substring(0, 4));
            		sBuffer.append("-");
            		sBuffer.append(string[0].substring(4, 6));
            		sBuffer.append("-");
            		sBuffer.append(string[0].substring(6, 8));
	            }
	            else if(string.length == 3)
	            {
	            	sBuffer.append(string[0]);
            		sBuffer.append("-");
            		if(string[1].length() == 1)
            		{
            			sBuffer.append("0");
            		}
            		sBuffer.append(string[1]);
            		sBuffer.append("-");
            		if(string[2].length() == 1)
            		{
            			sBuffer.append("0");
            		}
            		sBuffer.append(string[2]);
	            }
	            else {
	            	return null;
	            }
				Pattern pattern = Pattern.compile("^[1-9]\\d{3}(\\-|\\/|\\.)(0[1-9]|1[0-2])(\\-|\\/|\\.)(0[1-9]|[1-2][0-9]|3[0-1])$");
		        Matcher matcher = pattern.matcher(sBuffer.toString());
		        boolean rs = matcher.matches();//用正则表达式去验证
	            if(rs == true)
	            {
	            	return sBuffer.toString();
	            }
	            else {
	            	return null;
	            }
			}
			
		}
}
