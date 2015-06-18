package jp.game;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class Jsonic
 */
public class EndService {

	public List<Map<String,String>> getPostParameter(Map<String,String> params) {

		String sv = params.get("sv");
		String ap = params.get("ap");
		String id = params.get("id");
		String cval = params.get("cval");
		String pval = params.get("pval");
		String count = params.get("count");
		String dat = params.get("dat");

		List<Map<String,String>> result = new LinkedList<Map<String,String>>();

		result.add(new HashMap<String,String>(){
			{ put("result", "1"); }
			{ put("mes", "ok,アラート"); }
			{ put("jump", "http://www.yahoo.co.jp/"); }
		});

		return result;
	}

}
