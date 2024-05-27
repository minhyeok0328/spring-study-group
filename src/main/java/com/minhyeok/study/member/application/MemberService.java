package com.minhyeok.study.member.application;

import com.minhyeok.study.member.domain.Member;
import com.minhyeok.study.member.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public String TestMethod() {
        return "hello world!";
    }

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

}
