package model.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

	public class TaskBean {

	private int taskId;
	private String taskName;
	private int categoryId;
	private String categoryName;
	private LocalDate limit;
	private String userId;
	private String statusName;
	private int statusCode;
	private String memo;
	private LocalDate createDateTime;
	private LocalDate updateDateTime;
	private LocalDateTime createDatetime;
	
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

<<<<<<< HEAD
	public void setLimit(Date limit) {
		this.limit = LocalDate.ofInstant(limit.toInstant(), ZoneId.systemDefault());
=======
	public void setLimit(LocalDate limit) {
		this.limit = limit;
>>>>>>> d76b576c85ad9efd6f9b70c66d3feff91417e333
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

<<<<<<< HEAD
	public LocalDate getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = LocalDate.ofInstant(createDateTime.toInstant(), ZoneId.systemDefault());
		;
	}

	public LocalDate getUpdateDateTime() {
		return updateDateTime;
	}

public void setUpdateDateTime(Date updateDateTime) {
	this.updateDateTime = LocalDate.ofInstant(updateDateTime.toInstant(), ZoneId.systemDefault());;
}
=======
	public LocalDateTime getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime2) {
		this.createDatetime = createDatetime2;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	

>>>>>>> d76b576c85ad9efd6f9b70c66d3feff91417e333
}
