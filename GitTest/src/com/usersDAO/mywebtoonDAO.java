package com.usersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.webtoon.DTO.mywebtoonDTO;
import com.webtoon.DTO.usersDTO;
import com.webtoon.DTO.webtoonDTO;

public class mywebtoonDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null; // 지역변수 전체로
	int cnt = 0;

	usersDTO dto = null;
	webtoonDTO wdto = null;

	mywebtoonDTO mwdto = null;
	
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
	
	public mywebtoonDTO MyWebtoonSelect(String mweb_id, String mweb_seq) {

		try {

			getConn();

			String sql = "select * from t_mywebtoon where muser_id = ? and mwebtoon_seq = ?";


			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mweb_id);
			psmt.setString(2, mweb_seq);

			rs = psmt.executeQuery();

			if (rs.next()) {

				String mwebtoon_seq = rs.getString("mwebtoon_seq");
				String muser_id = rs.getString("muser_id");
				String mwebtoon_name = rs.getString("mwebtoon_name");
				String mwebtoon_writer = rs.getString("mwebtoon_writer");
				String mwebtoon_genre = rs.getString("mwebtoon_genre");
				String mwebtoon_img = rs.getString("mwebtoon_img");
				String mwebtoon_link = rs.getString("mwebtoon_link");
				String mwebtoon_keyword = rs.getString("mwebtoon_keyword");

				mwdto = new mywebtoonDTO(muser_id,mwebtoon_seq , mwebtoon_name, mwebtoon_writer, mwebtoon_genre, mwebtoon_img, mwebtoon_link, mwebtoon_keyword);

			}	
			else {
				mwdto=null;
			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally {

			close();

		}

		return mwdto;

	}
	
	// 일단 t_my_webtoon테이블에 insert -> 나중에 ArrayList<mywebtoonDTO>에가져와서 넣고, delete
	public int JoinMyWebtoon(mywebtoonDTO mydto1) {
		
		try { 
			
			getConn();
			
			String sql = "insert into t_mywebtoon values (?,?,?,?,?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mydto1.getMwebtoon_seq());
			psmt.setString(2, mydto1.getMuser_id());
			psmt.setString(3, mydto1.getMwebtoon_name());
			psmt.setString(4, mydto1.getMwebtoon_writer());
			psmt.setString(5, mydto1.getMwebtoon_content());
			psmt.setString(6, mydto1.getMwebtoon_genre());
			psmt.setString(7, mydto1.getMwebtoon_img());
			psmt.setString(8, mydto1.getMwebtoon_link());
			psmt.setString(9, mydto1.getMwebtoon_keyword());

			cnt = psmt.executeUpdate();


		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally { 
			
			close();
			
		}
		
		return cnt;
		
	}
	
	public int MyWebtoonDelete(String muser_id, String mwebtoon_seq) {
		
		try { 
			
			getConn();

			String sql = "delete from t_mywebtoon where muser_id = ? and mwebtoon_seq = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, muser_id);
			psmt.setString(2, mwebtoon_seq);
			
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally { 
			
			close();
		}
		
		return cnt;
		
	}
	
	
	public ArrayList<mywebtoonDTO> selectWebtoon(String mwdto_id) {

		ArrayList<mywebtoonDTO> web_arr = new ArrayList<mywebtoonDTO>();

		try { // db연결코드

			getConn();

			// 5 .SQL명령문을 준비 //콘솔창에입력 ? 써야한다
			String sql = "select * from t_mywebtoon where muser_id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mwdto_id);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String muser_id = rs.getString("muser_id");
				String mwebtoon_seq = rs.getString("mwebtoon_seq");
				String mwebtoon_name = rs.getString("mwebtoon_name");
				String mwebtoon_writer = rs.getString("mwebtoon_writer");
				String mwebtoon_content = rs.getString("mwebtoon_content");
				String mwebtoon_genre = rs.getString("mwebtoon_genre");
				String mwebtoon_img = rs.getString("mwebtoon_img");
				String mwebtoon_link = rs.getString("mwebtoon_link");
				String mwebtoon_keyword = rs.getString("mwebtoon_keyword");

				mwdto = new mywebtoonDTO(muser_id, mwebtoon_seq, mwebtoon_name, mwebtoon_writer, mwebtoon_content, mwebtoon_genre, mwebtoon_img, mwebtoon_link, mwebtoon_keyword);
				web_arr.add(mwdto);
				

			}

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();// try 문 안에서 오류확인하는 코드

		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}

		return web_arr;

	}
	
	
	
	
}
