package fmi.uni.sofia.demo;

import fmi.uni.sofia.demo.repo.UserRepository;
import fmi.uni.sofia.demo.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SurveyMakerTests {
    @Autowired
    MailService mailService;

    @Autowired
    UserRepository userRepository;

    @Test
    void testSendingMail() {
        mailService.sendEmailToEveryone();
    }

    @Test
    void testSurveyStat() {
        Integer count = userRepository.findCount("drawingllamas@gmail.com");
        System.out.println(count);
    }
}
