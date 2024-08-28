package com.example.school.service.skill;

import java.util.ArrayList;
import java.util.List;
import com.example.school.dto.skill.CreateSkillDto;
import com.example.school.dto.skill.SkillDto;
import com.example.school.mapper.skill.SkillMapper;
import com.example.school.model.Skill;
import com.example.school.repository.skill.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Override
    public SkillDto save(CreateSkillDto requestDto) {
        Skill skill = skillMapper.toModel(requestDto);
        Skill saved = skillRepository.save(skill);
        return skillMapper.toDto(saved);
    }

    @Override
    public List<SkillDto> getAllSkills() {
        return skillRepository.findAll().stream().map(skill -> skillMapper.toDto(skill)).toList();
    }

//    @Override
//    public List<SkillDto> getAllSkills() {
//        List<Skill> skillList = skillRepository.findAll();
//        List<SkillDto> skillDtos = new ArrayList<>();
//        for (Skill skill : skillList) {
//            SkillDto skillDto = skillMapper.toDto(skill);
//            skillDtos.add(skillDto);
//        }
//        return skillDtos;
//    }
}
