<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>大祭り管理画面</title>
</head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<body>

<%
	String FILENAME = "Oomatsuri.txt";
	String filepath = application.getRealPath(FILENAME);

	//out.println("filepath:"+filepath);

	File file = new File(filepath);
	if(!file.exists()){
		// 設定ファイルを生成
		FileWriter fileWriter = new FileWriter(filepath);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		writer.write("30,30,10,10,10,10");
		writer.newLine();
		writer.write("30,30,10,10,10,10");
		writer.newLine();
		writer.write("30,30,10,10,10,10");
		writer.newLine();
		writer.flush();
		writer.close();
		fileWriter.close();

		out.println("設定ファイルを生成しました<BR>");
	}

	// 設定ファイルから設定値を読み取る
	Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
	FileReader fileReader = new FileReader(filepath);
	BufferedReader reader = new BufferedReader(fileReader);
	String line="";
	int row=10;
	while ((line = reader.readLine()) != null) {
		//out.println(line + "<BR>");
		String[] values = line.split(",");
		int count = 1;
		for( String value : values ){
			valueMap.put(row+count, Integer.parseInt(value));
			count++;
		}
		row+=10;
	}
	reader.close();
	fileReader.close();

	List<Integer> index1 = new ArrayList<Integer>(Arrays.asList( 11, 12, 13, 14, 15, 16 ));
	List<Integer> index2 = new ArrayList<Integer>(Arrays.asList( 21, 22, 23, 24, 25, 26 ));
	List<Integer> index3 = new ArrayList<Integer>(Arrays.asList( 31, 32, 33, 34, 35, 36 ));

	String[] lefts = new String[] { "設定1","設定2","設定3","設定4","設定5","設定6" };
%>

<%!
	/***
		テーブルを出力する
	*/
	String getTable(List<Integer> index, String title, Map<Integer,Integer> valueMap, String[]lefts){
		String ret = "";

		ret += "<div class=\"col-md-4\">\n";
		ret += "<table class=\"table\">\n";
		ret += "<thead>\n";
		ret += "<tr>\n";
		ret += "<th colspan=\"3\">" + title + "</th>\n";
		ret += "</tr>\n";
		ret += "</thead>\n";
		ret += "<tbody>\n";

		int count=0;
		for(Integer i : index){
			ret += "<tr>\n";
			ret += "<td>" + lefts[count] + "</td>\n";
			ret += "<td>" + valueMap.get(i) + "</td>\n";
			ret += "<td>％</td>\n";
			count++;
		}

		ret += "</tbody>\n";
		ret += "</table>\n";
		ret += "</div>\n";

		return ret;
	}
%>

<h1>大祭り管理画面</h1>

<form method="post" action="result.jsp">

      <div class="row">
		<%= getTable(index1, "共通設定画面PC(リアル)", valueMap, lefts) %>
		<%= getTable(index2, "共通設定画面PC(リアル)", valueMap, lefts) %>
		<%= getTable(index3, "共通設定画面(スマホ)アプリ", valueMap, lefts) %>
      </div>

	<input type="submit" class="btn btn-lg btn-primary" onclick="location.href='result.jsp'"value="変更">
	<input type="button" class="btn btn-lg btn-primary" onclick="location.href='Setting.jsp'"value="戻る">

</form>


</body>
</html>