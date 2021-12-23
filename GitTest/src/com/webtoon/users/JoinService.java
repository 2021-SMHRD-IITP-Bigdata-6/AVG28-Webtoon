package com.webtoon.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.Command;
import com.usersDAO.usersDAO;
import com.webtoon.DTO.usersDTO;

public class JoinService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ڰ� �Է��� email, pw,tel,address��
		//member_message ���̺� �Է�����  'main.jsp'���̵�
		
		request.setCharacterEncoding("utf-8");

		String user_email = request.getParameter("user_email");
		String user_pw = request.getParameter("user_pw");
		String user_tel = request.getParameter("user_tel");
		String user_address = request.getParameter("user_address");
		String user_sex = request.getParameter("user_sex");

		usersDTO dto = new usersDTO(user_email, user_pw, user_tel, user_address, user_sex);
		
		//1. memberDAO�� �ش��ϴ� ��ɸ޼ҵ�� �� �����ֱ�(��ü����, �޼ҵ�, �Ű�����)
		usersDAO dao = new usersDAO();
		int cnt = dao.Join(dto); // memberDAO�� ���ο� �ִ� ������ �����ִ� ��
		//2. cnt�� �������ֱ�(�޼ҵ�, ����)
		
		if (cnt > 0) {
			
			// JoinCon�� request�� ����, response ����������
			request.setAttribute("dto", dto);
			
			// JoinCon�� �ִ� request�������� -> joinSuccess.jsp�� ����
			RequestDispatcher dis = request.getRequestDispatcher("joinSuccess.jsp");
			dis.forward(request, response); // foward����� ����ϸ� return�� null ���� ��������Ѵ�.
			
		} else {

		}
		
		return null;
		
	}
	
}
