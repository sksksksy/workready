package site.part.ms.resp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author ZHP
 * 构建自己的返回报文体
 */
public class MSResponseStatus {
	private String msg;
	private int statusCode;
	private Map<String, Object> data;
	public static enum MsStatus{
		SUCCESSFUL(1),//成功
		LOGIN_ERROR(-2),
		DEFAULT_ERROR(-1);//默认错误
		public int val=0;
		MsStatus(int i) {
			this.val=i;
		}
		public int getVal() {
			return this.val;
		}
		public void setVal(int value) {
			this.val=value;
		}
	}
	public MSResponseStatus() {
		data=new LinkedHashMap<String, Object>();
	}
	public MSResponseStatus(String msg,MsStatus statusCode) {
		this.msg=msg;
		this.statusCode=statusCode.getVal();
		data=new LinkedHashMap<String, Object>();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(MsStatus statusCode) {
		this.statusCode = statusCode.getVal();
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public void setKeyValue(String key,Object val) {
		this.data.put(key, val);
	}
	public Object getValByKey(String key) {
		return this.data.get(key);
	}
}
