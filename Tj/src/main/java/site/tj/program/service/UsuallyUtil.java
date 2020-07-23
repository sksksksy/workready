package site.tj.program.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import site.tj.program.service.impl.SequenceService;

@Component
public class UsuallyUtil {
	
	@Autowired
	SequenceService sequence;
	/**
	 * 获取当前系统时间，使用pattern控制格式
	 * @param pattern
	 * @return
	 */
	public final  String getNowTime(String pattern) {
		SimpleDateFormat s=new SimpleDateFormat(pattern);
		return s.format(System.currentTimeMillis());
	}
	/**
	 * 获取时间
	 * @return
	 */
	public final  Date getNowData() {
		return new Date();
	}
	/**
	 * 获取编号
	 * @param type
	 * @return
	 */
	public final String SeqNo(String type) {
		String d=getNowTime("yyyyMMdd");
		int r=sequence.getSequenceNo(type);
		String a=type+"_"+d+"#"+r;
		System.out.println("生成的编号："+a+" type:"+type);
		return a;
	}
	public final  String getUUId() {
		String a=UUID.randomUUID().toString();
		return a.replace("-", "");
	}
}





