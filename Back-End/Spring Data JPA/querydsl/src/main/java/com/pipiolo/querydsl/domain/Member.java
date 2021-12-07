package com.pipiolo.querydsl.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Team team;

    @Builder
    public Member(String name, Team team) {
        this.name = name;
        this.team = team;
    }
}
