package com.dykyi.toad.study.api;

import com.dykyi.toad.study.dto.CourseDTO;
import com.dykyi.toad.study.entity.Student;
import com.dykyi.toad.study.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("{id}/students")
    public ResponseEntity<List<Student>>
    getStudentsByCourse(@PathVariable Long id) {
        try {
            List<Student> students = courseService.getStudentsByCourseId(id);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO
                                                       courseDTO){
        try{
            CourseDTO result=courseService.save(courseDTO);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        try{
            List <CourseDTO> students=courseService.getAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception e){
            return new
                    ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}