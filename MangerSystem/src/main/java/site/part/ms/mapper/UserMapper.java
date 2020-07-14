package site.part.ms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import site.part.ms.entity.User;

@Mapper
public interface UserMapper {
	public int login(@Param("user") User user);
	public int updateLoginStatus(@Param("user") User user);
}
