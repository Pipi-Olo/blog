package com.pipiolo.kafka.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany
    private final List<Member> members = new ArrayList<>();

    @JsonCreator
    @Builder
    public Team(
            @JsonProperty("name") String name
    ) {
        this.name = name;
    }

    public void addMember(Member member) {
        members.add(member);
    }
}
