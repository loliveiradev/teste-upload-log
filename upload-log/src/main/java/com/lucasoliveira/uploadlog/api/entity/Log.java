package com.lucasoliveira.uploadlog.api.entity;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_LOG")
public class Log implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5699641994039488527L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String ip;

    private String status;

    private String userAgent;
    

    public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Log(Long id, Date date, String ip, String status, String userAgent) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
