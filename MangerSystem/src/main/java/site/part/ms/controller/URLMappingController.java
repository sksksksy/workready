package site.part.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.part.ms.resp.MSResponseStatus;
import site.part.ms.resp.MSResponseStatus.MsStatus;
import site.part.ms.service.async.URLAsyncTask;

//@Scope("prototype")
@Controller
public class URLMappingController {
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
		MSResponseStatus rs=new MSResponseStatus("这是一个测试", MsStatus.SUCCESSFUL);
		rs.setKeyValue("url", urla);
		System.err.println(a);
		a++;
		return rs;
	}
	@GetMapping("/h")
	public String hel() {
		System.err.println(a);
		a++;
		return "htmls/hello";
	}
}