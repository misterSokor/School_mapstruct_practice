package com.example.school.controller;

import java.util.List;
import com.example.school.dto.grade.CreateGradeDto;
import com.example.school.dto.grade.GradeDto;
import com.example.school.model.Grade;
import com.example.school.service.grade.GradeService;
import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/grades")
public class GradeController extends HttpServlet {
    private final GradeService gradeService;

    @PostMapping
    public GradeDto save(@RequestBody CreateGradeDto requestDto) {
        return gradeService.save(requestDto);
    }

    @GetMapping
    public List<GradeDto> getAll() {
        return gradeService.getAll();
    }
}
