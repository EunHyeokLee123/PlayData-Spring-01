package com.study.springcore.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 빈 등록을 해야 요청이 들어왔을 때 메소드를 호출할 수 있음
// RestController 안에 있는 모든 메소드는 return 값이 json으로 변환되어
// 클라이언트에게 전송됨. -> 더이상 백엔드는 화면에 관여하지 않음.
@RestController
public class RestControllerTest {

    // json 형태로 웹페이지에 리턴함.
    @GetMapping("/rest/list")
    public List<String> method1(){
        List<String> list = List.of("hello","world","Spring", "boot", "yaho");
        return list;
    }

    @PostMapping("/rest/object")
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
    @PostMapping("/rest/regist")
    // @RequestBody를 붙여서 클라이언트가 전송한 JSON을
    // Java 객체로 변환할 수 있음.
    // 안붙이면 텅 빈 객체로 받음.
    public String method3(@RequestBody Person person){
        System.out.println("전달된 데이터는 " + person);
        return "ok!";
    }

}
