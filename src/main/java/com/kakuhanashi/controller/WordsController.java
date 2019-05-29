package com.kakuhanashi.controller;

import com.jfinal.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.common.model.User;
import com.kakuhanashi.common.model.Words;
import com.kakuhanashi.service.WordsService;

public class WordsController extends com.jfinal.Controller {
	public void addwords() {
		Record user = getSessionAttr("UserInfo");

	boolean r=WordsService.me.add(getModel(Words.class,"m"),(user.getStr("id")));
	if(r){
		setCode(1);
	}else{
		setCode(2);
	}
//		System.err.println(user);
		
	}
}
