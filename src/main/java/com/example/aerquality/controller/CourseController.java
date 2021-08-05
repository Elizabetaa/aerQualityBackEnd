package com.example.aerquality.controller;

import com.example.aerquality.model.entity.CourseEntity;
import com.example.aerquality.service.CourseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/all")
    public List<CourseEntity>getAllCourses(){
        return this.courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseEntity getCourseById (@PathVariable Long id){
      return  this.courseService.getById(id);
    }


    @PostMapping("/addCourse")
    public  void addCourse(@RequestBody String course){
        this.courseService.addCourse(course);
    }

}
