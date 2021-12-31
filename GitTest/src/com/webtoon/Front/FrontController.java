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
		// 1. ��� ��û�� �ϳ��� Servlet�� �����ϴ� ����
		// 2. �ߺ��Ǵ� �ڵ峪 ����, ������ ������ �� �ϳ��� Servlet���� ���ǵǱ⶧����
		//    ���������� ����

		// ������? ���� ȣ���ߴ��� ��
		String uri = request.getRequestURI(); // /MessageSystem/LoginCon.do ���
		System.out.println(uri);
		String path = request.getContextPath(); // /MessageSystem ���
		System.out.println(path);
		String command = uri.substring(path.length()+1); // �տ� /�����ؼ� ���̸�ŭ �����
		System.out.println("��û��� : " + command);
		
		Command com = null;
		String nextpage = null;
		
		if(command.equals("LoginCon.do")) {
			
			com = new LoginService(); // �ڽ��� �����ϴµ� �θ��� �̸����� ���� (��ĳ����) -> ����: ������ ��ü�� �����ϴ� ������ �ٿ��� 
			nextpage = com.execute(request, response);
			// Command Pattern
			// ������� ��û�� ��ü�� Ŭ�������Ϸ� ó��
			
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
			
			// 1. �Ķ���� ����
			String user_id = request.getParameter("user_id");
			
			// 2. DAO ��ü ����
			usersDAO dao = new usersDAO();
			
			// 3. DAO ��ü�� �޼ҵ� ���
			boolean check = dao.emailCheck(user_id);
			
			// �ߺ��� ���̵� �Դϴ�.
			// if(res == "�ߺ��� ���̵� �Դϴ�.") ��� �� ���� ������.
			
			// 4. PrintWriter ��ü ����
			PrintWriter out = response.getWriter();
			
			// 5. ����
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
