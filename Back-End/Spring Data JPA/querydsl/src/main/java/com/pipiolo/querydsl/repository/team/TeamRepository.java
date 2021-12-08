package com.pipiolo.querydsl.repository.team;

import com.pipiolo.querydsl.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends
        JpaRepository<Team, Long>,
        TeamRepositoryCustom
{
}
