package com.example.rmsoft.service;

import com.example.rmsoft.mapper.MemberMapper;
import com.example.rmsoft.model.Book;
import com.example.rmsoft.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member){
        memberMapper.insert(member);
    }

    @Transactional(readOnly = true)
    public Member getById(String id){
        return memberMapper.getById(id);
    }

}
