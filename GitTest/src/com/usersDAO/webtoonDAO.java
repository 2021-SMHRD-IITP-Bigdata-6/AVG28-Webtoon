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
	ResultSet rs = null; // �������� ��ü��
	int cnt = 0;

	webtoonDTO wdto = null;

	usersDAO udao = new usersDAO();

	public void getConn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Ŭ�������� �ε��Ϸ�");

			// 3.DB���� ����ϴ� id/pw�� ����
			String url = "jdbc:oracle:thin:@127.0.0.1:1521";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			if (conn != null) {
				System.out.println("���Ἲ��");
			} else {
				System.out.println("�������");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {

		System.out.println("������ ����");

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
				
				System.out.println("infodao���ప" + webtoon_seq);
				System.out.println("infodao���ప" + webtoon_name);
				System.out.println("infodao���ప" + webtoon_writer);
				System.out.println("infodao���ప" + webtoon_content);
				System.out.println("infodao���ప" + webtoon_genre);
				System.out.println("infodao���ప" + webtoon_img);
				System.out.println("infodao���ప" + webtoon_link);
				System.out.println("infodao���ప" + webtoon_keyword);
			}

		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
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
				
				System.out.println("�����̵�dao���ప" + webtoon_seq);
				System.out.println("�����̵�dao���ప" + wdto_genre);
				System.out.println("�����̵�dao���ప" + webtoon_name);
				System.out.println("�����̵�dao���ప" + webtoon_writer);
				System.out.println("�����̵�dao���ప" + webtoon_content);
				System.out.println("�����̵�dao���ప" + webtoon_genre);
				System.out.println("�����̵�dao���ప" + webtoon_img);
				System.out.println("�����̵�dao���ప" + webtoon_link);
				System.out.println("�����̵�dao���పŰ���� " + webtoon_keyword);
			}

		} catch (Exception e) {
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();

		} finally {

			close();

		}
		return web_arr;

	}

	// �� ���ڵ� ���� ����..
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
		} finally { // �ڵ尡 ��������� �ȉ�� ������ ����

			close();

		}

		return count;
	}
	
	//webToon ���̺� getList
	public ArrayList<webtoonDTO> getSelectWebtoonList(int startRow, int endRow) {

		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();

		try { // db�����ڵ�

			getConn();

			// 5 .SQL��ɹ��� �غ� //�ܼ�â���Է� ? ����Ѵ�
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
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();// try �� �ȿ��� ����Ȯ���ϴ� �ڵ�

		} finally { // �ڵ尡 ��������� �ȉ�� ������ ����

			close();

		}

		return web_arr;

	}

	
	public ArrayList<webtoonDTO> selectWebtoon() {

		ArrayList<webtoonDTO> web_arr = new ArrayList<webtoonDTO>();

		try { // db�����ڵ�

			getConn();

			// 5 .SQL��ɹ��� �غ� //�ܼ�â���Է� ? ����Ѵ�
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
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();// try �� �ȿ��� ����Ȯ���ϴ� �ڵ�

		} finally { // �ڵ尡 ��������� �ȉ�� ������ ����

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
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();

		} finally {

			close();

		}
		return web_arr;

	}   public ArrayList<webtoonDTO> keyword_hWebtoon(String[] keyword) {
		// ArrayList �� �±� ���� �����ͼ� ��ȸ
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
			System.out.println("Ŭ�������� �ε� ����");
			e.printStackTrace();

		} finally {

			close();

		}
		return key_arr;

	}
	


	
}
