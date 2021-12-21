package com.pipiolo.querydsl.dto;

import com.pipiolo.querydsl.domain.Team;

public record MemberResponse(
        String name,
        Integer age,
        Team team
) {
}
