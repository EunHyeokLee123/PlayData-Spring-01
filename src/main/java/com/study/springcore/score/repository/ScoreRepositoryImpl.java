package com.study.springcore.score.repository;

import com.study.springcore.score.entity.Grade;
import com.study.springcore.score.entity.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// @Component처럼 빈등록하는 것은 동일하나,
// 이름으로 좀 더 클래스 역할을 명확하게 표시
@Repository
// final 변수 초기화 전용 생성자
@RequiredArgsConstructor
public class ScoreRepositoryImpl implements ScoreRepository {

    class ScoreRowMapper implements RowMapper<Score> {
        // ResultSet은 sql의 실행 결과를 들고 있습니다.
        // 타겟을 한 행씩 지목하면서 컬럼값을 가져올 수 있습니다.
        // 한 행의 데이터를 어떤 객체로 포장할 것인지는 우리가 정의해야 함.
        @Override
        public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
            Score score = new Score(
                    rs.getInt("stu_num"),
                    rs.getString("stu_name"),
                    rs.getInt("kor"),
                    rs.getInt("eng"),
                    rs.getInt("math"),
                    rs.getInt("total"),
                    rs.getDouble("average"),
                    Grade.valueOf(rs.getString("grade"))
            );
            return score;
        }
    }

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
        String sql = "SELECT * FROM scores";
        // query: 여러 행을 조회해야 할 때 사용, 매개값으로 sql과 RowMapper의 구현체 전달
        // JdbcTemplate은 ScoreMapper에 있는 mapRow 메소드를 통해 한 행씩 객체를 포장
        List<Score> query = template.query(sql, new ScoreRowMapper());
        return query;
    }

    @Override
    public Score selectOne(int stuNum) {
        String sql = "SELECT * FROM scores WHERE stu_num = ?";
        // 한 행 조회시에는 queryForObject를 사용함.
        // 조회된 결과를 포장하는 것은 동일하기 때문에 ScoreMapper를 사용합니다.
        Score score = template.queryForObject(sql, new ScoreRowMapper(), stuNum);
        return score;
    }

    @Override
    public void delete(int stuNum) {
        String sql = "DELETE FROM scores WHERE stu_num = ?";
        template.update(sql, stuNum);
    }
}
