package com.kakuhanashi.service;

import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.common.model.Bootuser;

public class RandomUserService {
	public static final RandomUserService me = new RandomUserService();
	Bootuser dao = new Bootuser().dao();

	public Record randomUser() {
		Record r =  dao.get();
		r.keep("name","id","state");
		return r;
	}

}
