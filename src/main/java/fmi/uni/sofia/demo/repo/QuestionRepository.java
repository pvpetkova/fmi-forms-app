package fmi.uni.sofia.demo.repo;

import fmi.uni.sofia.demo.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findAllBySurveyId(Long surveyId);
}
