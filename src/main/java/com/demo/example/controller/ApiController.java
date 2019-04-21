package com.demo.example.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.bean.RoncooUserLog;
import com.demo.example.cache.RoncooUserLogCache;
import com.demo.example.component.RoncooJavaMailComponent;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private RoncooJavaMailComponent component;

	@RequestMapping(value = "mail")
	public String mail(String email) {
		component.sendMail(email);
		return "success";
	}
	
//细粒度设置
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}
	
	@Autowired
	private RoncooUserLogCache roncooUserLogCache;
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public RoncooUserLog get(@RequestParam(defaultValue = "1") Integer id) {
		return roncooUserLogCache.selectById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RoncooUserLog update(@RequestParam(defaultValue = "1") Integer id) {
		RoncooUserLog bean = roncooUserLogCache.selectById(id);
		bean.setUserName("测试");
		bean.setCreateTime(new Date());
		roncooUserLogCache.updateById(bean);
		return bean;
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(@RequestParam(defaultValue = "1") Integer id) {
		return roncooUserLogCache.deleteById(id);
	}
	
	
	
}