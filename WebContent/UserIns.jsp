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

    <!-- 最初のローディング表示 -->
    <!--
    <section id="loading" class="view">
      <span class="initial-loading-icon glyphicon glyphicon-refresh" aria-hidden="true"></span>
    </section>-->

    <!-- ログイン画面 -->
    <section id="login" class="view">
      <div class="container">
        <form id="login-form" class="form-horizontal">
          <div class="form-group login__email">
            <label for="login-email" class="col-sm-3 control-label">メールアドレス</label>
            <div class="col-sm-9">
              <input type="email" class="form-control" id="login-email" required>
            </div>
          </div>
          <div class="form-group login__password">
            <label for="login-password" class="col-sm-3 control-label">パスワード</label>
            <div class="col-sm-9">
              <input type="password" class="form-control" id="login-password" required>
              <p class="help-block">初めての方は、登録するパスワードを入力してください</p>
            </div>
          </div>

          <div class="col-sm-offset-3 col-sm-9 alert alert-danger login__help"></div>
          <div class="form-group login__submit">
            <div class="col-sm-offset-3 col-sm-9">
              <button type="submit" class="btn btn-primary login__submit-button">ログイン</button>
              <button type="button" class="btn btn-default login__password-reset-button" data-toggle="modal" data-target="#passwordResetModal">パスワードを忘れた場合</button>
            </div>
          </div>
        </form>
      </div>
    </section><!-- /#login -->

    <script src="js/vendor/jquery-2.2.4.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/vendor/moment.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>
