package jp.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 設定値を初期化する
 */
public class ResetSettingService extends HttpServlet
{
	public static List<String> lines;

	public void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException, ServletException
	{
		System.out.println("[INFO]ResetSettingService");
		System.out.println("[INFO]"+request.getMethod());

		Path path;
		String result = "{result:Init}";
		String fileName = "~/setting.txt";

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

		System.out.println(result);

		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}
}
