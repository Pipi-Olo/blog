package com.pipiolo.relation.domain;

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

    @OneToMany(mappedBy = "team")
    private final List<Member> members = new ArrayList<>();

    @Builder
    public Team(String name) {
        this.name = name;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addMembers(List<Member> members) {
        for (Member member : members) {
            this.members.add(member);
        }
    }
}
