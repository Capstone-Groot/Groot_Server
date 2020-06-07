# Groot_Server
I'm Groot 팀 서버 구축을 위한 레파지토리

### 사용 목적
- Groot 안드로이드에서 사용하는 DB, 로그인 기능, AI 모델과의 통신.. 등등 비즈니스 로직을 담당하기 위한 서버

### Technology
- java8
- Spring Boot
- h2 DataBase

### Install
```java
git clone https://github.com/Capstone-Groot/Groot_Server.git
cd Groot_Server 
./gradelw build 
cd build/libs
java -jar demo-0.0.1-SNAPSHOT.jar 
```

### 구현 기능
- 로그인 / 사용자 인증
- AI Model과 API 통신
- 사진 저장/불러오기
- 관리자(꽃집)을 위한 기능
- 검색 기록 조회 기능
- ....
