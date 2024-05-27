package com.minhyeok.study.member.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberCRUDService {
    private final MemberService memberService;

    @Autowired
    public MemberCRUDService(final MemberService memberService) {
        this.memberService = memberService;
    }

    public String TestCRUDMethod() {
        return memberService.TestMethod();
    }
}
