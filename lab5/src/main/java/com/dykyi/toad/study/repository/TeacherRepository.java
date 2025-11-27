package com.dykyi.toad.study.repository;

import com.dykyi.toad.study.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
