package com.webtoon.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inter.Command;
import com.usersDAO.usersDAO;
import com.webtoon.DTO.usersDTO;

public class UpdateService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

	      request.setCharacterEncoding("utf-8");
	      
	      usersDTO dto = (usersDTO) session.getAttribute("dto");
	      
	      String user_id = dto.getUser_id();
	      String user_pw = request.getParameter("user_pw");
	      String user_email = request.getParameter("user_email");
	      String user_tel = request.getParameter("user_tel");
	      String user_addr = request.getParameter("user_addr");
	      String user_joindate = request.getParameter("user_joindate");
	      
	   // ------------------ 위 코드는 servlet에서만 선언가능
	      
	      usersDAO dao = new usersDAO();
	      int cnt = dao.Update(user_id, user_pw, user_email, user_tel, user_addr, user_joindate);
	      
	      if (cnt > 0) {
	     	 
	    	  usersDTO update_dto =  new usersDTO(user_id, user_pw, user_email, user_tel, user_addr, user_joindate);
	         
//	         dto = new memberDTO(dto.getEmail(), tel, address);
//	         session.setAttribute("dto",dto);
	         
	     	session.setAttribute("dto", update_dto);
	         //dto.getEmail();
	         //dto.getAddress();
	     	//dto.getTel();
	         
	        response.sendRedirect("main.jsp");
	         
	      } else {
	         
	      }
	      
	      return null;
		
	}

}
