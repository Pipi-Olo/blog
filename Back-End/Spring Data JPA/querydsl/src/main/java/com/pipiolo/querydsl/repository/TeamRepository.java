package com.pipiolo.querydsl.repository;

import com.pipiolo.querydsl.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
