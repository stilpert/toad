package com.dykyi.toad.api;

import com.dykyi.toad.dto.StudentDTO;
import com.dykyi.toad.dto.StudentLightDTO;
import com.dykyi.toad.entity.Student;
import com.dykyi.toad.enums.Country;
import com.dykyi.toad.service.StudentService;
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

    @GetMapping("by/group/{group}")
    public ResponseEntity<List<StudentDTO>> getStudentsByGroup(@PathVariable String group) {
        try {
            List<StudentDTO> students = studentService.getAllByGroup(group);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by/country/{country}")
    public ResponseEntity<List<StudentDTO>> getStudentsByCountry(@PathVariable Country country) {
        try {
            List<StudentDTO> students = studentService.getAllByCountry(country);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = studentService.getAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        try {
            Student student = studentService.getById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("byNumber/{number}")
    public ResponseEntity<StudentDTO> getStudentByNumber(@PathVariable Integer number) {
        try {
            StudentDTO student = studentService.getByNumber(number);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}/curator/name")
    public ResponseEntity<String> getCuratorNameByStudentId(@PathVariable String id) {
        try {
            String name = studentService.getCuratorName(id);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/names")
    public ResponseEntity<List<StudentLightDTO>> getAllStudentNames(){
        try{
            List<StudentLightDTO> result=studentService.getAllStudentNames();
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}