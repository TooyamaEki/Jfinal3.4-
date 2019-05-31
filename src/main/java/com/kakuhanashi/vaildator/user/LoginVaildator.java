package com.kakuhanashi.vaildator.user;

import com.jfinal.ValidatorExt;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginVaildator extends ValidatorExt {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		setShortCircuit(true);
		validateRegex(200002, 200001);
		System.out.println("校验器");
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.renderJson();

	}

}
