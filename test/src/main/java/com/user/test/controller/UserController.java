package com.user.test.controller;

import com.user.test.dto.UserDto;
import com.user.test.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1")
@Log4j2
public class UserController {

    private UserService userService;

    @GetMapping(value = "/users")
    List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/users")
    UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);

    }

    @GetMapping(value = "/users/{userId}")
    UserDto getUserById(@PathVariable(name = "userId") String userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping(value = "/users/{userId}")
    String deleteUserById (@PathVariable(name = "userId") String userId){
        return userService.deleteUserById(userId);
    }

}
