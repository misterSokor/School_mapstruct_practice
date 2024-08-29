package com.example.school.service.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.school.dto.student.CreateStudentDto;
import com.example.school.dto.student.StudentDto;
import com.example.school.mapper.student.StudentMapper;
import com.example.school.model.Grade;
import com.example.school.model.Student;
import com.example.school.repository.grade.GradeRepository;
import com.example.school.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GradeRepository gradeRepository;

    public StudentDto save(CreateStudentDto requestDto) {
        // Check if gradeNumber exists
        Long gradeNumber = requestDto.getGradeNumber();
        Grade grade = null;
        if (gradeNumber != null) {
            Optional<Grade> gradeOpt = gradeRepository.findById(gradeNumber);
            if (gradeOpt.isEmpty()) {
                throw new IllegalArgumentException("Invalid gradeNumber: " + gradeNumber);
            }
            grade = gradeOpt.get();
        }

        Student student = studentMapper.toModel(requestDto, grade);
        Student saved = studentRepository.save(student);
        return studentMapper.toDto(saved);
    }

    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudentsWithSkills();
        for (Student student : studentList) {
            StudentDto dto = studentMapper.toDto(student);
            studentDtos.add(dto);
        }
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findByIdWithSkills(id);
        StudentDto studentDto = studentMapper.toDto(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> getByNameAll(String name) {
        return studentRepository.findAllByName(name)
                .stream()
                .map(student -> studentMapper.toDto(student))
                .toList();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }


}
