package com.jpa.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    public List<Student> findByEmail(String email);
    public List<Student> findByEmailStartingWith(String prefix);
    public List<Student> findByNameEndingWith(String suffix);
    public List<Student> findByNameContaining(String words );
    @Query("SELECT s FROM Student s WHERE s.name like '%ru%'")
    public List<Student> getAllStudents();
    @Query(value = "select * from student" , nativeQuery = true)
    public List<Student> getStudent();
    public List<Student> findAllByOrderByName(String name);

    @Query("SELECT s FROM Student s WHERE s.name = :n")
    public List<Student> getAllStudents(@Param("n") String name);

}
