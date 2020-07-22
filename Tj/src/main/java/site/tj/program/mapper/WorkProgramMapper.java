package site.tj.program.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import site.tj.program.entity.DayRecords;
import site.tj.program.entity.Emplyees;
import site.tj.program.entity.EmplyeesRecord;
import site.tj.program.entity.WorkPrograms;

@Mapper
public interface WorkProgramMapper {
		public int saveDayRecords(@Param("dayR") DayRecords dayRecords);
		public int saveEmplyees(@Param("empl") Emplyees empl);
		public int saveEmplyeesRecord(@Param("emplRe") EmplyeesRecord emplRe);
		public int saveWorkPrograms(@Param("workp") WorkPrograms workProgram);

		public int updateDayRecords(@Param("dayR") DayRecords dayRecords);
		public int updateEmplyees(@Param("empl") Emplyees empl);
		public int updateEmplyeesRecord(@Param("emplRe") EmplyeesRecord emplRe);
		public int updateWorkPrograms(@Param("workp") WorkPrograms workProgram);
		
		public int deleteDayRecords(@Param("dayR") DayRecords dayRecords);
		public int deleteEmplyees(@Param("empl") Emplyees empl);
		public int deleteEmplyeesRecord(@Param("emplRe") EmplyeesRecord emplRe);
		public int deleteWorkPrograms(@Param("workp") WorkPrograms workProgram);
		
		public List<DayRecords> selectDayRecords();
		public List<Emplyees> selectEmplyees();
		public List<EmplyeesRecord> selectEmplyeesRecord();
		public List<WorkPrograms> selectWorkPrograms();
		
}
