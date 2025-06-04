<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク詳細</title>
</head>
<body>

	<h2>タスク詳細</h2>
	<p style="text-align: right">
		<%--=session.getAttribute("loginsuccess")--%>
		ユーザーID：<%=session.getAttribute("id")%><br> ユーザー名：<%=session.getAttribute("name")%>さん
		<br>
	</p>

	<hr>

	<table border="1">

		<tr>

			<th>ID</th>
			<td></td>

		</tr>
		<tr>

			<th>タスク名</th>
			<td></td>

		</tr>
		<tr>

			<th>カテゴリ名</th>
			<td></td>

		</tr>
		<tr>

			<th>期限</th>
			<td></td>

		</tr>
		<tr>

			<th>ユーザーID</th>
			<td></td>

		</tr>
		<tr>

			<th>ステータス</th>
			<td></td>

		</tr>
		<tr>

			<th>メモ</th>
			<td></td>

		</tr>
		<tr>

			<th>登録日時</th>
			<td></td>

		</tr>
		<tr>

			<th>更新日時</th>
			<td></td>

		</tr>

	</table>
	
	<p><div style="display:inline-flex">
	
	<form action="task-edit.jsp" method="post">

			<input type="submit" value="編集する">

		</form>

		<form action="task-delete.jsp" method="post">

			<input type="submit" value="削除する">

		</form>

		<form action="task-list.jsp" method="post">

			<input type="submit" value="一覧へ戻る">

		</form>
		
		</div></p>
	

</body>
</html>