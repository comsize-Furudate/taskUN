package model.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class TaskBean {
int taskId;
String taskName;
int categoryId;
String categoryName;
LocalDate limit;
String userId;
String statusName;
int statusCode;
String memo;
LocalDate createDateTime;
LocalDate updateDateTime;
public TaskBean() {
	}
public int getTaskId() {
	return taskId;
}
public void setTaskId(int taskId) {
	this.taskId = taskId;
}
public String getTaskName() {
	return taskName;
}
public void setTaskName(String taskName) {
	this.taskName = taskName;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public LocalDate getLimit() {
	return limit;
}
public void setLimit(Date limit) {
	this.limit = LocalDate.ofInstant(limit.toInstant(), ZoneId.systemDefault());
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getStatusName() {
	return statusName;
}
public void setStatusName(String statusName) {
	this.statusName = statusName;
}
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public LocalDate getCreateDateTime() {
	return createDateTime;
}
public void setCreateDateTime(Date createDateTime) {
	this.createDateTime = LocalDate.ofInstant(createDateTime.toInstant(), ZoneId.systemDefault());;
}
public LocalDate getUpdateDateTime() {
	return updateDateTime;
}
public void setUpdateDateTime(Date updateDateTime) {
	this.updateDateTime = LocalDate.ofInstant(updateDateTime.toInstant(), ZoneId.systemDefault());;
}
}
