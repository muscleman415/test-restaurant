package com.netease;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class Dbquery {
	
	public static BasicDataSource ds=null;
	public static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	public static final String DB_URL="jdbc:mysql://localhost/world";
	public static final String USER_NAME ="root";
	public static final String PASSWORD="asdfzxcv";
	
	public static void dbpoolInit(){
		ds=new BasicDataSource();
		ds.setUrl(DB_URL);
		ds.setDriverClassName(DRIVER_NAME);
		ds.setUsername(USER_NAME);
		ds.setPassword(PASSWORD);
	}
	
	public static String dbpoolTest(String title){
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String cons=".......";
		System.out.println(title);
		try {
			System.out.println("entered try block");
			conn=ds.getConnection();
			System.out.println("entered try block2");
			st=conn.createStatement();
			System.out.println("entered try block3");
			rs=st.executeQuery("SELECT * FROM POEMS WHERE TITLE='"+title+"'");
		
			while (rs.next()){
				System.out.println("entered try block5");
				cons=rs.getString("content");
			
			}
			System.out.println(cons);
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
			cons="a";
			
		}finally {
			try {
			if (conn!=null) conn.close();
			if (st!=null) st.close();
			if (rs!=null) rs.close();
		}catch (SQLException e1){
			
			cons="c";
		}
				
	}
		return cons;
		
	}

	public static String returnPoem(String title){
		if (title==null){
			title="默认";
		}
		
		dbpoolInit();
		
		String content=dbpoolTest(title);
		
		StringBuffer s=new StringBuffer();
		
		s.append(content);
		
//		s.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n")
//		.append("<html><body>\n")
//		.append("<h1>Poem is")
//		.append(content)
//		.append("</h1>\n")
//		.append("</body></html>");
		
		return s.toString();
		
	}
	
	public static String returnPoem(String title, String author, String content){
		if (title==null){
			title="默认";
		}
		
		dbpoolInit();
		
		String con=dbpoolTest(title);
		
		StringBuffer s=new StringBuffer();
		
		s.append(con);
		
//		s.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n")
//		.append("<html><body>\n")
//		.append("<h1>Poem is")
//		.append(content)
//		.append("</h1>\n")
//		.append("</body></html>");
		
		return s.toString();
		
	}
	
	
}

