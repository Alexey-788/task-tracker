package com.alex788.pets.repository;

import com.alex788.pets.entity.BoardEntity;
import com.alex788.pets.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity, Long> {

    List<BoardEntity> findAllByUser(UserEntity user);
}
