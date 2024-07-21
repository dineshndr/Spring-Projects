package com.dinesh.quizapp.service;

import com.dinesh.quizapp.DAO.Questionsrepo;
import com.dinesh.quizapp.DAO.QuizDao;
import com.dinesh.quizapp.Model.Question;
import com.dinesh.quizapp.Model.QuestionWrapper;
import com.dinesh.quizapp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Quiz_service {
    @Autowired
    QuizDao quizdao;


    @Autowired
    Questionsrepo questionsrepo;

    public ResponseEntity<String> createQuizbyCategory(String category,Integer num,String title)
    {
        List<Question> questions  = questionsrepo.createQuizbyCategory(category, num);
        Quiz quiz  = new Quiz();
        //quiz.setQuizCategory(category);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizbyId(Integer id)
    {
        List<QuestionWrapper> qw_list = new ArrayList<>();
        Optional<Quiz> quiz = quizdao.findById(id);
        List<Question> questionsfromDB = quiz.get().getQuestions();
        for(Question q: questionsfromDB)
        {
            QuestionWrapper qew = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            qw_list.add(qew);
        }

        return new ResponseEntity<>(qw_list, HttpStatus.OK);
    }




}
