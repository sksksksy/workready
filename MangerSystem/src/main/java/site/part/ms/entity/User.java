package site.part.ms.entity;

import java.io.Serializable;


import site.part.ms.util.GennerallyUtil;

public class User implements Serializable{

	private static final long serialVersionUID = -1L;
	
	private String userId;//用户id
	private String userCode;//用户编号
	private String userName;//用户名
	private String password;
	private String emplyeeNo;//员工编号
	private int status;//登录状态
	public User() {
	}
	public User(String userId, String userCode, String userName, String emplyeeNo,int status,String password) {
		super();
		if(userId==null) {
			this.userId=GennerallyUtil.getUUId();
		}else {			
			this.userId = userId;
		}
		this.userCode = userCode;
		this.userName = userName;
		this.password=password;
		this.emplyeeNo = emplyeeNo;
		this.status=status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmplyeeNo() {
		return emplyeeNo;
	}
	public void setEmplyeeNo(String emplyeeNo) {
		this.emplyeeNo = emplyeeNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
