<%@page import="java.time.LocalDate,java.time.format.DateTimeFormatter"%>
<%@page import="model.entity.TaskBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集内容確認</title>
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
	
<b>以下の情報を登録します</b>
<%TaskBean tb=(TaskBean)session.getAttribute("newdetail"); %>
<table border="1">
<tr>
<td>タスク名</td>
<td><%=tb.getTaskName() %></td>
</tr>
<tr>
<td>カテゴリ名</td>
<td><%=tb.getCategoryName() %></td>
</tr>
<tr>
<td>期限</td>
<td><%LocalDate targetDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")
			        .parse("2019/01/01", LocalDate::from);
			        if(tb.getLimit().equals(targetDate)){%>未入力<%}else{ %>	<%=tb.getLimit() %><%} %></td>
</tr>
<tr>
<td>ステータス</td>
<td><%=tb.getStatusName() %></td>
</tr>
<tr>
<td>メモ</td>
<td><%=tb.getMemo() %></td>
</tr>
</table>
<form action="task-edit-servlet"method="post">
<input type="submit" value="登録">
</form>
<form action="task-edit.jsp"method="post">
<input type="submit" value="編集画面に戻る">
</form>

<%} %>
</body>
</html>