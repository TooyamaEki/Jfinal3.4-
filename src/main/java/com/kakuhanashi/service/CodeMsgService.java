package com.kakuhanashi.service;

import com.alibaba.druid.sql.ast.expr.SQLAggregateExpr;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.common.model.CodeMsg;

public class CodeMsgService {
	public final static CodeMsgService me = new CodeMsgService();
	CodeMsg dao = new CodeMsg().dao();

	/**
	 * 获取code信息 2019年5月24日14:49:34
	 * 
	 * @param code
	 * @return
	 */
	public Record getByCode(int code) {
		Record r = dao.get(code);
		return r;
	}

	public String seCode(int code) {
		Record r = getByCode(code);
		return r.getStr("msg");
	}

	/**
	 * 获得校验规则
	 */
	public String getRegex(int code) {
		Record r = getByCode(code);
		return r.getStr("regex_value");

	}

	/**
	 * 获得校验信息
	 * 
	 * @param code
	 * @return
	 */
	public String getMsg(int code) {
		Record r = getByCode(code);
		return r.getStr("msg");
	}

	public String getFieId(int code) {
		Record r = getByCode(code);
		return r.getStr("field");
	}
}
