package com.example.school.service.grade;

import java.util.List;
import com.example.school.dto.grade.CreateGradeDto;
import com.example.school.dto.grade.GradeDto;
import com.example.school.model.Grade;

public interface GradeService {

    GradeDto save(CreateGradeDto requestDto);

    List<GradeDto> getAll();
}
