package com.alex788.pets.dto;

import com.alex788.pets.entity.CardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardDto {

    private final long id;
    private final String title;
    private final String description;

    public CardDto(CardEntity cardEntity) {
        this.id = cardEntity.getId();
        this.title = cardEntity.getTitle();
        this.description = cardEntity.getDescription();
    }
}
