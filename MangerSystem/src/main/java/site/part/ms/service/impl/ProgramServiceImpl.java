package site.part.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.part.ms.entity.Program;
import site.part.ms.mapper.ProgramMapper;
import site.part.ms.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {
	@Autowired
	ProgramMapper progmapper;
	@Override
	public List<Program> paging(int start, int count) {
		List<Program> r=progmapper.paging(start, count);
		return r;
	}

}
