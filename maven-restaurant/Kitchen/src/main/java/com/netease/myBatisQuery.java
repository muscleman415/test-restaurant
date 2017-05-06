package com.netease;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class myBatisQuery {
	
	public static List<poem> returnPoem (String title, String author, String content_detail){
		
        String resource="conf.xml";
		
		InputStream is = myBatisQuery.class.getClassLoader().getResourceAsStream(resource);
		
		SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session=sessionFactory.openSession();
		
		List<poem> poemList=null;
		
		
		try{
		
		poemQuery poemQuery =session.getMapper(poemQuery.class);
		
		poemList= poemQuery.getPoems(title,author,content_detail);
		}
		finally{
			session.close();
		}
		
		return poemList;
		
	}
	 
	

}

