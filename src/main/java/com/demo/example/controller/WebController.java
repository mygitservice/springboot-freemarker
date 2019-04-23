package com.demo.example.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping("/index")
	public String index(ModelMap map){
		logger.info("这里是controller");
		map.put("title", "hello world");

		return "index v0.1 --v0.7 -master GitHub update";//不要在前面加上 / linux下面会出错
	}
	
	@RequestMapping("/error")
	public String error(){
		
		logger.info("这里是一个异常");
		throw new RuntimeException("异常");
	}
	
	@RequestMapping(value = "/index2")
	public String index(ModelMap map, HttpSession httpSession) {
		map.put("title", "第一个应用：sessionID=" + httpSession.getId());
		logger.info("sessionID=" + httpSession.getId());
		return "index";
	}
	
	
}
