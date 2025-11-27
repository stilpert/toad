package com.dykyi.lab3.study.repository;

import com.dykyi.lab3.study.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
