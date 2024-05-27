package com.minhyeok.study.member.controller;

import com.minhyeok.study.member.application.MemberCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MemberCRUDController {
    private final MemberCRUDService memberCRUDService;

    @Autowired
    public MemberCRUDController(final MemberCRUDService memberCRUDService) {
        this.memberCRUDService = memberCRUDService;
    }

    @GetMapping("/member")
    public ResponseEntity TestMember() {
        return ResponseEntity.ok(memberCRUDService.TestCRUDMethod());
    }
}
