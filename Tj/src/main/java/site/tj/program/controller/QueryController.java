package site.tj.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import site.tj.program.entity.TableResponse;
import site.tj.program.mapper.WorkProgramTjMapper;

@RestController
public class QueryController {
	@Autowired
	WorkProgramTjMapper wProgramTjMapper;
	
	public TableResponse getxx() {
		TableResponse vr=new TableResponse();
		
		return vr;
	}
}
