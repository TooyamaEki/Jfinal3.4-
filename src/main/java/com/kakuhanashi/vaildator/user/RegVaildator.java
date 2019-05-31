package com.kakuhanashi.vaildator.user;

import com.jfinal.ValidatorExt;
import com.jfinal.core.Controller;
import com.sun.org.apache.regexp.internal.recompile;

public class RegVaildator extends ValidatorExt{

	@Override
	protected void validate (Controller c) {
		// TODO Auto-generated method stub
		String ExtAccount =  "[0-9]*$";
		validateRegex("m.account", ExtAccount, "error", "请输入手机号码");
		addError("obj", "失踪出现");
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.renderJson();
	}

}
