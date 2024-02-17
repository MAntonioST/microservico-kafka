package io.github.marcot.consumer.service;

import io.github.marcot.consumer.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SudentServiceListener {

    @KafkaListener(topics = "student-topic", groupId = "student-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeMessage(@Payload Student student){
        log.info("Reading student {}", student);
    }
}
