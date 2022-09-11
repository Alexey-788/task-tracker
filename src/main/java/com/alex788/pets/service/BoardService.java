package com.alex788.pets.service;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.exception.UserDoesNotOwnEntityException;

import java.util.List;

public interface BoardService {

    BoardEntity getById(long id);

    List<BoardEntity> getAllByUserId(long userId);

    /**
     * Checks whether the user has access to this board.
     * @throws UserDoesNotOwnEntityException if the board belongs to another user
     */
    void boardBelongToUser(long userId, long boardId);
}
