package site.tj.program.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import site.tj.program.entity.DayRecords;
import site.tj.program.mapper.WorkProgramMapper;

@Controller
public class WorkMananger {
	
	@Autowired
	WorkProgramMapper workProgramMapper;
	
	Map<Integer,String> status=new HashMap<Integer, String>();
	public WorkMananger(){
		status.put(0, "成功");
		status.put(-1, "失败");
	}
	@PostMapping("/save/day_records")
	public String saveDayRecords(DayRecords dayr){
		int i= workProgramMapper.saveDayRecords(dayr);
		i=i>0?0:-1;
		return status.get(i);
	}
}
