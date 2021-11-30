package com.pipiolo.relation.service;

import com.pipiolo.relation.domain.Team;
import com.pipiolo.relation.dto.TeamRequest;
import com.pipiolo.relation.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional(readOnly = true)
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Team getTeam(Long teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "There is no Team id : " + teamId));
    }

    @Transactional
    public Team create(TeamRequest request) {
        return teamRepository.save(request.toEntity());
    }

}
