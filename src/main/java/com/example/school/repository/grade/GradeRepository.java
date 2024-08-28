package com.example.school.repository.grade;

import com.example.school.model.Grade;
import jakarta.servlet.http.HttpServlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
