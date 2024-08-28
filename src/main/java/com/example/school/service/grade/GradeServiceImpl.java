package com.example.school.service.grade;

import java.util.ArrayList;
import java.util.List;
import com.example.school.dto.grade.CreateGradeDto;
import com.example.school.dto.grade.GradeDto;
import com.example.school.mapper.grade.GradeMapper;
import com.example.school.model.Grade;
import com.example.school.repository.grade.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;


    @Override
    public GradeDto save(CreateGradeDto requestDto) {
        Grade grade = gradeMapper.toModel(requestDto);
        Grade saved = gradeRepository.save(grade);
        return gradeMapper.toDto(saved);
    }

    @Override
    public List<GradeDto> getAll() {
        return gradeRepository.findAll()
                .stream()
                .map(grade -> gradeMapper.toDto(grade))
                .toList();
    }
}
