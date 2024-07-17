package com.dinesh.quizapp.DAO;

import com.dinesh.quizapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Questionsrepo extends JpaRepository<Question, Integer> {

}
