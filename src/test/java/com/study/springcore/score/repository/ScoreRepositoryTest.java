package com.study.springcore.score.repository;

import com.study.springcore.score.entity.Grade;
import com.study.springcore.score.entity.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        Score score = new Score("김민철", 50, 60, 70);
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

    @Test
    @DisplayName("기존의 성적을 stu_num으로 삭제한다.")
    void deleteTest() {
        int stuNum = 1;
        repository.delete(stuNum);
    }

    @Test
    @DisplayName("scores 테이블의 모든 학생을 조회했을 때, 학생 수는 3명 일 것이다.")
    void selectAllTest() {
        // given: 준비단계 -> 테스트에 사용할 변수, 입력값 등을 정의하는 곳

        // when: 실행단계 -> 테스트를 실행하는 메인 로직
        String sql = "SELECT * FROM scores";
        List<Score> scoreList = repository.selectAll();
        // then: 검증단계 -> 예상한 값, 실제 실행한 값을 확인하는 부분
        scoreList.forEach(System.out::println);
        // Assertions 클래스가 제공하는 메소드를 통해 (단언 기법) 테스트 통과 조건을 설정
        assertEquals(scoreList.size(), 3);

    }

    @Test
    @DisplayName("3번 학생의 이름은 김민식일 것 이다.")
    void findOneTest() {
        // given
            int stuNum = 3;
        // when
        String name = repository.selectOne(stuNum).getStuName();

        // then
        assertEquals("김민식", name);
    }
    
}