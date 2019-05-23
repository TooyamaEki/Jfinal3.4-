package com.kakuhanashi.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.service.RandomUserService;

public class UserController extends Controller{
	public void randomUser(){
		Record r =  RandomUserService.me.randomUser();
		renderJson(r);
	}
}
