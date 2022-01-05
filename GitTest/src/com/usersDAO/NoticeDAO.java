package com.usersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.webtoon.DTO.NoticeDTO;

/**
 * @author mandu
 * @content 게시판 DAO
 */
public class NoticeDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null; // 지역변수 전체로
	int cnt = 0;

	NoticeDTO noticeDTO = null;

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

	/**
	 * @return
	 * @content 게시판 카운트
	 */
	public int getNoticeCount() {
		int count = 0;

		try {
			getConn();

			String sql = "SELECT COUNT(*) FROM T_COMMUNITY";
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

	/**
	 * @return
	 * @content 게시판 전체 리스트 조회
	 */
	public ArrayList<NoticeDTO> getNoticeList(int startRow, int endRow) {
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();

		try {
			getConn();

			String sql = "SELECT * FROM( "
					+ " SELECT article_seq,article_subject,article_content,article_date,article_file,article_cnt,user_id,rownum rn FROM T_COMMUNITY "
					+ " ORDER BY article_seq DESC ) WHERE rn between ? and ? ";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, startRow);
			psmt.setInt(2, endRow);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String article_seq = rs.getString(1);
				String article_subject = rs.getString(2);
				String article_content = rs.getString(3);
				String article_date = rs.getString(4);
				String article_file = rs.getString(5);
				String article_cnt = rs.getString(6);
				String user_id = rs.getString(7);
//				String rn = rs.getString(8);
				noticeDTO = new NoticeDTO(article_seq, article_subject, article_content, article_date, article_file,
						article_cnt, user_id);
				list.add(noticeDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}

		return list;
	}

	/**
	 * @param articleSeq
	 * @return
	 * @conteont 게시판 검색
	 */
	public NoticeDTO getNoticeData(String articleSeq) {
		try {
			getConn();

			String sql = "SELECT * FROM T_COMMUNITY WHERE article_seq = " + articleSeq;
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			if (rs.next()) {
				String article_seq = rs.getString(1);
				String article_subject = rs.getString(2);
				String article_content = rs.getString(3);
				String article_date = rs.getString(4);
				String article_file = rs.getString(5);
				String article_cnt = rs.getString(6);
				String user_id = rs.getString(7);
				noticeDTO = new NoticeDTO(article_seq, article_subject, article_content, article_date, article_file,
						article_cnt, user_id);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}
		return noticeDTO;
	}

	/**
	 * @param articleSeq
	 * @return 추가 성공여부 1 / 0
	 * @content 추가
	 */
	public int insertData(String articleSubject, String articleContent, String articleDate, String articleFile,
			String articleCnt, String userId, String articleSeq) {
		int success = 0;
		int cnt = Integer.parseInt(articleCnt);
		try {
			getConn();
			String sql = "INSERT INTO t_community ( article_seq, article_subject,  article_content,article_date,article_file,article_cnt,user_id)"
					+ " VALUES ( '"+articleSeq+"', '"+articleSubject+"', '"+articleContent+"', SYSDATE, '"+articleFile+"', "+cnt+", '"+userId+"') ";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
			success = 1;

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}
		return success;
	}

	/**
	 * @param articleSubject
	 * @param articleContent
	 * @param articleDate
	 * @param articleFile
	 * @param articleCnt
	 * @param userId
	 * @param articleSeq
	 * @return 업데이트 성공여부 1 / 0
	 * @content 업
	 */
	public int updateData(String articleSubject, String articleContent, String articleDate, String articleFile,
			String articleCnt, String userId, String articleSeq) {
		int success = 0;

		try {
			getConn();

			String sql = "UPDATE T_COMMUNITY SET " + " article_subject = ? " + " , article_content = ? "
//					+ " , article_date = ? " 
//					+ " , article_file = ? " 
//					+ " , article_cnt = ? " 
//					+ " , user_id = ? "
					+ " WHERE article_seq = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, articleSubject);
			psmt.setString(2, articleContent);
//			psmt.setString(3, articleDate);
//			psmt.setString(4, articleFile);
//			psmt.setString(5, articleCnt);
//			psmt.setString(6, userId);
			psmt.setString(3, articleSeq);
			psmt.executeUpdate();

//			rs = psmt.executeQuery();
//			
//			System.out.println(rs.toString());
			success = 1;

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}
		return success;
	}

	/**
	 * @param articleSeq
	 * @return 업데이트 성공여부 1 / 0
	 * @content 조회수 증가
	 */
	public int updateArticleCnt(String articleSeq) {
		int success = 0;

		try {
			getConn();

			String sql = "UPDATE T_COMMUNITY SET " + " article_cnt = article_cnt + 1 " + " WHERE article_seq = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, articleSeq);
			psmt.executeUpdate();
			success = 1;

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}
		return success;
	}

	/**
	 * @param articleSeq
	 * @return 삭제 성공여부 1 / 0
	 * @content 삭제
	 */
	public int deleteData(String articleSeq) {
		int success = 0;

		try {
			getConn();

			String sql = "DELETE FROM T_COMMUNITY  WHERE article_seq = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, articleSeq);
			
			cnt = psmt.executeUpdate();

			success = 1;

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 코드가 오류가됬던 안됬던 무조건 실행

			close();

		}
		return success;
	}
}
//여기 확인ㄴ
