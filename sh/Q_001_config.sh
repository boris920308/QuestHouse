# config.sh

VALID_NAMES=("chan" "chung" "hoon")

# 디렉토리 이름 입력받기
while true; do
  read -p "누구의 코드를 실행할거야? : " USER_NAME

  # 입력값이 유효한지 확인
  if [[ " ${VALID_NAMES[@]} " =~ " ${USER_NAME} " ]]; then
    break
  else
    echo "그런놈은없어."
  fi
done

# Q001_solution
CASE1_SOLUTION=$(echo -e "2360\n3776\n1416\n181720")

# chung
CLASS_DIR="$BASE_DIR/$USER_NAME"
JAVA_FILE="$CLASS_DIR/Solution1.java"
