package site.tj.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import site.tj.program.entity.DayRecords;
import site.tj.program.entity.Emplyees;
import site.tj.program.entity.EmplyeesRecord;
import site.tj.program.entity.VResponse;
import site.tj.program.entity.WorkPrograms;
import site.tj.program.mapper.WorkProgramMapper;

@RestController
public class QueryWorkController {
	@Autowired
	WorkProgramMapper workProgramMapper;
	
	@GetMapping("/all/empl")
	public VResponse allEmplyees() {
		VResponse vr=new VResponse();
		List<Emplyees> vdata=workProgramMapper.selectEmplyees();
		if(vdata!=null) {
			vr.setMsg("查询成功!");
		}else {
			vr.setMsg("查询失败!");
		}
		vr.setVdata(vdata);
		return vr;
	}
	@GetMapping("/all/dayrecord")
	public VResponse allDayRecords() {
		VResponse vr=new VResponse();
		List<DayRecords> vdata=workProgramMapper.selectDayRecords();
		if(vdata!=null) {
			vr.setMsg("查询成功!");
		}else {
			vr.setMsg("查询失败!");
		}
		vr.setVdata(vdata);
		return vr;
	}
	@GetMapping("/all/emplrecord")
	public VResponse allEmplyeesRecords() {
		VResponse vr=new VResponse();
		List<EmplyeesRecord> vdata=workProgramMapper.selectEmplyeesRecord();
		if(vdata!=null) {
			vr.setMsg("查询成功!");
		}else {
			vr.setMsg("查询失败!");
		}
		vr.setVdata(vdata);
		return vr;
	}
	@GetMapping("/all/wrokprogram")
	public VResponse allWorkProrams() {
		VResponse vr=new VResponse();
		List<WorkPrograms> vdata=workProgramMapper.selectWorkPrograms();
		if(vdata!=null) {
			vr.setMsg("查询成功!");
		}else {
			vr.setMsg("查询失败!");
		}
		vr.setVdata(vdata);
		return vr;
	}
}
