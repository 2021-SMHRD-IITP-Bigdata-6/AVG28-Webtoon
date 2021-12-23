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
	public int Join(usersDTO dto) {
		
		try { 
			
			getConn();
			
			String sql = "insert into users values (?,?,?,?,?,sysdate)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_email());
			psmt.setString(2, dto.getUser_pw());
			psmt.setString(3, dto.getUser_sex());
			psmt.setString(4, dto.getUser_tel());
			psmt.setString(5, dto.getUser_address());

			cnt = psmt.executeUpdate();


		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();

		} finally { 
			
			close();
			
		}
		
		return cnt;
		
	}
	
	public int Delete(String user_email) {
		
		try { 
			
			getConn();

			String sql = "delete from users where user_email = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_email);
			
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally { 
			
			close();
		}
		
		return cnt;
		
	}
	
	public int Update(String user_email, String user_pw, String user_tel, String user_address) {
	      
	      try {
	    	  
	    	 getConn();
	         
	         String sql = "update users set user_pw = ? , user_tel = ? , user_address= ? , user_sex = ? where user_email = ? "; 
	      
	         psmt = conn.prepareStatement(sql);

	         psmt.setString(1, user_pw);
	         psmt.setString(2, user_tel);
	         psmt.setString(3, user_address);
	         psmt.setString(4, user_email);

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
			
			String sql = "select * from users where user_email = ?";

			System.out.println(dto1.getUser_email());
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto1.getUser_email());
			
			
			rs = psmt.executeQuery();


			if (rs.next()) {
				
				String getemail = rs.getString(1);
				String getpw = rs.getString(2);
				String gettel = rs.getString(3);
				String getaddress = rs.getString(4);
				String getsex = rs.getString(5);
				
				if(dto1.getUser_pw().equals(getpw)) {
					
					dto = new usersDTO(dto1.getUser_email(), getpw, gettel, getaddress, getsex);
					
				}
				
				
			} 

		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();

		} finally { 
			
			close();

		}
		
		return dto;
		
	}
	
	public ArrayList<usersDTO> selectMember(String user_email) {
		
		ArrayList<usersDTO> arr = new ArrayList<usersDTO>();
		
		try { // db�����ڵ�
			
			getConn();
			
			// 5 .SQL��ɹ��� �غ� //�ܼ�â���Է� ? ����Ѵ�
			String sql = "select * from users";
			
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery(); 
			
			while (rs.next()) {
				
				String muser_email = rs.getString(1);
				String user_tel = rs.getString(3);
				String user_address = rs.getString(4);//�μ�Ʈ ������ 4��° �����ϴ¹��
				String user_sex = rs.getString(5);//�μ�Ʈ ������ 4��° �����ϴ¹��

				dto = new usersDTO(muser_email, user_tel, user_address, user_sex);
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
	
	public boolean emailCheck(String user_email) {
		
		try { 

			getConn();
			
			String sql = "select * from member_message where email = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_email);
			
			rs = psmt.executeQuery();

			check = rs.next();
			
		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();

		} finally { 
			
			close();

		}
		
		return check;
	}
	

	
	
}
