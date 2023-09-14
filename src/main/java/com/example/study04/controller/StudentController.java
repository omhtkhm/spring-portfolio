package com.example.study04.controller;

import com.example.study04.dto.CommentDTO;
import com.example.study04.dto.StudentDTO;
import com.example.study04.dto.TeacherDTO;
import com.example.study04.entity.Comment;
import com.example.study04.entity.Student;
import com.example.study04.service.CommentService;
import com.example.study04.service.StudentService;
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
public class StudentController {
    private StudentService studentService;
    private CommentService commentService;

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> studentsList = studentService.findAll();
        List<StudentDTO> studentDTOs = studentsList.stream().map(StudentDTO::toDTO).collect(Collectors.toList());; // dto
        List<Comment> commentList = commentService.findAll();
        List<CommentDTO> commentDTOs = commentList.stream().map(CommentDTO::toDTO).collect(Collectors.toList());; // dto

        model.addAttribute("students", studentDTOs);
        model.addAttribute("comments", commentDTOs);
        return "students";
    }

    @GetMapping("/student/{studentId}")
    public String getStudentById(@PathVariable Integer studentId, Model model) {
        Student student = studentService.findById(studentId);
        StudentDTO studentDTO = StudentDTO.toDTO(student); // entity(db정보넣는통) => dto(화면에전달하고받는통)
        model.addAttribute("student", studentDTO);
        return "student";
    }

    @GetMapping("/new-student")
    public String newStudent() {
        return "new-student";
    }

    @PostMapping("/new-student")
    public String newStudentPost(@ModelAttribute StudentDTO studentDTO) {
//        System.out.println(studentDTO);
        studentService.save(studentDTO);
        return "redirect:students";
    }

    @PostMapping("/del-student")
    public String delStudent(@ModelAttribute StudentDTO studentDTO) {
//        System.out.println(studentDTO);
        studentService.delete(studentDTO);
        return "redirect:students";
    }
}
