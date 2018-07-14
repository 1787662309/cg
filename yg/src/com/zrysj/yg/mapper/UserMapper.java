package com.zrysj.yg.mapper;


import java.util.List;

import com.zrysj.yg.po.User;


public interface UserMapper {

	void insertUser(User user);

	void updateUserState(User user);

	User findUserByUserName(String username);



}
