package com.asm.spring.test.response_and_dataStruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Restcontroller
{
	@RequestMapping("1")
	public List<Map<String, Object>> movieList()
	{
		List<Map<String, Object>> movieList = new ArrayList<>();
		Map<String, Object> movieMap = new HashMap<String, Object>()
		{
				{
					put("rate", 15);
					put("directer", "봉준호");
					put("time", 131);
					put("title", "기생충");
				}
		};
		movieList.add(movieMap);
		
		movieMap = new HashMap<String, Object>()
		{
				{
					put("rate", 0);
					put("directer", "로베르토 베니니");
					put("time", 166);
					put("title", "인생은 아름다워");
				}
		
		};
		movieList.add(movieMap);
		
		movieMap = new HashMap<String, Object>()
		{
				{
					put("rate", 12);
					put("directer", "크리스토퍼 놀린");
					put("time", 147);
					put("title", "인셉션");
				}
		
		};
		movieList.add(movieMap);
		
		movieMap = new HashMap<String, Object>()
		{
				{
					put("rate", 15);
					put("directer", "프란시스 로맨스");
					put("time", 137);
					put("title", "헝거게임");
				}
		
		};
		movieList.add(movieMap);
		return movieList;
	}
	
	@RequestMapping("2")
	public List<Board> boardList()
	{
		List<Board> BoardList = new ArrayList<>();
		Board board = new Board("안녕하세요 가입인사 드립니다", "haguru", "안녕하세요 가입했어요 잘 부탁드립니다.");
		BoardList.add(board);
		board = new Board("헐 대박", "bada", "목요일 이었네 금요일 인 줄");
		board = new Board("반가워요", "durumary", "....");
		
		return BoardList;
	}
	
	@RequestMapping("3")
	public ResponseEntity<Board> boardError()
	{
		Board board = new Board("안녕하세요 가입인사 드립니다", "haguru", "안녕하세요 가입했어요 잘 부탁드립니다.");
		
		
		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
}
