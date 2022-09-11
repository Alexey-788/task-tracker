package com.alex788.pets.service;

import com.alex788.pets.entity.CardGroupEntity;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CardGroupServiceImpl implements CardGroupService {

    private final BoardService boardService;

    @Override
    public List<CardGroupEntity> getAllByBoardId(long boardId) {
        throw new NotImplementedException();
    }
}
