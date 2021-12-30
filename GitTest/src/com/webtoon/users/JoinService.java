package com.webtoon.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.Command;
import com.usersDAO.usersDAO;
import com.webtoon.DTO.usersDTO;

public class JoinService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 email, pw,tel,address를
		//member_message 테이블에 입력한후  'main.jsp'로이동
		
		request.setCharacterEncoding("utf-8");

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_email = request.getParameter("user_email");
		String user_tel = request.getParameter("user_tel");
		String user_addr = request.getParameter("user_addr");
		String user_gender = request.getParameter("user_gender");


		usersDTO dto = new usersDTO(user_id, user_pw, user_email, user_tel, user_addr, user_gender);
		
		System.out.println(dto.getUser_yesno());
		System.out.println(dto.getUser_joindate());
		//1. memberDAO에 해당하는 기능메소드로 값 보내주기(객체생성, 메소드, 매개변수)
		usersDAO dao = new usersDAO();
		int cnt = dao.Join(dto); // memberDAO에 가로에 있는 값들을 보내주는 중
		//2. cnt값 리턴해주기(메소드, 리턴)
		
		if (cnt > 0) {
			
			// JoinCon에 request에 저장, response 공간도있음
			request.setAttribute("dto", dto);
			
			// JoinCon에 있는 request공간에서 -> joinSuccess.jsp에 보냄
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response); // foward방식을 사용하면 return에 null 값을 보내줘야한다.
			
		} else {

		}
		
		return null;
		
	}
	
}
