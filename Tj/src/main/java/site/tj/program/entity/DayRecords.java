package site.tj.program.entity;


import java.io.Serializable;
import java.util.Date;

//import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

//@Document(indexName = "dayrecord",indexStoreType = "record")
public class DayRecords implements Serializable,Cloneable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 乐观锁 */
    private Integer revision ;
    /** 创建人(职工号) */
    private String createdBy ;
    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime ;
    /** 更新人(职工号) */
    private String updatedByid ;
    /** 更新时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedTime ;
    /** 项目编号 */
    private String progNo ;
    /** 地址 */
    private String addr ;
    /** id */
    private String dayId ;
    /** 备注金额 */
    private Double notePay ;
    /** 员工号*/
    private String emplno;

  /** 乐观锁 */
    public Integer getRevision(){
        return this.revision;
    }
    /** 乐观锁 */
    public void setRevision(Integer revision){
        this.revision = revision;
    }
    /** 创建人(职工号) */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人(职工号) */
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
    /** 更新人(职工号) */
    public String getUpdatedByid(){
        return this.updatedByid;
    }
    /** 更新人(职工号) */
    public void setUpdatedByid(String updatedByid){
        this.updatedByid = updatedByid;
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
    /** 地址 */
    public String getAddr(){
        return this.addr;
    }
    /** 地址 */
    public void setAddr(String addr){
        this.addr = addr;
    }
    /** id */
    public String getDayId(){
        return this.dayId;
    }
    /** id */
    public void setDayId(String dayId){
        this.dayId = dayId;
    }
    /** 备注金额 */
    public Double getNotePay(){
        return this.notePay;
    }
    /** 备注金额 */
    public void setNotePay(Double notePay){
        this.notePay = notePay;
    }

    public String getEmplNo() {
        return emplno;
    }
    public void setEmplNo(String emplno) {
        this.emplno = emplno;
    }

    @Override
    public String toString() {
        return "DayRecords{" +
                "revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedByid='" + updatedByid + '\'' +
                ", updatedTime=" + updatedTime +
                ", progNo='" + progNo + '\'' +
                ", addr='" + addr + '\'' +
                ", dayId='" + dayId + '\'' +
                ", notePay=" + notePay +
                ", emplno='" + emplno + '\'' +
                '}';
    }
}