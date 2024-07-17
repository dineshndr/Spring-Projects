package com.dinesh.quizapp.controller;

import com.dinesh.quizapp.Model.Question;
import com.dinesh.quizapp.service.Questions_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
public class Questions_controller {

    @Autowired
    Questions_service service ;

    @PostMapping("/AddQuestion")
    public Question add_question(@RequestBody Question question)
    {
        return service.add_question(question);
    }
    //Read
    @GetMapping("/AllQuestions")
    public List<Question> get_questions()
    {
        return service.getAllQuestions();
    }

    @GetMapping("/error")
    public String show_error(){
        return "error";
    }
}
