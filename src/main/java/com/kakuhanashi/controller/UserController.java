package com.kakuhanashi.controller;



import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.service.RandomUserService;


public class UserController extends com.jfinal.Controller {
	public void randomUser() {
		Record r = RandomUserService.me.randomUser();
		r.set("obj", 1);
		renderJson(r) ;
	}
}
