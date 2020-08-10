package com.application.SurveySystem.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "users", schema = "public")
public class Users {
	
	@Id
	private String id;
	private String password;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Requests> requests;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Users() {}
	
	public Users(String id, String pass) {
		super();
		this.id = id;
		this.password = pass;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", password=" + password + "]";
	}
	
}
