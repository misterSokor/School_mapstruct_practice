package com.example.school.service.student;

import java.util.List;
import com.example.school.dto.student.CreateStudentDto;
import com.example.school.dto.student.StudentDto;

public interface StudentService {
    StudentDto save(CreateStudentDto requestDto);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    List<StudentDto> getByNameAll(String name);

    void deleteStudentById(Long id);
}
