package com.lucasoliveira.uploadlog.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogDTO {
	
    private Long id;

    private String date;

    private String ip;

    private String status;

    private String userAgent;
    

	public LogDTO() {
		super();
	}
	
	
	@JsonCreator
	public LogDTO(@JsonProperty("id") Long id, 
			      @JsonProperty("date") String date, 
			      @JsonProperty("ip") String ip, 
			      @JsonProperty("status") String status, 
			      @JsonProperty("userAgent") String userAgent) {
		super();
		this.id = id;
		this.date = date;
		this.ip = ip;
		this.status = status;
		this.userAgent = userAgent;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
    


}
