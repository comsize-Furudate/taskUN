<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,model.entity.TaskBean,java.time.format.DateTimeFormatter,model.entity.CommentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント削除確認画面</title>
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


<h2>コメント削除</h2>

<hr>

以下のコメントを削除しますか？



<form action="comment-delete-servlet" method="post">

<input type="submit" value="はい">

</form>

<form action="task-detail.jsp">

<input type="submit" value="いいえ">

</form>

<%} %>

</body>
</html>