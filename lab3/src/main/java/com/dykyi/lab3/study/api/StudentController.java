package com.dykyi.lab3.study.api;

import com.dykyi.lab3.study.entity.Student;
import com.dykyi.lab3.study.enums.Country;
import com.dykyi.lab3.study.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/byCountry/{country}")
    public ResponseEntity<List<Student>> getStudentsByCountry(@PathVariable
                                                              Country country) {
        try {
            List<Student> students = studentService.getAllByCountry(country);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}/curator/name")
    public ResponseEntity<String> getCuratorNameByStudentId(@PathVariable
                                                            Long id) {
        try {
            String name = studentService.getCuratorName(id);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}