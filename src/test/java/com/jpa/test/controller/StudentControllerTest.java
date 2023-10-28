package com.jpa.test.controller;

import com.jpa.test.entities.Student;
import com.jpa.test.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testGetAllStudentWhenStudentsExistThenReturnStudents() throws Exception {
        Student student = new Student(1, "John", "Class 1", "john@gmail.com");
        when(studentService.getAllStudent()).thenReturn(Arrays.asList(student));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John"));
    }

    @Test
    public void testGetAllStudentWhenNoStudentsThenReturnEmptyList() throws Exception {
        when(studentService.getAllStudent()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    public void testCreateStudentWithValidStudentThenReturnStudent() throws Exception {
        Student student = new Student(1, "John", "Class 1", "john@gmail.com");
        when(studentService.createStudent(any())).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/api")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John\",\"clsName\":\"Class 1\",\"email\":\"john@gmail.com\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));
    }

 /*   @Test
    public void testCreateStudentWithInvalidStudentThenReturnInternalServerError() throws Exception {
        when(studentService.createStudent(any())).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders.post("/api")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John\",\"clsName\":\"Class 1\",\"email\":\"john@gmail.com\"}"))
                .andExpect(status().isInternalServerError());
    }*/

    // Similar tests can be written for other methods in the StudentController class.
}