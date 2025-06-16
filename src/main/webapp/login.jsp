<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

<script type="text/javascript">

localStorage.clear();

</script>

<h2>ログイン</h2>

<form action="login-servlet" method="post">

ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="password">

<p>

<input type="submit" value="ログイン">
<input type="reset" value="クリア">

</p>

</form>

</body>
</html>