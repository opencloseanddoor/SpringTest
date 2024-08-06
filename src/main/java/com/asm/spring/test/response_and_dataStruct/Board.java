package com.asm.spring.test.response_and_dataStruct;

public class Board 
{
	private String title;
	private String user;
	private String content;
	
	public Board(String title, String user, String content) //생성자 생성
	{
		this.title = title;
		this.user = user;
		this.content = content;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getUser() 
	{
		return user;
	}

	public void setUser(String user) 
	{
		this.user = user;
	}

	public String getContent() 
	{
		return content;
	}

	public void setContent(String content) 
	{
		this.content = content;
	}
}
