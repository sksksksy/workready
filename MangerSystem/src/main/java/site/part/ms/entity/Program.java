package site.part.ms.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


public class Program implements Serializable{
	private static final long serialVersionUID = -1L;
	@Getter @Setter private String progId;//项目编号
	@Getter @Setter private String progName;//项目名称
	@Getter @Setter private String progCreateTime;//项目创建时间
	@Getter @Setter private String progStatus;//项目当前状态
	public Program(String progId, String progName, String progCreateTime, String progStatus) {
		super();
		this.progId = progId;
		this.progName = progName;
		this.progCreateTime = progCreateTime;
		this.progStatus = progStatus;
	}
	public Program() {
		super();
	}
	
}
