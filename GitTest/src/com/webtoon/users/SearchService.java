package com.webtoon.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.inter.Command;
import com.usersDAO.webtoonDAO;
import com.webtoon.DTO.webtoonDTO;

public class SearchService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String webtoon_name = request.getParameter("webtoon_name");
		
		// DAO 객체 생성
		webtoonDAO dao = new webtoonDAO();
		
		// dao의 메소드
		ArrayList<webtoonDTO> list = dao.searchWebtoon(webtoon_name);
		
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
