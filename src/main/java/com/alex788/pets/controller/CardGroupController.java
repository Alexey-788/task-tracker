package com.alex788.pets.controller;

import com.alex788.pets.dto.CardGroupDto;
import com.alex788.pets.service.BoardService;
import com.alex788.pets.service.CardGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(description = "Card group resources that provides access to available card group data", name = "Card group Resource")
@AllArgsConstructor
@RestController
@RequestMapping("/rest-api/v1")
public class CardGroupController {

    private final CardGroupService cardGroupService;
    private final BoardService boardService;

    @Operation(summary = "Get card groups of the board", description = "Provides all available card groups for the board")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "403", description = "Board doesn't belong to user"),
            @ApiResponse(responseCode = "404", description = "There is no board or user with provided id"),
    })
    @GetMapping(value = "/boards/{boardId}/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CardGroupDto>> getBoardCardGroups(@PathVariable long boardId, @RequestHeader long userId) {
        boardService.boardBelongToUser(boardId, userId);

        List<CardGroupDto> cardGroups = cardGroupService.getAllByBoardId(boardId)
                .stream()
                .map(CardGroupDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(cardGroups);
    }
}
