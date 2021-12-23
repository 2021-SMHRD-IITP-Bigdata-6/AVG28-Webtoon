package com.webtoon.DTO;

public class usersDTO {

	String user_email;
	String user_pw;
	String user_tel;
	String user_address;
	String user_sex;
	
	public usersDTO(String user_email, String user_pw, String user_tel, String user_address, String user_sex) {
		super();
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.user_tel = user_tel;
		this.user_address = user_address;
		this.user_sex = user_sex;
	}
	
	public usersDTO(String user_email, String user_pw) {
		super();
		this.user_email = user_email;
		this.user_pw = user_pw;
	}

	public usersDTO(String user_email, String user_tel, String user_address, String user_sex) {
		super();
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_address = user_address;
		this.user_sex = user_sex;
	}

	public usersDTO(String user_email, String user_tel, String user_address) {
		super();
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_address = user_address;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	
}
