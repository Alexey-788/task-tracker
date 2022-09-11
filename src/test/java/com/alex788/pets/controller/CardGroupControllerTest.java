package com.alex788.pets.controller;

import com.alex788.pets.entity.CardGroupEntity;
import com.alex788.pets.exception.UserDoesNotOwnEntityException;
import com.alex788.pets.exception.NotFoundException;
import com.alex788.pets.service.BoardService;
import com.alex788.pets.service.CardGroupService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CardGroupControllerTest {

    @Autowired
    MockMvc mvc;

    @Mock
    CardGroupService cardGroupService;

    @Mock
    BoardService boardService;

    @Test
    void getBoardCardGroups_AllDataIsCorrect_ReturnsOk() throws Exception {
        final long boardId = 10;
        final long userId = 20;

        doNothing().when(boardService).boardBelongToUser(userId, boardId);
        when(cardGroupService.getAllByBoardId(boardId)).thenReturn(List.of(new CardGroupEntity()));

        mvc.perform(get("/boards/{boardId}/groups", boardId).header("userId", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getBoardCardGroups_BoardHasNoCardGroup_ReturnsOk() throws Exception {
        final long boardId = 10;
        final long userId = 20;

        doNothing().when(boardService).boardBelongToUser(userId, boardId);
        when(cardGroupService.getAllByBoardId(boardId)).thenReturn(List.of());

        mvc.perform(get("/boards/{boardId}/groups", boardId).header("userId", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getBoardCardGroups_ThereIsNoBoardWithProvidedId_ReturnsNotFound() throws Exception {
        final long boardId = 10;
        final long userId = 20;

        doNothing().when(boardService).boardBelongToUser(userId, boardId);
        when(cardGroupService.getAllByBoardId(boardId)).thenThrow(NotFoundException.class);

        mvc.perform(get("/boards/{boardId}/groups", boardId).header("userId", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getBoardCardGroups_ThereIsNoUserWithProvidedId_ReturnsNotFound() throws Exception {
        final long boardId = 10;
        final long userId = 20;

        doThrow(NotFoundException.class).when(boardService).boardBelongToUser(userId, boardId);
        when(cardGroupService.getAllByBoardId(boardId)).thenReturn(List.of(new CardGroupEntity()));

        mvc.perform(get("/boards/{boardId}/groups", boardId).header("userId", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getBoardCardGroups_BoardDoesNotBelongToUser_ReturnsForbidden() throws Exception {
        final long boardId = 10;
        final long userId = 20;

        doThrow(UserDoesNotOwnEntityException.class).when(boardService).boardBelongToUser(userId, boardId);

        mvc.perform(get("/boards/{boardId}/groups", boardId).header("userId", userId))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}