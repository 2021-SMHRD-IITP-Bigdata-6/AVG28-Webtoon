package com.webtoon.DTO;

public class webtoonDTO{

	private String webtoon_seq;
	private String webtoon_name;
	private String webtoon_writer;
	private String webtoon_link;
	private String webtoon_genre;
	private String webtoon_content;
	private String webtoon_keyword;
	
	public webtoonDTO(String webtoon_seq, String webtoon_name, String webtoon_writer, String webtoon_link,
			String webtoon_genre, String webtoon_content, String webtoon_keyword) {
		super();
		this.webtoon_seq = webtoon_seq;
		this.webtoon_name = webtoon_name;
		this.webtoon_writer = webtoon_writer;
		this.webtoon_link = webtoon_link;
		this.webtoon_genre = webtoon_genre;
		this.webtoon_content = webtoon_content;
		this.webtoon_keyword = webtoon_keyword;
	}
	
	public webtoonDTO(String webtoon_name, String webtoon_writer, String webtoon_link, String webtoon_genre,
			String webtoon_content, String webtoon_keyword) {
		super();
		this.webtoon_name = webtoon_name;
		this.webtoon_writer = webtoon_writer;
		this.webtoon_link = webtoon_link;
		this.webtoon_genre = webtoon_genre;
		this.webtoon_content = webtoon_content;
		this.webtoon_keyword = webtoon_keyword;
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
	public String getWebtoon_link() {
		return webtoon_link;
	}
	public void setWebtoon_link(String webtoon_link) {
		this.webtoon_link = webtoon_link;
	}
	public String getWebtoon_genre() {
		return webtoon_genre;
	}
	public void setWebtoon_genre(String webtoon_genre) {
		this.webtoon_genre = webtoon_genre;
	}
	public String getWebtoon_content() {
		return webtoon_content;
	}
	public void setWebtoon_content(String webtoon_content) {
		this.webtoon_content = webtoon_content;
	}
	public String getWebtoon_keyword() {
		return webtoon_keyword;
	}
	public void setWebtoon_keyword(String webtoon_keyword) {
		this.webtoon_keyword = webtoon_keyword;
	}

	@Override
	public String toString() {
		return "webtoonDTO [webtoon_seq=" + webtoon_seq + ", webtoon_name=" + webtoon_name + ", webtoon_writer="
				+ webtoon_writer + ", webtoon_link=" + webtoon_link + ", webtoon_genre=" + webtoon_genre
				+ ", webtoon_content=" + webtoon_content + ", webtoon_keyword=" + webtoon_keyword + "]";
	}

	
	
	
}
