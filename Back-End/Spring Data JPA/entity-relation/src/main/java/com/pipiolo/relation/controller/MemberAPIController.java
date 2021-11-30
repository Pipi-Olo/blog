package com.pipiolo.relation.controller;

import com.pipiolo.relation.domain.Member;
import com.pipiolo.relation.dto.MemberRequest;
import com.pipiolo.relation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberAPIController {

    private final MemberService memberService;

    @GetMapping()
    public List<Member> getMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PostMapping()
    public void create(@RequestBody MemberRequest request) {
        memberService.create(request);
    }
}
