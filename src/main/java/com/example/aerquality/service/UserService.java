package com.example.aerquality.service;


import com.example.aerquality.model.dto.EditProfileDto;
import com.example.aerquality.model.dto.UserDto;
import com.example.aerquality.model.entity.CourseEntity;
import com.example.aerquality.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    void registerUser(UserDto userDto);

    void addCourseToUser(Long courseId, String userEmail);

    List<CourseEntity> getMyCourses(String email);

    void login(UserDto userDto);

    UserEntity getCurrentUser();

    void logout();

    void initUser();

    void editUserInfo(EditProfileDto userDto);
}
