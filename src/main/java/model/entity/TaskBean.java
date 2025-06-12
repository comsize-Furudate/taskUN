package model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TaskBean implements Serializable{
	private int taskId;
	private String taskName;
	private int categoryId;
	private String categoryName;
	private LocalDate limit;
	private String userId;
	private String statusName;
	private String statusCode;
	private String memo;
	private LocalDateTime createDateTime;
	private LocalDateTime updateDateTime;

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

	public void setLimit(LocalDate limit) {
		if(limit != null) {
			this.limit = limit;
		} else{
			LocalDate targetDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")
			        .parse("2019/01/01", LocalDate::from);
			this.limit = targetDate;
		}
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

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		if(Objects.nonNull(memo)) {
			this.memo = memo;
		}else {
			this.memo="未入力";
		}
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
}
