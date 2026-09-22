
# 운영체제(맥/윈도우)에서는 리눅스 커널이 없는데 컨테이너는 리눅스 커널을 공유해야 돌아간다.
# 그래서 Docker Desktop이 리눅스 VM을 하나 띄운다

# ====== Build stage ======
# 이 FROM부터 다음 FROM 전까지가 "build" 스테이지
# 여기서 만들어지는 모든 것(JDK, Gradle 캐시, 소스, .class)은
# 최종 이미지에 포함되지 않는다. jar 을 뽑아내는 일회용 작업장이다.
FROM eclipse-temurin:25-jdk AS build

# ====== Runtime stage ======
FROM eclipse-temurin:25-jre

ENTRYPOINT ["top", "-b"]