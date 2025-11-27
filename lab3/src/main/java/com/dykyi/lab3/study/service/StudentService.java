package com.dykyi.lab3.study.service;

import com.dykyi.lab3.study.entity.Curator;
import com.dykyi.lab3.study.entity.Student;
import com.dykyi.lab3.study.enums.Country;
import com.dykyi.lab3.study.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getByNumber(int number) {
        return studentRepository.findByNumber(number).orElseThrow(() -> new
                RuntimeException("Student doesn't exist"));
    }

    public Student getById(long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllByGroup(String group) {
        return studentRepository.findAllByGroupOrderByNumberDesc(group);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student>getAllByCountry(Country country){
        return studentRepository.findAllByAddressCountry(country);
    }

    public String getCuratorName(Long studentId){
        Optional<Student> student=studentRepository.findById(studentId);
        if(student.isPresent()){
            Curator curator=student.get().getCurator();
            if(curator!=null){
                return curator.getTeacher().getName();
            }else{
                return "This student doesn't have a curator";
            }
        }else{
            throw new RuntimeException("Student doesn't exist, id="+studentId);
        }
    }
}