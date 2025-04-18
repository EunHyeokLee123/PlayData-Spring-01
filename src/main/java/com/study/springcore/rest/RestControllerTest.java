package com.study.springcore.rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// 빈 등록을 해야 요청이 들어왔을 때 메소드를 호출할 수 있음
// RestController 안에 있는 모든 메소드는 return 값이 json으로 변환되어
// 클라이언트에게 전송됨. -> 더이상 백엔드는 화면에 관여하지 않음.
@RestController
@RequestMapping("/rest") // 이 controller는 /rest url을 처리할것이다~
// 이 클래스의 메소드는 /rest를 생략해도 됨.
public class RestControllerTest {

    // json 형태로 웹페이지에 리턴함.
    @GetMapping("/list")
    public List<String> method1(){
        List<String> list = List.of("hello","world","Spring", "boot", "yaho");
        return list;
    }

    @PostMapping("/object")
    public Person method2(){
        Person person = new Person();
        person.setName("김춘식");
        person.setAge(30);
        person.setHobbies(List.of("놀기","밥먹기","독서"));

        return person;
    }

    // 클라이언트(리엑트)단에서 JSON 데이터를 보내고 있다.
    // 1. JSON 형태로 생긴 클래스가 있다? -> 그 객체로 받으면 되고
    // 2. JSON 형태로 생긴 클래스가 없다? ->
    // Map으로 받으면 된다.(단, <String, Object>로 받아야함)
    @PostMapping("/regist")
    // @RequestBody를 붙여서 클라이언트가 전송한 JSON을
    // Java 객체로 변환할 수 있음.
    // 안붙이면 텅 빈 객체로 받음.
    public String method3(@RequestBody Person person){
        System.out.println("전달된 데이터는 " + person);
        return "ok!";
    }

    // /rest/posts/에 해당하는 모든 url을 처리하려고 하기 위해 사용
    // posts/뒤에 붙는 url을 bno로 지정한 것임
    @GetMapping("/{userId}/posts/{bno}")
    // @PathVariable: url에 포함되어 있는 특정한 값을 얻어옴.
    // 찾을 변수가 주소의 별칭과 같다면 굳이 지칭하지 않아도됨.
    public String method4(@PathVariable("bno") String bno,
                          @PathVariable String userId){
        System.out.println("bno의 값은 : " + bno);
        System.out.println("userId의 값은 : " + userId);
        return "ok~~";
    }


    // 쿼리 스트링(쿼리 파라미터)로 전달되는 데이터 받기
    @GetMapping("/posts")
    public String method5(@RequestParam String category,
                          @RequestParam("sort") String s,
                          @RequestParam String keyword){
        System.out.println("category는 " + category);
        System.out.println("sort는 " + s);
        System.out.println("keyword는 " + keyword);
        return "잘 왔네~~~";
    }

    // localhost:8181/orders?orderNum=22&goods=구두&price=20000&amout=3...
    // class를 새로 선언해서 객체 형태로 받자.
    @GetMapping("/orders")
    // 커맨드 객체 (DTO) 사용해서 쿼리 파라미터 처리하기~
    // 쿼리 파라미터의 키 값을 DTO의 필드명과 맞춰줘야
    // Setter가 정상적으로 호출이 된다.
    public String method6(OrderDTO orderDTO){

        System.out.println("dto = " + orderDTO);
        return "6번도 잘됨~~";
    }
}
