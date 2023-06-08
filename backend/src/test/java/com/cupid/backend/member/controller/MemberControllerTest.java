package com.cupid.backend.member.controller;

import com.cupid.backend.post.controller.dto.PostRequest;
import com.cupid.backend.post.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    private SignUpRequest signUpRequest;

    @MockBean
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        signUpRequest = SignUpRequest.builder()
                .build();
    }

    @Test
    void 회원가입_성공() throws Exception {
        // given
        willDoNothing().given(signUpRequest).create(any(SignUpRequest.class));
        // when
        ResultActions resultActions = 회원가입_요청();
        // then
        회원가입_요청_성공(resultActions);
    }

    private ResultActions 회원가입_요청() throws Exception {
        return mockMvc.perform(post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(postRequest)));
    }

    private ResultActions 회원가입_요청_성공(ResultActions resultActions) throws Exception {
        return resultActions.andExpect(status().isOk())
                .andDo(print())
                .andDo(toDocument("create-post-success"));
    }
}
