package io.github.marcot.studentservice.config;

import java.util.HashMap;
import java.util.Map;

import io.github.marcot.studentservice.model.Student;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer; // Importe a classe correta aqui

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JsonProducerConfig {

    private final KafkaProperties properties;

    @Bean
    public ProducerFactory<String, Student> producerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Use a classe correta aqui

        // Adicione configurações adicionais do produtor, se necessário

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, Student> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
