package com.alex788.pets.service;

import com.alex788.pets.entity.UserEntity;
import com.alex788.pets.exception.NotFoundException;
import com.alex788.pets.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void getById_AllDataIsCorrect_ReturnsRightUser() {
        final long id = 10;

        final UserEntity expected = new UserEntity();
        when(userRepository.findById(id)).thenReturn(Optional.of(expected));

        final UserEntity actual = userService.getById(id);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getById_ThereIsNoUserWithProvidedId_ThrowsNotFoundException() {
        final long id = 10;

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> userService.getById(id));
    }
}