package com.example.school.dto.student;

import java.util.List;
import lombok.Data;

@Data
public class CreateStudentDto {
    private String name;
    private String school;
    private Long gradeNumber;
    private List<Long> skillList;
}
