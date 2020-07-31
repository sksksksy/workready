package site.tj.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import site.tj.program.entity.TableResponse;
import site.tj.program.mapper.WorkProgramTjMapper;
import site.tj.program.service.impl.WPTJService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class QueryController {
	@Autowired(required = false)
	WorkProgramTjMapper wProgramTjMapper;

	@Autowired
	WPTJService wptjService;

	public TableResponse getxx() {
		TableResponse vr=new TableResponse();
		return vr;
	}
	@PostMapping("/get/infos")
	public TableResponse getGzxx(String EmplNo, String ProgNo){
		TableResponse vr=new TableResponse();
		System.out.println(EmplNo+"\t&&&&"+ProgNo);
		Map<String,Double> r=wptjService.progData(EmplNo, ProgNo);
		List<Map<String,Double>> l=new LinkedList<>();
		l.add(r);
		vr.setTdata(l);
		return vr;
	}
}
