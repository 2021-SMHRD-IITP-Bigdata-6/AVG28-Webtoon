package com.usersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.webtoon.DTO.usersDTO;
import com.webtoon.DTO.webtoonDTO;
/**
 * @author mandu
 *
 */
public class webtoonDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null; // 지역변수 전체로
	int cnt = 0;

	webtoonDTO wdto = null;

	usersDAO udao = new usersDAO();

	public void getConn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스파일 로딩완료");

			// 3.DB에서 사용하는 id/pw를 인증
			String url = "jdbc:oracle:thin:@127.0.0.1:1521";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			if (conn != null) {
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {

		System.out.println("무조건 실행");

		try {

			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public webtoonDTO WebtoonInfoGo(String wdto1seq) {

		try {

			getConn();

			String sql = "select * from t_webtoon where webtoon_seq = ?";

			// System.out.println(wdto1.getWebtoon_seq());

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, wdto1seq);

			rs = psmt.executeQuery();

			if (rs.next()) {

				String webtoon_seq = rs.getString(1);
				String webtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_content = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_img = rs.getString(6);
				String webtoon_link = rs.getString(7);
				String webtoon_keyword = rs.getString(8);

				wdto = new webtoonDTO(webtoon_seq, webtoon_name, webtoon_writer, webtoon_content, webtoon_genre,
						webtoon_img, webtoon_link, webtoon_keyword);
				
				System.out.println("infodao실행값" + webtoon_seq);
				System.out.println("infodao실행값" + webtoon_name);
				System.out.println("infodao실행값" + webtoon_writer);
				System.out.println("infodao실행값" + webtoon_content);
				System.out.println("infodao실행값" + webtoon_genre);
				System.out.println("infodao실행값" + webtoon_img);
				System.out.println("infodao실행값" + webtoon_link);
				System.out.println("infodao실행값" + webtoon_keyword);
			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally {

			close();

		}

		return wdto;

	}

	public ArrayList<webtoonDTO> selectWebtoonInfo(String wdto_genre) {
		System.out.println(wdto_genre);
		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();

		try {

			getConn();

			String sql = "select * from t_webtoon where webtoon_genre like ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, wdto_genre);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String webtoon_seq = rs.getString(1);
				String webtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_content = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_img = rs.getString(6);
				String webtoon_link = rs.getString(7);
				String webtoon_keyword = rs.getString(8);

				wdto = new webtoonDTO(webtoon_seq, webtoon_name, webtoon_writer, webtoon_content, webtoon_genre, webtoon_img,
						webtoon_link, webtoon_keyword);
				web_arr.add(wdto);
				
				System.out.println("슬라이드dao실행값" + webtoon_seq);
				System.out.println("슬라이드dao실행값" + wdto_genre);
				System.out.println("슬라이드dao실행값" + webtoon_name);
				System.out.println("슬라이드dao실행값" + webtoon_writer);
				System.out.println("슬라이드dao실행값" + webtoon_content);
				System.out.println("슬라이드dao실행값" + webtoon_genre);
				System.out.println("슬라이드dao실행값" + webtoon_img);
				System.out.println("슬라이드dao실행값" + webtoon_link);
				System.out.println("슬라이드dao실행값키워드 " + webtoon_keyword);
			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally {

			close();

		}
		return web_arr;

	}

	// 총 레코드 수를 구함..
	public int getWebtoonCount() {
		int count = 0;

		try {
			getConn();

			String sql = "select COUNT(*) from t_webtoon";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}

		return count;
	}
	
	//webToon 테이블 getList
	public ArrayList<webtoonDTO> getSelectWebtoonList(int startRow, int endRow) {

		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();

		try { // db연결코드

			getConn();

			// 5 .SQL명령문을 준비 //콘솔창에입력 ? 써야한다
//			String sql = "select *from t_webtoon where ";
			String sql = " SELECT * FROM ( "
				    + "SELECT webtoon_seq, webtoon_name, webtoon_writer,  webtoon_content, webtoon_genre, webtoon_img,webtoon_link, webtoon_keyword,rownum rn FROM t_webtoon"
				    + " ORDER BY webtoon_seq DESC ) WHERE rn between ? and ? "; 
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, startRow);
			psmt.setInt(2, endRow);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String webtoon_seq = rs.getString(1);
				String webtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_content = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_img = rs.getString(6);
				String webtoon_link = rs.getString(7);
				String webtoon_keyword = rs.getString(8);

				wdto = new webtoonDTO(webtoon_seq, webtoon_name, webtoon_writer, webtoon_content, webtoon_genre,
						webtoon_img, webtoon_link, webtoon_keyword);
				web_arr.add(wdto);

			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();// try 문 안에서 오류확인하는 코드

		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}

		return web_arr;

	}

	
	public ArrayList<webtoonDTO> selectWebtoon() {

		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();

		try { // db연결코드

			getConn();

			// 5 .SQL명령문을 준비 //콘솔창에입력 ? 써야한다
			String sql = "select * from t_webtoon ";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String webtoon_seq = rs.getString(1);
				String webtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_content = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_img = rs.getString(6);
				String webtoon_link = rs.getString(7);
				String webtoon_keyword = rs.getString(8);

				wdto = new webtoonDTO(webtoon_seq, webtoon_name, webtoon_writer, webtoon_content, webtoon_genre,
						webtoon_img, webtoon_link, webtoon_keyword);
				web_arr.add(wdto);

			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();// try 문 안에서 오류확인하는 코드

		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}

		return web_arr;

	}


	public ArrayList<webtoonDTO> searchWebtoon(String webtoon_name) {
		System.out.println(webtoon_name);
		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();

		try {

			getConn();

			String sql = "select * from t_webtoon where webtoon_name like ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + webtoon_name + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {

//				String mwebtoon_name = rs.getString(2);
//				String webtoon_writer = rs.getString(3);
//				String webtoon_content = rs.getString(4);
//				String webtoon_genre = rs.getString(5);
//				String webtoon_img = rs.getString(6);
//				String webtoon_link = rs.getString(7);
//				String webtoon_keyword = rs.getString(8);
				
				String webtoon_seq = rs.getString(1);
				webtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_content = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_img = rs.getString(6);
				String webtoon_link = rs.getString(7);
				String webtoon_keyword = rs.getString(8);
				wdto = new webtoonDTO(webtoon_seq, webtoon_name, webtoon_writer, webtoon_content, webtoon_genre,
						webtoon_img, webtoon_link, webtoon_keyword);
//				wdto = new webtoonDTO(mwebtoon_name, webtoon_writer, webtoon_content, webtoon_genre, webtoon_img,
//						webtoon_link, webtoon_keyword);
				web_arr.add(wdto);
			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally {

			close();

		}
		return web_arr;

	}   public ArrayList<webtoonDTO> keyword_hWebtoon(String[] keyword) {
		// ArrayList 로 태그 값을 가져와서 조회
		ArrayList<webtoonDTO> key_arr = new ArrayList<webtoonDTO>();

		try {

			getConn();
			
			String sql = "select * from t_webtoon where webtoon_keyword  like '%"+keyword[0]+"%'";
			
			//System.out.println(keyword[1]);
			
			for(int i = 1 ; i< keyword.length;i++ ) {
				sql = "select * from (" + sql +  ")where webtoon_keyword  like '%"+keyword[i]+"%'";
				//sql+="AND like '%"+keyword[i]+"%' ";
				
			}

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				
				String webtoon_seq = rs.getString(1);
				String webtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_content = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_img = rs.getString(6);
				String webtoon_link = rs.getString(7);
				String webtoon_keyword = rs.getString(8);
				wdto = new webtoonDTO(webtoon_seq, webtoon_name, webtoon_writer, webtoon_content, webtoon_genre,
						webtoon_img, webtoon_link, webtoon_keyword);
				key_arr.add(wdto);
			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally {

			close();

		}
		return key_arr;

	}
	


	
}
