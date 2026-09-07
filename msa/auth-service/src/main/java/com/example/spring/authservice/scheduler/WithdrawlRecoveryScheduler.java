package com.example.spring.authservice.scheduler;

// * 탈퇴 saga 복구 배치 - "미완경 saga를 끝까지 밀어주는" 장치
// UserService.withdraw()는 커밋1(WITHDRAWING) -> board 호출 -> 커밋2(WITHDRAWING)의 연쇄인데,
// 커밋1과 커밋2 "사이"에 auth가 죽으면 사용자는 WITHDRAWING에 영원히 갇힌다.

public class WithdrawlRecoveryScheduler {
}
