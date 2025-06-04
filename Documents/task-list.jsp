<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<br>
	</p>

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

		<tr>

			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>


		</tr>

	</table>
	
	<p>
	<form action="menu.jsp" method="post">
	
	<input type="submit" value="メニューへ戻る">
	
	</form>
	</p>

</body>
</html>