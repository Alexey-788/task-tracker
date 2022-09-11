package com.alex788.pets.dto;

import com.alex788.pets.entity.CardEntity;
import com.alex788.pets.entity.CardGroupEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CardGroupDto {

    private final long id;
    private final String title;
    private final List<CardDto> cards = new ArrayList<>();

    public CardGroupDto(CardGroupEntity cardGroupEntity) {
        this.id = cardGroupEntity.getId();
        this.title = cardGroupEntity.getTitle();
        for(CardEntity cardEntity : cardGroupEntity.getCards()) {
            cards.add(new CardDto(cardEntity));
        }
    }
}