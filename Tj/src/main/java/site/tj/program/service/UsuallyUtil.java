package site.tj.program.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UsuallyUtil {
	/**
	 * 获取当前系统时间，使用pattern控制格式
	 * @param pattern
	 * @return
	 */
	public final static String getNowTime(String pattern) {
		SimpleDateFormat s=new SimpleDateFormat(pattern);
		return s.format(System.currentTimeMillis());
	}
	/**
	 * 获取时间
	 * @return
	 */
	public final static Date getNowData() {
		return new Date();
	}
	/**
	 * 获取编号
	 * @param type
	 * @return
	 */
	public final static String No(String type) {
		String d=getNowTime("yyyyMMddHHmmss");
		int i=(int) Math.floor(Math.random()*10);
		String a=Integer.toHexString(i<<4);
		return type+"_"+d+a;
	}
	public final static String getUUId() {
		String a=UUID.randomUUID().toString();
		return a.replace("-", "");
	}
}





