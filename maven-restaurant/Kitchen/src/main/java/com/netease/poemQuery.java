package com.netease;


import java.util.List;

import org.apache.ibatis.annotations.*;;

public interface poemQuery {
	
	public List<poem> getPoems (@Param("title") String title, @Param("author") String author, @Param("content_detail") String content_detail);

}
