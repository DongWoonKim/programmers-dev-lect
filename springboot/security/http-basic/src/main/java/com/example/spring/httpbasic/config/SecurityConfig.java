package com.example.spring.httpbasic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// * Spring Security의 동작 메커니즘
// Spring Security의 모든 것은 필터(Filter) 위에서 돌아간다.
// 웹 요청이 들어오면 실제 컨트롤러에 도달하기 전에 여러 개의 보안 필터를 순서대로 통과한다.
// 이 진입점이 DelegatingFilterProxy이다.
// 서블릿 컨테이너(톰캣)에 등록된 이 필터가 요청을 받아서 스프링이 관리하는 FilterChainProxy에게 위임하고,
// 이 FilterChainProxy가 내부적으로 여러 SecurityFilterChain을 들고 있다.
// 즉 "톰캣 필터 -> 스프링 빈으로 관리되는 보안 필터들"로 다리를 놓아주는 구조이다.
// - 요청 -> DelegatingFilterProxy -> FilterChainProxy -> [보안 필터 체인] -> DispatcherServlet -> Controller

// * DelegatingFilterProxy : "서블릿 컨테이너(톰캣)의 세계와 스프링의 세계를 이어주는 다리 역할을 하는 필터"이다.
// - Delegating(위임) +  Filter + Proxy(대리인) : 실제 일은 다른 녀석에게 위임하는 껍데기 필터
// 왜 이런 게 필요한가
// 핵심은 톰캣과 스프링이 서로 다른 세계라는 점이다.

// 서블릿 컨테이너는 Filter를 자기 규칙대로 등록하고 생성/관리한다.
//하지만 톰캣은 스프링 Bean을 전혀 모른다. 스프링 컨테이너 안에 뭐가 있는지 전혀 모른다.
// 그런데 우리가 쓰고 싶은 실제 보안 필터들(FilterChainProxy와 그 안의 인증/인가 필터)은 스프링 Bean이다.
// DI, 라이프사이클 관리 등 스프링 기능을 다 써야 하기때문이다.


@Configuration
@EnableWebSecurity
public class SecurityConfig {
}
