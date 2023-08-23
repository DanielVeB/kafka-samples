package com.kurosz.kafka;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import kafka.example.Cat;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    public ProducerFactory<String, Cat> catProducerFactory() {

        Map<String, Object> properties = new HashMap<>();

        properties.put("bootstrap.servers", "http://localhost:9092");
        properties.put("acks", "all");
        properties.put("retries", "10");

        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", KafkaAvroSerializer.class.getName());
        properties.put("schema.registry.url", "http://localhost:8081");

        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, Cat> kafkaTemplate() {
        return new KafkaTemplate<String, Cat>(catProducerFactory());
    }

}
