package com.hybrid.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hybrid.model.Dept;

@Mapper
public interface DeptMapper {
	  @Select("SELECT * FROM dept WHERE deptno = #{deptno}")
	  Dept getDept(@Param("deptno") int deptno);
	  
	  @Select("SELECT 999 FROM dual")
	  int getTest();
}
