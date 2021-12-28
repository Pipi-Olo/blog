package com.pipiolo.kafka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(nullable = false)
    private Integer age;

//    @JsonBackReference
//    @ManyToOne
//    private Team team;

    @JsonCreator
    @Builder
    public Member(
            @JsonProperty("name") String name,
            @JsonProperty("age") Integer age,
            Team team
    ) {
        this.name = name;
        this.age = age;
//        this.team = team;
    }
}

