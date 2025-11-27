package com.dykyi.lab2.config;

import com.dykyi.lab2.entity.Address;
import com.dykyi.lab2.entity.Car;
import com.dykyi.lab2.entity.Owner;
import com.dykyi.lab2.entity.Student;
import com.dykyi.lab2.enums.Country;
import com.dykyi.lab2.enums.OwnerType;
import com.dykyi.lab2.service.CarService;
import com.dykyi.lab2.service.OwnerService;
import com.dykyi.lab2.service.StudentService;
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
            }
        };
    }

    @Bean
    public CommandLineRunner loadCars(CarService carService, OwnerService ownerService) {
        return args -> {
            if (carService.getAll().isEmpty()) {
                Owner owner1 = new Owner(null, "John Doe", OwnerType.INDIVIDUAL, "Kyiv, Ukraine");
                Owner owner2 = new Owner(null, "Acme Corp", OwnerType.COMPANY, "Lviv, Ukraine");
                Owner owner3 = new Owner(null, "Jane Smith", OwnerType.INDIVIDUAL, "Odesa, Ukraine");
                owner1 = ownerService.save(owner1);
                owner2 = ownerService.save(owner2);
                owner3 = ownerService.save(owner3);
                carService.save(new Car("Toyota", 2023, "A", 1, owner1));
                carService.save(new Car("Honda", 2010, "A", 2, owner2));
                carService.save(new Car("Ford", 1973, "B", 3, owner3));
                carService.save(new Car("Chevrolet", 1999, "B", 4, owner1));
                carService.save(new Car("Nissan", 2015, "C", 5, owner2));
                carService.save(new Car("Hyundai", 2020, "C", 6, owner3));
            }
        };
    }
}
