package com.alex788.pets.service;

import com.alex788.pets.entity.UserEntity;
import com.alex788.pets.exception.NotFoundException;
import com.alex788.pets.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getById(long id) {
        System.out.println("test with id " + id);
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No user found for id " + id)
        );
    }
}
