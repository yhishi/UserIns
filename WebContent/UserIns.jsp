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
    <br>
	<section id="search-panel">
		<div class="container">
			<div class="col-sm-6 panel panel-default">
				<label for="login-email" class="col-sm-3 control-label">メールアドレス</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" id="login-email" required>
				</div>
				<button type="button" class="btn btn-primary">検索</button>
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
	</section>
	<!-- /#search-panel -->
	<br>
	<section id="meisai">
		<div class="container">
			<table class="table table-striped">

			</table>
		</div>
	</section>


    <script src="js/vendor/jquery-2.2.4.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/vendor/moment.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>
