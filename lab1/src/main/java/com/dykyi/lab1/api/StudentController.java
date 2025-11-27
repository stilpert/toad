package com.dykyi.lab1.api;

import com.dykyi.lab1.entity.Student;
import com.dykyi.lab1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = studentService.getAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        try {
            Student student = studentService.getById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("byGroup/{number}")
    public ResponseEntity<Student> getStudentByNumber(@PathVariable
                                                      Integer number) {
        try {
            Student student = studentService.getByNumber(number);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("byGroup/{group}")
    public ResponseEntity<List<Student>> getStudentsByGroup(@PathVariable
                                                            String group) {
        try {
            List<Student> students = studentService.getAllByGroup(group);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}