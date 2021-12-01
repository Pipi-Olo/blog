package com.pipiolo.relation.dto;

import com.pipiolo.relation.domain.Team;

public record TeamResponse(
        String name
) {
    public static TeamResponse from(Team team) {
        return new TeamResponse(team.getName());
    }
}
