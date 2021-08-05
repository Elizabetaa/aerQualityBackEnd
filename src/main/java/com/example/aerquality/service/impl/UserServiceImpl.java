package com.example.aerquality.service.impl;

import com.example.aerquality.model.CurrentUser;
import com.example.aerquality.model.dto.UserDto;
import com.example.aerquality.model.entity.CourseEntity;
import com.example.aerquality.model.entity.UserEntity;
import com.example.aerquality.repository.UserRepository;
import com.example.aerquality.service.CourseService;
import com.example.aerquality.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CourseService courseService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CourseService courseService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.courseService = courseService;
        this.currentUser = currentUser;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public void registerUser(UserDto userDto) {
        if (this.userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new IllegalArgumentException("Already have user with this email");
        }
        UserEntity map = this.modelMapper.map(userDto, UserEntity.class);
        map.setUserRole("user");
        this.userRepository.save(map);
    }

    @Override
    public void addCourseToUser(Long courseId, String userEmail) {
        UserEntity user = this.userRepository.findByEmail(userEmail);
        for (int i = 0; i < user.getCourses().size(); i++) {
            if (user.getCourses().get(i).getId() == courseId) {
                return;
            }
        }
        CourseEntity course = this.courseService.getById(courseId);
        user.getCourses().add(course);
        this.userRepository.save(user);
    }

    @Override
    public List<CourseEntity> getMyCourses(String email) {
        UserEntity user = this.userRepository.findByEmail(email);
        return user.getCourses();
    }

    @Override
    public void login(UserDto userDto) {
        UserEntity userEntity = this.modelMapper.map(userDto, UserEntity.class);
        UserEntity byEmail = this.userRepository.findByEmail(userEntity.getEmail());
        if (byEmail == null || !userEntity.getPassword().equals(byEmail.getPassword())) {
            throw new IllegalArgumentException("User doesn't exist!");
        }
        currentUser.setEmail(byEmail.getEmail());
    }

    @Override
    public UserEntity getCurrentUser() {
        return this.userRepository.findByEmail(this.currentUser.getEmail());
    }

    @Override
    public void logout() {
        this.currentUser.setEmail(null);
    }

    @Override
    public void initUser() {
        if (userRepository.count() != 0){
            return;
        }
        this.userRepository.save(new UserEntity("Jhon", "Doe", "jhonDoe@mail.com","111111","admin"));
    }

}
