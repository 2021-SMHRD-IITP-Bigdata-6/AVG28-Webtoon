package com.webtoon.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.Command;
import com.usersDAO.usersDAO;

public class DeleteService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String users_email = request.getParameter("delete_email");
		System.out.println("삭제하는 이메일:"+ users_email);
	
		//member_message 테이블에서 위 email값을 삭제 후
		//다시 'selectMember.jsp 로 이동하시오
		
		usersDAO dao = new usersDAO();
		int cnt = dao.Delete(users_email);
		
		return "selectMember.jsp";
		
	}

	
	
}
