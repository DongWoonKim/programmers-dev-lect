
# AWS 배포 가이드

## 1. 인프라 구축
### 1) VPC 생성 : msa-vpc
- VPC만 선택
- IPv4 CIDR : 10.0.0.0/16
### 2) 서브넷 생성
- 서브넷 이름 : msa-public-a-subnet
- IPv4 CIDR : 10.0.1.0/24 
- 서브넷 이름 : msa-private-a-subnet
- IPv4 CIDR : 10.0.11.0/24
### 3) IGW 생성 : msa-igw
- 생성후 -> 작업 -> vpc연결(msa-vpc) 
- 이렇게 해줘야 라우팅 테이블에서 연동 가능
### 4) NAT
- IGW가 먼저 셋팅이 되어야(라우팅테이블까지 완료) NAT GW 목록에서 msa-vpc를 선택할 수 있다.
- vpc : msa-vpc
### 5) 보안그룹
- msa-app-sg
- 인바운드 규칙 : ssh(내 IP), HTTP 허용
- msa-db-sg
- 인바운드 규칙 : ssh, mysql/aurora(두 개 모두 사용자지정 - msa-app-sg)
### 6) EC2
- msa-app
- t3.small
- 키 페어 : pem키 설정
- 네트워크 설정 
- vpc(msa-vpc)
- subnet(msa-public-a-subnet)
- 퍼블릭 IP 자동 할당 : 활성화
- 보안그룹 : msa-app-sg
- 탄력적 IP 생성 및 할당(생성한 탄력적IP -> 탄력적 IP 주소연결 -> 인스턴스 선택, 프라이빗 IP 선택)
- msa-db
- t3.small
- 키 페어 : pem키 설정
- 네트워크 설정 
- vpc(msa-vpc)
- subnet(msa-private-a-subnet)
- 퍼블릭 IP 자동 할당 : 비활성화
- 보안그룹 : msa-db-sg
### 7) 라우팅 테이블 설정
- msa-public-rt
- vpc : msa-vpc
- 라우팅 편집 : 0.0.0.0/0 인터넷게이트웨(msa-igw) 추가
- 작업 -> 서브넷 편집 -> msa-public-a-subnet
- msa-private-rt
- vpc : msa-vpc
- 라우팅 편집 : 0.0.0.0/0 NAT-GW(msa-nat) 추가
- 작업 -> 서브넷 편집 -> msa-private-a-subnet

# scp : Secure Copy. ssh 연결로 파일을 복사하는 명령
# -i ~/Desktop/msa-key.pem : 서버에 접속할 때 쓸 키(ssh -i)
# ~/Desktop/msa-key.pem : 복사할 파일
# ubuntu@15.164.188.158:~/ : 보낼 곳. (사용자@서버주소:경로)
scp -i ~/Desktop/msa-key.pem ~/Desktop/msa-key.pem ubuntu@3.39.65.107:~/

## 2.리눅스 기본 명령어
### 경로표기
- / : 최상위(루트) 디렉터리
- ~ : 내 홈 디렉터리(/home/ubuntu)
- . : 현재 디렉터리
- .. : 상위 디렉터리
- .이름 : 숨긴파일 -ls로는 안 보이고 ls -a로 보인다. (.git, .env, .ssh)

### 이동/조회
- pwd : 현재 위치 출력
- ls : 목록
- ls -a : 숨김파일 포함
- cd <폴더> : 이동
- cat <파일> : 파일 내용 전체 출력
- grep <단어> <파일> : 파일에서 단어가 있는 줄만
- tail -f <파일> : 파일 끝을 실시간으로 계속 보기(로그 확인 - ctrl+c로 종료)
- head -n 20 <파일> / tail -n 20 <파일> : 앞/뒤 20줄

### 파일/폴더 만들기, 복사, 이름바꾸기, 삭제
- mkdir <폴더> : 폴더 생성
- touch <파일> : 빈 파일 생성
- cp <원본> <대상> : 파일 복사
- cp -r <폴더> <대상> : 폴더 통째로 복사(-r : 하위까지)
- mv <원본> <대상> : 이동 또는 이름 바꾸기(같은 폴더 안에서 옮기면 이름 변경)
- rm <파일> : 파일 삭제
- rm -r <폴더> : 폴더 삭제
- rm -rf <폴더> : 확이 없이 강제 삭제
리눅스에는 휴지통이 없다. rm은 즉시 영구 삭제다.
sudo rm -rf / -> 서버를 통째로 날린다.

### 파일쓰기 - 리다이렉션/파이프, heredoc
- > : 결과를 파일에 덮어쓰기 echo hello > a.txt
- >> : 결과를 파일 끝에 추가 echo world >> a.txt
- | : 앞 명령 결과를 뒤 명령어의 입력으로 docker ps | grep auth
- cat <<'EOF'> 파일 ~ 여러줄을 파일로 저장
  EOF

