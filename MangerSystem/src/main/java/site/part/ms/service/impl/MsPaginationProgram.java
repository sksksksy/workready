package site.part.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import site.part.ms.entity.Program;
import site.part.ms.service.PaginationAdapter;
import site.part.ms.service.ProgramService;

@Service
public class MsPaginationProgram implements PaginationAdapter<List<Program>> {
	@Getter @Setter private int current = 0;
	@Getter @Setter private int count=10;
	@Autowired
	ProgramService progservice;
	@Override
	public List<Program> nextPage() {
		nextp();
		return null;
	}

	@Override
	public List<Program> previousPage() {
		privioustp();
		return null;
	}

	@Override
	public List<Program> currentPage() {
		progservice.paging(this.current, this.count);
		return null;
	}
	
	private void nextp() {
		this.current=this.current+this.count;
	}
	private void privioustp() {
		this.current=this.current-this.count;
	}
}
