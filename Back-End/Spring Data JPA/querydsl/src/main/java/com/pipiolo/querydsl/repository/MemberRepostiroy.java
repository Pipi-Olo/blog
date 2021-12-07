package com.pipiolo.querydsl.repository;

import com.pipiolo.querydsl.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepostiroy extends JpaRepository<Member, Long> {
}
