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
		System.out.println("�����ϴ� �̸���:"+ muser_id);
	
		//member_message ���̺��� �� email���� ���� ��
		//�ٽ� 'selectMember.jsp �� �̵��Ͻÿ�
		
		mywebtoonDAO dao = new mywebtoonDAO();
		int cnt = dao.MyWebtoonDelete(muser_id, mwebtoon_seq);
		
		return "deleteSuccess.jsp";
		
	}

	
	
}
