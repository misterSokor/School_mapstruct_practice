package com.example.school.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String school;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Grade grade;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    private List<Skill> skillOfStudent;
}
