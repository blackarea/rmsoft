package com.example.rmsoft.mapper;

import com.example.rmsoft.model.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {

    @Insert("INSERT INTO MEMBER (name, id, password, phone, jumin_no, address) " +
            "VALUES (#{name}, #{id}, #{password}, #{phone}, #{juminNo}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "memberId")
    int insert(Member member);

    @Select("SELECT * FROM MEMBER WHERE id = #{id}")
    Member getById(String id);

}
