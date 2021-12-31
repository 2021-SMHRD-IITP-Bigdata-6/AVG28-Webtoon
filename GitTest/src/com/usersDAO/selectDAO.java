package com.usersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.webtoon.DTO.selectionDTO;
import com.webtoon.DTO.usersDTO;
import com.webtoon.DTO.webtoonDTO;

import sun.nio.ch.SelChImpl;

public class selectDAO {

	Connection conn = null; 
	PreparedStatement psmt = null;
	ResultSet rs = null;  //�������� ��ü��
	int cnt = 0;
	
	usersDTO dto = null; // select���� dto�� ����ִ� ���� ���ϱ� ������ dto�� ���� ������ Ȯ���ϴ� ����� ������.
	private boolean check;
	
	public void getConn() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Ŭ�������� �ε��Ϸ�");
			
			//3.DB���� ����ϴ� id/pw�� ����
			String url ="jdbc:oracle:thin:@127.0.0.1:1521";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn != null) {
				System.out.println("���Ἲ��");
			}else {
				System.out.println("�������");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void close() {
		
		System.out.println("������ ����");

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
	
	// String�� �����̸��� �޶󵵵� a ���
	public int Join(selectionDTO sdto) {
		
		try { 
			
			getConn();
			
			String sql = "insert into t_selection values (?,?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sdto.getWebtoon_seq());
			psmt.setString(2, sdto.getUser_id());
			psmt.setString(3, sdto.getWebtoon_name());
			psmt.setString(4, sdto.getWebtoon_writer());
			psmt.setString(5, sdto.getWebtoon_genre());
			psmt.setString(6, sdto.getWebtoon_keyword());

			cnt = psmt.executeUpdate();


		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();

		} finally { 
			
			close();
			
		}
		
		return cnt;
		
	}
	
	public int Delete(String webtoon_name) {
		
		try { 
			
			getConn();

			String sql = "delete from t_selection where webtoon_name = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, webtoon_name);
			
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally { 
			
			close();
		}
		
		return cnt;
		
	}
	
	public int Update(String webtoon_seq, String user_id, String webtoon_name, String webtoon_writer, String webtoon_genre, String webtoon_keyword) {
	      
	      try {
	    	  
	    	 getConn();
	         
	         String sql = "update t_selection set webtoon_seq = ? , user_id = ?, webtoon_name = ? , webtoon_writer= ? , webtoon_genre = ?, webtoon_keyword = ? where user_id = ? "; 
	      
	         psmt = conn.prepareStatement(sql);

	         psmt.setString(1, webtoon_seq);
	         psmt.setString(2, user_id);
	         psmt.setString(3, webtoon_name);
	         psmt.setString(4, webtoon_writer);
	         psmt.setString(5, webtoon_genre);
	         psmt.setString(5, webtoon_keyword);

	         cnt = psmt.executeUpdate();



	      } catch (Exception e) {

	         e.printStackTrace();

	      } finally {

	    	  close();

	      }		
		
	      return cnt;
	}
	

	public ArrayList<usersDTO> selectMember() {
		
		ArrayList<usersDTO> arr = new ArrayList<usersDTO>();
		
		try { // db�����ڵ�
			
			getConn();
			
			// 5 .SQL��ɹ��� �غ� //�ܼ�â���Է� ? ����Ѵ�
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
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();// try �� �ȿ��� ����Ȯ���ϴ� �ڵ�

		} finally { // �ڵ尡 ��������� �ȉ�� ������ ����
			
			close();

		}
		
		return arr;
		
	}
	

	public ArrayList<usersDTO> searchUser(String user_id){
		System.out.println(user_id);
		ArrayList<usersDTO> user_arr = new ArrayList<usersDTO>();
		
		try {
			
			getConn();
			
			String sql = "select * from t_user where user_id like ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + user_id + "%");
			rs= psmt.executeQuery(); 
			
			while (rs.next()) {
				
				String muser_id = rs.getString(1);
				String user_email = rs.getString(3);
				String user_tel = rs.getString(4);
				String user_addr = rs.getString(5);
				String user_joindate = rs.getString(7);

				dto = new usersDTO(muser_id, user_email, user_tel, user_addr, user_joindate);
				user_arr.add(dto);
				System.out.println(muser_id);
			} 
			
		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();
			
		} finally {
			
			close();
			
		}
		return user_arr;
		
	}
	
	
}
