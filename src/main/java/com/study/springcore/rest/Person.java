package com.study.springcore.rest;


import lombok.*;

import java.util.List;

// lombok을 통해 실제로 작성하지 않아도, getter/setter/toString/생성자를 만들 수 있음.
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private int age;
    private List<String> hobbies;



}
