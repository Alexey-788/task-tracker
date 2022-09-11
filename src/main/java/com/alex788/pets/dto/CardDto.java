package com.alex788.pets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CardDto {

    private long id;
    private String title;
    private String description;
}
