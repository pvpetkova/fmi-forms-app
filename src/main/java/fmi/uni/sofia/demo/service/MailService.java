package fmi.uni.sofia.demo.service;

import fmi.uni.sofia.demo.model.User;
import fmi.uni.sofia.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class MailService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Scheduled(cron = "0 0 10 * * 1")
    public void sendEmailToEveryone() {
        Iterable<User> allUsers = userRepository.findAll();
        allUsers.forEach(user -> {
            Integer count = userRepository.findCount(user.getEmail());
            String message = "Prez poslednata sedmica vashite anketi sa otgovoreni " + count + "puti. ";
            if (user.getEmail() != null) {
                sendEmail(user.getEmail(), message);
            }
        });
    }

    private void sendEmail(String email, String messageText) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailUsername);
        message.setTo(email);
        message.setSubject("Sedmichna statistika za vashite anketi");
        message.setText(messageText);
        javaMailSender.send(message);
    }
}
