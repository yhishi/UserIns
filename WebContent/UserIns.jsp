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

    <script src="js/vendor/jquery-2.2.4.min.js"></script>
    <script src="js/main.js"></script>

  </head>
  <body>

    <!-- 検索パネル 各種ボタン -->
    <br><br>
	<section id="search-panel">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<label for="email" class="col-sm-3 control-label">メールアドレス</label>
					<div class="col-sm-6">
						<input type="email" class="form-control" id="login-email" required>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary" id="search">検索</button>
					</div>
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-primary" id="insert">新規</button>
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-primary" id="update">更新</button>
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-primary" id="delete">削除</button>
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-primary" id="submit">実行</button>
				</div>
				<div id="mode" class="alert alert-info col-sm-2">検索モード</div>
			</div>

		</div>
	</section>
	<!-- /#search-panel -->
	<br><br>

	<section id="meisai">
		<div class="container">
			<table class="table table-striped" id="tbl">
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
				<tbody id="tb-meisai">
					<!-- テーブル要素追加箇所-->
				</tbody>
  		</div>
	</section>

    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/vendor/moment.min.js"></script>
  </body>
</html>