
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