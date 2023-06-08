package com.cupid.backend.member.controller.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    private String name;
    private int age;
    private String email;
}
