package com.dinesh.question_microservice_app.controller;


import com.dinesh.question_microservice_app.Model.Question;
import com.dinesh.question_microservice_app.Model.QuestionWrapper;
import com.dinesh.question_microservice_app.Model.Response;
import com.dinesh.question_microservice_app.service.Questions_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category);
    }

    //generate
    //get Questions (quiz id)
    //get score
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numOfQuestions)
    {
        return service.getQuestionsForQuiz(categoryName, numOfQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds)
    {
        return service.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return service.getScore(responses);
    }
}
