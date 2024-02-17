package io.github.marcot.studentservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class KafkaAdminConfig {

    private final KafkaProperties properties;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics newTopics() {
        if (!topicExists("student-topic")) {
            return new KafkaAdmin.NewTopics(
                    TopicBuilder.name("student-topic").partitions(2).build()
            );
        }
        return null;
    }

    // Método auxiliar para verificar se o tópico já existe
    private boolean topicExists(String topicName) {
        System.out.println("O topico já existe "+topicName);
        return false;
    }
}
