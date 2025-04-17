package com.study.springcore.chap03.config;


import com.study.springcore.chap03.*;

// 객체 생성의 제어권을 모두 이 클래스에 작성할 예정
public class AppConfig {

    public Chef chef1(){
        return new KimChef();
    }

    public Chef chef2(){
        return new JohnChef();
    }

    public Course course1(){
        return new SushiCourse();
    }

    public Course course2(){
        return new WesternCourse();
    }

    public Restaurant restaurant1(){
        return new WeternRestaurant(chef2(), course2());
    }

    public Restaurant restaurant2(){
        return new AsianRestaurant(chef1(), course1());
    }

    public Hotel hotel(){
        return new Hotel(restaurant1(), chef2());
    }
}
