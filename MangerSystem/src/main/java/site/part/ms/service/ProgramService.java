package site.part.ms.service;

import java.util.List;

import site.part.ms.entity.Program;

public interface ProgramService {
	public List<Program> paging(int start,int count);
}
