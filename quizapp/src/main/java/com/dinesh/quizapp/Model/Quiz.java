package com.dinesh.quizapp.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    // private String quizCategory;

    private String title;
    @ManyToMany
    private List<Question> questions;
}
