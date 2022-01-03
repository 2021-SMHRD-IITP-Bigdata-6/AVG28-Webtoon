package com.webtoon.users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inter.Command;
import com.usersDAO.mywebtoonDAO;
import com.usersDAO.usersDAO;
import com.webtoon.DTO.mywebtoonDTO;
import com.webtoon.DTO.usersDTO;

public class SelectionService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		usersDAO dao = new usersDAO();
		mywebtoonDAO mwdao = new mywebtoonDAO();
		//memberDAO���� �Ѿ���� DTO���� �޾Ƽ�
		//DTO�� null�� �ƴϿ������� �α���ó���� �ϰ�
		//DTO�� null�̿������� 'LoginFalse.jsp�� �̵��ϰ� �Ͻÿ�.'
		usersDTO dto1 = new usersDTO(user_id, user_pw);
		
		System.out.println(dto1.getUser_id());
		
		
		usersDTO dto = dao.Login(dto1);// dao. ���� Login()�� ��ô �����⿪��
		ArrayList<mywebtoonDTO> mwdto1 = mwdao.selectWebtoon(user_id);
		
		String nextpage =  "";
		
		if(dto != null) {
			
			HttpSession session =request.getSession();
			
			session.setAttribute("dto",dto);
			session.setAttribute("mwdto1",mwdto1);
		
			nextpage = "selection.jsp";
		
		}else {

			nextpage = "loginFalse.jsp";
			
		}
		
		return nextpage;
		
	}
	
}
