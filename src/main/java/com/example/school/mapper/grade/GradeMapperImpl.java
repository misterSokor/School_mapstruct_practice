package com.example.school.mapper.grade;

import com.example.school.dto.grade.CreateGradeDto;
import com.example.school.dto.grade.GradeDto;
import com.example.school.model.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GradeMapperImpl implements GradeMapper {
    @Override
    public GradeDto toDto(Grade grade) {
        GradeDto gradeDto = new GradeDto();
        gradeDto.setId(grade.getId());
        gradeDto.setNumberOfGradeDto(grade.getNumOfGrade());
        return gradeDto;
    }

    @Override
    public Grade toModel(CreateGradeDto requestDto) {
        Grade grade = new Grade();
        Long numberOfGradeRequest = requestDto.getNumberOfGradeRequest();
        grade.setNumOfGrade(numberOfGradeRequest);
        return grade;
    }
}
