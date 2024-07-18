package com.dinesh.quizapp.DAO;

import com.dinesh.quizapp.Model.Question;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Questionsrepo extends JpaRepository<Question, Integer> {
    @Query(value="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Question> createQuizbyCategory(String category, Integer num);
}
