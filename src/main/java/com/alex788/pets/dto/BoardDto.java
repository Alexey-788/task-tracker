package com.alex788.pets.dto;

import com.alex788.pets.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardDto {

    private final long id;
    private final String title;
    private final boolean favorite;
    private final long creationTimeInMillis;

    public BoardDto(BoardEntity boardEntity) {
        this.id = boardEntity.getId();
        this.title = boardEntity.getTitle();
        this.favorite = boardEntity.isFavorite();
        this.creationTimeInMillis = boardEntity.getCreationDate().getTime();
    }
}
