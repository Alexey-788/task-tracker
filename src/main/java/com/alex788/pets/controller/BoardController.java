package com.alex788.pets.controller;

import com.alex788.pets.dto.BoardDto;
import com.alex788.pets.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(description = "Board resources that provides access to available board data", name = "Board Resource")
@AllArgsConstructor
@RestController
@RequestMapping("/rest-api/v1")
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "Get boards of the user", description = "Provides all available boards for the user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "User with provided id not doesn't exist"),
    })
    @GetMapping(value = "/users/{userId}/boards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BoardDto>> getUserBoards(@PathVariable long userId) {
        throw new NotImplementedException();
    }
}
