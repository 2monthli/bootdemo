package com.test.boot.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.boot.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;
	
	//@RequestMapping("/getName")
	@GetMapping("/getName")
	@ResponseBody
    public String getName(HttpServletRequest req){
		System.out.println(req.getParameter("id"));
        return "li";
    }
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public String get(@PathVariable("id") String id) throws JsonProcessingException{
		System.out.println(id);
		return testService.queryName(id);
	}
	
	@PostMapping("/update")
	public String update(Object o){
		return testService.updateName("1");
	}
	
	@DeleteMapping("/del/{id}")
	public String delete(@PathVariable("id") String id){
		return testService.delete(id);
	}
}
