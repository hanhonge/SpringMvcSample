####이 샘플의 목적은
 - spring + mvc + junit + h2 + mybatis 을 사용하여 기본적인 웹 개발 환경을 구성한다.

####프로젝트 생성 후 변경항목 정리
 + 이클립스 가독성 증대를 위한 폰트 및 배경색상 변경 완료
  - 이클립스 마켓플레이스에서 DevStyle 검색후 Darkest Dark Theme with DevStyle 2020.7.20 install 함
  - 참고링크   
    https://choseongho93.tistory.com/14

 + 마크다운(markdown) 에디터 플러그인 설치 완료
  - 이 문서를 작성할때 사용하기 위한 용도.
  - 설치한 플러그인 정보(https://github.com/winterstein/Eclipse-Markdown-Editor-Plugin)
  - 참고링크   
    https://theorydb.github.io/envops/2019/05/22/envops-blog-how-to-use-md/

 + spring 버전 변경
  - 2020.11.01 기준) 최신 버전 5.3.0(https://spring.io/projects/spring-framework)으로 변경
  - pom.xml 파일 수정 
    `<org.springframework-version>5.3.0</org.springframework-version>`

 + H2 설치 및 연동 설정
  - 테스트 용도로 사용하기에 가볍고 설치가 쉽기 때문에 유용하다.
  - 설치 참고링크(https://atoz-develop.tistory.com/entry/H2-Database-%EC%84%A4%EC%B9%98-%EC%84%9C%EB%B2%84-%EC%8B%A4%ED%96%89-%EC%A0%91%EC%86%8D-%EB%B0%A9%EB%B2%95)

 + root-context.xml 파일 위치 변경(src/main/resources/spring)
  - dataSource 및 myBaties 설정 추가
 
 + @RestController 응답값 json 변환 설정
  - pom.xml 에 jackson-databind,core,annotations 만 추가하면 된다.  
    (별도 xml 파일에 convert 관련 설정값을 필요 없음)
    
 + junit 설정
  - src/main/resources 를 복사하여 구성함.
  
 + logback 적용(2020.11.10)
  - spring 프로젝트 생성시 log4j 기준으로 셋팅된거 모두 제거
  - pom.xml dependency에는 jcl-over-slf4j, logback-classic 만 지정
    * 참고 https://yookeun.github.io/java/2015/11/10/log4jtologback/
  - console, file 로 로그저장 설정 추가 
 
 + web.xml 수정(2020.11.10)
  - <filter> 태그 auto-complete 지원이 안되어서 xml schema 변경.
     아래 내용으로 수정함
     <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
     </web-app>
     * 참고  
       https://antoniogoncalves.org/2013/06/04/java-ee-7-deployment-descriptors/
       
 + h2 메모리 db dirver not found 대처(2020.11.11)
  - pom.xml dependency h2 scope compile 변경
  - h2 driver .jar 파일 라이브러리로 추가
  
 + filter 추가(2020.11.11)
  - web.xml 에 filter 등록
  - root-context.xml 에 filter bean 등록
  
 + 인터셉터 추가(2020.11.11)
  - servlet-context.xml 에 bean 및 인터셉터 추가

 + JWT(Json Web Token) 샘플추가(2020.11.12)
  - JwtTokenFactory 토큰 생성 및 파싱
  - JwtResult 토큰 처리 결과 관련 메세지 처리
  * 참고  
    https://devkingdom.tistory.com/113  
    https://jamcode.tistory.com/m/45  
    https://www.codota.com/code/java/methods/io.jsonwebtoken.JwtBuilder/setClaims  
    