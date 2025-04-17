package com.study.springcore;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Component처럼 빈 등록한 것, 스피링이 이름을 통해 역할을 구분할 수 있음.
// @Controller

// 컨트롤러 역할 빈을 등록하겠다. REST 방식으로 응답하겠다~
@RestController
public class HomeController {

    // Spring이 @Controller가 붙은 메소드의 객체를 자동 생성해서
    // 아래의 메소드를 수행함.
    public HomeController() {
        System.out.println("컨트롤러가 생성이 됐네?");
    }

    // 아무것도 없는 주소가 localhost포트 뒤에 붙으면
    @GetMapping("/")
    public String home() {
        // 터미널에 해당 글을 출력하고
        System.out.println("서버에 요청이 들어옴~");
        // templates에 있는 home을 찾아서 브라우저에 띄움
        return "home";
    }

    @GetMapping("/55")
    public String hello() {
        // 터미널에 해당 글을 출력하고
        System.out.println("하이~~");
        // templates에 있는 home을 찾아서 브라우저에 띄움
        return "hello";
    }

}
