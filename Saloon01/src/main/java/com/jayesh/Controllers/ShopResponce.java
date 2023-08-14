package com.jayesh.Controllers;

public class ShopResponce {
	static enum Status{
		success,error
	}
	private Status status;
	private Object data;
	private String error;
	public ShopResponce(Status status, Object data, String error) {
		this.status = status;
		this.data = data;
		this.error = error;
	}
	public ShopResponce() {
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	 public static ShopResponce success(Object data)
	 {
		 ShopResponce res = new ShopResponce(Status.success,data,null);
		 return res;
	 }
	 public static ShopResponce error(String error)
	 {
		 ShopResponce res = new ShopResponce(Status.error,null,error);
		 return res;
	 }
	

}
