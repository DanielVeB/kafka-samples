package com.kurosz.kafka;

import com.kurosz.dto.CatDto;
import kafka.example.Breed;
import kafka.example.Cat;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AvroPublisher {

    private final KafkaTemplate<String, Cat> kafkaTemplate;

    public AvroPublisher(KafkaTemplate<String, Cat> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(CatDto catDto) {

        var cat = new Cat(Breed.valueOf(catDto.getBreed().toString()), catDto.getName(), catDto.getExtra());

        kafkaTemplate.send("cat-output", cat);

    }

}
