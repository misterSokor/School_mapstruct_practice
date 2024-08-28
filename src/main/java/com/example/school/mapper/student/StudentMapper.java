package com.example.school.mapper.student;

import com.example.school.dto.student.CreateStudentDto;
import com.example.school.dto.student.StudentDto;
import com.example.school.model.Grade;
import com.example.school.model.Student;

public interface StudentMapper {
    Student toModel(CreateStudentDto requestStudentDto, Grade grade);

    StudentDto toDto(Student student);
}
