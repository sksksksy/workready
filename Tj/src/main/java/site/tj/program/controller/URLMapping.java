package site.tj.program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLMapping {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/add")
	public String index01() {
		return "addwork";
	}
	@GetMapping("/proglist")
	public String prog_list() {
		return "prog_list";
	}
	@GetMapping("/query")
	public String query() {
		return "query";
	}
}
