package site.tj.program.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WorkProgramTjMapper {

	public List<String> getProgNo();

	/**
	 * 获取某个员工在某个项目工作的总天数
	 * @param EMPL_NO
	 * @param PROG_NO
	 * @return
	 */
	public double getEmplOneWordDay(@Param("emplNo") String EMPL_NO,@Param("progNo") String PROG_NO);

	/**
	 * 获取该员工在项目中额外获得的钱
	 * @param EMPL_NO
	 * @param PROG_NO
	 * @return
	 */
	public double getMoneyByEmplInProg(@Param("emplNo") String EMPL_NO,@Param("progNo") String PROG_NO);

	/**
	 * 获取该项目总的上班天数，每个人的上班天数之和
	 * @param PROG_NO
	 * @return
	 */
	public double getDaysInProg(@Param("progNo") String PROG_NO);

	/**
	 * 获取中的奖励金额之和
	 * @param PROG_NO
	 * @return
	 */
	public double getNoteMoney(@Param("progNo") String PROG_NO);

	/**
	 * 获取项目的总金额
	 * @return
	 */
	public double getMoneyByProg(@Param("progNo") String PROG_NO);
}
