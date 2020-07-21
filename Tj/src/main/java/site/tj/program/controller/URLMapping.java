package site.tj.program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLMapping {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/index")
	public String index01() {
		return "index";
	}
}
