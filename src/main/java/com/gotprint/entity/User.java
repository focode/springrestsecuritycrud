package com.gotprint.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity; 

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")  
	private int id;
	
	@Column(name = "email")  
	private String email;
	
	@Column(name = "password")  
	private String password;
	
	@Column(name = "createTime")  
	private Date createTime;
	
	@Column(name = "lastUpdateTime")  
	private Date lastUpdateTime;
	
	@OneToMany(cascade={CascadeType.ALL})
	private Collection<Notes> notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Collection<Notes> getNotes() {
		return notes;
	}

	public void setNotes(Collection<Notes> notes) {
		this.notes = notes;
	}

	
	
}
