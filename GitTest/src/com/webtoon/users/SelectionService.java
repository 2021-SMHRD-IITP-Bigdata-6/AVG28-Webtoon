package com.webtoon.users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inter.Command;
import com.usersDAO.mywebtoonDAO;
import com.usersDAO.usersDAO;
import com.webtoon.DTO.mywebtoonDTO;
import com.webtoon.DTO.usersDTO;

public class SelectionService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		usersDAO dao = new usersDAO();
		mywebtoonDAO mwdao = new mywebtoonDAO();
		//memberDAO에서 넘어오는 DTO값을 받아서
		//DTO가 null이 아니였을때는 로그인처리를 하고
		//DTO가 null이였을때는 'LoginFalse.jsp로 이동하게 하시오.'
		usersDTO dto1 = new usersDTO(user_id, user_pw);
		
		System.out.println(dto1.getUser_id());
		
		
		usersDTO dto = dao.Login(dto1);// dao. 부터 Login()에 투척 투석기역할
		ArrayList<mywebtoonDTO> mwdto1 = mwdao.selectWebtoon(user_id);
		
		String nextpage =  "";
		
		if(dto != null) {
			
			HttpSession session =request.getSession();
			
			session.setAttribute("dto",dto);
			session.setAttribute("mwdto1",mwdto1);
		
			nextpage = "selection.jsp";
		
		}else {

			nextpage = "loginFalse.jsp";
			
		}
		
		return nextpage;
		
	}
	
}
