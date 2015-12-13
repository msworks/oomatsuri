package jp.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 設定値を設定する
 */
public class SetSettingService extends HttpServlet
{
	public void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException, ServletException
	{
		core(request, response);
	}

	public void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException, ServletException
	{
		core(request, response);
	}

	void core(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException, ServletException
	{
		System.out.println("[INFO]ResetSettingService");
		System.out.println("[INFO]"+request.getMethod());

	    Enumeration<String> en = request.getParameterNames();

	    Map<String, String> params = new HashMap<String, String>();

	    while(en.hasMoreElements()){
	       String name = (String)en.nextElement();
	       String value = request.getParameterValues(name)[0];
	       params.put(name, value);
	    }

		String param = params.get("param");

		if(param==null){
			param = "s00:0";
		}

		String gameId = param.substring(1, 2);
		String settingId = param.substring(2, 3);
		String settingValue = param.split(":")[1];

		System.out.println("[INFO]param:"+param);
		System.out.println("[INFO]gameId:" + gameId);
		System.out.println("[INFO]settingId:" + settingId);
		System.out.println("[INFO]settingValue:" + settingValue);

        List<String> lines = ResetSettingService.lines;

        if(lines == null){
    		lines = new ArrayList<String>();
    		lines.add("1 0 0");
    		lines.add("1 1 0");
    		lines.add("1 2 0");
    		lines.add("1 3 0");
    		lines.add("1 4 20");
    		lines.add("1 5 30");
    		lines.add("1 6 50");
    		lines.add("2 0 0");
    		lines.add("2 1 0");
    		lines.add("2 2 0");
    		lines.add("2 3 0");
    		lines.add("2 4 20");
    		lines.add("2 5 30");
    		lines.add("2 6 50");
    		ResetSettingService.lines = lines;
        }

        List<Setting> settings = new ArrayList<Setting>();
        for(String line : lines)
        {
        	String[] e = line.split(" ");
        	Setting s = new Setting(e[0], e[1], e[2]);
        	settings.add(s);
        }

        for(Setting s : settings)
        {
        	if( s.gameId.equals(gameId) &&
        		s.settingId.equals(settingId) )
        	{
            	s.settingValue = settingValue;
        	}
        }

        // store
		lines = new ArrayList<String>();
		for(Setting s : settings)
		{
			lines.add(s.toString());
		}
  		ResetSettingService.lines = lines;

        String result ="{\"result\":\"Setting change\"}";
		System.out.println(result);

		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}

	class Setting
	{
		public String gameId;
		public String settingId;
		public String settingValue;

		public Setting(
			String gameId,
			String settingId,
			String settingValue
		)
		{
			this.gameId = gameId;
			this.settingId = settingId;
			this.settingValue = settingValue;
		}

		public String toString()
		{
			return gameId + " " + settingId + " " + settingValue;
		}
	}
}
