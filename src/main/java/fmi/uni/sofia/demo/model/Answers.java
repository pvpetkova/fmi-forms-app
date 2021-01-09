package fmi.uni.sofia.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answers {
    @Id
    private Long answerId;
    private Long questionId;
    private String answerText;
    private boolean isCorrect;
}
