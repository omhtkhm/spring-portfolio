package com.example.study04.service;

import com.example.study04.dto.StudentDTO;
import com.example.study04.dto.TeacherDTO;
import com.example.study04.entity.Student;
import com.example.study04.entity.Teacher;
import com.example.study04.repo.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Controller -> Service -> Repo

@Service
@AllArgsConstructor
public class TeacherService {
    private TeacherRepo teacherRepo;

    // 여러개 조회
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    // 단건 조회
    public Teacher findById(Long id) {
        Teacher teacher = teacherRepo.findById(id).orElse(null);
        return teacher;
    }

    // 생성/수정: 화면에서 넘어온 dto -> entity 변환해서 저장
    public Teacher save(TeacherDTO teacherDTO) {
        System.out.println("teacherDTO = " + teacherDTO);
        return teacherRepo.save(Teacher.toEntity(teacherDTO)); // dto => entity
    }

    // 삭제: 화면에서 넘어온 dto -> entity 변환해서 삭제
    public void delete(TeacherDTO teacherDTO) {
        teacherRepo.delete(Teacher.toEntity(teacherDTO)); // dto => entity
    }
}
