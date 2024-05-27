package com.minhyeok.study.member.application;

import com.minhyeok.study.member.domain.Member;
import com.minhyeok.study.member.domain.MemberRepository;
import com.minhyeok.study.member.dto.MemberCreateRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberCRUDService {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberCRUDService(final MemberService memberService, final MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    public Member createMember(MemberCreateRequestDto requestDto) {
        Member member = Member.builder()
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .email(requestDto.getEmail())
                .build();

        return memberRepository.save(member);
    }

    public Member TestCRUDMethod(String username) {
        return memberService.findByUsername(username);
    }
}
