package com.example.school.mapper.skill;

import com.example.school.config.MapperConfig;
import com.example.school.dto.skill.CreateSkillDto;
import com.example.school.dto.skill.SkillDto;
import com.example.school.model.Skill;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SkillMapper {
    SkillDto toDto(Skill skill);

    Skill toModel(CreateSkillDto requestDto);
}
