package site.tj.program.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Emplyees implements Serializable,Cloneable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 创建人(创建人) */
    private String createdBy ;
    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime ;
    /** 最近一次更新人 */
    private String updatedby_ ;
    /** 更新时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedTime ;
    /** 职工编号 */
    private String emplNo ;
    /** 名字 */
    private String emplName ;
    /** 电话 */
    private String emplNumber ;
    /** 年龄 */
    private Integer emplAge ;
    /** 籍贯 */
    private String emplAddr ;

    /** 创建人(创建人) */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人(创建人) */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 最近一次更新人 */
    public String getUpdatedby_(){
        return this.updatedby_;
    }
    /** 最近一次更新人 */
    public void setUpdatedby_(String updatedby_){
        this.updatedby_ = updatedby_;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
    /** 职工编号 */
    public String getEmplNo(){
        return this.emplNo;
    }
    /** 职工编号 */
    public void setEmplNo(String emplNo){
        this.emplNo = emplNo;
    }
    /** 名字 */
    public String getEmplName(){
        return this.emplName;
    }
    /** 名字 */
    public void setEmplName(String emplName){
        this.emplName = emplName;
    }
    /** 电话 */
    public String getEmplNumber(){
        return this.emplNumber;
    }
    /** 电话 */
    public void setEmplNumber(String emplNumber){
        this.emplNumber = emplNumber;
    }
    /** 年龄 */
    public Integer getEmplAge(){
        return this.emplAge;
    }
    /** 年龄 */
    public void setEmplAge(Integer emplAge){
        this.emplAge = emplAge;
    }
    /** 籍贯 */
    public String getEmplAddr(){
        return this.emplAddr;
    }
    /** 籍贯 */
    public void setEmplAddr(String emplAddr){
        this.emplAddr = emplAddr;
    }
}