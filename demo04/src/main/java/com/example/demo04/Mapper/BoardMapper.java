package com.example.demo04.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo04.dto.BoardDTO;

@Mapper
public interface BoardMapper {

		// 추가
		@Insert("insert into board(title, writer, content, regdate) values(#{title},#{writer},#{content},now())")
		public void insert(BoardDTO board);
		
		// 전체보기
		@Select("select * from board")
		public List<BoardDTO> list();
		
		// 상세보기
		@Select("select * from board where num=#{num}")
		public BoardDTO findByNum(int num);
		// 수정
		public void update(BoardDTO board);
		// 삭제
		public void delete(int num);
		// 개수
		@Select("select count(*) from board")
		public int getCount();
}
