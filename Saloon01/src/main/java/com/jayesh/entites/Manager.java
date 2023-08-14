package com.jayesh.entites;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Table(name="manager")
@Entity
public class Manager {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int manager_Id;
	
	private String manager_name;
	@Column(name = "manager_Email")
	private String email;
	
	private String manager_Password;
	@JsonIgnoreProperties("manager")
	@OneToOne(mappedBy = "manager")
	private Branch branch;
	
	private int enabled;
	public Manager() {
	}
	public Manager(int manager_Id, String manager_name, String manager_Email, String manager_Password, int enabled) {
		this.manager_Id = manager_Id;
		this.manager_name = manager_name;
		this.email = manager_Email;
		this.manager_Password = manager_Password;
		this.enabled = enabled;
	}
	public int getManager_Id() {
		return manager_Id;
	}
	public void setManager_Id(int manager_Id) {
		this.manager_Id = manager_Id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_Email() {
		return email;
	}
	public void setManager_Email(String manager_Email) {
		this.email = manager_Email;
	}
	public String getManager_Password() {
		return manager_Password;
	}
	public void setManager_Password(String manager_Password) {
		this.manager_Password = manager_Password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
//	@Override
//	public String toString() {
//		return "Manager [manager_Id=" + manager_Id + ", manager_name=" + manager_name + ", manager_Email="
//				+ manager_Email + ", manager_Password=" + manager_Password + ", enabled=" + enabled + "]";
//	}
	
	
	
	

}
