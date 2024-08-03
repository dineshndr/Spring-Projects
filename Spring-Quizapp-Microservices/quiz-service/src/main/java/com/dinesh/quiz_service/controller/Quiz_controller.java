package com.dinesh.quiz_service.controller;

import com.dinesh.quiz_service.Model.QuestionWrapper;
import com.dinesh.quiz_service.Model.Quiz_Dto;
import com.dinesh.quiz_service.Model.Response;
import com.dinesh.quiz_service.service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Quiz_controller<QuizDto> {

    @Autowired
    Quiz_service quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody Quiz_Dto quizdto)
    {
        return quizService.createQuiz(quizdto.getCategoryName(), quizdto.getNumQuestions(), quizdto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizbyId(@PathVariable Integer id)
    {
        return quizService.getQuizbyId(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id, responses);
    }
}
