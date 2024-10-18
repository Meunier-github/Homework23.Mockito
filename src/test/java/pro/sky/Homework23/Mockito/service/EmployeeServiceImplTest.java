package pro.sky.Homework23.Mockito.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pro.sky.Homework23.Mockito.exception.EmployeeAlreadyAddedException;
import pro.sky.Homework23.Mockito.exception.EmployeeNotFoundException;
import pro.sky.Homework23.Mockito.exception.EmployeeStorageIsFullException;
import pro.sky.Homework23.Mockito.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @BeforeEach
    void setUp() {
        employeeService.add("Ivan", "Ivanov", "Ivanych", 1, 300000);
        employeeService.add("Petr", "Petrov", "Petrovich", 1, 100000);
        employeeService.add("Nicolay", "Ivanov", "Ivanych", 2, 200000);
    }

    @Test
    void addEmployeeAlreadyExit() {
        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.add("Ivan", "Ivanov", "Ivanych", 1, 300000);
        });
    }

    @Test
    void addEmployeeIsFullException() {
        employeeService.add("Ivan1", "Ivanov", "Ivanych", 1, 300000);
        employeeService.add("Petr1", "Petrov", "Petrovich", 1, 100000);
        assertThrows(EmployeeStorageIsFullException.class, () -> {
            employeeService.add("Nicolay1", "Ivanov", "Ivanych", 2, 200000);
        });
    }

    @Test
    void testremove() {
        int size = employeeService.getAll().size();
        employeeService.remove("Ivan", "Ivanov", "Ivanych");
        assertEquals(size - 1, employeeService.getAll().size());
    }

    @Test
    void testgetFIO() {
        String employeeFIO = employeeService.getFIO("Ivan", "Ivanov", "Ivanych");
        assertEquals("IvanIvanovIvanych",employeeFIO);
    }

    @Test
    void testfind() {

        Employee employee = employeeService.employees.get(employeeService.getFIO("Ivan", "Ivanov", "Ivanych"));
        Employee employeeFind = employeeService.find("Ivan", "Ivanov", "Ivanych");
        assertEquals(employee,employeeFind);

    }
    @Test
    void testfindEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.find("Ivan1", "Ivanov", "Ivanych");
        });

    }

}