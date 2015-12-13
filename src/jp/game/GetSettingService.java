package jp.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * パラメータ：gameID(0..1000)
 * 返却値：json
 *
 * [正常時]
 * {
 * 		setting0:n,
 * 		setting1:n,
 * 		setting2:n,
 * ...
 * 		setting6:n
 * }
 *
 * [異常時]
 * {
 * 		result:error
 * }
 */
public class GetSettingService extends HttpServlet
{
	public void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException, ServletException
	{
		System.out.println("[INFO]ResetSettingService");
		System.out.println("[INFO]"+request.getMethod());

		String gameId = request.getParameter("gameId");

		Path path;
		String result;
		String fileName = "setting.txt";

        path = Paths.get(fileName);

//      List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
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

        // 抽出
        List<Setting> where = new ArrayList<Setting>();
        for(Setting s : settings)
        {
        	if(s.gameId.equals(gameId))
        	{
        		where.add(s);
        	}
        }

        List<String> values = new ArrayList<String>();
        for(Setting s : where)
        {
        	values.add(s.settingValue);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : values) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str);
        }

        result = sb.toString();

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
	}
}
