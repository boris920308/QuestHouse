#!/bin/bash

VALID_DIRS=("Q_001" "hoon")

# 스크립트 실행시 몇번 Quest인지 입력받음
while true; do
  read -p "몇번 Quest를 실행할거야? ex) Q_001 : " BASE_DIR
  
  #유효성 확인 
  if [[ " ${VALID_DIRS[@]} " =~ " ${BASE_DIR} " ]]; then
    break
  else
    echo "그건 유효하지 않은 Quest인디 ?? "
  fi
done


# config
source sh/./${BASE_DIR}_config.sh

# 클래스 파일의 이름을 추출합니다 (파일명에서 .java 확장자 제거)
CLASS_NAME=$(basename "$JAVA_FILE" .java)

# Java 파일 컴파일
javac "$JAVA_FILE"

# 실행
if [ $? -eq 0 ]; then
  echo " - - - - Solution1.class - - - - "
  echo " input1 = 472, input2 = 385"
  echo " - - - - Result - - - - "
  SOLUTION1_OUTPUT=$(echo -e "472\n385" | java -cp "$CLASS_DIR" "$CLASS_NAME")

  if [ "$SOLUTION1_OUTPUT" == "$CASE1_SOLUTION" ]; then
    echo -e "Solution1 . . . . . . . . [ \e[32mpass\e[0m ]"
  else 
    echo -e "Solution1 . . . . . . . . [ \e[31mfail\e[0m ]"
    echo "실제 출력값:"
    echo "$SOLUTION1_OUTPUT"
    echo "기대값:"
    echo "$CASE1_SOLUTION"
  fi

  # Solution1.class 파일 삭제
  rm "$CLASS_DIR/${CLASS_NAME}.class"
  echo "Solution1.class 파일이 삭제되었습니다."

else
  echo "컴파일 오류 발생"
fi
