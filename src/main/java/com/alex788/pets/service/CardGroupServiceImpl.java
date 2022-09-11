package com.alex788.pets.service;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.entity.CardGroupEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CardGroupServiceImpl implements CardGroupService {

    private final BoardService boardService;

    @Override
    public List<CardGroupEntity> getAllByBoardId(long boardId) {
        BoardEntity board = boardService.getById(boardId);
        return board.getCardGroups();
    }
}
