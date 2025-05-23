package com.study.springcore.chap04;

import org.springframework.stereotype.Component;

@Component("western")
public class WesternCourse implements Course {

    public void combineMenu() {
        System.out.println("====== 서양 코스 구성 ======");
        System.out.println("1. 제철 채소, 퀴노아");
        System.out.println("2. 트러플 크림 스프");
        System.out.println("3. 참돔 포와레");
        System.out.println("4. 한우 살치살 스테이크");
        System.out.println("5. 프렌치 랙");
        System.out.println("6. 조리장 특제 마카롱");
    }

}
