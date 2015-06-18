package jp.game;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class Jsonic
 */
public class StartService {

	public List<Map<String,String>> getPostParameter(Map<String,String> params) {

		String sv = params.get("sv");
		String ap = params.get("ap");

		System.out.println("getPostParameter sv"+sv);
		System.out.println("getPostParameter ap"+ap);

		List<Map<String,String>> result = new LinkedList<Map<String,String>>();

		result.add(new HashMap<String,String>(){
			{ put("result", "1"); }
			{ put("id", "000001"); }
			{ put("setting", "6"); }
			{ put("key", "123456789"); }
			{ put("rate", "4"); }
			{ put("hall", "1"); }
			{ put("dai", "255"); }
			{ put("dat", "0,0,0,0,1,1,1,1,1,1"); }
			{ put("mes", "ok,アラート"); }
			{ put("jump", "http://www.yahoo.co.jp/"); }
		});

		return result;
	}

}
