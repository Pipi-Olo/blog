package com.pipiolo.querydsl.repository.member;

import com.pipiolo.querydsl.domain.Member;
import com.pipiolo.querydsl.domain.Team;
import com.pipiolo.querydsl.dto.MemberResponse;
import com.pipiolo.querydsl.repository.team.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.*;

@DisplayName("[DB] - Repository")
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
    void before() {
        Team team = Team.builder()
                .name("Team Name")
                .build();

        Member member = Member.builder()
                .name("Member Name")
                .age(20)
                .team(team)
                .build();

        team.addMember(member);

        teamRepository.save(team);
        memberRepository.save(member);
    }

    @DisplayName("주어진 조건으로 검색했을 때, 알맞는 멤버들을 반환한다.")
    @Test
    void givenSearchParams_whenSearching_thenReturnsMemberPage() {
        // Given
        String name = "Member Name";
        Integer age = 20;
        Team team = Team.builder()
                .name("Team Name")
                .build();

        // When
        Page<MemberResponse> members = memberRepository.findMembersByParams(
                name,
                age,
                team,
                PageRequest.of(0, 5));

        // Then
        assertThat(members.getContent().get(0))
                .hasFieldOrPropertyWithValue("name", name)
                .hasFieldOrPropertyWithValue("age", age);
    }

    @DisplayName("조건없이 검색했을 때, 저장된 모든 멤버를 반환한다.")
    @Test
    void givenNothing_whenSearching_thenReturnsAllMembers() {
        // Given

        // When
        Page<MemberResponse> members = memberRepository.findMembersByParams(
                null,
                null,
                null,
                PageRequest.of(0, 5)
        );

        // Then
        assertThat(members.getContent().get(0))
                .hasFieldOrPropertyWithValue("name", "Member Name")
                .hasFieldOrPropertyWithValue("age", 20);
    }
}