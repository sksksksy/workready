package site.tj.program.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProgSequenceMapper {
	public int getSequenceNo(@Param("prog_type") String type);
	public int setSequenceNo(@Param("prog_type") String type,@Param("sequence_no") int seqno);
	public int updateSequenceNo(@Param("prog_type") String type,@Param("sequence_no") int seqno);
	public List<String> getAllType();
}
