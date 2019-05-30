package com.jfinal;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.template.stat.ast.Break;
import com.jfinal.validate.Validator;
import com.kakuhanashi.service.CodeMsgService;
import com.sun.org.apache.bcel.internal.classfile.Code;

public abstract class ValidatorExt extends Validator {
	Record record = new Record();
//
//	protected void validateRegex(int... errCode) {
//		System.out.println("传进来检验的码数");
//		for (int code : errCode) {
//	
//			validateRegex(CodeMsgService.me.getFieId(code), CodeMsgService.me.getRegex(code),CodeMsgService.me.getMsg(code), code);
//
//		}
//		// validateRegex(field, regExpression, errorKey, errorMessage);
//	}
//
//	protected void validateRegex(String field, String regExpression,String Msg,int code) {
//
//		validateRegex(field, regExpression, "code", String.valueOf(code));
//		controller.setAttr("field", field);
//		controller.setAttr("msg", Msg);
//		
//	}
}
