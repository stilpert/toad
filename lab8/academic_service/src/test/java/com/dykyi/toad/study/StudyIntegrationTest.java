package com.dykyi.toad;

import com.dykyi.toad.entity.Address;
import com.dykyi.toad.entity.Student;
import com.dykyi.toad.enums.Country;
import com.dykyi.toad.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyIntegrationTest {
    @Autowired StudentService studentService;

    @Test
    void testSaveAndRetrieveStudent() {
        Student student = new Student("IntegrationTestStudent", new GregorianCalendar(1814, Calendar.MARCH, 9), "КН-1", 7777, new Address("01001", "Street, 35", "Kyiv", Country.UKRAINE));
        Student saved = studentService.save(student);
        assertNotNull(saved.getId());
        Student found = studentService.getById(saved.getId());
        assertEquals("IntegrationTestStudent", found.getName());
    }
}