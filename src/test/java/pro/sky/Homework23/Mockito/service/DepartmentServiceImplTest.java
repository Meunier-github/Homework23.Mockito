package pro.sky.Homework23.Mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Homework23.Mockito.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentServiceImpl departmentService;

    @BeforeEach
    void init() {
        when(employeeService.getAll())
                .thenReturn(List.of(
                        new Employee("Ivan", "Ivanov", "Ivanych", 1, 300000),
                        new Employee("Petr", "Petrov", "Petrovich", 1, 100000),
                        new Employee("Nicolay", "Ivanov", "Ivanych", 2, 200000)
                ));
    }

    @Test
    void getEmployeeSalarySum() {
        assertEquals(400000, departmentService.getEmployeeSalarySum(1));
    }

    @Test
    void getEmployeeSalaryMin() {
        assertEquals(100000, departmentService.getEmployeeSalaryMin(1));
    }
    @Test
    void getEmployeeSalaryMinNull() {
        assertThrows(NullPointerException.class, () -> departmentService.getEmployeeSalaryMin(3));
    }

    @Test
    void getEmployeeSalaryMax() {
        double resultat = departmentService.getEmployeeSalaryMax(1);
        assertEquals(300000, resultat);
    }
    @Test
    void getEmployeeSalaryMaxNull() {
        assertThrows(NullPointerException.class, () -> departmentService.getEmployeeSalaryMax(3));
    }

    @Test
    void getAllDepartement() {
        List<Employee> employees =  employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == 1)
                .collect(Collectors.toList());
        assertEquals(employees,departmentService.getAll(1));

    }

    @Test
    void testGetAll() {
        Map<Integer, List<Employee>> employees =  employeeService.getAll().stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));
        assertEquals(employees,departmentService.getAll());

    }
}