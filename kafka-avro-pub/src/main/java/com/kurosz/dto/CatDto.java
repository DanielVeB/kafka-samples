package com.kurosz.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CatDto {



    private Breed breed;
    private String name;
    private String extra;
}

