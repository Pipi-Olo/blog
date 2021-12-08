package com.pipiolo.querydsl.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @ManyToOne
    private Team team;

    @Builder
    public Member(String name, Integer age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }
}
