<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント削除完了</title>
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

<h2>コメント削除完了</h2>
<hr>

コメントの削除が完了しました

<form action="menu.jsp">

<input type="submit" value="メニュー画面に戻る">

</form>

<%} %>

</body>
</html>