### 편집기 - vi최소 사용법
- vi <파일> : 열기 (없으면 새로 만듦)
- i : 입력 모드(화면 아래 insert)
- esc : 명령 모드로 복귀
- /단어 + enter : 검색
- :wq + enter : 저장 후 종료
- :q! + enter : 저장하지 않고 종료
- dd : (명령모드) 현재 줄 삭제
- u : 되돌리기

### 권한 : chmod
- r : 4 - 읽기, w : 2 - 쓰기, x : 1 - 실행
- rw- => 6, rwx => 7
- chmod 400 <파일> : 소유자만 읽기
- chmod 600 <파일> : 소유자만 읽기/쓰기
- chmod 644 <파일> : 누구나 읽기, 쓰기는 소유자만
- chmod 700 <폴더> : 소유자만 접근 가능
- chmod 755 <파일> : 누구나 실행, 수정은 소유자만
- chmod +x <파일> : 실행 권한만 추가

### 관리자 권한, 사용자
- sudo <명령> : 관리자 권한으로 실행
- whoami : 현재 사용자

### 패키지/서비스 관리(우분투 기준)
- sudo apt update : 설치 가능한 패키지 목록 갱신
- sudo apt upgrade -y : 설치된 패키지 업그레이드
- sudo apt install -y <패키지> : 설치(git, nginx, mysql-server,...)
- sudo systemctl status <서비스명> : 상태(active running이면 정상)
- sudo systemctl start/stop/restart <서비스> : 시작/중지/재시작
- sudo systemctl enable <서비스> : 부팅 시 자동 시작

### 접속/파일 전송
- ssh -i <키> ubuntu@<IP> : 서버 접속
- exit : 접속 종료
- scp -i <키> <내파일> ubuntu@<IP>:~/ : 내 pc -> 서버 복사
- scp -i <키> ubuntu@<IP>:~/<파일> . : 서버 -> 내 pc 복사

## 3. DB서버 셋팅(ec2 : msa-db)
- sudo apt update && sudo apt upgrade -y
- sudo timedatectl set-timezone Asia/Seoul
- sudo apt install -y mysql-server
- mysql --version
- sudo systemctl status mysql
- sudo systemctl enable mysql
- mysql설정 파일 : sudo vi /etc/mysql/mysql.conf.d/mysqld.cnf
-> bind-address : 127.0.0.1 -> 0.0.0.0
character-set-server    = utf8mb4
collation-server        = utf8mb4_unicode_ci
- sudo systemctl restart mysql
- 접속 : sudo mysql
```SQL
CREATE USER 'app'@'10.0.1.%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON board_auth.* TO 'app'@'10.0.1.%';
GRANT ALL PRIVILEGES ON board_app.* TO 'app'@'10.0.1.%';
FLUSH PRIVILEGES;
```

