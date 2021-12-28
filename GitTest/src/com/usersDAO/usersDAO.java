package com.usersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.webtoon.DTO.usersDTO;

public class usersDAO {

	Connection conn = null; 
	PreparedStatement psmt = null;
	ResultSet rs = null;  //지역변수 전체로
	int cnt = 0;
	
	usersDTO dto = null; // select문은 dto에 들어있는 값이 변하기 때문에 dto로 값이 들어갔는지 확인하는 방법을 선택함.
	private boolean check;
	
	public void getConn() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("클래스파일 로딩완료");
			
			//3.DB에서 사용하는 id/pw를 인증
			String url ="jdbc:oracle:thin:@127.0.0.1:1521";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn != null) {
				System.out.println("연결성공");
			}else {
				System.out.println("연결실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void close() {
		
		System.out.println("무조건 실행");

		try {
			
			if(rs != null){
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
	
	// String에 변수이름은 달라도됨 a 등등
	public int Join(usersDTO dto) {
		
		try { 
			
			getConn();
			
			String sql = "insert into t_user values (?,?,?,?,?,?,sysdate,'no')";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getUser_pw());
			psmt.setString(3, dto.getUser_email());
			psmt.setString(4, dto.getUser_tel());
			psmt.setString(5, dto.getUser_addr());
			psmt.setString(6, dto.getUser_gender());

			cnt = psmt.executeUpdate();


		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally { 
			
			close();
			
		}
		
		return cnt;
		
	}
	
	public int Delete(String user_id) {
		
		try { 
			
			getConn();

			String sql = "delete from t_user where user_id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally { 
			
			close();
		}
		
		return cnt;
		
	}
	
	public int Update(String user_id, String user_pw, String user_email, String user_tel, String user_addr, String user_joindate) {
	      
	      try {
	    	  
	    	 getConn();
	         
	         String sql = "update users set user_pw = ? , user_email = ?, user_tel = ? , user_addr= ? , where user_id = ? "; 
	      
	         psmt = conn.prepareStatement(sql);

	         psmt.setString(1, user_pw);
	         psmt.setString(2, user_email);
	         psmt.setString(3, user_tel);
	         psmt.setString(4, user_addr);
	         psmt.setString(5, user_id);

	         cnt = psmt.executeUpdate();



	      } catch (Exception e) {

	         e.printStackTrace();

	      } finally {

	    	  close();

	      }		
		
	      return cnt;
	}
	
	public usersDTO Login(usersDTO dto1) {
		
		try { 

			getConn();
			
			String sql = "select * from t_user where user_id = ?";

			System.out.println(dto1.getUser_id());
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto1.getUser_id());
			
			
			rs = psmt.executeQuery();


			if (rs.next()) {
				
				String getid = rs.getString(1);
				String getpw = rs.getString(2);
				String getemail = rs.getString(3);
				String gettel = rs.getString(4);
				String getaddr = rs.getString(5);
				String getgender = rs.getString(6);
				String getjoindate = rs.getString(7);
				
				if(dto1.getUser_pw().equals(getpw)) {
					
					dto = new usersDTO(dto1.getUser_id(), getpw, getemail, gettel, getaddr, getgender, getjoindate);
					
				}
				
				
			} 

		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally { 
			
			close();

		}
		
		return dto;
		
	}
	
	public ArrayList<usersDTO> selectMember(String user_id) {
		
		ArrayList<usersDTO> arr = new ArrayList<usersDTO>();
		
		try { // db연결코드
			
			getConn();
			
			// 5 .SQL명령문을 준비 //콘솔창에입력 ? 써야한다
			String sql = "select * from t_user";
			
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery(); 
			
			while (rs.next()) {
				
				String muser_id = rs.getString(1);
				String user_pw = rs.getString(2);
				String user_email = rs.getString(3);
				String user_tel = rs.getString(4);
				String user_addr = rs.getString(5);
				String user_gender = rs.getString(6);
				String user_joindate = rs.getString(7);
				String user_yesno = rs.getString(8);

				dto = new usersDTO(muser_id, user_pw, user_email, user_tel, user_addr, user_gender, user_joindate, user_yesno);
				arr.add(dto);
				
			} 
			
			
		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();// try 문 안에서 오류확인하는 코드

		} finally { // 코드가 오류가됬던 안됬던 무조건 실행
			
			close();

		}
		
		return arr;
		
	}
	
	public boolean emailCheck(String user_id) {
		
		try { 

			getConn();
			
			String sql = "select * from t_user where user_id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			rs = psmt.executeQuery();

			check = rs.next();
			
		} catch (Exception e) {
			System.out.println("클래스파일 로딩 실패");
			e.printStackTrace();

		} finally { 
			
			close();

		}
		
		return check;
	}
	

	
	
}
