package com.webtoon.Front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.Command;
import com.usersDAO.usersDAO;
import com.usersDAO.webtoonDAO;
import com.webtoon.DTO.webtoonDTO;
import com.webtoon.users.DeleteService;
import com.webtoon.users.JoinService;
import com.webtoon.users.LoginService;
import com.webtoon.users.UpdateService;
import com.webtoon.users.UserSearchService;
import com.webtoon.users.WebtoonInfoGoService;
import com.webtoon.users.WebtoonSelectGoService;
import com.webtoon.users.LogoutService;
import com.webtoon.users.MyWebtoonDeleteService;
import com.webtoon.users.MyWebtoonJoinService;
import com.webtoon.users.RecommendService;
import com.webtoon.users.SearchService;
import com.webtoon.users.SelectionService;
import com.webtoon.users.MyWebtoonInfoDeleteService;
import com.webtoon.users.MyWebtoonInfoJoinService;



@WebServlet("*.do")//action -> a.do, b.do
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//FrontController Pattern
		// 1. 모든 요청을 하나의 Servlet로 정의하는 패턴
		// 2. 중복되는 코드나 추적, 보안을 적용할 때 하나의 Servlet에서 정의되기때문에
		//    유지보수에 용이

		// 문제는? 누가 호출했는지 모름
		String uri = request.getRequestURI(); // /MessageSystem/LoginCon.do 출력
		System.out.println(uri);
		String path = request.getContextPath(); // /MessageSystem 출력
		System.out.println(path);
		String command = uri.substring(path.length()+1); // 앞에 /포함해서 길이만큼 살아짐
		System.out.println("요청기능 : " + command);
		
		Command com = null;
		String nextpage = null;
		
		if(command.equals("LoginCon.do")) {
			
			com = new LoginService(); // 자식을 생성하는데 부모의 이름으로 생성 (업캐스팅) -> 장점: 각자의 객체를 생성하는 갯수를 줄여서 
			nextpage = com.execute(request, response);
			// Command Pattern
			// 사용자의 요청을 객체인 클래스파일로 처리
			
		}else if(command.equals("Selection.do")) {
			
			com = new SelectionService(); // 자식을 생성하는데 부모의 이름으로 생성 (업캐스팅) -> 장점: 각자의 객체를 생성하는 갯수를 줄여서 
			nextpage = com.execute(request, response);

			// Command Pattern
			// 사용자의 요청을 객체인 클래스파일로 처리
			
		}else if(command.equals("JoinCon.do")) {
			
			com = new JoinService();
			com.execute(request, response);
			
		}else if(command.equals("myWebtoonInfoDeleteCon.do")) {
		
			com = new MyWebtoonInfoDeleteService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("myWebtoonDeleteCon.do")) {
		
			com = new MyWebtoonDeleteService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("DeleteCon.do")) {
		
			com = new DeleteService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("LogoutCon.do")) {
			
			com = new LogoutService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("UpdateCon.do")) {
			
			com = new UpdateService();
			com.execute(request, response);
		      
		}else if(command.equals("searchWebtoon.do")) {
			
			com = new SearchService();
			com.execute(request, response);
			
		}else if(command.equals("searchUser.do")) {
			
			com = new UserSearchService();
			com.execute(request, response);
			
		}else if(command.equals("webtoonInfoGo.do")) {
			
			com = new WebtoonInfoGoService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("webtoonSelectGo.do")) {
			
			com = new WebtoonSelectGoService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("myWebtoonjoin.do")) {
			
			com = new MyWebtoonJoinService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("myWebtoonInfojoin.do")) {
			
			com = new MyWebtoonInfoJoinService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("keyWebtoon.do")) {
			
			com = new RecommendService();
			nextpage = com.execute(request, response);
			
		}
		if(nextpage != null) {			
			response.sendRedirect(nextpage);
		}
		
	}

}
