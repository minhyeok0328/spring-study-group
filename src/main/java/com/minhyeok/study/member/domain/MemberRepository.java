package com.minhyeok.study.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
    Member findByEmail(String email);
    Member findByPassword(String password);
}
