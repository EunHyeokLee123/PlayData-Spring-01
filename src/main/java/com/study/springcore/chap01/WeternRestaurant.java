package com.study.springcore.chap01;

public class WeternRestaurant {

    private JohnChef chef = new JohnChef();

    private WesterCourse course = new WesterCourse();

    public void order(){
        System.out.println("안녕하세요. 서양 레스토랑입니다.");
        chef.cook();
        course.combineMenu();
    }

}
