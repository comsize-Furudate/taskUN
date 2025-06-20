<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,model.entity.TaskBean,java.time.format.DateTimeFormatter,model.entity.CommentBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク詳細</title>
<script type="text/javascript" src="button.js"></script>
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

	<a href="login.jsp">ログイン画面へ</a>

	<%
	} else {
	%>

	<h2>タスク詳細</h2>
	<p style="text-align: right">

		ユーザーID：<%=session.getAttribute("id")%><br>
		ユーザー名：<%=session.getAttribute("name")%>さん<br>

	</p>

	<hr>
	
		<%
		TaskBean tb = (TaskBean) session.getAttribute("detail");
		String formatCreateDate = dtf1.format(tb.getCreateDateTime());
		String formatUpdateDate = dtf1.format(tb.getUpdateDateTime());
		List<CommentBean> commentList = (List<CommentBean>) session.getAttribute("commentList");
		boolean check = (boolean) session.getAttribute("check");
		%>

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
			<td><%=formatCreateDate%></td>

		</tr>
		<tr>

			<th>更新日時</th>
			<td><%=formatUpdateDate%></td>

		</tr>

	</table>
	
	<%
	if (check) {
	%>
	
	<div style="display:inline-flex">
	
	<form action="task-edit.jsp" method="post">

		<input type="submit" value="編集する" id="button">

	</form>

	<form action="task-delete.jsp" method="post">

		<input type="submit" value="削除する" id="button">
	</form>
	<%
	} else {
	%>
	<form action="task-edit.jsp" method="post">

		<input type="submit" value="編集する" id="button" disabled>

	</form>

	<form action="task-delete.jsp" method="post">

		<input type="submit" value="削除する" id="button" disabled>

	</form>
	<%
	}
	%>

	<form action="task-list.jsp" method="post">

		<input type="submit" value="一覧へ戻る">

	</form>
	
	</div><br>
	
	<table border="1">
	<%
	if (commentList != null) {
	%>

	
	<%
		for (CommentBean bean : commentList) {
			String formatUpdateDatetime = dtf1.format(bean.getUpdateDateTime());
	%>
	
		<tr>
			
			<td><%=bean.getUserId()%></td>
			<td><%=bean.getComment()%></td>
			<td><%=formatUpdateDatetime%></td>
			<%
			if (session.getAttribute("id").equals(bean.getUserId())) {
	%>
			<td><a
				href="comment-delete-check-servlet?comment_id=<%=bean.getCommentId()%>">削除</a></td>
			<br>

		</tr>
	

	<%
			}
		}
	}
	%>
	</table>
	
	<form action="comment-post-servlet" method="post">
		<textarea name="commentPost" rows="4" cols="25" maxlength="100">コメントを投稿する。</textarea><br>
		<input type=submit value=" 投稿する">
		<input type=reset value="クリア">
	</form>
	
	<%}%>


</body>
</html>