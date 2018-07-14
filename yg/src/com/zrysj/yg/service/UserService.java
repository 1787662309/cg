package com.zrysj.yg.service;



import java.util.List;

import com.zrysj.yg.po.User;


public interface UserService {

	void insertUser(User user);

	void activeUser(User user);

	boolean findUserByUserName(String username);

	
	
}
