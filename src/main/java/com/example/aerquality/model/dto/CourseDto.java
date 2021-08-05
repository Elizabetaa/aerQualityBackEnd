package com.example.aerquality.model.dto;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

public class CourseDto {
    @Expose
    private String courseName;
    @Expose
    private long members;
    @Expose
    private int weeks;
    @Expose
    private String description;
    @Expose
    private String imageUrl;
    @Expose
    private String examDate;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getMembers() {
        return members;
    }

    public void setMembers(long members) {
        this.members = members;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

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

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }
}
