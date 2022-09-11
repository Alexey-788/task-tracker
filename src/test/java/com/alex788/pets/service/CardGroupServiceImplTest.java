package com.alex788.pets.service;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.entity.CardGroupEntity;
import com.alex788.pets.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class CardGroupServiceImplTest {

    @Autowired
    CardGroupService cardGroupService;

    @MockBean
    BoardService boardService;

    @Test
    void getAllByBoardId_AllDataIsCorrect_ReturnsRightCardGroupList() {
        final long boardId = 10;

        List<CardGroupEntity> expected = List.of(new CardGroupEntity(), new CardGroupEntity());
        when(boardService.getById(boardId)).thenReturn(new BoardEntity(boardId, null, expected, null, false, null));

        List<CardGroupEntity> actual = cardGroupService.getAllByBoardId(boardId);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllByBoardId_BoardHasNoCardGroup_ReturnsEmptyCardGroupList() {
        final long boardId = 10;

        List<CardGroupEntity> expected = List.of();
        when(boardService.getById(boardId)).thenReturn(new BoardEntity(boardId, null, expected, null, false, null));

        List<CardGroupEntity> actual = cardGroupService.getAllByBoardId(boardId);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllByBoardId_ThereIsNoBoardWithProvidedId_ThrowsNotFoundException() {
        final long boardId = 10;

        when(boardService.getById(boardId)).thenThrow(NotFoundException.class);

        Assertions.assertThrows(NotFoundException.class, () -> cardGroupService.getAllByBoardId(boardId));
    }
}