package com.dykyi.toad.repository;

import com.dykyi.toad.dto.StudentLightDTO;
import com.dykyi.toad.entity.Student;
import com.dykyi.toad.enums.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByNumber(Integer number);

    List<Student> findAllByGroupOrderByNumberDesc(String group);

    List<Student> findAllByAddressCountry(Country country);

    @Aggregation(pipeline = {
            "{ '$project': { 'id': 1, 'name': 1 } }"
    })
    List<StudentLightDTO> findAllStudentLightDTO();
}
