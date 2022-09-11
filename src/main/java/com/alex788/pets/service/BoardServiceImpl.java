package com.alex788.pets.service;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.entity.UserEntity;
import com.alex788.pets.exception.NotFoundException;
import com.alex788.pets.exception.UserDoesNotOwnEntityException;
import com.alex788.pets.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserService userService;

    @Override
    public BoardEntity getById(long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No board found for id " + id)
        );
    }

    @Override
    public List<BoardEntity> getAllByUserId(long userId) {
        UserEntity user = userService.getById(userId);
        return user.getBoards();
    }

    @Override
    public void boardBelongToUser(long boardId, long userId) {
        BoardEntity board = getById(boardId);
        if (board.getUser().getId() != userId) {
            throw new UserDoesNotOwnEntityException("User with id " + userId + " doesn't own board with id " + boardId);
        }
    }
}
