package com.pipiolo.querydsl.repository.team;

import com.pipiolo.querydsl.domain.Member;
import com.pipiolo.querydsl.domain.QTeam;
import com.pipiolo.querydsl.domain.Team;
import com.pipiolo.querydsl.dto.TeamResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

public class TeamRepositoryCustomImpl
    extends QuerydslRepositorySupport
    implements TeamRepositoryCustom
{
    public TeamRepositoryCustomImpl() {
        super(Team.class);
    }

    @Override
    public Page<TeamResponse> findTeamsByParams(
            String name,
            Pageable pageable
    ) {
        QTeam team = QTeam.team;
        JPQLQuery<TeamResponse> query = from(team)
                .select(Projections.constructor(
                        TeamResponse.class,
                        team.name
                ));

        if (StringUtils.hasText(name)) {
            query.where(team.name.eq(name));
        }

        List<TeamResponse> teams = getQuerydsl()
                .applyPagination(pageable, query)
                .fetch();

        return new PageImpl<>(teams, pageable, query.fetchCount());
    }
}
