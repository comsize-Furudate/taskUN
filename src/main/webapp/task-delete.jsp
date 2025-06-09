<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除画面</title>
</head>
<body>
<%TaskBean bean=(TaskBean)session.getAttribute("detail"); %>
<table border=1>
	<tr>
		<th>タスク名</th>
		<td><%bean.getTaskName(); %></td>
	</tr>
	<tr>
		<th>カテゴリ名</th>
		<td><%bean.getCategoryName(); %></td>
	</tr>
	<tr>
		<th>期限</th>
		<td><%bean.getLimit(); %></td>
	</tr>
	<tr>
		<th>ステータス</th>
		<td><%bean.getStatusName(); %></td>
	</tr>
	<tr>
		<th>メモ</th>
		<td><%bean.getMemo(); %></td>
	</tr>
</table>
<form action="task-delete-servlet" method="post">
<input type="submit" value="削除する">
</form>
<form action="detail.jsp" method="get">
<input type="submit" value="詳細に戻る">
</form>
</body>
</html>