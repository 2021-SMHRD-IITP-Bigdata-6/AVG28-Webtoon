package com.webtoon.DTO;

public class usersDTO {

	String user_id;
	String user_pw;
	String user_email;
	String user_tel;
	String user_addr;
	String user_gender;
	String user_joindate;
	String user_yesno;
	
	public usersDTO(String user_id, String user_pw, String user_email, String user_tel, String user_addr,
			String user_gender, String user_joindate, String user_yesno) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_addr = user_addr;
		this.user_gender = user_gender;
		this.user_joindate = user_joindate;
		this.user_yesno = user_yesno;
	}
	
	public usersDTO(String user_id, String user_pw, String user_email, String user_tel, String user_addr,
			String user_gender, String user_joindate) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_addr = user_addr;
		this.user_gender = user_gender;
		this.user_joindate = user_joindate;
	}

	public usersDTO(String user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}


	public usersDTO(String user_id, String user_pw, String user_email, String user_tel, String user_addr,
			String user_gender) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_tel = user_tel;
		this.user_addr = user_addr;
		this.user_gender = user_gender;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_joindate() {
		return user_joindate;
	}

	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}

	public String getUser_yesno() {
		return user_yesno;
	}

	public void setUser_yesno(String user_yesno) {
		this.user_yesno = user_yesno;
	}
	
	
	
}
