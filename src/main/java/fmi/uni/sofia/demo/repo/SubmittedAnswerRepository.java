package fmi.uni.sofia.demo.repo;

import fmi.uni.sofia.demo.model.SubmittedAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubmittedAnswerRepository extends CrudRepository<SubmittedAnswer, Long> {

    @Query("select count(s.submitId) from submitted s where s.answerId = :answerId and s.questionId = :questionId and s.surveyId = :surveyId")
    Integer count(@Param("answerId") Long answerId, @Param("questionId") Long questionId, @Param("surveyId") Long surveyId);
}
