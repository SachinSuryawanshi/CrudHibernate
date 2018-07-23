package com.scp.pojos;

public class User {

	private int id;
	private String name;
	private String password;
	private boolean isActive;

	public User() {
		super();
	
	}

	public User(int id, String name, String password, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.isActive = isActive;
	}

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "\n User [id=" + id + ", name=" + name + ", password=" + password + ", isActive=" + isActive + "]";
	}

}
