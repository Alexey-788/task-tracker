package com.alex788.pets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardDto {

    private long id;
    private String title;
    private boolean favorite;
    private long creationTime;
}
