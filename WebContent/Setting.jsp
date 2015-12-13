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

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>

<div class="container">
  <h2>機械割設定</h2>
  <ul class="nav nav-tabs nav-justified">
    <li class="active"><a data-toggle="tab" href="#game1">The Ocean</a></li>
    <li><a data-toggle="tab" href="#game2">大花火</a></li>
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
			<td><input type="text" class="form-control" value="10"></td>
			<td><input type="text" class="form-control" value="10"></td>
			<td><input type="text" class="form-control" value="10"></td>
			<td><input type="text" class="form-control" value="10"></td>
			<td><input type="text" class="form-control" value="10"></td>
			<td><input type="text" class="form-control" value="10"></td>
			<td><input type="text" class="form-control" value="10"></td>
			</tr>
			</table>
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
			</table>
		</div>
    </div>

  </div>
</div>

</body>
</html>
