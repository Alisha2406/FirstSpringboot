package com.user.test.service;

import com.user.test.dto.UserDto;
import com.user.test.mapper.UserMapper;
import com.user.test.model.User;
import com.user.test.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public List<UserDto> getAllUsers() {

        List<User> userList = userRepository.findAll();
        return userMapper.toDtos(userList);
    }

    public UserDto  createUser(UserDto userDto) {

        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto getUserById(String userId) {

        Optional<User> user = userRepository.findById(userId);
        return userMapper.toDto(user.orElse(null));
    }

    public String deleteUserById(String userId) {

        Optional<User> user = userRepository.findById(userId);
        userRepository.delete(user.get());
        return "user is deleted";
    }
}
