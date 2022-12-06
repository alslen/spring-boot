package com.example.demo04.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo04.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public MemberDTO read(String username);
}
