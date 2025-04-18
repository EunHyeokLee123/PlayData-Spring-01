package com.study.springcore.score.repository;

import com.study.springcore.score.entity.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Component처럼 빈등록하는 것은 동일하나,
// 이름으로 좀 더 클래스 역할을 명확하게 표시
@Repository
// final 변수 초기화 전용 생성자
@RequiredArgsConstructor
public class ScoreRepositoryImpl implements ScoreRepository {

    // Spring-jdbc의 핵심 객체 -> 의존성 객체 주입으로 받아와서 사용
    // 데이터베이스 접속 객체(COnnection)을 바로 활용하는 것이 가능
    // -> 미리 app.properties에 세팅했기에 Spring이 컴포넌트로 등록 해놓음
    // 자동 주입 하기

    // final 변수 초기화 전용 생성자 lombok을 사용하여
    // 반드시 생성이 되게 함. -> 무조건 주입이 됨 (안되면 프로젝트 실행이 안됨)
    private final JdbcTemplate template;

    @Override
    public void save(Score score) {
        String sql = "INSERT INTO scores " +
                "(stu_name, kor, eng, math, total, average, grade) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, score.getStuName(), score.getKor(), score.getEng(),
                score.getMath(), score.getTotal(),
                score.getAverage(), score.getGrade().toString());

    }

    @Override
    public List<Score> selectAll() {
        return List.of();
    }

    @Override
    public Score selectOne(int stuNum) {
        return null;
    }

    @Override
    public void delete(int stuNum) {
        String sql = "DELETE FROM scores WHERE stu_num = ?";
        template.update(sql, stuNum);
    }
}
