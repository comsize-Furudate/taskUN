<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
</head>
<body>

	<h2>タスク一覧</h2>
	<p style="text-align: right">
		<%--=session.getAttribute("loginsuccess")--%>
		ユーザーID：<%=session.getAttribute("id")%><br> ユーザー名：<%=session.getAttribute("name")%>さん
	</p>
	<%
	boolean con = (boolean) session.getAttribute("Connect");
	if (con) {
		List<TaskBean> tbList = (List) session.getAttribute("taskList");
		if (tbList.size() == 0) {
	%>

	<h1>タスクは現在ありません</h1>
	<%
	} else {
	%>
	<br>


	<hr>

	<table border="1">

		<tr>

			<th>ID</th>
			<th>タスク名</th>
			<th>カテゴリ名</th>
			<th>期限</th>
			<th>ユーザーID</th>
			<th>ステータス</th>
			<th>メモ</th>
			<th>登録日時</th>
			<th>更新日時</th>

		</tr>
		<%
		for (int i = 0; i < tbList.size(); i++) {
			TaskBean tb = tbList.get(i);
		%>
		<tr>

			<td><a href="taskDetailServlet?task_id=<%=tb.getTaskId()%>"><%=tb.getTaskId()%></a></td>
			<td><%=tb.getTaskName()%></td>
			<td><%=tb.getCategoryName()%></td>
			<td><%=tb.getLimit()%></td>
			<td><%=tb.getUserId()%></td>
			<td><%=tb.getStatusName()%></td>
			<td><%=tb.getMemo()%></td>
			<td><%=tb.getCreateDateTime()%></td>
			<td><%=tb.getUpdateDateTime()%></td>


		</tr>
		<%
		}
		%>

	</table>
	<%
	}
	} else {
	%>
	<h1>データベースの接続に失敗しました</h1>
	<%
	}
	%>
	<p>
	<form action="menu.jsp" method="post">

		<input type="submit" value="メニューへ戻る">
		</p>
	</form>


</body>
</html>