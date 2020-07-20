package site.tj.program.mapper;

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
		
		public int selectDayRecords(@Param("dayR") DayRecords dayRecords);
		public int selectEmplyees(@Param("empl") Emplyees empl);
		public int selectEmplyeesRecord(@Param("emplRe") EmplyeesRecord emplRe);
		public int selectWorkPrograms(@Param("workp") WorkPrograms workProgram);
}
