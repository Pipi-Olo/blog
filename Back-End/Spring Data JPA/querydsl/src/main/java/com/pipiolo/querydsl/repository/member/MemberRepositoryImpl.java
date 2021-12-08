package com.pipiolo.querydsl.repository.member;

import com.pipiolo.querydsl.domain.Member;
import com.pipiolo.querydsl.domain.QMember;
import com.pipiolo.querydsl.domain.Team;
import com.pipiolo.querydsl.dto.MemberResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberRepositoryImpl
    extends QuerydslRepositorySupport
    implements MemberRepositoryCustom
{
    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Page<MemberResponse> findMembersByParams(
            String name,
            Integer age,
            Team team,
            Pageable pageable
    ) {
        QMember member = QMember.member;
        JPQLQuery<MemberResponse> query = from(member)
                .select(Projections.constructor(
                        MemberResponse.class,
                        member.name,
                        member.age,
                        member.team
                ));

        if (StringUtils.hasText(name)) {
            query.where(member.name.eq(name));
        }

        if (age != null) {
            query.where(member.age.eq(age));
        }

        if (team != null) {
            query.where(member.team.name.eq(team.getName()));
        }

        List<MemberResponse> members = getQuerydsl()
                .applyPagination(pageable, query)
                .fetch();

        return new PageImpl<>(members, pageable, query.fetchCount());
    }
}
