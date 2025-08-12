package com.example.jv250211_md04_session05.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class StudentDTO {
    private String name;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private double avgMark;

    public StudentDTO() {
    }

    public StudentDTO(String name, String email, LocalDate birthday, double avgMark) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.avgMark = avgMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }
}
