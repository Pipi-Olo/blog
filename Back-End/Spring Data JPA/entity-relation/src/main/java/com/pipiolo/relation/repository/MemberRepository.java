package com.pipiolo.relation.repository;

import com.pipiolo.relation.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select a from Member a join fetch a.team")
    List<Member> findAllJoinQuery();
}
