package com.zrysj.yg.service.impl;




import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zrysj.yg.mapper.UserMapper;
import com.zrysj.yg.po.User;
import com.zrysj.yg.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	public void insertUser(User user) {
		userMapper.insertUser(user);
		
	}
	@Override
	public void activeUser(User user) {
		userMapper.updateUserState(user);
		
	}
	@Override
	public boolean findUserByUserName(String username) {
		if(userMapper.findUserByUserName(username)==null){
			return false;
		} else {
			return true;
		}
		
	}
	
}
