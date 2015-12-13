package jp.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 設定値を設定する
 * {
 *
 * }
 * @author tny3
 */
public class SetSettingService extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException, ServletException
	{
		String gameId;
		gameId = request.getParameter("gameId");

		System.out.println("[INFO]SetSettingService");
		System.out.println("[INFO]"+request.getMethod());
		System.out.println("[INFO]gameId:"+gameId);

		// 設定値のjsonを読み込む
		Path path;
		byte[] bytes;
		String msg;

		path = Paths.get("Setting.json");

		try {
			bytes = Files.readAllBytes(path);
			msg = new String(bytes, StandardCharsets.UTF_8);
		}
		catch(Exception e)
		{
			msg = "{Setting:0, setting1:0}";
			Files.write(path, msg.getBytes());
		}

		System.out.println(msg);

		PrintWriter out = response.getWriter();
		out.println(msg);
		out.close();
	}
}
