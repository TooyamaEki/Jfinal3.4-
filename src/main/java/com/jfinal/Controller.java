package com.jfinal;

import com.jfinal.plugin.activerecord.Record;
import com.kakuhanashi.service.CodeMsgService;

public class Controller extends com.jfinal.core.Controller {
	Record result = new Record();

	
	public void setCode(int code) {
		result.set("code",code );
		result.set("msg",CodeMsgService.me.seCode(code) );
		renderJson(result);
	}
	
	
	public void setCode(int code, Record obj) {
		result.set("code",code );
		result.set("msg",CodeMsgService.me.seCode(code) );
		result.set("obj", obj);
		renderJson(result);
	}
}
