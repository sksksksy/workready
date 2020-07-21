package site.part.ms.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class GennerallyUtil {
	/**
	 * 获取uid
	 * @return
	 */
	public final static String getUUId() {
		String uid=UUID.randomUUID().toString();
		return uid.replace("-","");
	} 
	/**
	 * 根据pattern获取当前时间
	 * @param pattern
	 * @return
	 */
	public final static String getTime(String pattern) {
		long t=System.currentTimeMillis();
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(t);
	}
	public final static String getBytes() {
		return null;
	}
	/**
	 * 关闭输出流
	 * @param out
	 */
	public final static void closeOutputStream(OutputStream out) {
		if(out!=null) {
			try {
				out.close();
			}catch (IOException e) {
//				
			}
		}
	}
	/**
	 * 关闭输入流
	 * @param out
	 */
	public final static void closeInputStream(InputStream out) {
		if(out!=null) {
			try {
				out.close();
			}catch (IOException e) {
//				
			}
		}
	}
}
