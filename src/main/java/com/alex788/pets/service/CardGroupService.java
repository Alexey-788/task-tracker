package com.alex788.pets.service;

import com.alex788.pets.entity.CardGroupEntity;

import java.util.List;

public interface CardGroupService {

    List<CardGroupEntity> getAllByBoardId(long boardId);
}
