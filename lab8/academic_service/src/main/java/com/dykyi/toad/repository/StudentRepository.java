package com.dykyi.toad.repository;

import com.dykyi.toad.dto.StudentLightDTO;
import com.dykyi.toad.entity.Student;
import com.dykyi.toad.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNumber(Integer number);

    List<Student> findAllByGroupOrderByNumberDesc(String group);

    List<Student> findAllByAddressCountry(Country country);

    @Query("SELECT new com.dykyi.toad.dto.StudentLightDTO(student.id,student.name) from Student student")
    List<StudentLightDTO> findAllStudentLightDTO();
}
