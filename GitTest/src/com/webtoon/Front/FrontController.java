package com.webtoon.Front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.inter.Command;
import com.usersDAO.usersDAO;
import com.webtoon.users.DeleteService;
import com.webtoon.users.JoinService;
import com.webtoon.users.LoginService;
import com.webtoon.users.UpdateService;
import com.webtoon.users.UserSearchService;
import com.webtoon.users.WebtoonInfoGoService;
import com.webtoon.users.LogoutService;
import com.webtoon.users.SearchService;



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
			
		}else if(command.equals("JoinCon.do")) {
			
			com = new JoinService();
			com.execute(request, response);
			
		}else if(command.equals("DeleteCon.do")) {
		
			com = new DeleteService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("LogoutCon.do")) {
			
			com = new LogoutService();
			nextpage = com.execute(request, response);
			
		}else if(command.equals("UpdateCon.do")) {
			
			com = new UpdateService();
			com.execute(request, response);
		      
		}else if(command.equals("check.do")) {
			
			// 1. 파라미터 수집
			String user_id = request.getParameter("user_id");
			
			// 2. DAO 객체 생성
			usersDAO dao = new usersDAO();
			
			// 3. DAO 객체의 메소드 사용
			boolean check = dao.emailCheck(user_id);
			
			// 중복된 아이디 입니다.
			// if(res == "중복된 아이디 입니다.") 라고 쓸 수도 있지만.
			
			// 4. PrintWriter 객체 생성
			PrintWriter out = response.getWriter();
			
			// 5. 응답
			out.print(check);
			
		}else if(command.equals("searchWebtoon.do")) {
			
			com = new SearchService();
			com.execute(request, response);
			
		}else if(command.equals("searchUser.do")) {
			
			com = new UserSearchService();
			com.execute(request, response);
			
		}else if(command.equals("webtoonInfoGo.do")) {
			
			com = new WebtoonInfoGoService();
			nextpage =com.execute(request, response);
			
		}else if(command.equals("InfoGosearchUser.do")) {
			
			com = new UserSearchService();
			com.execute(request, response);
		}
		if(nextpage != null) {			
			response.sendRedirect(nextpage);
		}
		
	}

}
