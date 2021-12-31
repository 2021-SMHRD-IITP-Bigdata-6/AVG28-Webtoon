package com.webtoon.users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inter.Command;
import com.usersDAO.webtoonDAO;
import com.webtoon.DTO.usersDTO;
import com.webtoon.DTO.webtoonDTO;

public class WebtoonInfoGoService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String webtoon_seq = request.getParameter("webtoon_se");
		String webtoon_genre = request.getParameter("webtoon_ge");
		
		System.out.println("À¥Å÷ °íÀ¯¹øÈ£:" + webtoon_seq + "À¥Å÷Àå¸£:" + webtoon_genre);
		
		webtoonDAO wdao = new webtoonDAO();
		webtoonDTO wdto1 = wdao.WebtoonInfoGo(webtoon_seq);
		ArrayList<webtoonDTO> wdto_genre = wdao.selectWebtoonInfo(webtoon_genre);
		
		String nextpage = "";
		
		if(wdto1 != null) {
			
			HttpSession session =request.getSession();
			
			session.setAttribute("wdto1",wdto1);
			session.setAttribute("wdto_genre",wdto_genre);
			
			nextpage = "info.jsp";
		
		}else {

			nextpage = "login.jsp";
			
		}
		
		return nextpage;
		
	}
	
}
