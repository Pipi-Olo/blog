package com.pipiolo.relation.controller;

import com.pipiolo.relation.domain.Team;
import com.pipiolo.relation.dto.TeamRequest;
import com.pipiolo.relation.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/team")
@RestController
public class TeamAPIController {

    private final TeamService teamService;

    @GetMapping()
    public List<Team> getTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{teamId}")
    public Team getTeam(@PathVariable Long teamId) {
        return teamService.getTeam(teamId);
    }

    @PostMapping()
    public void create(@RequestBody TeamRequest request) {
        teamService.create(request);
    }
}
