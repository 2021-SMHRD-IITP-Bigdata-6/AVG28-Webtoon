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
import com.usersDAO.webtoonDAO;
import com.webtoon.DTO.mywebtoonDTO;
import com.webtoon.DTO.usersDTO;
import com.webtoon.DTO.webtoonDTO;

public class MyWebtoonInfoDeleteService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String muser_id = request.getParameter("muser_i");
		String mwebtoon_seq = request.getParameter("mwebtoon_se");
		System.out.println("삭제하는 아이디:"+ muser_id);
		
		String mwebtoon_genre = request.getParameter("mwebtoon_ge");
	
		System.out.println("MyInfoDelete 장르값 : " + mwebtoon_genre);
		
		mywebtoonDAO dao = new mywebtoonDAO();
		int cnt = dao.MyWebtoonDelete(muser_id, mwebtoon_seq);

		

		
		return "deleteSuccessInfo.jsp";
		
	}
	
}
