<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
</head>
<body>

	<%
	if (session.getAttribute("id")==null) {
	%>

	<h2>ログインされていません</h2>

	<a href="login.jsp">ログイン画面へ</a>

	<%
	} else {
	%>

	<h2>ログアウトしますか？</h2>

	<form action="logout-servlet" method="post">

		<input type="submit" value="はい">

	</form>

	<form action="menu.jsp" method="post">

		<input type="submit" value="いいえ">

	</form>

	<%
	}
	%>

</body>
</html>