package com.netease;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.netease.*;

public class QueryServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	response.setCharacterEncoding("UTF-8");
	PrintWriter writer= response.getWriter();
	String title = request.getParameter("title");
	String outcome=Dbquery.returnPoem(title);
	writer.println(outcome);
	
	}	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter writer= response.getWriter();
	String title = request.getParameter("poem_title");
	String author = request.getParameter("poem_author");
	String content_detail=request.getParameter("poem_content");
	System.out.println(title);
	System.out.println(author);
	System.out.println(content_detail);
//	String outcome=Dbquery.returnPoem(title);
	List<poem> outcome=myBatisQuery.returnPoem(title,author,content_detail);
	writer.println("<html><head>");
	writer.println("<meta charset=\"UTF-8\">");
	writer.println("<title>Insert title here</title>");
	writer.println("</head>");
	writer.println("<body>");
	writer.println("<form action=\"http://localhost:8080/Restaurant/query\" method=\"post\">");
	writer.println("<table><tr>");
	writer.println("<td><label for=\"txtname\">题目</label></td>");
	writer.println("<td><input id=\"txttitle\" name=\"poem_title\" value=\""+title+"\"/></td></tr>");
	writer.println("<tr><td><label for=\"txtname\">作者</label></td>");
	writer.println("<td><input id=\"txtauthor\" name=\"poem_author\" value=\""+author+"\" /></td></tr>");
	writer.println("<tr><td><label for=\"txtname\">内容</label></td>");
	writer.println("<td><input id=\"txtcontent\" name=\"poem_content\" value=\""+content_detail+"\" /></td></tr>");
	writer.println("<tr><td><input type=\"submit\" value=\"查询\"></td>");
	writer.println("<td><input type=\"reset\" value=\"重置\"></td></tr>");
	writer.println("</table></form>");
	
	writer.println("<h1>");
	
	
	for (int i=0;i<outcome.size();i++){
		writer.println(outcome.get(i));
	}
	writer.println("</h1>");
	writer.println("</body></html>");
	
//	writer.println("<h1>Poem is"+"  "+outcome+"</h1>");		
//	writer.println("</body></html>");

	}
}
	
	