package com.dinesh.quizapp.controller;

import com.dinesh.quizapp.Model.QuestionWrapper;
import com.dinesh.quizapp.service.Quiz_service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Quiz_controller {

    @Autowired
    Quiz_service quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title)
    {
        return quizService.createQuizbyCategory(category, num, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizbyId(@PathVariable Integer id)
    {
        return quizService.getQuizbyId(id);
    }
}
