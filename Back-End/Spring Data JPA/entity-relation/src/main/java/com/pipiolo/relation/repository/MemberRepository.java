package com.pipiolo.relation.repository;

import com.pipiolo.relation.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
