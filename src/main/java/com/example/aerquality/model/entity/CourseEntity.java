package com.example.aerquality.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CourseEntity extends BaseEntity {
    private String courseName;
    private int weeks;
    private String description;
    private String imageUrl;
    private LocalDate examDate;

    public CourseEntity(String courseName, int weeks, String description, String imageUrl, LocalDate examDate) {
        this.courseName = courseName;
        this.weeks = weeks;
        this.description = description;
        this.imageUrl = imageUrl;
        this.examDate = examDate;
    }

    public CourseEntity() {

    }

    @Column(name = "courseName", nullable = false)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "weeks")
    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    @Column(name = "description", nullable = false,columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Column( nullable = false)
    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}
