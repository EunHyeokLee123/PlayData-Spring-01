package com.study.springcore.chap04.config;


import com.study.springcore.chap04.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 스프링 관련 설정 클래스
@Configuration
// 지정한 패키지 내에 있는 @Component 붙은 객체들을 전부 스캔해서
// 스프링 컨테이너에 등록시키겠다.
@ComponentScan(basePackages = "com.study.springcore.chap04")
public class AppConfig {




}
