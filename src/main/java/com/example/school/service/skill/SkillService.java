package com.example.school.service.skill;

import java.util.List;
import com.example.school.dto.skill.CreateSkillDto;
import com.example.school.dto.skill.SkillDto;

public interface SkillService {
    SkillDto save(CreateSkillDto requestDto);

    List<SkillDto> getAllSkills();
}
