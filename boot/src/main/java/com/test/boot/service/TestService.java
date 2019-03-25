package com.test.boot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.boot.dao.TestMapper;
import com.test.boot.vo.UserVo;

@Service
@CacheConfig(cacheNames = {"myCache"})
public class TestService {
	
	private static final Logger logger = LoggerFactory.getLogger(TestService.class);
	
	@Autowired
	private TestMapper testMapper;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Cacheable(key = "targetClass + methodName +#id")//此处没写value
	public String queryName(String id) throws JsonProcessingException{
		ObjectMapper om=new ObjectMapper();
		
		UserVo uo=testMapper.getUserCompanyInfo(Integer.parseInt(id));
	    String sdata=om.writeValueAsString(uo);
	    System.out.println(cacheManager.getCache("targetClass + methodName"+id));
	    return sdata;
	}
	
	@CachePut(key = "targetClass + #id")  //更新缓存数据
	public String updateName(String id){
		logger.info("update value by id=" + id);
		return "success";
	}
	
	@CacheEvict(key="#id")
	public String delete(String id){
		logger.info("delete value by id=" + id);
		return "";
	}
}
