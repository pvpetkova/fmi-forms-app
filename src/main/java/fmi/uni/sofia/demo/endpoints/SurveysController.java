package fmi.uni.sofia.demo.endpoints;


import fmi.uni.sofia.demo.model.*;
import fmi.uni.sofia.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/surveys")
public class SurveysController {

    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private SubmittedAnswerRepository submittedAnswerRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Survey getAllSurveys() {
        return surveyRepository.findById(1L).orElse(null);
    }

    @GetMapping(path = "/for-user/{username}")
    public @ResponseBody
    List<Survey> getAllSurveysForUser(@PathVariable(value = "username") String username) {
        User thisUser = userRepository.findByUsername(username);
        return surveyRepository.findByUserId(thisUser.getUserId());
    }

    @GetMapping(path = "/{surveyId}")
    public @ResponseBody
    Survey getSurveyById(@PathVariable(value = "surveyId") Long surveyId) {
        return surveyRepository.findById(surveyId).orElse(null);
    }

    @GetMapping(path = "/{surveyId}/answers-stat")
    public @ResponseBody
    Survey getAnswersCountForSurvey(@PathVariable(value = "surveyId") Long surveyId) {
        // TODO replace with new stats table
        return surveyRepository.findById(surveyId).orElse(null);
    }

    @GetMapping(path = "/{surveyId}/questions")
    public @ResponseBody
    List<Question> getQuestionsForSurvey(@PathVariable(value = "surveyId") Long surveyId) {
        return questionRepository.findAllBySurveyId(surveyId);
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Long addNewSurvey(@RequestBody Survey survey) {
        Survey insertedEntity = surveyRepository.save(survey);
        return insertedEntity.getSurveyId();
    }

    @PostMapping(path = "/add-question")
    public @ResponseBody
    Long addNewSurvey(@RequestBody Question question) {
        Question insertedEntity = questionRepository.save(question);
        return insertedEntity.getQuestionId();
    }

    @PostMapping(path = "/add-answers")
    public @ResponseBody
    String addNewSurvey(@RequestBody Answer answer) {
        answerRepository.save(answer);
        return "Saved";
    }

    @PostMapping(path = "/submit")
    public @ResponseBody
    String submitAnswers(@RequestBody List<SubmittedAnswer> answers) {
        Long randomUserId = (long) ((Math.random() * (1000)) + 1);
        answers.forEach(answer -> {
            answer.setUserKey(randomUserId);
            submittedAnswerRepository.save(answer);
        });
        return "Saved";
    }
}
