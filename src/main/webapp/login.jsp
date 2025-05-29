<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<h2>ログイン</h2>

	<form action="login-servlet" method="post">

		ユーザー：　<input type="text" name="user_id"><br>
		パスワード：<input type="text" name="password"><br>
		<p>
		<input type="submit" value="ログイン">
		<input type="reset" value="クリア">
		</p>

	</form>

</body>
</html>