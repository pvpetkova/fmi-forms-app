package fmi.uni.sofia.demo.repo;

import fmi.uni.sofia.demo.model.Survey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyRepository extends CrudRepository<Survey, Long> {

    public List<Survey> findByUserId(Long userId);
}
