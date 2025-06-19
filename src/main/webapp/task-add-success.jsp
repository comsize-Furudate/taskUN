<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録完了</title>
</head>
<body>
<%
	if (session.getAttribute("id") == null) {
%>

	<h2>ログインされていません</h2>

	<a href = "login.jsp">ログイン画面へ</a>

	<%
	} else {
	%>

<h1>タスク登録完了</h1>
<h2>タスクの登録が完了しました</h2>
<form action = "menu.jsp" method = "get">
<input type = "submit" value = "メニュー画面に戻る">
</form>
<%} %>

</body>
</html>