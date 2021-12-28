package com.usersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.webtoon.DTO.webtoonDTO;

public class webtoonDAO {

	Connection conn = null; 
	PreparedStatement psmt = null;
	ResultSet rs = null;  //�������� ��ü��
	int cnt = 0;
	
	webtoonDTO wdto = null; 
	
	usersDAO udao = new usersDAO();

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
	
	public ArrayList<webtoonDTO> selectWebtoon() {
		
		
		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();
		
		try { // db�����ڵ�
			
			getConn();
			
			// 5 .SQL��ɹ��� �غ� //�ܼ�â���Է� ? ����Ѵ�
			String sql = "select * from t_webtoon";
			
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery(); 
			
			while (rs.next()) {
				
				String webtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_link = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_content = rs.getString(6);
				String webtoon_keyword = rs.getString(7);

				wdto = new webtoonDTO(webtoon_name, webtoon_writer, webtoon_link, webtoon_genre, webtoon_content, webtoon_keyword);
				web_arr.add(wdto);
				
			} 
			
			
		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();// try �� �ȿ��� ����Ȯ���ϴ� �ڵ�

		} finally { // �ڵ尡 ��������� �ȉ�� ������ ����
			
			close();

		}
		
		return web_arr;
		
	}
	
	public ArrayList<webtoonDTO> searchWebtoon(String webtoon_name){
		System.out.println(webtoon_name);
		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();
		
		try {
			
			getConn();
			
			String sql = "select * from t_webtoon where webtoon_name like ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + webtoon_name + "%");
			rs= psmt.executeQuery(); 
			
			while (rs.next()) {
				
				String mwebtoon_name = rs.getString(2);
				String webtoon_writer = rs.getString(3);
				String webtoon_link = rs.getString(4);
				String webtoon_genre = rs.getString(5);
				String webtoon_content = rs.getString(6);
				String webtoon_keyword = rs.getString(7);

				wdto = new webtoonDTO(mwebtoon_name, webtoon_writer, webtoon_link, webtoon_genre, webtoon_content, webtoon_keyword);
				web_arr.add(wdto);
				System.out.println(mwebtoon_name);
			} 
			
		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();
			
		} finally {
			
			close();
			
		}
		return web_arr;
		
	}
	
}
