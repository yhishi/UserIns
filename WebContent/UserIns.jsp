<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>UserIns</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
  </head>
  <body>

    <!-- 検索パネル 各種ボタン -->
    <br><br>
	<section id="search-panel">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<label for="login-email" class="col-sm-3 control-label">メールアドレス</label>
					<div class="col-sm-6">
						<input type="email" class="form-control" id="login-email" required>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary">検索</button>
					</div>
				</div>
				<div class="col-sm-offset-1 col-sm-1">
					<button type="submit" class="btn btn-primary login__submit-button">新規</button>
				</div>
				<div class="col-sm-1">
					<button type="submit" class="btn btn-primary login__submit-button">更新</button>
				</div>
				<div class="col-sm-1">
					<button type="submit" class="btn btn-primary login__submit-button">削除</button>
				</div>
			</div>
		</div>
	</section>
	<!-- /#search-panel -->
	<br><br>
	<section id="meisai">
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th></th>
						<th>No</th>
						<th>メールアドレス</th>
						<th>パスワード</th>
						<th>登録日</th>
						<th>更新日</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox"></td>
						<td>1</td>
						<td>aaaa@example.com</td>
						<td>xxxxxx</td>
						<td>2017/7/18</td>
						<td>2017/7/19</td>
					</tr>
					<tr>
						<td><input type="checkbox"></td>
						<td>2</td>
						<td>bbbbbbb@gmail.com</td>
						<td>yyy</td>
						<td>2017/5/18</td>
						<td>2017/6/19</td>
					</tr>
					<tr>
						<td><input type="checkbox"></td>
						<td>3</td>
						<td>cccccccc@ezweb.ne.jp</td>
						<td>xxxxzzzzzz</td>
						<td>2017/2/13</td>
						<td>2017/9/23</td>
					</tr>
				</tbody>
		</div>
	</section>


	<script src="js/vendor/jquery-2.2.4.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/vendor/moment.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>
