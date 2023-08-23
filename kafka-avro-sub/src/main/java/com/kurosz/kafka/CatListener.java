package com.kurosz.kafka;

import kafka.example.Cat;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CatListener {

    @KafkaListener(topics = "cat-output", groupId = "cat-group-id")
    public void listen(ConsumerRecord<String, Cat> message) {
        log.info("Registered cat: {}", message.value());
    }

}
