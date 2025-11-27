package com.dykyi.toad.automotive;

import com.dykyi.toad.automotive.entity.Car;
import com.dykyi.toad.automotive.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AutomotiveIntegrationTest {
    @Autowired CarService carService;

    @Test
    void testSaveAndRetrieveCar() {
        Car car = new Car();
        car.setNumber(12345);
        car.setGroup("IntegrationTestGroup");
        Car saved = carService.save(car);
        assertNotNull(saved.getId());
        Car found = carService.getById(saved.getId());
        assertEquals(12345, found.getNumber());
        assertEquals("IntegrationTestGroup", found.getGroup());
    }
}

