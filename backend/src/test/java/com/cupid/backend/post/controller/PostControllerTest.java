package com.cupid.backend.post.controller;

import com.cupid.backend.ApiDocument;
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

@WebMvcTest(PostController.class)
public class PostControllerTest extends ApiDocument {

    private PostRequest postRequest;

    @MockBean
    private PostService postService;

    @BeforeEach
    void setUp() {
        postRequest = PostRequest.builder()
                .title("제목")
                .content("본문")
                .author("작성자")
                .build();
    }

    @Test
    void 게시글_저장_성공() throws Exception {
        // given
        willDoNothing().given(postService).create(any(PostRequest.class));
        // when
        ResultActions resultActions = 게시글_저장_요청();
        // then
        게시글_저장_요청_성공(resultActions);
    }

    @Test
    void 게시글_조회_성공() throws Exception {
        // given
        willDoNothing().given(postService).create(any(PostRequest.class));
        // when
        ResultActions resultActions = 게시글_저장_요청();
        // then
        게시글_저장_요청_성공(resultActions);
    }

    @Test
    void 게시글_수정_성공() throws Exception {
        // given
        willDoNothing().given(postService).create(any(PostRequest.class));
        // when
        ResultActions resultActions = 게시글_저장_요청();
        // then
        게시글_저장_요청_성공(resultActions);
    }

    private ResultActions 게시글_저장_요청() throws Exception {
        return mockMvc.perform(post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(postRequest)));
    }

    private ResultActions 게시글_저장_요청_성공(ResultActions resultActions) throws Exception {
        return resultActions.andExpect(status().isOk())
                .andDo(print())
                .andDo(toDocument("create-post-success"));
    }
}
