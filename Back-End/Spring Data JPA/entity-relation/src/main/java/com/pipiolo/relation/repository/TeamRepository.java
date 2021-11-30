package com.pipiolo.relation.repository;

import com.pipiolo.relation.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
