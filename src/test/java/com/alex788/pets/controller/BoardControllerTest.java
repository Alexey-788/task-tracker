package com.alex788.pets.controller;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.exception.NotFoundException;
import com.alex788.pets.service.BoardService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private BoardService boardService;

    @Test
    void getUserBoards_AllDataIsCorrect_ReturnsOk() throws Exception {
        final long userId = 10;

        when(boardService.getAllByUserId(userId)).thenReturn(List.of(new BoardEntity()));

        mvc.perform(get("/users/{userId}/boards", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getUserBoards_UserHasNoBoard_ReturnsOk() throws Exception {
        final long userId = 10;

        when(boardService.getAllByUserId(userId)).thenReturn(List.of());

        mvc.perform(get("/users/{userId}/boards", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getUserBoards_ThereIsNoUserWithProvidedId_ReturnsNotFound() throws Exception {
        final long userId = 10;

        when(boardService.getAllByUserId(userId)).thenThrow(NotFoundException.class);

        mvc.perform(get("/users/{userId}/boards", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}