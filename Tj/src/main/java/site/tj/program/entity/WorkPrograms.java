package site.tj.program.entity;


import java.io.Serializable;
import java.util.Date;


public class WorkPrograms implements Serializable,Cloneable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 乐观锁 */
    private Integer revision ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;
    /** 项目编号 */
    private String progNo ;
    /** 项目名称 */
    private String progName ;
    /** 项目地址 */
    private String progAddr ;
    /** 项目负责人 */
    private String progMan ;
    /** 项目工期（单位：天） */
    private Integer progDyas ;
    /** 合同金额 */
    private Double progPay ;
    /** 已付金额 */
    private Double progHasPay ;
    /** 追加金额 */
    private Double progAddPay ;
    /** 待支付金额 */
    private Double progNopay ;
    /** 项目状态 */
    private Integer progStatus ;
    /** 金额币种 */
    private String cucycd ;
    /** 项目说明 */
    private String progIinfos ;

    /** 乐观锁 */
    public Integer getRevision(){
        return this.revision;
    }
    /** 乐观锁 */
    public void setRevision(Integer revision){
        this.revision = revision;
    }
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
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
    /** 项目编号 */
    public String getProgNo(){
        return this.progNo;
    }
    /** 项目编号 */
    public void setProgNo(String progNo){
        this.progNo = progNo;
    }
    /** 项目名称 */
    public String getProgName(){
        return this.progName;
    }
    /** 项目名称 */
    public void setProgName(String progName){
        this.progName = progName;
    }
    /** 项目地址 */
    public String getProgAddr(){
        return this.progAddr;
    }
    /** 项目地址 */
    public void setProgAddr(String progAddr){
        this.progAddr = progAddr;
    }
    /** 项目负责人 */
    public String getProgMan(){
        return this.progMan;
    }
    /** 项目负责人 */
    public void setProgMan(String progMan){
        this.progMan = progMan;
    }
    /** 项目工期（单位：天） */
    public Integer getProgDyas(){
        return this.progDyas;
    }
    /** 项目工期（单位：天） */
    public void setProgDyas(Integer progDyas){
        this.progDyas = progDyas;
    }
    /** 合同金额 */
    public Double getProgPay(){
        return this.progPay;
    }
    /** 合同金额 */
    public void setProgPay(Double progPay){
        this.progPay = progPay;
    }
    /** 已付金额 */
    public Double getProgHasPay(){
        return this.progHasPay;
    }
    /** 已付金额 */
    public void setProgHasPay(Double progHasPay){
        this.progHasPay = progHasPay;
    }
    /** 追加金额 */
    public Double getProgAddPay(){
        return this.progAddPay;
    }
    /** 追加金额 */
    public void setProgAddPay(Double progAddPay){
        this.progAddPay = progAddPay;
    }
    /** 待支付金额 */
    public Double getProgNopay(){
        return this.progNopay;
    }
    /** 待支付金额 */
    public void setProgNopay(Double progNopay){
        this.progNopay = progNopay;
    }
    /** 项目状态 */
    public Integer getProgStatus(){
        return this.progStatus;
    }
    /** 项目状态 */
    public void setProgStatus(Integer progStatus){
        this.progStatus = progStatus;
    }
    /** 金额币种 */
    public String getCucycd(){
        return this.cucycd;
    }
    /** 金额币种 */
    public void setCucycd(String cucycd){
        this.cucycd = cucycd;
    }
    /** 项目说明 */
    public String getProgIinfos(){
        return this.progIinfos;
    }
    /** 项目说明 */
    public void setProgIinfos(String progIinfos){
        this.progIinfos = progIinfos;
    }
}