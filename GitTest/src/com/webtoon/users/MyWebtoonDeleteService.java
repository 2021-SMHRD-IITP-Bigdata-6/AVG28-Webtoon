package com.webtoon.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.Command;
import com.usersDAO.mywebtoonDAO;
import com.usersDAO.usersDAO;

public class MyWebtoonDeleteService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String muser_id = request.getParameter("muser_i");
		String mwebtoon_seq = request.getParameter("mwebtoon_se");
		System.out.println("삭제하는 이메일:"+ muser_id);
	
		//member_message 테이블에서 위 email값을 삭제 후
		//다시 'selectMember.jsp 로 이동하시오
		
		mywebtoonDAO dao = new mywebtoonDAO();
		int cnt = dao.MyWebtoonDelete(muser_id, mwebtoon_seq);
		
		return "deleteSuccess.jsp";
		
	}

	
	
}
