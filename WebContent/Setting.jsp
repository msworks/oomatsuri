<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
<head>
  <title>機械割設定</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    $.getJSON("Setting.json", function(data){
        for(var i in data){
        $("#output").append("<li><strong>" + data[i].division + "</strong></li>");
            for(var j in data[i].person){
                $("#output").append("<li>" + data[i].person[j].name + "（" + data[i].person[j].age + "才）</li>n");
            }
        }
    });
});
</script>

<div class="container">
  <h2>機械割設定</h2>
  <ul class="nav nav-tabs nav-justified">
    <li class="active"><a data-toggle="tab" href="#game1">The Ocean</a></li>
    <li><a data-toggle="tab" href="#game2">大花火</a></li>
    <li><a data-toggle="tab" href="#game3">I am pierrot</a></li>
  </ul>

  <div class="tab-content">
    <!-- The Ocean -->
    <div id="game1" class="tab-pane fade in active">
	    <div class="form-group">
			<table class="table table-striped">
			<tr>
			<th>The Ocean</th>
			<th>0</th>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<tr>

			<tr>
			<td>1</td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			</tr>
		</div>
    </div>

    <!-- The 大花火 -->
    <div id="game2" class="tab-pane fade in active">
	    <div class="form-group">
			<table class="table table-striped">
			<tr>
			<th>大花火</th>
			<th>0</th>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<tr>

			<tr>
			<td>1</td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			<td><input type="text" class="form-control" value="10"></div></td>
			</tr>
		</div>
    </div>

  </div>
</div>

</body>
</html>
