package com.kakuhanashi.service;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.common.model.User;
import com.kakuhanashi.tools.DateUtil;
import com.kakuhanashi.vaildator.user.LoginVaildator;

public class UserService {
	public static final UserService me = new UserService();
	User dao = new User().dao();

	/**
	 * 添加用户 2019年5月24日17:04:16
	 * 
	 * @param m
	 * @return
	 */
	public boolean add(User m) {
		m.removeNullValueAttrs();
		m.keep("account", "psw", "name");
		m.set("create_time", DateUtil.getNowTime());
		return m.save();

	}

	/**
	 * 根据account拿信息
	 * 
	 * @param account
	 * @return
	 */
	
	public Record get(String account) {
		Record r = dao.get(account);
		return r;
	}

	
	public Record login(String account, String psw) {
		Record r = get(account);
		if (r != null && r.getStr("psw").equals(psw)) {
			r.keep("name", "id", "state", "type", "account");
			return r;
		}
		return null;
	}

}
