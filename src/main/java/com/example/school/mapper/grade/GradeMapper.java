package com.example.school.mapper.grade;

import com.example.school.dto.grade.CreateGradeDto;
import com.example.school.dto.grade.GradeDto;
import com.example.school.model.Grade;
import org.mapstruct.Named;

public interface GradeMapper {
    GradeDto toDto(Grade grade);

    Grade toModel(CreateGradeDto requestDto);

    @Named("getById")
    default Grade getById(Long id) {
        if (id != null) {
            return new Grade(id);
        }
        return null;
    }
}
