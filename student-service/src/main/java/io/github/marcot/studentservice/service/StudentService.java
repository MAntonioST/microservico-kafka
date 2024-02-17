package io.github.marcot.studentservice.service;


import io.github.marcot.studentservice.model.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final KafkaTemplate<String, Student> kafkaTemplate;
     
    public void sendMessage(Student student){
        log.info("Sending message to kafka {}", student);
        kafkaTemplate.send("student-topic", student);

    }
}
