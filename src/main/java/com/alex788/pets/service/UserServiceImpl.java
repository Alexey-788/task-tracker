package com.alex788.pets.service;

import com.alex788.pets.entity.UserEntity;
import com.alex788.pets.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getById(long id) {
        throw new NotImplementedException();
    }
}
