package fmi.uni.sofia.demo.endpoints;


import fmi.uni.sofia.demo.model.Question;
import fmi.uni.sofia.demo.model.Survey;
import fmi.uni.sofia.demo.model.User;
import fmi.uni.sofia.demo.repo.QuestionRepository;
import fmi.uni.sofia.demo.repo.SurveyRepository;
import fmi.uni.sofia.demo.repo.UserRepository;
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
    String addNewSurvey(@RequestBody Survey survey) {
        surveyRepository.save(survey);
        return "Saved";
    }

    @PostMapping(path = "/add-question")
    public @ResponseBody
    String addNewSurvey(@RequestBody Question question) {
        questionRepository.save(question);
        return "Saved";
    }
}
