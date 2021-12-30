package com.webtoon.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.inter.Command;
import com.usersDAO.usersDAO;
import com.usersDAO.webtoonDAO;
import com.webtoon.DTO.usersDTO;
import com.webtoon.DTO.webtoonDTO;

public class UserSearchService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		
		// DAO 객체 생성
		usersDAO dao = new usersDAO();
		
		// dao의 메소드
		ArrayList<usersDTO> list = dao.searchUser(user_id);
		
		// ArraryList -> json
		Gson gson = new Gson();
		
		// gson.toJson();
		String json = gson.toJson(list);
		
		// 인코딩
		response.setCharacterEncoding("utf-8");
		
		// PrintWriter객체 이용해서 응답.
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return json;
	}
	
}
