package model.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
		try {
			this.limit = limit.toLocalDate();
		} catch (NullPointerException e) {
			LocalDate targetDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")
			        .parse("2019/01/01", LocalDate::from);
			this.limit=targetDate;
		}
	}
	public void setLimit(LocalDate limit) {
		if(Objects.nonNull(limit)) {
			this.limit=limit;
		}else {
			LocalDate targetDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")
			        .parse("2019/01/01", LocalDate::from);
			this.limit=targetDate;
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
		if(Objects.nonNull(memo)) {
			this.memo = memo;
		}else {
			this.memo="未入力";
		}
	}

	public LocalDate getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime.toLocalDate();
	}
	public void setCreateDateTime(LocalDate createDatetime) {
		this.createDateTime=createDateTime;
	}

	public LocalDate getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime.toLocalDate();
	}
}
