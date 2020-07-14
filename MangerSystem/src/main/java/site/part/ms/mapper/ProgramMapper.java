package site.part.ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import site.part.ms.entity.Program;

@Mapper
public interface ProgramMapper {
	public List<Program> paging(@Param("startindex") int start,@Param("count") int count);
}
