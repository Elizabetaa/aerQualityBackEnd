package com.example.aerquality;

import com.example.aerquality.service.CourseService;
import com.example.aerquality.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final CourseService courseService;
    private final UserService userService;

    public DBInit(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        initCourses();
        initUser();
    }

    private void initUser() {
        this.userService.initUser();
    }

    private void initCourses() {
        this.courseService.initCourses();
    }
}
