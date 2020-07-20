package site.tj.program.entity;


import java.io.Serializable;
import java.util.Date;


public class EmplyeesRecord implements Serializable,Cloneable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 主键 */
    private String id ;
    /** 职工编号 */
    private String emplNo ;
    /** 项目编号 */
    private String progNo ;
    /** 在该项目所得金额 */
    private Double money ;
    /** 在该项目天数 */
    private Integer days ;

    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
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
    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id = id;
    }
    /** 职工编号 */
    public String getEmplNo(){
        return this.emplNo;
    }
    /** 职工编号 */
    public void setEmplNo(String emplNo){
        this.emplNo = emplNo;
    }
    /** 项目编号 */
    public String getProgNo(){
        return this.progNo;
    }
    /** 项目编号 */
    public void setProgNo(String progNo){
        this.progNo = progNo;
    }
    /** 在该项目所得金额 */
    public Double getMoney(){
        return this.money;
    }
    /** 在该项目所得金额 */
    public void setMoney(Double money){
        this.money = money;
    }
    /** 在该项目天数 */
    public Integer getDays(){
        return this.days;
    }
    /** 在该项目天数 */
    public void setDays(Integer days){
        this.days = days;
    }
}