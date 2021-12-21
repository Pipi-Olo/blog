package com.pipiolo.querydsl.repository.team;

import com.pipiolo.querydsl.domain.Member;
import com.pipiolo.querydsl.dto.TeamResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeamRepositoryCustom {

    Page<TeamResponse> findTeamsByParams(
            String name,
            Pageable pageable
    );
}
