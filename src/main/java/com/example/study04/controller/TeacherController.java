package com.example.study04.controller;

import com.example.study04.dto.TeacherDTO;
import com.example.study04.entity.Teacher;
import com.example.study04.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TeacherController {
    private TeacherService teacherService;

    // 조회: entity -> dto 변환해서 화면으로 전송
    @GetMapping("/teachers")
    public String teacherListPage(Model model) {
        List<Teacher> teachers = teacherService.findAll(); // entity
        List<TeacherDTO> teacherDTOs = teachers.stream().map(TeacherDTO::toDTO).collect(Collectors.toList());; // dto
        model.addAttribute("teachers", teacherDTOs);
        return "teacher/teachers"; // 목록페이지
    }

    // 조회: entity -> dto 변환해서 화면으로 전송
    @GetMapping("/teacher/{id}")
    public String teacherDetailPage(@PathVariable Long id, Model model) {
        Teacher teacher = teacherService.findById(id); // entity
        TeacherDTO teacherDTO = TeacherDTO.toDTO(teacher); // dto
        model.addAttribute("teacher", teacherDTO);
        return "teacher/teacher"; // 상세페이지
    }

    // 등록페이지
    @GetMapping("/teacher-new")
    public String teacherNewPage() {
        return "teacher/teacher-new"; // 등록페이지
    }

    // 생성/수정: 화면에서 넘어온 dto -> entity 변환해서 저장
    @PostMapping("/save-teacher")
    public String saveTeacher(@ModelAttribute TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO); // dto
        return "redirect:teachers";
    }

    // 삭제: 화면에서 넘어온 dto -> entity 변환해서 삭제
    @PostMapping("/del-teacher")
    public String delTeacher(@ModelAttribute TeacherDTO teacherDTO) {
        teacherService.delete(teacherDTO); // dto
        return "redirect:teachers";
    }
}
