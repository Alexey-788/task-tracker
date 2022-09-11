package com.alex788.pets.service;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.entity.UserEntity;
import com.alex788.pets.exception.NotFoundException;
import com.alex788.pets.exception.UserDoesNotOwnEntityException;
import com.alex788.pets.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Mock
    BoardRepository boardRepository;

    @Mock
    UserService userService;

    @Test
    void getById_AllDataIsCorrect_ReturnsRightBoard() {
        final long id = 10;

        final BoardEntity expected = new BoardEntity();
        when(boardRepository.findById(id)).thenReturn(Optional.of(expected));

        final BoardEntity actual = boardService.getById(id);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getById_ThereIsNoBoardWithProvidedId_ThrowsNotFoundException() {
        final long id = 10;

        when(boardRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> boardService.getById(id));
    }

    @Test
    void getAllByUserId_AllDataIsCorrect_ReturnsRightBoardList() {
        final long userId = 10;

        List<BoardEntity> expected = List.of(new BoardEntity(), new BoardEntity());
        when(userService.getById(userId)).thenReturn(new UserEntity(userId, expected, null, null, null));

        List<BoardEntity> actual = boardService.getAllByUserId(userId);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllByUserId_UserHasNoBoards_ReturnsEmptyBoardList() {
        final long userId = 10;

        List<BoardEntity> expected = List.of();
        when(userService.getById(userId)).thenReturn(new UserEntity(userId, expected, null, null, null));

        List<BoardEntity> actual = boardService.getAllByUserId(userId);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAllByUserId_ThereIsNoUserWithProvidedId_ThrowsNotFoundException() {
        final long userId = 10;

        when(userService.getById(userId)).thenThrow(NotFoundException.class);

        Assertions.assertThrows(NotFoundException.class, () -> boardService.getAllByUserId(userId));
    }

    @Test
    void boardBelongToUser_BoardBelongToUser_DoNothing() {
        final long userId = 10;
        final long boardId = 20;

        UserEntity user = new UserEntity(userId, null, null, null, null);
        BoardEntity board = new BoardEntity(boardId, user, null, null, false, null);
        when(boardService.getById(boardId)).thenReturn(board);

        Assertions.assertDoesNotThrow(() -> boardService.boardBelongToUser(userId, boardId));
    }

    @Test
    void boardBelongToUser_ThereIsNoBorderWithProvidedId_ThrowsNotFoundException() {
        final long userId = 10;
        final long boardId = 20;

        when(boardService.getById(boardId)).thenThrow(NotFoundException.class);

        Assertions.assertThrows(NotFoundException.class, () -> boardService.boardBelongToUser(userId, boardId));
    }

    @Test
    void boardBelongToUser_BoardDoesNotBelongToUser_ThrowsUserDoesNotOwnEntityException() {
        final long userId = 10;
        final long boardId = 20;

        long realBoardOwnerId = 30;

        UserEntity realBoardOwner = new UserEntity(realBoardOwnerId, null, null, null, null);
        BoardEntity board = new BoardEntity(boardId, realBoardOwner, null, null, false, null);
        when(boardService.getById(boardId)).thenReturn(board);

        Assertions.assertThrows(UserDoesNotOwnEntityException.class, () -> boardService.boardBelongToUser(userId, boardId));
    }
}