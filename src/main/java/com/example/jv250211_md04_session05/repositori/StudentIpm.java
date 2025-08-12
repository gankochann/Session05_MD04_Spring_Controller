package com.example.jv250211_md04_session05.repositori;

import com.example.jv250211_md04_session05.models.entity.Students;
import com.example.jv250211_md04_session05.models.until.ConnectionDb;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentIpm implements StudentDAO{

    @Override
    public List<Students> findAll() {
        Connection conn = null;
        CallableStatement callstm = null;
        List<Students> list = null;
        try {
            conn = ConnectionDb.openConnection();
            callstm = conn.prepareCall("{call find_add()}");
            ResultSet rs = callstm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()){
                Students students = new Students();
                students.setId(rs.getInt("id"));
                students.setName(rs.getString("name"));
                students.setEmail(rs.getString("email"));
                students.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                students.setAvgMark(rs.getDouble("avgMark"));
                list.add(students);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDb.closeConnection(conn,callstm);
        }
        return list;
    }

    @Override
    public boolean save(Students students) {
        Connection conn = null;
        CallableStatement callstm = null;
        boolean result = false;
        try {
            conn = ConnectionDb.openConnection();
            callstm = conn.prepareCall("{call add_student(?,?,?,?)}");
            callstm.setString(1, students.getName());
            callstm.setString(2, students.getEmail());
            callstm.setDate(3, java.sql.Date.valueOf(students.getBirthday()));
            callstm.setDouble(4, students.getAvgMark());
            callstm.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDb.closeConnection(conn,callstm);
        }
        return result;
    }

    @Override
    public boolean update(Students students) {
        Connection conn = null;
        CallableStatement callstm = null;
        boolean result = false;
        try {
            conn = ConnectionDb.openConnection();
            callstm = conn.prepareCall("{call update_student(?,?,?,?,?)}");
            callstm.setInt(1, students.getId());
            callstm.setString(2, students.getName());
            callstm.setString(3, students.getEmail());
            callstm.setDate(4, java.sql.Date.valueOf(students.getBirthday()));
            callstm.setDouble(5, students.getAvgMark());
            callstm.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDb.closeConnection(conn,callstm);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callstm = null;
        boolean result = false;
        try {
            conn = ConnectionDb.openConnection();
            callstm = conn.prepareCall("{call delete_student(?)}");
            callstm.setInt(1,id);
            callstm.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDb.closeConnection(conn,callstm);
        }
        return result;
    }

    @Override
    public Students findById(int id) {
        Connection conn = null;
        CallableStatement callstm = null;
        Students student = null;
        try {
            conn = ConnectionDb.openConnection();
            callstm = conn.prepareCall("{call find_student_by_id(?)}");
            callstm.setInt(1, id);
            ResultSet rs = callstm.executeQuery();
            student = new Students();
            while (rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                student.setAvgMark(rs.getDouble("avgMark"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDb.closeConnection(conn,callstm);
        }
        return student;
    }

    @Override
    public List<Students> searchStudentByName(String name ) {
        Connection conn = null;
        CallableStatement callstm = null;
        List<Students> list = null;
        try {
            conn = ConnectionDb.openConnection();
            callstm = conn.prepareCall("{call search_student_by_name(?)}");
            callstm.setString(1,name);
            ResultSet rs = callstm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()){
                Students students = new Students();
                students.setId(rs.getInt("id"));
                students.setName(rs.getString("name"));
                students.setEmail(rs.getString("email"));
                students.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                students.setAvgMark(rs.getDouble("avgMark"));
                list.add(students);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDb.closeConnection(conn,callstm);
        }
        return list;
    }

}
