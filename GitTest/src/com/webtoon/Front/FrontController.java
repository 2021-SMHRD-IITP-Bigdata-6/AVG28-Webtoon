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
			
		}else if(command.equals("Selection.do")) {
			
			com = new SelectionService(); // �ڽ��� �����ϴµ� �θ��� �̸����� ���� (��ĳ����) -> ����: ������ ��ü�� �����ϴ� ������ �ٿ��� 
			nextpage = com.execute(request, response);

			// Command Pattern
			// ������� ��û�� ��ü�� Ŭ�������Ϸ� ó��
			
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
