<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
</head>
<body>

<h2>ログアウトしますか？</h2>

<table>

<tr>
<th>
<td>

<form action="logout-servlet" method="post">

<input type="submit" value="はい">

</form>

<form action="menu.jsp" method="post">

<input type="submit" value="いいえ">

</form>

</td>
</th>
</tr>

</table>

</body>
</html>