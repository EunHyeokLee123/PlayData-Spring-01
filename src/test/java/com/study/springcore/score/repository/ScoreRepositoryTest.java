package com.study.springcore.score.repository;

import com.study.springcore.score.entity.Grade;
import com.study.springcore.score.entity.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// 스프링 컨테이너에 등록된 빈을 이 테스트 클래스에서 활용하겠다는 선언
@SpringBootTest
class ScoreRepositoryTest {

    @Autowired // 테스트 클래스는 객체가 생성되지 않음 -> 생성자 호출 안됨
            // -> 직접 필드 주입 해야 함.
    ScoreRepository repository;

    @Test
    @DisplayName("새로운 성적 정보를 save를 통해 추가한다.")
    void saveTest(){
        Score score = new Score("김춘식", 70, 80, 90);
        score.setTotal(score.getKor() +  score.getEng() + score.getMath());
        score.setAverage(score.getTotal() / 3.0);

        if(score.getAverage() >= 90 ){
            score.setGrade(Grade.A);
        }
        else if(score.getAverage() >= 80 ){
            score.setGrade(Grade.B);
        }
        else if(score.getAverage() >= 70 ){
            score.setGrade(Grade.C);
        }
        else if(score.getAverage() >= 60 ){
            score.setGrade(Grade.D);
        }
        else{
            score.setGrade(Grade.F);
        }

        repository.save(score);
    }

}