## 4. Docker & git설치 (ec2 : msa-app)
- sudo apt update && sudo apt upgrade -y
- sudo timedatectl set-timezone Asia/Seoul
- curl -fsSL https://get.docker.com | sudo sh
- sudo usermod -aG docker ubuntu     # sudo 없이 docker 사용
- exit                               # 그룹 반영을 위해 재접속
- ssh 재접속
- docker version
- docker compose version
- sudo apt install -y git
- ssh-keygen -t ed25519 -C "msa-app-deploy" -f ~/.ssh/github_deploy -N ""
```
ssh-keygen : ssh 키를 만드는 프로그램
-t ed25519 : 키 종류(알고리즘). RSA보다 짧고 빠르면서 안전한 최신 방식(GitHub 권장)
-C "msa-app-deploy" : 공개키 끝에 붙어 어떤 키인지 알아보는 용도. 인증 과는 무관
-f ~/.ssh/github_deploy : 저장할 파일 경로
-N "" : 키 암호를 빈 값으로 설정하여, 서버가 사람없이 자동으로 git pull할 수 있게한다.

~/.ssh/github_deploy     : 개인키 - 자물쇠의 "열쇠"
~/.ssh/github_deploy.pub : 공개키 - 자물쇠의 "자물통"

인증흐름
1. GitHub에 공개키 등록(Deploy key)
2. 서버가 git pull 할 때 개인키로 서명한다
3. GitHub가 등록된 공개키로 서명을 검증 -> 맞으면 통과
```
- cat ~/.ssh/github_deploy.pub
- 서버의 ~/.ssh/conifg
```
cat <<'EOF' >> ~/.ssh/config
Host github.com
    IdentityFile ~/.ssh/github_deploy
    IdentitiesOnly yes
EOF
chmod 600 ~/.ssh/config
```
- ssh -T git@github.com
- git clone git@github.com:DongWoonKim/programmers-dev-lect.git
- 폴더명 변경 : mv ~/programmers-dev-lect ~/app
- docker-compose.aws.yml
```yaml
name: msa-aws

networks:
  msa-network:
    name: msa-network

x-common: &common
  restart: unless-stopped
  networks: [msa-network]

services:
  config-service:
    <<: *common
    build: ../msa/config-service
    image: config-service:latest
    container_name: config-service
    volumes:
      - ../msa/config-repo:/config-repo:ro
    environment:
      CONFIG_REPO_PATH: file:/config-repo
      JAVA_OPTS: ${JAVA_OPTS}
    # ports 없음 → 호스트에도 공개하지 않는다. 같은 네트워크의 컨테이너만 접근
    healthcheck:
      test: ["CMD", "bash", "-c", "echo > /dev/tcp/127.0.0.1/8888"]
      interval: 5s
      timeout: 3s
      retries: 40            

  auth-service:
    <<: *common
    build: ../msa/auth-service
    image: auth-service:latest
    container_name: auth-service
    depends_on:
      config-service: { condition: service_healthy }
    environment:
      CONFIG_SERVICE_URL: http://config-service:8888 
      DB_URL: "jdbc:mysql://${DB_HOST}:3306/board_auth?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8"
      SPRING_DATASOURCE_USERNAME: ${DB_USER}
      SPRING_DATASOURCE_PASSWORD: ${DB_PASSWORD}
      BOARD_SERVICE_URL: http://board-service:8081
      # OAuth 성공 후 브라우저를 돌려보낼 주소 (application.yaml 의 web-service.url)
      WEB_SERVICE_URL: http://${PUBLIC_HOST}
      JAVA_OPTS: ${JAVA_OPTS}

  board-service:
    <<: *common
    build: ../msa/board-service
    image: board-service:latest
    container_name: board-service
    depends_on:
      config-service: { condition: service_healthy }
    environment:
      CONFIG_SERVICE_URL: http://config-service:8888
      DB_URL: "jdbc:mysql://${DB_HOST}:3306/board_app?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8"
      SPRING_DATASOURCE_USERNAME: ${DB_USER}
      SPRING_DATASOURCE_PASSWORD: ${DB_PASSWORD}
      AUTH_SERVICE_URL: http://auth-service:8082
      JAVA_OPTS: ${JAVA_OPTS}
    volumes: 
      - board-uploads:/app/uploads

  edge-service:
    <<: *common
    build: ../msa/edge-service
    image: edge-service:latest
    container_name: edge-service
    depends_on:
      config-service: { condition: service_healthy }
    environment:
      AUTH_SERVICE_URL: http://auth-service:8082
      BOARD_SERVICE_URL: http://board-service:8081 
      TRUSTED_PROXIES: ".*"
      JAVA_OPTS: ${JAVA_OPTS}
    ports:
      - "127.0.0.1:8000:8000"   # ← 호스트의 Nginx만 접근 가능 (외부 X)

  web-service:
    <<: *common
    build: ../msa/web-service
    image: web-service:latest
    container_name: web-service
    environment:
      EDGE_SERVICE_URL: http://edge-service:8000
      JAVA_OPTS: ${JAVA_OPTS}
    ports:
      - "127.0.0.1:8080:8080"

volumes:
  board-uploads: {}
```
- docker 폴더 : vi docker-compose.aws.yml
- docker 폴더
```bash
cat <<'EOF' > .env
PUBLIC_HOST=<Elastic IP>
DB_HOST=10.0.11.x
DB_USER=app
DB_PASSWORD=1234
# 서비스당 JVM 메모리 제한 (5개 × ~300MB)
JAVA_OPTS=-Xms64m -Xmx256m -XX:MaxMetaspaceSize=160m -Xss512k -XX:+UseSerialGC -XX:TieredStopAtLevel=1
EOF
chmod 600 .env
```
- 배포 스크립트
```bash
cat <<'EOF' > deploy.sh
#!/bin/bash
# 사용법
#   ./deploy.sh                      전체 서비스 갱신
#   ./deploy.sh board-service        지정한 서비스만 갱신
set -e
cd "$(dirname "$0")"

COMPOSE="docker compose -f docker-compose.aws.yml"
SERVICES="${*:-config-service auth-service board-service edge-service web-service}"

echo "[1/4] 최신 코드 받기"
# --ff-only : 서버에서 코드를 고쳐서 GitHub과 갈라졌으면 병합하지 말고 실패시킨다
git pull --ff-only

echo "[2/4] 이미지 빌드 (메모리 때문에 하나씩)"
for s in $SERVICES; do
  echo "  - $s"
  $COMPOSE build "$s"
done

echo "[3/4] 컨테이너 교체"
$COMPOSE up -d $SERVICES

echo "[4/4] 이전 이미지 정리"
docker image prune -f

echo
$COMPOSE ps
EOF
```

## . 자원 삭제
- EC2(비용), NAT-GW(비용), EIP(비용), 
- 보안그룹, 키 페어
- VPC(subnet, igw, routing table) 
