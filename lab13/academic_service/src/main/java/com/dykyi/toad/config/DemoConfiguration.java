package com.dykyi.toad.config;

import com.dykyi.toad.entity.Address;
import com.dykyi.toad.entity.Course;
import com.dykyi.toad.entity.Curator;
import com.dykyi.toad.entity.Student;
import com.dykyi.toad.entity.Teacher;
import com.dykyi.toad.enums.Country;
import com.dykyi.toad.service.CourseService;
import com.dykyi.toad.service.CuratorService;
import com.dykyi.toad.service.StudentService;
import com.dykyi.toad.service.TeacherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.AUGUST;


@Configuration
public class DemoConfiguration {
    @Bean
    public CommandLineRunner loadData(StudentService studentService, CuratorService curatorService, TeacherService teacherService, CourseService courseService) {
        return args -> {
            Teacher teacher01 = new Teacher(
                    "Альберт Айнштайн",
                    new Address(
                            "01004",
                            "Main street",
                            "London",
                            Country.UK
                    ),
                    new GregorianCalendar(1879, Calendar.MARCH, 14)
            );
            teacher01=teacherService.save(teacher01);
            Curator curator01=new Curator(10);
            curator01 = curatorService.save(curator01);
            teacher01.setCurator(curator01);
            teacher01=teacherService.save(teacher01);

            Teacher teacher02 = new Teacher(
                    "Ервін Шредінгер",
                    new Address(
                            "22007",
                            "First street",
                            "Bristol",
                            Country.UK
                    ),
                    new GregorianCalendar(1887, Calendar.AUGUST, 12)
            );
            Curator curator02=new Curator(7);
            teacher02.setCurator(curator02);
            teacher02=teacherService.save(teacher02);

            Course course01=new Course("Java", 8.0);
            course01=courseService.save(course01);
            Course course02=new Course("Python",5.0);
            course02=courseService.save(course02);
            Course course03=new Course("C#",6.5);
            course03=courseService.save(course03);

            if (studentService.getAll().isEmpty()) {
                Student student01 = new Student("Тарас Шевченко", new GregorianCalendar(1814, Calendar.MARCH, 9), "КН-1", 10001, new Address("01001", "Street, 35", "Kyiv", Country.UKRAINE));
                student01 = studentService.save(student01);
                Student student02 = new Student("Іван Франко", new GregorianCalendar(1856, Calendar.AUGUST, 27), "КН-1", 10002, new Address("79000", "Freedom St, 1", "Lviv", Country.UKRAINE));
                student02 = studentService.save(student02);
                Student student03 = new Student("Леся Українка", new GregorianCalendar(1871, Calendar.FEBRUARY, 25), "КН-2", 10003, new Address("01002", "Main St, 10", "Kyiv", Country.UKRAINE));
                student03 = studentService.save(student03);
                Student student04 = new Student("Григорій Сковорода", new GregorianCalendar(1722, Calendar.NOVEMBER, 3), "КН-2", 10004, new Address("61000", "Shevchenko St, 5", "Kharkiv", Country.UKRAINE));
                student04 = studentService.save(student04);
                Student student05 = new Student("Володимир Винниченко", new GregorianCalendar(1880, Calendar.JULY, 27), "КН-3", 10005, new Address("79001", "Bandera St, 15", "Lviv", Country.UKRAINE));
                student05 = studentService.save(student05);
                Student student06 = new Student("Михайло Коцюбинський", new GregorianCalendar(1864, Calendar.SEPTEMBER, 17), "КН-3", 10006, new Address("58000", "Franko St, 20", "Chernivtsi", Country.UKRAINE));
                student06 = studentService.save(student06);

                student01.addCourse(course01);
                student01.addCourse(course02);
                student01.addCourse(course03);
                student01=studentService.save(student01);
                student02.addCourse(course01);
                student02=studentService.save(student02);
                student03.addCourse(course01);
                student03.addCourse(course02);
                student03=studentService.save(student03);

                student01.setCurator(teacher01.getCurator());
                student01=studentService.save(student01);
                student02.setCurator(teacher01.getCurator());
                student02=studentService.save(student02);
                student03.setCurator(teacher02.getCurator());
                student03=studentService.save(student03);
            }
        };
    }
}
