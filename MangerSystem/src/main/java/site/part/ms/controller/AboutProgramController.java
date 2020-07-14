package site.part.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.part.ms.entity.Program;
import site.part.ms.service.impl.MsPaginationProgram;

@Controller
public class AboutProgramController {
	
	int count=10;
	int current=0;
	@Autowired
	MsPaginationProgram pagination;
	
	@GetMapping("/showlist")
	@ResponseBody
	public List<Program> showList(){
		pagination.setCount(count);
		pagination.setCurrent(current);	
		return pagination.currentPage();
	}
	public List<Program> next(){
		return pagination.nextPage();
	}
	public List<Program> previous(){
		return pagination.previousPage();
		
	}
}
