<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>

<h2>メニュー</h2>
<p style="text-align: right">
<%--=session.getAttribute("loginsuccess")--%>
ユーザーID：<%=session.getAttribute("id")%><br>
ユーザー名：<%=session.getAttribute("name")%>さん
<br>
</p>

<hr>

<p>
<form="task-list-servlet" method="post">

<input type ="submit" value="タスク一覧表示">

</form>
</p>

<p>
<form action="task-add-form.jsp">

<input type="submit" value="タスク登録">

</form>
</p>


<form action="logout.jsp">

<input type="submit" value="ログアウト">

</form>

</body>
</html>