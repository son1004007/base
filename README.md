# 기본 프로젝트
이 문서는 공통을 위주로 작성된 기본 프로젝트 입니다.  
추후 프로젝트 진행 시 이 프로젝트를 기준으로 코드를 작성해서 납품할 수 있도록 합니다.

## 1. 요구 사항
아래의 요구 사항을 충족해야 합니다.
- JDK(Java Development Kit) 8 설치
- IntelliJ 또는 기타 Java 개발 도구 설치
- Git 설치
- MySQL 데이터베이스 설치 // 플젝별 버전 확인 필요


## 2. 소스 코드 다운로드
Git Address : 

## 3. 프로젝트 실행
1) 서버에서 명령어 실행 :
- JVM_OPTS="-Xms1g -Xmx1g"
- 설명 : $JVM_OPTS 를 JVM 환경변수로 이용하여, APP_HOME/base.jar 위치의 파일을 /home/user/base/conf/application_dev.properties 설정의 속성 값으로 실행
- 개발(로컬)서버 : java $JVM_OPTS -jar base.jar --spring.config.location=/home/user/base/conf/application_dev.properties
- 운영서버 : java $JVM_OPTS -jar base.jar --spring.config.location=/home/user/base/conf/application_prod.properties
 
=======
# base
기본은 해보자