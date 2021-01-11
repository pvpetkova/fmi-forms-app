package fmi.uni.sofia.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "surveys")
public class Survey {
    @Id
    private Long surveyId;
    private String surveyName;
    private Long userId;
//    @OneToMany()
//    @JoinColumn(name = "survey_id")
//    private List<Questions> questions;
}
