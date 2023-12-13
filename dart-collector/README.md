DART(전자공시) 정보를 수집하여 활용하는 시스템
======================================

- 스프링부트 2.7.10

선행조건
-------------

- 자바버전 `JDK 11` and `JAVA_HOME`

환경설정
-------------

application.properties 또는 프로필에 해당하는 *.properties 파일을 수정.

프로필 설정:

    - spring.profiles.active=prod

포트 설정:

    - server.port=8000

DB 설정:
    
    데이터베이스 시스템 IP, 데이터베이스명, 접속계정 설정

    - spring.datasource.url=jdbc:mariadb://localhost:3306/
    - spring.datasource.username=
    - spring.datasource.password=
    - spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

REDIS 설정:

    spring.redis.host=localhost
    spring.redis.port=6379

로그경로 설정:

    log.config.path=/tmp

마이바티스 설정 확인:
    
    - 파일: 

프로젝트 빌드
--------------------

프로젝트 실행:

    ./mvnw clean spring-boot:run

패키지 생성
-----------------------

To package the project run:

    ./mvnw clean package
