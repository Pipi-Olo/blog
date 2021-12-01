package com.pipiolo.relation.service;

import com.pipiolo.relation.domain.Member;
import com.pipiolo.relation.domain.Team;
import com.pipiolo.relation.dto.MemberRequest;
import com.pipiolo.relation.dto.MemberResponse;
import com.pipiolo.relation.repository.MemberRepository;
import com.pipiolo.relation.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberResponse> findAll() {
        return memberRepository.findAll()
                .stream().map(MemberResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(Long MemberId) {
        return memberRepository.findById(MemberId)
                .map(MemberResponse::from)
                .orElseThrow(() -> new IllegalArgumentException(
                        "There is no Member id : " + MemberId));
    }
    
    @Transactional
    public void create(MemberRequest request) {
        Team team = teamRepository.findById(request.teamId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "There is No Team Id : " + request.teamId()));

        Member member = memberRepository.save(request.toEntity(team));
        team.addMember(member);
    }

}