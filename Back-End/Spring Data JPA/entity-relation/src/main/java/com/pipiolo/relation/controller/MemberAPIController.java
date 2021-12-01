package com.pipiolo.relation.controller;

import com.pipiolo.relation.dto.MemberRequest;
import com.pipiolo.relation.dto.MemberResponse;
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
    public List<MemberResponse> getMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{memberId}")
    public MemberResponse getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PostMapping()
    public void create(@RequestBody MemberRequest request) {
        memberService.create(request);
    }
}
