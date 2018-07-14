package com.zrysj.yg.controller;



import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zrysj.yg.po.User;
import com.zrysj.yg.service.UserService;
import com.zrysj.yg.utils.CommonUtils;
import com.zrysj.yg.utils.MailUtils;



@Controller
@RequestMapping("/page")
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("regUser")
	public String regUser(User user) throws Exception{
		//注册成功
		user.setUserstate(0);
		String activeCode = CommonUtils.getUUID();
		user.setUsercode(activeCode);
		userService.insertUser(user);
		activeCode = "<a href=\"http://127.0.0.1/yg/page/activieUser.action?activeCode="+
				activeCode
				+"\">激活连接 </a>" ;
		MailUtils.sendMail(user.getUseremail(),activeCode);
		return "redirect:activeUser.jsp";
	}
	@RequestMapping("activieUser")
	public String activieUser(String activeCode) {
		User user = new User();
		user.setUsercode(activeCode);
		user.setUserstate(1);
		userService.activeUser( user);
		return "redirect:login.jsp";
	}
	@RequestMapping("findUserByUserName")
	public @ResponseBody Boolean findUserByUserName(String username){
		System.out.println(username);
		boolean  tag = userService.findUserByUserName(username);
		System.out.println(tag);
		return tag;
	}
}
