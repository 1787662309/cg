package com.zrysj.yg.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrysj.yg.service.CategoryService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Controller
@RequestMapping("/page")
public class ProductController {
	@Resource
	private JedisPool jedisPool;
	@Resource
	private CategoryService categoryService ;
	@RequestMapping("categoryList")
	public void  gatCategoryList(HttpServletResponse resp) throws Exception{
		Jedis jedis = jedisPool.getResource();
		String gategoryList = jedis.get("gategoryList");
		
		if(gategoryList==null){
			gategoryList = categoryService.getCategoryList();
			jedis.set("gategoryList", gategoryList);
			
		}
		resp.getWriter().print(gategoryList);
		
	}
}
