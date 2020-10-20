package com.kumar.model;

public class Email {
	private String email;
	private String password;
	private String body;
	private String subject;
	private String to;
	
	
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.email+" "+this.password+" "+this.body+" "+this.subject;
	}
	
	
	

}
