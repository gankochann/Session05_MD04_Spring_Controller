package com.example.jv250211_md04_session05.service;

import com.example.jv250211_md04_session05.models.entity.StudentDTO;
import com.example.jv250211_md04_session05.models.entity.Students;
import com.example.jv250211_md04_session05.repositori.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;
    public List<Students> findAll(){
        return studentDAO.findAll();
    };

     public boolean save(StudentDTO studentDTO){
         Students students = convertStudentDTOToStudent(studentDTO);
         return studentDAO.save(students);
    }

    private static Students convertStudentDTOToStudent(StudentDTO studentDTO) {
        Students students = new Students();
        students.setName(studentDTO.getName());
        students.setEmail(studentDTO.getEmail());
        students.setBirthday(studentDTO.getBirthday());
        students.setAvgMark(studentDTO.getAvgMark());
        return students;
    }

    ;

     public boolean update(StudentDTO studentDTO, int id){
         Students oldStudents = studentDAO.findById(id);
         if(oldStudents != null){
            Students newStudents = convertStudentDTOToStudent(studentDTO);
            newStudents.setId(oldStudents.getId());
            return studentDAO.update(newStudents);
         }else {
             return false;
         }
     };

   public boolean delete(int id){
        Students oldStudents = studentDAO.findById(id);
        if(oldStudents != null){
            return studentDAO.delete(id);
        }else {
            return false;
        }
    };

    public Students findById(int id){
        return studentDAO.findById(id);
    };

    public List<Students> searchStudentByName(String name){
        return studentDAO.searchStudentByName(name);
    };

    public StudentDTO convertStudenttoStudentDTO(Students students){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(students.getName());
        studentDTO.setEmail(students.getEmail());
        studentDTO.setBirthday(students.getBirthday());
        studentDTO.setAvgMark(students.getAvgMark());
        return studentDTO;
    }

}
