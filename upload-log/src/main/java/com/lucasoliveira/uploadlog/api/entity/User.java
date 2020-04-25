package com.lucasoliveira.uploadlog.api.entity;

import javax.persistence.*;


import com.lucasoliveira.uploadlog.api.enums.ProfileEnum;


@Entity
@Table(name = "TB_USER")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String email;
	
	private String password;
	
	private ProfileEnum profile;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
	
	
}
