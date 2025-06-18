<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集失敗</title>
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
	
編集登録に失敗しました。
</body>
<form action="menu.jsp" method="post">
<input type="submit" value="メニューに戻る">
</form>
<form action="task-edit.jsp" method="post">
<input type="submit" value="編集画面に戻る">
</form>

<%} %>
</html>