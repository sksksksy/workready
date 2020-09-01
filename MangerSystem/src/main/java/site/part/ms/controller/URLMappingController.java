package site.part.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import site.part.ms.entity.DirTable;
import site.part.ms.resp.MSResponseStatus;
import site.part.ms.resp.MSResponseStatus.MsStatus;
import site.part.ms.service.async.URLAsyncTask;
import site.part.ms.service.impl.DirTableService;
import site.part.ms.util.GenerateJsDataFile;

import java.util.List;

//@Scope("prototype")
@Controller
public class URLMappingController {
	Logger L= LoggerFactory.getLogger(URLMappingController.class);
	@Autowired
	DirTableService dirTableService;
	@Autowired
	GenerateJsDataFile generateJsDataFile;
	@Autowired
	URLAsyncTask urlAsyncTask;
	int a=0;
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		System.err.println(a);
		urlAsyncTask.dealAsync();
		a++;
		return "hello";
	}
	@GetMapping(value = "/test/{url}")
	@ResponseBody
	public MSResponseStatus test(@PathVariable("url") String urla) {
		MSResponseStatus rs=new MSResponseStatus();
		a++;
		return rs;
	}
	@GetMapping("/h")
	public String hel() {
		System.err.println(a);
		a++;
		return "htmls/hello";
	}
	@GetMapping("/get/dir/{id}")
	@ResponseBody
	public MSResponseStatus getDirs(@PathVariable Integer id){
		L.info("我请求到了"+id);
		return new MSResponseStatus(dirTableService.getDirs(id));
	}
	@GetMapping("/get/{id}")
	@ResponseBody
	public MSResponseStatus getDir(@PathVariable Integer id){
		System.out.println("我请求到了"+id);
		Object o=dirTableService.getSubDirs(id);
		StringBuffer s=generateJsDataFile.JsonText(0);
		System.out.println(s.toString());
		return new MSResponseStatus((List<DirTable>)o);
	}
}