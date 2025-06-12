<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>

	<script type="text/javascript">

	const isFirstLoad = sessionStorage.getItem('isFirstLoad');
	window.addEventListener('load', function() {

		 if (!isFirstLoad) {

	<%
	String msg = (String)session.getAttribute("msg");
	if(msg.equals(null)){
	%>
	
	
	<%}else{ 
	%>
		
	
	    var msg = "<%=msg%>";
			alert(msg);
	
	
	<%}%>
	
	sessionStorage.setItem('isFirstLoad', true);
	} else {}
	
	</script>



	<h2>メニュー</h2>
	<p style="text-align: right">

		ユーザーID：<%=session.getAttribute("id")%><br>
		ユーザー名：<%=session.getAttribute("name")%>さん<br>

	</p>

	<hr>

	<p>
	<form action="task-list-servlet" method="post">

		<input type="submit" value="タスク一覧表示">

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