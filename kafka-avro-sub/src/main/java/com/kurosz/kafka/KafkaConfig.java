package com.kurosz.kafka;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import kafka.example.Cat;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    public ConsumerFactory<String, Cat> catConsumerFactory() {

        Map<String, Object> properties = new HashMap<>();

        properties.put("bootstrap.servers", "http://localhost:9092");
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "cat-client_id");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "cat-group-id");

        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        properties.put("schema.registry.url", "http://localhost:8081");

        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Cat> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Cat> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(catConsumerFactory());
        return factory;
    }

}
