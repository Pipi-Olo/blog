package com.pipiolo.querydsl.repository.member;

import com.pipiolo.querydsl.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
