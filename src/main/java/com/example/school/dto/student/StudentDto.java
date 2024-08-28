package com.example.school.dto.student;

import java.util.List;
import com.example.school.model.Grade;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String school;
    private Long grade;
    private List<Long> listOfSkillsDto;
}
