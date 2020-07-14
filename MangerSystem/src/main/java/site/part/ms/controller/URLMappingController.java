package site.part.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.part.ms.resp.MSResponseStatus;
import site.part.ms.resp.MSResponseStatus.MsStatus;

@Controller
public class URLMappingController {
	int a=0;
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		System.err.println(a);
		a++;
		return "hello";
	}
	@GetMapping("/test")
	@ResponseBody
	public MSResponseStatus test() {
		MSResponseStatus rs=new MSResponseStatus("这是一个测试", MsStatus.SUCCESSFUL);
		rs.setKeyValue("url", "/test");
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