package com.example.school.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;


@Data
@Entity
@SQLDelete(sql = "UPDATE students SET is_deleted =true WHERE id = ?")
@FilterDef(name = "deleteById", parameters = @ParamDef(name = "isDeleted",
        type = Boolean.class))
@Filter(name = "deleteById", condition = "is_deleted = :isDeleted")
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

    @Column(nullable = false)
    private boolean isDeleted = false;
}
