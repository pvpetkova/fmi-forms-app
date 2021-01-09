package fmi.uni.sofia.demo.repo;

import fmi.uni.sofia.demo.model.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Questions, Long> {
}
