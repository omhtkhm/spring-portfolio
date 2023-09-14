package com.example.study04.controller.api;

import com.example.study04.dto.CommonResponseDTO;
import com.example.study04.dto.TeacherDTO;
import com.example.study04.entity.Teacher;
import com.example.study04.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // @Controller + @ResponseBody
@AllArgsConstructor
@RequestMapping("/api") // 공통경로 앞에 추가됨
public class TeacherApiController {
    private TeacherService teacherService;

    // 조회: entity -> dto 변환해서 화면으로 전송
    @GetMapping("/teachers")
    public List<TeacherDTO> getTeachers() {
        List<Teacher> teachers = teacherService.findAll(); // entity
        List<TeacherDTO> teacherDTOs = teachers.stream().map(TeacherDTO::toDTO).collect(Collectors.toList());; // dto
        return teacherDTOs; // 자동으로 json변환됨
    }

    // 조회: entity -> dto 변환해서 화면으로 전송
    @GetMapping("/teachers/{id}")
    public TeacherDTO getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.findById(id); // entity
        TeacherDTO teacherDTO = TeacherDTO.toDTO(teacher); // dto
        return teacherDTO; // 자동으로 json변환됨
    }

    // 생성/수정: 화면에서 넘어온 dto -> entity 변환해서 저장
    @PostMapping("/teachers")
    public CommonResponseDTO saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO); // dto
        CommonResponseDTO responseDTO = new CommonResponseDTO(true, "성공", null);
        return responseDTO;
    }

    // 삭제: 화면에서 넘어온 dto -> entity 변환해서 삭제
    @DeleteMapping("/teachers")
    public CommonResponseDTO delTeacher(@RequestBody TeacherDTO teacherDTO) {
        CommonResponseDTO responseDTO = new CommonResponseDTO(true, "성공", null);
        return responseDTO;
    }
}
