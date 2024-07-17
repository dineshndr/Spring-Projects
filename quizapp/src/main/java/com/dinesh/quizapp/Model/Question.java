package com.dinesh.quizapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Question {
    @Id
    //private Integer Id;
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
