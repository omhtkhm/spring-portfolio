package com.example.study04.service;

import com.example.study04.dto.StudentDTO;
import com.example.study04.entity.Student;
import com.example.study04.repo.StudentsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Controller -> Service -> Repo

@Service
@AllArgsConstructor
public class StudentService {
    private StudentsRepo studentsRepo;

    public List<Student> findAll() {
        return studentsRepo.findAll();
    }

    public Student findById(Integer studentId) {
        Student student = studentsRepo.findById(studentId).orElse(null);
        return student;
    }

    public Student save(StudentDTO studentDTO) {
        return studentsRepo.save(Student.toEntity(studentDTO));
    }

    public void delete(StudentDTO studentDTO) {
        studentsRepo.delete(Student.toEntity(studentDTO));
    }
}
