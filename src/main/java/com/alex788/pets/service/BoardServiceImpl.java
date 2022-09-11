package com.alex788.pets.service;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserService userService;

    @Override
    public BoardEntity getById(long id) {
        throw new NotImplementedException();
    }

    @Override
    public List<BoardEntity> getAllByUserId(long userId) {
        throw new NotImplementedException();
    }

    @Override
    public void boardBelongToUser(long userId, long boardId) {
        throw new NotImplementedException();
    }
}
