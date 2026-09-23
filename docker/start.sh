#!/bin/bash 
# #!/bin/bash : 셔뱅이라고 한다. "이 파일을 /bin/bash"로 실행하라는 의미이다.
# 실행 방법 : ./start.sh

# -e : 명령어 하나라도 실패하면 즉시 중단한다.
# data가 실패했는데 service를 실행하면 안되기 때문에 -e 옵션을 사용한다.
set -e
