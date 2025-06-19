package model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StatusBean implements Serializable{
	private String statusCode;
	private String statusName;
	private LocalDateTime updateDateTime;
	
	public StatusBean(){
		
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusName() {
		return statusName;
	}
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}
