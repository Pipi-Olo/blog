package com.pipiolo.relation.dto;

import com.pipiolo.relation.domain.Member;
import com.pipiolo.relation.domain.Team;

public record MemberRequest(
        String name,
        Long teamId
) {

    public Member toEntity(Team team) {
        return Member.builder()
                .name(name)
                .team(team)
                .build();
    }
}
