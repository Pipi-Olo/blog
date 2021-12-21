package com.pipiolo.querydsl.repository.member;

import com.pipiolo.querydsl.domain.Team;
import com.pipiolo.querydsl.dto.MemberResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

    Page<MemberResponse> findMembersByParams(
            String name,
            Integer age,
            Team team,
            Pageable pageable
    );
}
