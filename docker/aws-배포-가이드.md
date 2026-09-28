
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