package com.scp.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserEntity {
	@Id
	@Column(name="user_id")
	private int id;
	@Column(name="user_name")
	private String name;
	@Column(name="user_password")
	private String password;
	@Column(name="user_isAlive")
	private String isActive;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", password=" + password + ", isActive=" + isActive + "]";
	}
	public UserEntity(int id, String name, String password, String isActive) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.isActive = isActive;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}