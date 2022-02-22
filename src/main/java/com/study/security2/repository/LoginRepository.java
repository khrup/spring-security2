package com.study.security2.repository;

import com.study.security2.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginRepository {

    List<Member> findAllMember();

    int createMember(Member member);

    Member getMember(Member member);
}
