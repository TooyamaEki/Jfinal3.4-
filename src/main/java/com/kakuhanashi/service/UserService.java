package com.kakuhanashi.service;

import com.kakuhanashi.common.model.User;

public class UserService {
	public static final UserService me = new UserService();
	User dao = new User().dao();
}
