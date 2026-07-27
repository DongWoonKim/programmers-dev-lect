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

@Configuration
@EnableWebSecurity
public class SecurityConfig {
}
