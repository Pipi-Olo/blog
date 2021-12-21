package com.pipiolo.querydsl.dto;

import com.pipiolo.querydsl.domain.Member;

import java.util.List;

public record TeamResponse(
        String name,
        List<Member> members
) {
}
