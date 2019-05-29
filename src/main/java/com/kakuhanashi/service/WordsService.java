package com.kakuhanashi.service;

import com.kakuhanashi.common.KakuhanashiRoutes;
import com.kakuhanashi.common.model.User;
import com.kakuhanashi.common.model.Words;
import com.kakuhanashi.tools.DateUtil;
import com.sun.org.apache.regexp.internal.recompile;

public class WordsService {
	public static final WordsService me = new WordsService();
	Words dao = new Words().dao();

	public boolean add(Words m, String id) {
		m.removeNullValueAttrs();
		m.keep("pdesc");
		m.set("uid", id);
		m.set("create_time", DateUtil.getNowTime());
		m.set("update_time", DateUtil.getNowTime());
		return m.save();
	}
}
