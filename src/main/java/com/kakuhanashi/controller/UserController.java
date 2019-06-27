package com.kakuhanashi.controller;

import java.util.HashMap;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.kakuhanashi.common.model.User;
import com.kakuhanashi.service.RandomUserService;
import com.kakuhanashi.service.UserService;
import com.kakuhanashi.vaildator.user.LoginVaildator;
import com.kakuhanashi.vaildator.user.RegVaildator;

import cn.hutool.http.HttpUtil;

public class UserController extends com.jfinal.Controller {
	/**
	 * 获取随机用户 2019年5月24日14:59:42 振业
	 */
	public void randomUser() {
		Record r = RandomUserService.me.randomUser();
		setSessionAttr("UserInfo", r);
		setCode(1, r);

	}

	@Before({ RegVaildator.class })
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
	@Before({ LoginVaildator.class })
	public void login() {
		Record r = UserService.me.login(getPara("account"), getPara("psw"));
		if (r != null) {
			setSessionAttr("UserInfo", r);
			// setAttr("userPage",r);
			// renderJson(r);

			setCode(1, r);
		} else {
			renderText("登录失败");
		}
	}

	/**
	 * 上传测试
	 */

	public void upImg() {
		try {
			// 第二个参数为a，则保存到upload/a文件夹下，自动创建文件夹
			UploadFile file = getFile("photo");
			Long size=	file.getFile().length();
			System.err.println(size);
				
		} catch (Exception exception) {
			System.out.println("路径错误");
		}
		
	
	}
	
	public void testUrl(){
		String content = HttpUtil.get("http://127.0.0.1:81/user/login");

		
	}

}
