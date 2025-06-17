<<<<<<< HEAD
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskBean,java.time.format.DateTimeFormatter"%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskBean"%>
>>>>>>> c46a05ff471d12d850c90597d14cf58c9110acb5
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除画面</title>
</head>
<body>
<<<<<<< HEAD

<h2>タスク削除</h2>

	<p style="text-align: right">

		ユーザーID：<%=session.getAttribute("id")%><br>
		ユーザー名：<%=session.getAttribute("name")%>さん<br>

		<%
		TaskBean tb = (TaskBean) session.getAttribute("detail");
		boolean check = (boolean) session.getAttribute("check");
		%>
	</p>

	<hr>

	<table border="1">

		<tr>

			<th>ID</th>
			<td><%=tb.getTaskId()%></td>

		</tr>
		<tr>

			<th>タスク名</th>
			<td><%=tb.getTaskName()%></td>

		</tr>
		<tr>

			<th>カテゴリ名</th>
			<td><%=tb.getCategoryName()%></td>

		</tr>
		<tr>

			<th>期限</th>
			<td>
				<%
				LocalDate targetDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")
						.parse("2019/01/01", LocalDate::from);
				if (tb.getLimit().isEqual(targetDate)) {
				%> 未入力<%
				} else {
				%> <%=tb.getLimit()%> <%
 }
 %>
			</td>

		</tr>
		<tr>

			<th>ユーザーID</th>
			<td><%=tb.getUserId()%></td>

		</tr>
		<tr>

			<th>ステータス</th>
			<td><%=tb.getStatusName()%></td>

		</tr>
		<tr>

			<th>メモ</th>
			<td><%=tb.getMemo()%></td>

		</tr>
		<tr>

			<th>登録日時</th>
			<td><%=tb.getCreateDateTime()%></td>

		</tr>
		<tr>

			<th>更新日時</th>
			<td><%=tb.getUpdateDateTime()%></td>

		</tr>

	</table>
	<div style="display: inline-flex">
		<form action="task-delete-servlet" method="post">
			<input type="submit" value="削除する">
		</form>
		<form action="task-detail.jsp" method="get">
			<input type="submit" value="詳細に戻る">
		</form>
	</div>
=======
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
<div style = "display:inline-flex">
<form action = "task-delete-servlet" method = "post">
<input type = "submit" value = "削除する">
</form>
<form action = "detail.jsp" method = "get">
<input type = "submit" value = "詳細に戻る">
</form>
</div>
>>>>>>> c46a05ff471d12d850c90597d14cf58c9110acb5
</body>
</html>