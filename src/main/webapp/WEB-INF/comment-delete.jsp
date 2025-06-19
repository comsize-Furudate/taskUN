<%@page import="model.entity.CommentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%CommentBean cb=(CommentBean)session.getAttribute("DeleteComment"); %>
<h1>こちらのコメントを削除します</h1>
<table>
<tr>
<th>コメント:</th>
<td><%=cb.getComment() %></td>
</tr>
<th>投稿日時:</th>
<td><%=cb.getUpdateDateTime() %></td>
</table>
<form action="CommentDeleteServlet"method="post">
<input type="submit" value="削除">
</form>
<form action="task-detail.jsp"method="post">
<input type="submit" value="詳細画面へ">
</form>
</body>
</html>