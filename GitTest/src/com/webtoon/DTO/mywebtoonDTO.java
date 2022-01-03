package com.webtoon.DTO;

public class mywebtoonDTO{

	private String muser_id;
	private String mwebtoon_seq;
	private String mwebtoon_name;
	private String mwebtoon_writer;
	private String mwebtoon_content;
	private String mwebtoon_genre;
	private String mwebtoon_img;
	private String mwebtoon_link;
	private String mwebtoon_keyword;
	
	public mywebtoonDTO(String muser_id, String mwebtoon_seq, String mwebtoon_name, String mwebtoon_writer,
			String mwebtoon_content, String mwebtoon_genre, String mwebtoon_img, String mwebtoon_link,
			String mwebtoon_keyword) {
		super();
		this.muser_id = muser_id;
		this.mwebtoon_seq = mwebtoon_seq;
		this.mwebtoon_name = mwebtoon_name;
		this.mwebtoon_writer = mwebtoon_writer;
		this.mwebtoon_content = mwebtoon_content;
		this.mwebtoon_genre = mwebtoon_genre;
		this.mwebtoon_img = mwebtoon_img;
		this.mwebtoon_link = mwebtoon_link;
		this.mwebtoon_keyword = mwebtoon_keyword;
	}
	
	public mywebtoonDTO(String muser_id, String mwebtoon_seq, String mwebtoon_name, String mwebtoon_writer,
			String mwebtoon_genre, String mwebtoon_img, String mwebtoon_link, String mwebtoon_keyword) {
		super();
		this.muser_id = muser_id;
		this.mwebtoon_seq = mwebtoon_seq;
		this.mwebtoon_name = mwebtoon_name;
		this.mwebtoon_writer = mwebtoon_writer;
		this.mwebtoon_genre = mwebtoon_genre;
		this.mwebtoon_img = mwebtoon_img;
		this.mwebtoon_link = mwebtoon_link;
		this.mwebtoon_keyword = mwebtoon_keyword;
	}



	public String getMuser_id() {
		return muser_id;
	}

	public void setMuser_id(String muser_id) {
		this.muser_id = muser_id;
	}

	public String getMwebtoon_seq() {
		return mwebtoon_seq;
	}

	public void setMwebtoon_seq(String mwebtoon_seq) {
		this.mwebtoon_seq = mwebtoon_seq;
	}

	public String getMwebtoon_name() {
		return mwebtoon_name;
	}

	public void setMwebtoon_name(String mwebtoon_name) {
		this.mwebtoon_name = mwebtoon_name;
	}

	public String getMwebtoon_writer() {
		return mwebtoon_writer;
	}

	public void setMwebtoon_writer(String mwebtoon_writer) {
		this.mwebtoon_writer = mwebtoon_writer;
	}

	public String getMwebtoon_content() {
		return mwebtoon_content;
	}

	public void setMwebtoon_content(String mwebtoon_content) {
		this.mwebtoon_content = mwebtoon_content;
	}

	public String getMwebtoon_genre() {
		return mwebtoon_genre;
	}

	public void setMwebtoon_genre(String mwebtoon_genre) {
		this.mwebtoon_genre = mwebtoon_genre;
	}

	public String getMwebtoon_img() {
		return mwebtoon_img;
	}

	public void setMwebtoon_img(String mwebtoon_img) {
		this.mwebtoon_img = mwebtoon_img;
	}

	public String getMwebtoon_link() {
		return mwebtoon_link;
	}

	public void setMwebtoon_link(String mwebtoon_link) {
		this.mwebtoon_link = mwebtoon_link;
	}

	public String getMwebtoon_keyword() {
		return mwebtoon_keyword;
	}

	public void setMwebtoon_keyword(String mwebtoon_keyword) {
		this.mwebtoon_keyword = mwebtoon_keyword;
	}
	
	
	
	
}
