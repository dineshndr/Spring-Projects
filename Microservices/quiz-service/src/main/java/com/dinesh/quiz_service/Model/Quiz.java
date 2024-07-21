package com.dinesh.quiz_service.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.bouncycastle.util.Integers;

import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    // private String quizCategory;

    private String title;
    @ElementCollection
    private List<Integer> questionIds;
}
