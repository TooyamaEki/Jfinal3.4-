package com.kakuhanashi.service;

import com.kakuhanashi.common.model.Bootuser;

public class UserService {
	public static final UserService me = new UserService();
	 Bootuser dao = new Bootuser().dao();
}
