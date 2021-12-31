package com.webtoon.DTO;

public class selectionDTO {

	private String user_id;
	private String webtoon_seq;
	private String webtoon_name;
	private String webtoon_writer;
	private String webtoon_genre;
	private String webtoon_keyword;
	
	public selectionDTO(String user_id, String webtoon_seq, String webtoon_name, String webtoon_writer,
			String webtoon_genre, String webtoon_keyword) {
		super();
		this.user_id = user_id;
		this.webtoon_seq = webtoon_seq;
		this.webtoon_name = webtoon_name;
		this.webtoon_writer = webtoon_writer;
		this.webtoon_genre = webtoon_genre;
		this.webtoon_keyword = webtoon_keyword;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getWebtoon_seq() {
		return webtoon_seq;
	}

	public void setWebtoon_seq(String webtoon_seq) {
		this.webtoon_seq = webtoon_seq;
	}

	public String getWebtoon_name() {
		return webtoon_name;
	}

	public void setWebtoon_name(String webtoon_name) {
		this.webtoon_name = webtoon_name;
	}

	public String getWebtoon_writer() {
		return webtoon_writer;
	}

	public void setWebtoon_writer(String webtoon_writer) {
		this.webtoon_writer = webtoon_writer;
	}

	public String getWebtoon_genre() {
		return webtoon_genre;
	}

	public void setWebtoon_genre(String webtoon_genre) {
		this.webtoon_genre = webtoon_genre;
	}

	public String getWebtoon_keyword() {
		return webtoon_keyword;
	}

	public void setWebtoon_keyword(String webtoon_keyword) {
		this.webtoon_keyword = webtoon_keyword;
	}
	
	
	
}
