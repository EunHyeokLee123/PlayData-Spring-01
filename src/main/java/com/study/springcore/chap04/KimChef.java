package com.study.springcore.chap04;

import org.springframework.stereotype.Component;

// 같은 타입의 객체를 여러 개 등록할 때는 별칭을 지어주는 게 좋음
@Component("kim")
public class KimChef implements Chef {

    public void cook(){
        System.out.println("안녕하세요. 셰프 킴입니다.");
        System.out.println("요리를 시작할게요.");
    }

}
