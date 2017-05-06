package com.netease;

public class poem {
	
	private int id;
	private String title;
	private String content;
	private String content_detail;
	private int author_id;
	private String author;
	private String comment;
	
	public poem(Integer id, String title,String content, String content_detail,String author, Integer author_id,  String comment){
		this.id=id;
		this.title=title;
		this.content=content;
		this.content_detail=content_detail;
		this.author_id=author_id;
		this.author=author;
		this.comment=comment;
	}
	
	public String toString(){
		return content_detail;
	}
	
	public int getId(){
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentDetail() {
		return content_detail;
	}

	public void setContentDetail(String contentDetail) {
		this.content_detail = contentDetail;
	}

	public int getAuthorId() {
		return author_id;
	}

	public void setAuthorId(int authorId) {
		this.author_id = authorId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
