package com.example.jv250211_md04_session05.repositori;

import com.example.jv250211_md04_session05.models.entity.Students;

import java.util.List;

public interface StudentDAO {
    List<Students> findAll();

    boolean save(Students students);

    boolean update(Students students);

    boolean delete(int id);

    Students findById(int id);

    List<Students> searchStudentByName(String name);
}
