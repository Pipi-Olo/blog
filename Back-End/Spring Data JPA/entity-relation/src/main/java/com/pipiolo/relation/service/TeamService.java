package com.pipiolo.relation.service;

import com.pipiolo.relation.domain.Team;
import com.pipiolo.relation.dto.TeamRequest;
import com.pipiolo.relation.dto.TeamResponse;
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
    public List<TeamResponse> findAll() {
        return teamRepository.findAll()
                .stream().map(TeamResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public TeamResponse getTeam(Long teamId) {
        return teamRepository.findById(teamId)
                .map(TeamResponse::from)
                .orElseThrow(() -> new IllegalArgumentException(
                        "There is no Team id : " + teamId));
    }

    @Transactional
    public Team create(TeamRequest request) {
        return teamRepository.save(request.toEntity());
    }

}
