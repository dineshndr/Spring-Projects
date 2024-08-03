package com.dinesh.quiz_service.service;


import com.dinesh.quiz_service.DAO.QuizDao;
import com.dinesh.quiz_service.Model.QuestionWrapper;
import com.dinesh.quiz_service.Model.Quiz;
import com.dinesh.quiz_service.Model.Response;
import com.dinesh.quiz_service.feign.QuizInterface;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Quiz_service {
    @Autowired
    QuizDao quizdao;

    @Autowired
    QuizInterface quiz_interface;

//    @Autowired
//    Questionsrepo questionsrepo;

    public ResponseEntity<String> createQuiz(String category, Integer num, String title) {
        List<Integer> questions = quiz_interface.getQuestionsForQuiz(category, num).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizdao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizbyId(Integer id) {
        //List<QuestionWrapper> qw_list = new ArrayList<>();
        Quiz quiz = quizdao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quiz_interface.getQuestionsFromId(questionIds);
        return questions;
    }
//        List<Question> questionsfromDB = quiz.get().getQuestions();
//        for(Question q: questionsfromDB)
//        {
//            QuestionWrapper qew = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//            qw_list.add(qew);
//        }


//
//        return new ResponseEntity<>(qw_list, HttpStatus.OK);
//    }


    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//       // Quiz quiz = quizdao.findById(id).get();
//
//
//       // List<Question> questions = quiz.getQuestions();
//        int right = 0;
////        int i = 0;
////        for (Response response : responses) {
////            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
////                right++;
////            i++;
////        }
        //return  new ResponseEntity<>(right, HttpStatus.OK);
        ResponseEntity<Integer> score = quiz_interface.getScore(responses);
     return score;
    }


}

