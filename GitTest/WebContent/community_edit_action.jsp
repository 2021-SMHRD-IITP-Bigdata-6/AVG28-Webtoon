<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.usersDAO.NoticeDAO"%>
<%@page import="com.webtoon.DTO.NoticeDTO"%>
<%@page import="com.webtoon.DTO.usersDTO"%>

<%
request.setCharacterEncoding("utf-8");
String articleSeq = request.getParameter("articleSeq");
String articleSubject = request.getParameter("article_subject");
String articleContent = request.getParameter("article_content");
String articleDate = "";
String articleFile = "";
String articleCnt = "";
String userId = "";

NoticeDAO noticeDAO = new NoticeDAO();
int success = noticeDAO.updateData(articleSubject, articleContent, articleDate, articleFile, articleCnt, userId, articleSeq);
System.out.println(success);
if(success != 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('저장이 완료되었습니다.')");
	script.println("location.href='community_view.jsp?articleSeq="+articleSeq+"'");
	script.println("</script>");
}else{
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('저장에 실패하였습니다.')");
	script.println("history.back()");
	script.println("</script>");
}

%>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>