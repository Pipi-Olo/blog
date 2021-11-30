package com.pipiolo.relation.dto;

import com.pipiolo.relation.domain.Team;

public record TeamRequest(
        String name
) {

    public Team toEntity() {
        return Team.builder()
                .name(name)
                .build();
    }
}
