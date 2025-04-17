package com.study.springcore.chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("west")
public class WeternRestaurant implements Restaurant {

    private Chef chef;
    private Course course;

    // 필요한 객체를 자동으로 주입하겠다는 어노테이션
    // 같은 타입의 객체를 여러 개 등록할 때는 별칭을 지어주는 게 좋음
    // 클래스의 생성자가 단 한개뿐이라면 자동으로 Autowired가 됨
    // 고로 생략해도 됨.
    @Autowired
    public WeternRestaurant(@Qualifier("john") Chef chef,
                           @Qualifier("western") Course course) {
        this.chef = chef;
        this.course = course;
    }


    public void order(){
        System.out.println("안녕하세요. 서양 레스토랑입니다.");
        chef.cook();
        course.combineMenu();
    }

}
