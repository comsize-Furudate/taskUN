<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


ok<%=session.getAttribute("name")%>
<%=session.getAttribute("id")%>

<form action="logout.jsp">

<input type="submit" value="ログアウト">


</form>
</body>
</html>