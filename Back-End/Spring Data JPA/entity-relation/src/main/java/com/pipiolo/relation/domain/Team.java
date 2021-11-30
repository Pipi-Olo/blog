package com.pipiolo.relation.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @JsonBackReference
    @OneToMany
    private List<Member> memberList = new ArrayList<>();

    @Builder
    public Team(String name) {
        this.name = name;
    }

    public void addMember(Member member) {
        memberList.add(member);
    }
}
