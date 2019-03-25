package com.test.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.test.boot.vo.UserVo;

@Repository
@Mapper
public interface TestMapper {
	
	UserVo getUserCompanyInfo(@Param(value="user_id")Integer user_id);
}
