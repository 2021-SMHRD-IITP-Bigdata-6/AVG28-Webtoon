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

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_email = request.getParameter("user_email");
		String user_tel = request.getParameter("user_tel");
		String user_addr = request.getParameter("user_addr");
		String user_gender = request.getParameter("user_gender");


		usersDTO dto = new usersDTO(user_id, user_pw, user_email, user_tel, user_addr, user_gender);
		
		System.out.println(dto.getUser_yesno());
		System.out.println(dto.getUser_joindate());
		//1. memberDAO�� �ش��ϴ� ��ɸ޼ҵ�� �� �����ֱ�(��ü����, �޼ҵ�, �Ű�����)
		usersDAO dao = new usersDAO();
		int cnt = dao.Join(dto); // memberDAO�� ���ο� �ִ� ������ �����ִ� ��
		//2. cnt�� �������ֱ�(�޼ҵ�, ����)
		
		if (cnt > 0) {
			
			// JoinCon�� request�� ����, response ����������
			request.setAttribute("dto", dto);
			
			// JoinCon�� �ִ� request�������� -> joinSuccess.jsp�� ����
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response); // foward����� ����ϸ� return�� null ���� ��������Ѵ�.
			
		} else {

		}
		
		return null;
		
	}
	
}
