package fmi.uni.sofia.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Surveys {
    @Id
    private Long surveyId;
    private String surveyName;
    private Long userId;
}
