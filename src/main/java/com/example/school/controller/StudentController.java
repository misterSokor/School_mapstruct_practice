package com.example.school.controller;

import java.util.List;
import com.example.school.dto.student.CreateStudentDto;
import com.example.school.dto.student.StudentDto;
import com.example.school.service.student.StudentService;
import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController extends HttpServlet {
    private final StudentService studentService;

    @PostMapping
    public StudentDto save(@RequestBody CreateStudentDto requestDto) {
        return studentService.save(requestDto);
    }

    @GetMapping
    List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/by-name")
    public List<StudentDto> getStudentsByName(@RequestParam String name) {
        return studentService.getByNameAll(name);
    }
}
