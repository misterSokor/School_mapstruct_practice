package com.example.school.mapper.student;

import java.util.List;
import com.example.school.dto.student.CreateStudentDto;
import com.example.school.dto.student.StudentDto;
import com.example.school.model.Grade;
import com.example.school.model.Skill;
import com.example.school.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapperImpl implements StudentMapper {
    @Override
    public Student toModel(CreateStudentDto requestStudentDto, Grade grade) {
        Student student = new Student();
        student.setName(requestStudentDto.getName());
        student.setSchool(requestStudentDto.getSchool());
        student.setGrade(grade);
        setSkillsFromLong(student, requestStudentDto);
        return student;
    }

    private void setSkillsFromLong(Student student, CreateStudentDto createStudentDto) {
        List<Skill> list = createStudentDto.getSkillList()
                .stream()
                .map(Skill::new)
                .toList();
        student.setSkillOfStudent(list);
    }

    @Override
    public StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSchool(student.getSchool());
        studentDto.setGrade(student.getGrade().getNumOfGrade());
        setSkillToDtos(studentDto, student);
        return studentDto;
    }

    private void setSkillToDtos(StudentDto studentDto, Student student) {
        List<Long> longList = student.getSkillOfStudent()
                .stream()
                .map(Skill::getId)
                .toList();
        studentDto.setListOfSkillsDto(longList);
    }
}
