package com.example.school.controller;

import java.util.List;
import com.example.school.dto.skill.CreateSkillDto;
import com.example.school.dto.skill.SkillDto;
import com.example.school.mapper.skill.SkillMapper;
import com.example.school.service.skill.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/skills")
public class SkillController {
    private final SkillService skillService;

    @PostMapping
    public SkillDto save(@RequestBody CreateSkillDto requestDto) {
        return skillService.save(requestDto);
    }

    @GetMapping
    public List<SkillDto> getAllSkills() {
        return skillService.getAllSkills();
    }
}
