package com.kurosz.controller;

import com.kurosz.dto.CatDto;
import com.kurosz.kafka.AvroPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("avro")
@Slf4j
public class CatController {

    private final AvroPublisher avroPublisher;

    public CatController(AvroPublisher avroPublisher) {
        this.avroPublisher = avroPublisher;
    }

    @PostMapping
    public String registerNewCat(@RequestBody CatDto catDto){
        log.info("Register cat with name {}, breed: {}", catDto.getName(), catDto.getBreed());
        avroPublisher.publishMessage(catDto);
        return "Registered";
    }


}
