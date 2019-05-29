package com.kakuhanashi.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.common.model.User;
import com.kakuhanashi.service.RandomUserService;
import com.kakuhanashi.service.UserService;
import com.kakuhanashi.vaildator.user.LoginVaildator;

public class UserController extends com.jfinal.Controller {
	/**
	 * 获取随机用户 2019年5月24日14:59:42 振业
	 */
	public void randomUser() {
		Record r = RandomUserService.me.randomUser();
		setSessionAttr("UserInfo", r);
		setCode(1, r);

	}

	public void reg() {
		boolean b = UserService.me.add(getModel(User.class, "m"));
		if (b) {
			setCode(1);
			
		} else {
			renderText("注册失败");
		}
	}

	/**
	 * 登录 2019年5月24日17:53:08 振业
	 */
	@Before ({LoginVaildator.class})
	public void login() {
		Record r = UserService.me.login(getPara("account"), getPara("psw"));
		if (r != null) {
			setSessionAttr("UserInfo", r);
//			setAttr("userPage",r);
//			renderJson(r);
			
			setCode(1, r);
		} else {
			renderText("登录失败");
		}
	}
}
