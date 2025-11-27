package com.dykyi.lab1.config;


import com.dykyi.lab1.entity.Car;
import com.dykyi.lab1.entity.Student;
import com.dykyi.lab1.service.CarService;
import com.dykyi.lab1.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Configuration
public class DemoConfiguration {
    @Bean
    public CommandLineRunner loadData(StudentService studentService) {
        return args -> {
            if (studentService.getAll().isEmpty()) {
                Student student01 = new Student(
                        "Тарас Шевченко",
                        new GregorianCalendar(1814, Calendar.MARCH, 9),
                        "КН-1",
                        10001
                );
                student01 = studentService.save(student01);
                Student student02 = new Student(
                        "Іван Франко",
                        new GregorianCalendar(1856, Calendar.AUGUST, 27),
                        "КН-1",
                        10002
                );
                student02 = studentService.save(student02);
                Student student03 = new Student(
                        "Леся Українка",
                        new GregorianCalendar(1871, Calendar.FEBRUARY, 25),
                        "КН-2",
                        10003
                );
                student03 = studentService.save(student03);
                Student student04 = new Student(
                        "Григорій Сковорода",
                        new GregorianCalendar(1722, Calendar.NOVEMBER, 3),
                        "КН-2",
                        10004
                );
                student04 = studentService.save(student04);
                Student student05 = new Student(
                        "Володимир Винниченко",
                        new GregorianCalendar(1880, Calendar.JULY, 27),
                        "КН-3",
                        10005
                );
                student05 = studentService.save(student05);
                Student student06 = new Student(
                        "Михайло Коцюбинський",
                        new GregorianCalendar(1864, Calendar.SEPTEMBER, 17),
                        "КН-3",
                        10006
                );
                student06 = studentService.save(student06);
            }
        };
    }

    @Bean
    public CommandLineRunner loadCars(CarService carService) {
        return args -> {
            if (carService.getAll().isEmpty()) {
                carService.save(new Car("Toyota", 2023, "A", 1));
                carService.save(new Car("Honda", 2010, "A", 2));
                carService.save(new Car("Ford", 1973, "B", 3));
                carService.save(new Car("Chevrolet", 1999, "B", 4));
                carService.save(new Car("Nissan", 2015, "C", 5));
                carService.save(new Car("Hyundai", 2020, "C", 6));
            }
        };
    }
}
