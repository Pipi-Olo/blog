package com.pipiolo.relation.dto;

import com.pipiolo.relation.domain.Member;

public record MemberResponse(
        String name,
        TeamResponse teamResponse
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getName(),
                TeamResponse.from(member.getTeam())
        );
    }
}
