package com.example.aerquality.controller;

import com.example.aerquality.model.dto.UserDto;
import com.example.aerquality.model.entity.CourseEntity;
import com.example.aerquality.model.entity.UserEntity;
import com.example.aerquality.service.UserService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;


    @Autowired
    private Gson gson;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @PostMapping("/users/login")
    private UserEntity loginUser(@RequestBody String user) {
        UserDto userDto = this.gson.fromJson(user, UserDto.class);
        this.userService.login(userDto);
        return this.userService.getCurrentUser();
    }
    @PostMapping("/users/register")
    private void registerUser(@RequestBody String user) {
        UserDto userDto = this.gson.fromJson(user, UserDto.class);
        this.userService.registerUser(userDto);
    }


    @PostMapping("/users/addCourse/{id}")
    private void addCourseToUser(@PathVariable Long id, @RequestBody String userEmail) {
        this.userService.addCourseToUser(id, userEmail);
    }


    @RequestMapping("/users/getMyCourses/{email}")
    private List<CourseEntity> getMyCourses(@PathVariable String email) {
        return this.userService.getMyCourses(email);
    }

    @RequestMapping("/users/profile")
    private UserEntity profile(){
        return this.userService.getCurrentUser();
    }

    @PostMapping("/users/logout")
    private UserEntity logout(){
        this.userService.logout();
        return null;
    }
}
