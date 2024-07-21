package com.dinesh.question_microservice_app.DAO;


import com.dinesh.question_microservice_app.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Questionsrepo extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);


    @Query(value="SELECT q.id FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int num);


}
