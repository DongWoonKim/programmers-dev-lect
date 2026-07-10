package com.example.spring.basicboard.controller;

import com.example.spring.basicboard.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// * 프레젠테이션 계층 테스트 - 컨트롤러의 "Http 계약"을 검증한다

// 무엇을 보나?
// URL 매핑, 요청 본문(JSON) 파싱, 상태 코드, 응답 JSON, 예외 -> 상태 코드 변환
// "비즈니스 로직"이 아니라 "웹 껍데기가 제대로 동작하는가"가 관심사다.

// @WebMvcTest(MemberApiController.class)
// - 웹 계층(컨트롤러, @RestControllerAdvice 등)만 뜨는 슬라이스 테스트다 (서비스/레포지토리/DB는 안뜬다.)
// - 그래서 컨트롤러가 의존하는 MemberService는 "진짜"가 없다. -> @MockBean으로 가짜를 넣어준다
// - GlobalExceptionHandler(@RestControllerAdvice)는 웹 계층이라 자동으로 함께 로드된다. (예외 -> 응답 검증 가능)
@WebMvcTest(MemberApiController.class)
class MemberApiControllerTest {

    // MockMvc : 실제 서버(톰캣)를 띄우지 않고, HTTP 요청을 "흉내 내서" 컨트롤러에 넣어보는 도구
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper : 객체를 JSON으로 변환할 때 쓴다.
    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private MemberService memberService;

    @Test
    @DisplayName("회원가입 성공 - 200과 이동할 url을 반환한다.")
    void join_성공() throws Exception {
        // given
        String requestJson = objectMapper.writeValueAsString(
                Map.of(
                        "userId", "test",
                        "password", "1234",
                        "name", "test"
                )
        );

        // when & then
        mockMvc.perform(
                post("/api/members/join")
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( requestJson )
        )
        .andExpect(status().isOk())
        .andExpect( jsonPath("$.url").value("/members/login") );

    }

}




















