package com.dinesh.quizapp.service;

import com.dinesh.quizapp.DAO.Questionsrepo;
import com.dinesh.quizapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class Questions_service {
    @Autowired
    Questionsrepo questionsrepo;

    public List<Question> getAllQuestions()
    {
        return questionsrepo.findAll();
    }

    public Question add_question(@RequestBody Question question)
    {
        return questionsrepo.save(question);
    }
}
