package site.tj.program.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.tj.program.entity.DayRecords;
import site.tj.program.entity.Emplyees;
import site.tj.program.entity.EmplyeesRecord;
import site.tj.program.entity.WorkPrograms;
import site.tj.program.mapper.WorkProgramMapper;
import site.tj.program.service.UsuallyUtil;

@Controller
public class WorkSave {
	
	@Autowired(required = false)
	WorkProgramMapper workProgramMapper;
	
	@Autowired()
	UsuallyUtil ut;
	
	Map<Integer,String> status=new HashMap<Integer, String>();
	public WorkSave(){
		status.put(0, "保存成功");
		status.put(-1, "保存失败");
	}
	@PostMapping("/save/day_records")
	@ResponseBody
	public String saveDayRecords(DayRecords dayr){
		dayr.setDayId(ut.SeqNo("dred"));
		dayr.setCreatedTime(ut.getNowData());
		dayr.setUpdatedTime(ut.getNowData());
		
		int i= workProgramMapper.saveDayRecords(dayr);
		i=i>0?0:-1;
		return status.get(i);
	}
	@PostMapping("/save/emplyees")
	@ResponseBody
	public String saveEmplyees(Emplyees emplyees){
		emplyees.setCreatedTime(ut.getNowData());
		emplyees.setUpdatedTime(ut.getNowData());
		int i= workProgramMapper.saveEmplyees(emplyees);
		i=i>0?0:-1;
		return status.get(i);
	}
	@PostMapping("/save/emplyees_record")
	@ResponseBody
	public String saveEmplyeesRecord(EmplyeesRecord emplyeesRecord){
		emplyeesRecord.setCreatedTime(ut.getNowData());
		int i= workProgramMapper.saveEmplyeesRecord(emplyeesRecord);
		i=i>0?0:-1;
		return status.get(i);
	}
	@PostMapping("/save/work_programs")
	@ResponseBody
	public String saveWorkPrograms(WorkPrograms workPrograms){
		workPrograms.setProgNo(ut.SeqNo("prog"));
		workPrograms.setCreatedTime(ut.getNowData());
		workPrograms.setUpdatedTime(ut.getNowData());
		int i= workProgramMapper.saveWorkPrograms(workPrograms);
		i=i>0?0:-1;
		return status.get(i);
	}
}
