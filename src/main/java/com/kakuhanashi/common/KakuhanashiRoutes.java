package com.kakuhanashi.common;

import com.jfinal.config.Routes;
import com.kakuhanashi.controller.UserController;

public class KakuhanashiRoutes extends Routes{

	@Override
	public void config() {
		// TODO Auto-generated method stub
		add("user",UserController.class);
		
	}

}
