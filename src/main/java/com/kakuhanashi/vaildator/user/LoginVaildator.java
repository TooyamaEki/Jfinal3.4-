package com.kakuhanashi.vaildator.user;

import com.jfinal.ValidatorExt;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginVaildator extends ValidatorExt{

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		
//		String ExtAccount =  "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
//		validateRegex("account", ExtAccount, "error", "请输入手机号码");
		System.out.println("校验器");
		
		
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		 c.renderJson();

	}

}
