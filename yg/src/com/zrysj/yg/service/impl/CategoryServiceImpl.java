package com.zrysj.yg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonUtil;

import org.springframework.stereotype.Service;

import com.zrysj.yg.mapper.CategoryMapper;
import com.zrysj.yg.po.Category;
import com.zrysj.yg.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Resource
	private CategoryMapper categoryMapper;
	@Override
	public String getCategoryList() {
		List<Category> list = categoryMapper.selectCategoryList();
		System.out.println(list);
		//System.out.println(list);  gson json
		String str  = JsonUtil.fromObject(list);
	
		return str;
	}

}
