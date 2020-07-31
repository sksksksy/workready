package site.tj.program.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TableTitle {
	List<String> temp=new ArrayList<String>();
	public List<String> getTableTitles(TableName tablename){
		temp.clear();
		switch (tablename) {
		case DayRecords:
			temp.add("创建人");
			temp.add("创建时间");
			temp.add("更新人");
			temp.add("更新时间");
			temp.add("项目编号");
			temp.add("地址");
			temp.add("id");
			temp.add("备注金额");
			temp.add("员工号");
			break;
		case Emplyees:
//			temp.add("创建人");
			temp.add("创建时间");
			temp.add("最近一次更新人");
			temp.add("更新时间");
			temp.add("职工编号");
			temp.add("名字");
			temp.add("电话");
			temp.add("年龄");
			temp.add("籍贯");
			break;
		case EmplyeesRecord:
//			temp.add("创建人");
			temp.add("创建时间");
			temp.add("主键");
			temp.add("职工编号");
			temp.add("项目编号");
			temp.add("在该项目所得金额");
			temp.add("在该项目天数");
			break;
		case WorkPrograms:
//			temp.add("乐观锁");
			temp.add("创建人");
			temp.add("创建时间");
			temp.add("更新人");
			temp.add("更新时间");
			temp.add("项目编号");
			temp.add("项目名称");
			temp.add("项目地址");
			temp.add("项目负责人");
			temp.add("项目工期（单位：天）");
			temp.add("合同金额");
			temp.add("已付金额");
			temp.add("追加金额 ");
			temp.add("待支付金额");
			temp.add("项目状态");
			temp.add("金额币种");
			temp.add("项目说明");
			break;
		default:
			break;
		}
		return temp;
		
	}
}
