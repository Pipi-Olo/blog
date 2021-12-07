package com.pipiolo.relation.repository;

import com.pipiolo.relation.domain.Member;
import com.pipiolo.relation.domain.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

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
        Team team = Team.builder()
                .name("TeamName")
                .build();
        teamRepository.save(team);

        for (int i = 0; i < 10; i++) {
            Member member = Member.builder()
                    .name("MemberName" + i)
                    .team(team)
                    .build();

            team.addMember(member);
            memberRepository.save(member);
        }
    }

    @Test
    void givenNothing_whenFindMemberAll_thenReturnsMemberList() {
        // Given

        // When
        List<Team> teamList = teamRepository.findAll();
        List<Member> memberList = memberRepository.findAll();
//        List<Member> memberList = memberRepository.findAllJoinQuery();

        // Then
//        Assertions.assertEquals(10, memberList.size());
    }
}