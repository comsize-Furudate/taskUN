<%@page import="model.entity.CommentBean"%>
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

DateTimeFormatter dtf1 =
DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"); 

%>

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
	
<%CommentBean cb=(CommentBean)session.getAttribute("DeleteComment");
String formatUpdateDate = dtf1.format(cb.getUpdateDateTime());
%>

	<table>
	
		<tr>
			<th>コメント:</th>
			<td><%=cb.getComment()%></td>
		</tr>
		
		<th>投稿日時:</th>
		
		<td><%=formatUpdateDate%></td>
		
	</table>
	
	<div style="display:inline-flex">
	
	<form action="CommentDeleteServlet"method="post">
		<input type="submit" value="はい">
	</form>
	<form action="task-detail.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	
	</div>

	<%} %>
</body>
</html>