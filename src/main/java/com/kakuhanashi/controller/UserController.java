package com.kakuhanashi.controller;



import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.common.model.User;
import com.kakuhanashi.service.RandomUserService;
import com.kakuhanashi.service.UserService;


public class UserController extends com.jfinal.Controller {
	/**
	 * 获取随机用户 2019年5月24日14:59:42 振业
	 */
	public void randomUser() {
		Record r = RandomUserService.me.randomUser();
		setCode(1,r);
		
	}
	
	public void reg(){
            UserService.me.add(getModel(User.class,"m"));
	}
}
