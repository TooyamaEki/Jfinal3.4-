package com.kakuhanashi.vaildator.user;

import com.jfinal.ValidatorExt;
import com.jfinal.core.Controller;
import com.kakuhanashi.service.UserService;
import com.sun.org.apache.regexp.internal.recompile;

public class RegVaildator extends ValidatorExt{

	@Override
	protected void validate (Controller c) {
		// TODO Auto-generated method stub
		setShortCircuit(true);
		validateRegex(200003,200004,200005);
		validateTrue(!UserService.me.exist(c.getPara("m.account")),200006);
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.renderJson();
	}

}
