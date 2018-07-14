package com.zrysj.yg.po;

import java.util.Date;



public class User {
	private int userid;
	private String username;
	private String userpwd;
	private String useremail;
	private String usertruename;
	private String usersex;
	private Date userbirthday;
	private int userstate;// 激活状态
	private String usercode;//激活码
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", userpwd=" + userpwd + ", useremail=" + useremail
				+ ", usertruename=" + usertruename + ", usersex=" + usersex
				+ ", userbirthday=" + userbirthday + ", userstate=" + userstate
				+ ", usercode=" + usercode + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsertruename() {
		return usertruename;
	}
	public void setUsertruename(String usertruename) {
		this.usertruename = usertruename;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public Date getUserbirthday() {
		return userbirthday;
	}
	public void setUserbirthday(Date userbirthday) {
		this.userbirthday = userbirthday;
	}
	public int getUserstate() {
		return userstate;
	}
	public void setUserstate(int userstate) {
		this.userstate = userstate;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	
	
	
}
