package com.example.demo02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo02.dto.BoardDTO;

@Mapper  // 객체를 만들어주는 어노테이션 중 하나
public interface BoardMapper {

	// 추가
	@Insert("insert into board(title,writer,content,regdate) values(#{title},#{writer},#{content},now())")
	public void insert(BoardDTO board);
	
	// 전체보기
	//@Select("select * from board")
	public List<BoardDTO> list();
	
	// 상세보기
	@Select("select * from board where num=#{num}")
	public BoardDTO view(int num);
	
	// 개수
	public int getCount();
	
	@Delete("delete from board where num=#{num}")
	public void delete(int num);
}
