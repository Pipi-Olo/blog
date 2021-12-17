package com.pipiolo.relation.repository;

import com.pipiolo.relation.domain.Member;
import com.pipiolo.relation.domain.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DisplayName("[DB] - MemberRepository")
@DataJpaTest
class MemberRepositoryTest {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;


    public MemberRepositoryTest(
            @Autowired TeamRepository teamRepository,
            @Autowired MemberRepository memberRepository
    ) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    @BeforeEach
    void setup() {
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Team team = Team.builder()
                    .name("Team Name " + i)
                    .build();
            teams.add(team);
        }
        teamRepository.saveAll(teams);

        for (Team team : teams) {
            List<Member> members = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Member member = Member.builder()
                        .name("Member Name " + i)
                        .team(team)
                        .build();
                members.add(member);
            }
            team.addMembers(members);
            memberRepository.saveAll(members);
        }
    }

    @DisplayName("조건 없이, 멤버를 검색하면 멤버 리스트를 반환한다.")
    @Test
    void givenNothing_whenFindMembers_thenReturnsMemberList() {
        // Given

        // When
        List<Member> memberList = memberRepository.findAll();

        // Then
        Assertions.assertEquals(100, memberList.size());
        Assertions.assertEquals("Member Name 0", memberList.get(0).getName());
        Assertions.assertEquals("Team Name 0", memberList.get(0).getTeam().getName());
    }
}