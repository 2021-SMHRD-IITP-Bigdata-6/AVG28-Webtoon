package com.webtoon.DTO;

import java.util.Date;

public class NoticeDTO {
	private String article_seq;
	private String article_subject;
	private String article_content;
	private String article_date;
	private String article_file;
	private String article_cnt;
	private String user_id;
	private String rn;
	public NoticeDTO(String article_seq, String article_subject, String article_content, String article_date,
			String article_file, String article_cnt, String user_id) {
		super();
		this.article_seq = article_seq;
		this.article_subject = article_subject;
		this.article_content = article_content;
		this.article_date = article_date;
		this.article_file = article_file;
		this.article_cnt = article_cnt;
		this.user_id = user_id;
	}
	public String getArticle_seq() {
		return article_seq;
	}
	public void setArticle_seq(String article_seq) {
		this.article_seq = article_seq;
	}
	public String getArticle_subject() {
		return article_subject;
	}
	public void setArticle_subject(String article_subject) {
		this.article_subject = article_subject;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_date() {
		return article_date;
	}
	public void setArticle_date(String article_date) {
		this.article_date = article_date;
	}
	public String getArticle_file() {
		return article_file;
	}
	public void setArticle_file(String article_file) {
		this.article_file = article_file;
	}
	public String getArticle_cnt() {
		return article_cnt;
	}
	public void setArticle_cnt(String article_cnt) {
		this.article_cnt = article_cnt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
	}
	
}
