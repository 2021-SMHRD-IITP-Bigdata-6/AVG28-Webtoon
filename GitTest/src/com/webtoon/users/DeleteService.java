package com.webtoon.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.Command;
import com.usersDAO.usersDAO;

public class DeleteService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String users_email = request.getParameter("delete_email");
		System.out.println("�����ϴ� �̸���:"+ users_email);
	
		//member_message ���̺��� �� email���� ���� ��
		//�ٽ� 'selectMember.jsp �� �̵��Ͻÿ�
		
		usersDAO dao = new usersDAO();
		int cnt = dao.Delete(users_email);
		
		return "selectMember.jsp";
		
	}

	
	
}
