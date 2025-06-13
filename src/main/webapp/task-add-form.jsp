<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.CategoryBean,model.entity.StatusBean,
    java.util.List,java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録フォーム</title>
</head>
<body>
<%List<CategoryBean> categoryList = (List<CategoryBean>)session.getAttribute("categoryList");
  List<StatusBean> statusList = (List<StatusBean>)session.getAttribute("statusList");
  LocalDate today = (LocalDate) session.getAttribute("today");%>
<%if(session.getAttribute("id") == null){ %>
	<h2>ログインされていません</h2>
	<a href = "login.jsp">ログイン画面へ</a>
<%}else { %>
<form action = "task-add-servlet" method = "post" >
<table>
	<tr>
		<th>タスク名</th>
		<td><input type = "text" name = "taskName" maxlength = "50" required></td>
	</tr>
	<tr>
		<th>カテゴリー</th>
		<td><select name = "category">
		<%for(CategoryBean category : categoryList){%>
			<option value = "<%=category.getCategoryId() %>"><%=category.getCategoryName() %></option>
		<%} %>
		</select></td>
	</tr>
	<tr>
		<th>期限</th>
		<td><input type = "date" name = "limit" min = "<%=today %>"></td>
	</tr>
	<tr>
		<th>ステータス</th>
		<td><select name = "status">
		<%for(StatusBean status :statusList){ %>
			<option value = "<%=status.getStatusCode() %>"><%=status.getStatusName() %></option>
		
		<%} %>
		</select></td>
	</tr>
	<tr>
		<th>担当者のユーザID</th>
		<td><input type = "text" name = "userId" maxlength = "24" required></td>
	</tr>
	<tr>
		<th>メモ</th>
		<td><textarea name = "memo" rows ="4" cols = "25" maxlength = "100" ></textarea></td>
	</tr>
</table>
<input type = "submit" value = "登録実行">
<input type = "reset" value = "クリア">
</form>	
<%} %>
</body>
</html>