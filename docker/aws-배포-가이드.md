
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
- 탄력적 IP 생성 및 할당
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
scp -i ~/Desktop/msa-key.pem ~/Desktop/msa-key.pem ubuntu@15.164.188.158:~/

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
