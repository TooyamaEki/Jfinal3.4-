package com.kakuhanashi.service;

import java.sql.Timestamp;
import java.util.Date;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.common.model.User;

public class UserService {
	public static final UserService me = new UserService();
	User dao = new User().dao();
	
	public Record add (User m){
		Date date = new Date();      
		Timestamp nousedate = new Timestamp(date.getTime());
		m.removeNullValueAttrs();
		m.keep("account","psw","name");
		System.err.println(nousedate);
		return null;
		
	}
}
