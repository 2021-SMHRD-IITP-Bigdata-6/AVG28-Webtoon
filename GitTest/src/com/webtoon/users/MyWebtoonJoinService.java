package com.webtoon.users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inter.Command;
import com.usersDAO.mywebtoonDAO;
import com.usersDAO.webtoonDAO;
import com.webtoon.DTO.mywebtoonDTO;
import com.webtoon.DTO.usersDTO;
import com.webtoon.DTO.webtoonDTO;

public class MyWebtoonJoinService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String muser_id = request.getParameter("muser_i");
		String mwebtoon_seq = request.getParameter("mwebtoon_se");
		String mwebtoon_name = request.getParameter("mwebtoon_nam");
		String mwebtoon_writer = request.getParameter("mwebtoon_write");
		String mwebtoon_content = request.getParameter("mwebtoon_conten");
		String mwebtoon_genre = request.getParameter("mwebtoon_genr");
		String mwebtoon_img = request.getParameter("mwebtoon_im");
		String mwebtoon_link = request.getParameter("mwebtoon_lin");
		String mwebtoon_keyword = request.getParameter("mwebtoon_keywor");
		
		System.out.println("----------------------------------");
		System.out.println("�� ���� ���̵�:" + muser_id);
		
		mywebtoonDTO mwdto = new mywebtoonDTO(muser_id, mwebtoon_seq, mwebtoon_name, mwebtoon_writer, mwebtoon_content, mwebtoon_genre, mwebtoon_img, mwebtoon_link, mwebtoon_keyword);
		
		mywebtoonDAO mwdao = new mywebtoonDAO();
		int cnt = mwdao.JoinMyWebtoon(mwdto);

		if (cnt > 0) {
			
			// JoinCon�� request�� ����, response ����������
			request.setAttribute("mwdto", mwdto);
			
			// JoinCon�� �ִ� request�������� -> joinSuccess.jsp�� ����
			RequestDispatcher dis = request.getRequestDispatcher("joinSuccess.jsp");
			dis.forward(request, response); // foward����� ����ϸ� return�� null ���� ��������Ѵ�.
			
		} else {
			System.out.println("���߰� ����");
		}
		
		return null;
		
	}
	
}
