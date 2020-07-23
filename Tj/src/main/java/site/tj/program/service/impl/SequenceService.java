package site.tj.program.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.tj.program.mapper.ProgSequenceMapper;

@Service
public class SequenceService {
	@Autowired
	ProgSequenceMapper progSequenceMapper;
	
	@Transactional
	public synchronized int getSequenceNo(String type) {
		int r=progSequenceMapper.getSequenceNo(type);
		if(r<1) {
			setSequenceNo(1, type);
			r=getSequenceNo(type);
		}
		updateSequenceNo(r,type);
		return r;
	}
	private int setSequenceNo(int seqno,String type) {
		int i=progSequenceMapper.setSequenceNo(type, 1);
		return i;
	}
	
	private int updateSequenceNo(int seqno,String type) {
		int r=0;
		r=progSequenceMapper.updateSequenceNo(type, seqno+1);
		return r;
		
	}
	public List<String> getAllType(){
		return progSequenceMapper.getAllType();
	}
}
