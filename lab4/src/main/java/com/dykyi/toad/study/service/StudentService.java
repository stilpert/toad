package com.dykyi.toad.study.service;

import com.dykyi.toad.study.dto.StudentDTO;
import com.dykyi.toad.study.dto.StudentLightDTO;
import com.dykyi.toad.study.entity.Curator;
import com.dykyi.toad.study.entity.Student;
import com.dykyi.toad.study.enums.Country;
import com.dykyi.toad.study.mapper.StudentMapper;
import com.dykyi.toad.study.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getById(long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
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
    public StudentDTO getByNumber(int number){
        return studentRepository
                .findByNumber(number)
                .map(studentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Student doesn't exist"));
    }
    public List<StudentDTO> getAllByGroup(String group){
        return studentRepository
                .findAllByGroupOrderByNumberDesc(group)
                .stream()
                .map(studentMapper::toDTO)
                .toList();
    }
    public List<StudentDTO>getAllByCountry(Country country){
        return studentRepository
                .findAllByAddressCountry(country)
                .stream()
                .map(studentMapper::toDTO)
                .toList();
    }

    public List<StudentLightDTO>getAllStudentNames(){
        return studentRepository.findAllStudentLightDTO();
    }
}