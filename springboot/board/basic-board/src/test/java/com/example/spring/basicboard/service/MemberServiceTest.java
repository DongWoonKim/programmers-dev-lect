package com.example.spring.basicboard.service;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

// * 순수 단위 테스트 - 서비스 로직만 검증한다.

// * Mockito란?
// - "가짜 객체(Mock)"를 쉽게 만들어 주는 자바 테스트 라이브러리다.
// - Mock = 진짜와 유사한 모양의 빈 껍데기 -> 시나리오를 심어줄 수 있다.

// * 왜 가짜가 필요하나?
// - 단위 테스트 "대상 하나(MemberService)"가 제대로 동작하는지만 보고 싶음.
// - 그런데 MemberService 는 MemberRepository에 의존한다.
// -> 진짜 리포지토리를 쓰면 (1)DB가 떠 있어야 하고 (2)느리고 (3)DB/리포지토리 버그까지 섞여
// "무엇을 틀렸는지" 불분명해진다.
// - 그래서 리포지토리를 '가짜'로 바꿔, 그 행동을 내가 정해 놓고 -> 순수하게 서비스 로직만 검증한다.

// * 자주 쓰는 Mockito 문법
// @ExtendWith(MockitoExtension.class) : 이 테스트에서 Mockito 기능을 견다
// @Mock : 가짜 객체를 만든다.
// @InjectMocks : 테스트 대상을 만들고 위 @Mock 등을 주입한다.
@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

}


















