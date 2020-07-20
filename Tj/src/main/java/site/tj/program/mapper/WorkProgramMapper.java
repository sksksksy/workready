package site.tj.program.mapper;

import org.apache.ibatis.annotations.Mapper;

import site.tj.program.entity.DayRecords;
import site.tj.program.entity.Emplyees;
import site.tj.program.entity.EmplyeesRecord;
import site.tj.program.entity.WorkPrograms;

@Mapper
public interface WorkProgramMapper {
		public int saveDayRecords(DayRecords dayRecords);
		public int saveEmplyees(Emplyees empl);
		public int saveEmplyeesRecord(EmplyeesRecord emplRe);
		public int saveWorkPrograms(WorkPrograms workProgram);

		public int updateDayRecords(DayRecords dayRecords);
		public int updateEmplyees(Emplyees empl);
		public int updateEmplyeesRecord(EmplyeesRecord emplRe);
		public int updateWorkPrograms(WorkPrograms workProgram);
		
		public int deleteDayRecords(DayRecords dayRecords);
		public int deleteEmplyees(Emplyees empl);
		public int deleteEmplyeesRecord(EmplyeesRecord emplRe);
		public int deleteWorkPrograms(WorkPrograms workProgram);
		
		public int selectDayRecords(DayRecords dayRecords);
		public int selectEmplyees(Emplyees empl);
		public int selectEmplyeesRecord(EmplyeesRecord emplRe);
		public int selectWorkPrograms(WorkPrograms workProgram);
}
