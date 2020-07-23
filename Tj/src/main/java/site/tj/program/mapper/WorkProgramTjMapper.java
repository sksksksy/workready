package site.tj.program.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkProgramTjMapper {
	public List<String> getProgNo();
}
