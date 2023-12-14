package com.example.rmsoft.service;

import com.example.rmsoft.mapper.MemberMapper;
import com.example.rmsoft.model.Member;
import com.example.rmsoft.model.base.BaseException;
import com.example.rmsoft.model.base.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        Optional<Member> existedMember = Optional.ofNullable(getById(member.getId()));
        if (existedMember.isPresent()) {
            throw new BaseException(BaseResponseStatus.SIGNUP_FAIL);
        }
        memberMapper.insert(member);
    }

    @Transactional(readOnly = true)
    public Member getById(String id) {
        return memberMapper.getById(id);
    }

}
