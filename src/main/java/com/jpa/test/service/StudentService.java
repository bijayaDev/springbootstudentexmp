package com.jpa.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jpa.test.dao.StudentRepository;
import com.jpa.test.entities.Student;


@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}


	public Student updateStudent(Student student, int id) {
		Student exisStudent = studentRepository.findById(id).get();
		exisStudent.setName(student.getName());
		exisStudent.setEmail(student.getEmail());
		return studentRepository.save(student);
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public List<Student> getStudentEmail(){
		return studentRepository.findByEmail("j");
	}

    public List<Student> findByEmailStartingWithPrefix(String prefix){
		return studentRepository.findByEmailStartingWith(prefix);
	}

	public List<Student> findByNameEndingWith(String suffix){
		return studentRepository.findByNameEndingWith(suffix);
	}

	public List<Student> findByNameContaining(String words){
		return studentRepository.findByNameContaining(words);
	}

    public List<Student> getAllTheStudent()
	{
		return studentRepository.getAllStudents();
	}






}

