package com.example.school.repository.student;

//import java.util.List;
//import com.example.school.model.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface StudentRepository extends JpaRepository<Student, Long> {
////    @Query("from Student s where upper(s.name) like upper(:name)")
//    @Query(value = "SELECT * FROM students WHERE UPPER(name) LIKE UPPER(:name)",
//            nativeQuery = true)
//    List<Student> findAllByName(String name);
//}

import java.util.List;
import com.example.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s join fetch s.skillOfStudent")
    List<Student> findAllStudentsWithSkills();

    @Query("from Student s join fetch s.skillOfStudent where upper(s.name) like upper(:name)")
    List<Student> findAllByName(String name);

    @Query("from Student s join fetch s.skillOfStudent where s.id = :id")
    Student findByIdWithSkills(Long id);

}