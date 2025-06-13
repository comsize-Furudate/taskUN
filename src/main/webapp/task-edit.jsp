<%@page import="model.entity.StatusBean"%>
<%@page import="model.dao.StatusDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.CategoryDAO"%>
<%@page import="model.entity.CategoryBean"%>
<%@page import="model.entity.TaskBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集</title>
</head>
<body>
	<%
	TaskBean tb = (TaskBean) session.getAttribute("detail");
	%>

	<form action="task-edit-check-servlet" method="post">
	
		<table border="1">
		
			<tr>
				<td>タスク名</td>
				<td><input type="text" name="task_name" value="<%=tb.getTaskName()%>"></td>
			</tr>
			
			<tr>
				<td>カテゴリ名</td>
				
				<%CategoryBean cb =new CategoryBean(); 
				CategoryDAO cdao=new CategoryDAO();
				List<CategoryBean> clist= cdao.selectAllCategory();%>
				
				<td><select name="category_name">
				
						<%for(CategoryBean cbean:clist){%>
						<option value="<%=cbean.getCategoryId() %>,<%=cbean.getCategoryName()%>"><%=cbean.getCategoryName()%></option>
						<%} %>
						
				</select></td>
			</tr>
			
			<tr>
				<td>期限</td>
				<td><input type="date" name="limit"></td>
			</tr>
			
			<tr>
				<td>ステータス</td>
				
				<%StatusDAO sdao=new StatusDAO();
				List<StatusBean> slist= sdao.selectAllStatus(); %>
				
				<td><select name="status_name">
				
				<%for(StatusBean sbean:slist){ %>
						<option value="<%=sbean.getStatusCode() %>,<%=sbean.getStatusName()%>"><%=sbean.getStatusName() %>
						<%} %>
						
				</select></td>
			</tr>
			
			<tr>
				<td>メモ</td>

				<td><input type="text" name="memo"></td>
			</tr>
			
		</table>
		
		<input type="submit" value="確認"> <input type="reset" value="取消">
	</form>
	
	<form action="task-detail.jsp" method="post">
		<input type="submit" value="詳細へ戻る">
	</form>
	
</body>
</html>