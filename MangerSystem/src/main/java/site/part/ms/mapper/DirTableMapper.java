package site.part.ms.mapper;

import org.apache.ibatis.annotations.*;
import site.part.ms.entity.DirTable;

import java.util.List;

@Mapper
public interface DirTableMapper {
    @Select("select dir_id,parent_dir_id,dir_name from dir_table where dir_id=#{dirId}")
    @Results({
            @Result(column="dir_id",property = "dirId"),
            @Result(column = "parent_dir_id",property = "parentDirId"),
            @Result(column = "dir_name",property = "dirName")
    })
    DirTable getDir(@Param("dirId") Integer dirId);

    @Select("select dir_id,parent_dir_id,dir_name from dir_table where parent_dir_id=#{parentId}")
    @Results({
            @Result(column="dir_id",property = "dirId"),
            @Result(column = "parent_dir_id",property = "parentDirId"),
            @Result(column = "dir_name",property = "dirName")
    })
    List<DirTable> getSubDirs(@Param("parentId") Integer parentId);
}
