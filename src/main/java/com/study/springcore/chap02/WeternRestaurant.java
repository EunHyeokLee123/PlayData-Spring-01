package com.study.springcore.chap02;

public class WeternRestaurant implements Restaurant {

    private JohnChef chef = new JohnChef();

    private WesterCourse course = new WesterCourse();

    public void order(){
        System.out.println("안녕하세요. 서양 레스토랑입니다.");
        chef.cook();
        course.combineMenu();
    }

}
