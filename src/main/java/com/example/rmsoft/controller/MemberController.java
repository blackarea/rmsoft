package com.example.rmsoft.controller;

import com.example.rmsoft.model.Member;
import com.example.rmsoft.model.base.BaseResponse;
import com.example.rmsoft.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public BaseResponse<Void> signUp(@RequestBody Member member) {
        memberService.signUp(member);
        return new BaseResponse<>();
    }

    @GetMapping("/{memberId}")
    public BaseResponse<Member> getById(@PathVariable long memberId){
        return new BaseResponse<>(memberService.getById(memberId));
    }

}
