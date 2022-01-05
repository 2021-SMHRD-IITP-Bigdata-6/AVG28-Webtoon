package com.webtoon.users;

import java.io.IOException;
import java.io.PrintWriter;
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

public class RecommendService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	      
        String data = request.getParameter("data");
        System.out.println("hh"+data);
        String[] keyword = data.split(",");

		webtoonDAO dao = new webtoonDAO();
		ArrayList<webtoonDTO> key_arr = dao.keyword_hWebtoon(keyword);
		

		HttpSession session =request.getSession();
		
		
		session.setAttribute("key_arr",key_arr);
		
		String nextpage =  "";
		
		nextpage = "recommend2.jsp";
		
		return nextpage;
		
		
	}
	
}
