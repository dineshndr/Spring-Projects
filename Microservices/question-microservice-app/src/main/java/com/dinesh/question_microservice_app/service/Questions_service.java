package com.dinesh.question_microservice_app.service;

import com.dinesh.question_microservice_app.DAO.Questionsrepo;
import com.dinesh.question_microservice_app.Model.Question;
import com.dinesh.question_microservice_app.Model.QuestionWrapper;
import com.dinesh.question_microservice_app.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionsrepo.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numOfQuestions) {
        List<Integer> questions = questionsrepo.findRandomQuestionsByCategory(categoryName, numOfQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for(Integer id: questionIds)
        {
            questions.add(questionsrepo.findById(id).get());
        }
        for(Question question: questions)
        {
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }
        return new ResponseEntity<>(wrappers, HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {


            int right = 0;
            //int i = 0;
            for(Response response : responses){
                Question question = questionsrepo.findById(response.getId()).get();
                if(response.getResponse().equals(question.getRightAnswer()))
                    right++;

                //i++;
            }
            return new ResponseEntity<>(right, HttpStatus.OK);

    }
}
