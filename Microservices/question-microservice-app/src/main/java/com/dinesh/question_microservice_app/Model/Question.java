package com.dinesh.question_microservice_app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Question {
    @Id
    private Integer Id;
    @Column(name = "question_title")
    private String questionTitle;

    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @Column(name = "right_answer")
    private String rightAnswer;
}
