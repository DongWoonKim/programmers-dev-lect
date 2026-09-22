
# 운영체제(맥/윈도우)에서는 리눅스 커널이 없는데 컨테이너는 리눅스 커널을 공유해야 돌아간다.
# 그래서 Docker Desktop이 리눅스 VM을 하나 띄운다

# ====== Build stage ======
# 이 FROM부터 다음 FROM 전까지가 "build" 스테이지
# 여기서 만들어지는 모든 것(JDK, Gradle 캐시, 소스, .class)은
# 최종 이미지에 포함되지 않는다. jar 을 뽑아내는 일회용 작업장이다.
FROM eclipse-temurin:25-jdk AS build

# /app 은 빌드 중에만 존재하는 "컨테이너 안의 경로"다.
# 이후 COPY 의 도착지 상대경로 기준점.
WORKDIR /app

# 순서를 나눈 이유:
# 도커는 계층 단위로 캐시한다.
# COPY의 원본 파일이 안바뀌면 그 계층과 그 아래 RUN 결과까지 통째로 재사용한다.
#   - 자바 코드만 수정 -> build.gradle 그대로
#   - build.gradle 수정 -> 의존성부터 다시 받음
# 순서를 나누지 않고 COPY 로 한 번에 전체를 복사했다면 주석 한 줄만 고쳐도 의존성을 전부 다시 받는다.

# 호스트 service/gradlew -> 이미지 /app/gradlew
COPY gradlew ./
# 호스트 service/gradle/통째로 -> 이미지 /app/gradle
COPY gradlew gradle
# 호스트 service/settings.gradle -> 이미지 /app/settings.gradle
COPY settings.gradle .
# 호스트 service/build.gradle -> 이미지 /app/build.gradle
COPY build.gradle .


# ====== Runtime stage ======
FROM eclipse-temurin:25-jre

ENTRYPOINT ["top", "-b"]