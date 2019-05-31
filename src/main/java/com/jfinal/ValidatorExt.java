package com.jfinal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.template.stat.ast.Break;
import com.jfinal.validate.Validator;
import com.kakuhanashi.service.CodeMsgService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;

public abstract class ValidatorExt extends Validator {
	Record record = new Record();

	/**
	 * 循环错误码
	 * @param errCode
	 */
	protected void validateRegex(int... errCode) {
		System.out.println("传进来检验的码数");
		for (int code : errCode) {
			validateRegex(CodeMsgService.me.getFieId(code), CodeMsgService.me.getRegex(code), true,CodeMsgService.me.getMsg(code), code);
		}
	}

	protected void validateTrue(boolean check,int errorCode) {
	String	errorMsg = CodeMsgService.me.getMsg(errorCode);
		if(!check){
			controller.setAttr("code", errorCode);
			addError("msg", errorMsg);
			return;
		}
	}
	
	protected void validateRegex(String field, String regExpression, boolean isCaseSensitive, String errorKey,int errorCode) {
		String value = controller.getPara(field);
		if (value == null) {
			controller.setAttr("code", errorCode);
			controller.setAttr("field", field);
			addError("msg", errorKey);
			return;
		}
		Pattern pattern = isCaseSensitive ? Pattern.compile(regExpression)
				: Pattern.compile(regExpression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(value);
		if (!matcher.matches()) {
			controller.setAttr("code", errorCode);
			controller.setAttr("field", field);
			addError("msg", errorKey);
		}
	}
}
