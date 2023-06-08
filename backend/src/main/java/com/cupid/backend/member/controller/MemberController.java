package com.cupid.backend.member.controller;

import com.cupid.backend.member.controller.dto.SignUpRequest;
import com.cupid.backend.member.service.MemberService;
import com.cupid.backend.post.controller.dto.PostRequest;
import com.cupid.backend.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SignUpRequest signUpRequest) {
        memberService.create(signUpRequest);
        return ResponseEntity.ok().build();
    }
}
