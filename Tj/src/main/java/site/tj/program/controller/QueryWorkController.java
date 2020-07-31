package site.tj.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import site.tj.program.conf.GlobalParameters;
import site.tj.program.entity.DayRecords;
import site.tj.program.entity.Emplyees;
import site.tj.program.entity.EmplyeesRecord;
import site.tj.program.entity.TableName;
import site.tj.program.entity.TableResponse;
import site.tj.program.entity.TableTitle;
import site.tj.program.entity.WorkPrograms;
import site.tj.program.entity.ZPage;
import site.tj.program.mapper.WorkProgramMapper;

@RestController
public class QueryWorkController {
	@Autowired(required = false)
	WorkProgramMapper workProgramMapper;
	@Autowired
	TableTitle tableTitle;
	ZPage defaultZPage=new ZPage(0, 10, 100);
	int pz=defaultZPage.getPageSize();
	@PostMapping("/all/empl")
	public TableResponse allEmplyees(ZPage zpage) {
		TableResponse tr=new TableResponse();
		if(zpage.getPageNo()==0) {
			tr.setThead(tableTitle.getTableTitles(TableName.Emplyees));
		}
		System.out.println(zpage.toString());
		List<Emplyees> tdata=workProgramMapper.selectEmplyees(true,zpage.getPageNo()*pz,pz);
		if(tdata!=null) {
			tr.setMsg("查询成功!");
			tr.setTip("查询未出错");
		}else {
			tr.setMsg("查询失败!");
			tr.setTip("出现错误。。");
		}
		tr.setTdata(tdata);
		return tr;
	}
	@PostMapping("/all/dayrecord")
	public TableResponse allDayRecords(ZPage zpage) {
		TableResponse tr=new TableResponse();
		if(zpage.getPageNo()==0) {
			tr.setThead(tableTitle.getTableTitles(TableName.DayRecords));
		}
		System.out.println(zpage.toString());
		List<DayRecords> tdata=workProgramMapper.selectDayRecords(true,zpage.getPageNo()*pz,pz);
		if(tdata!=null) {
			tr.setMsg("查询成功!");
			tr.setTip("查询未出错");
		}else {
			tr.setMsg("查询失败!");
			tr.setTip("出现错误。。");
		}
		tr.setTdata(tdata);
		return tr;
	}
	@PostMapping("/all/emplrecord")
	public TableResponse allEmplyeesRecords(ZPage zpage) {
		TableResponse tr=new TableResponse();
		if(zpage.getPageNo()==0) {
			tr.setThead(tableTitle.getTableTitles(TableName.EmplyeesRecord));
		}
		System.out.println(zpage.toString());
		List<EmplyeesRecord> tdata=workProgramMapper.selectEmplyeesRecord(true,zpage.getPageNo()*pz,pz);
		if(tdata!=null) {
			tr.setMsg("查询成功!");
			tr.setTip("查询未出错");
		}else {
			tr.setMsg("查询失败!");
			tr.setTip("出现错误。。");
		}
		tr.setTdata(tdata);
		return tr;
	}
	@PostMapping("/all/wrokprogram")
	public TableResponse allWorkProrams(ZPage zpage) {
		TableResponse tr=new TableResponse();
		if(zpage.getPageNo()==0) {
			tr.setThead(tableTitle.getTableTitles(TableName.WorkPrograms));
		}
		System.out.println(zpage.toString());
		List<WorkPrograms> tdata=workProgramMapper.selectWorkPrograms(true,zpage.getPageNo()*pz,pz);
		if(tdata!=null) {
			tr.setMsg("查询成功!");
			tr.setTip("查询未出错");
		}else {
			tr.setMsg("查询失败!");
			tr.setTip("出现错误。。");
		}
		tr.setTdata(tdata);
		return tr;
	}
}
