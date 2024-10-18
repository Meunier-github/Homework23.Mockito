package pro.sky.Homework23.Mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework23.Mockito.exception.EmployeeAlreadyAddedException;
import pro.sky.Homework23.Mockito.exception.EmployeeNotFoundException;
import pro.sky.Homework23.Mockito.exception.EmployeeStorageIsFullException;
import pro.sky.Homework23.Mockito.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    Map<String, Employee> employees = new HashMap<>();
    final int MAX_COUNT_EMPLOYEES = 5;

    public Employee add(String firstName, String lastName, String secondName,int departement, int salary) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        if (employees.size() >= MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName, secondName,departement, salary);
        if (employees.containsKey(employee.getFIO())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFIO(), employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName, String secondName) {


        Employee employee = employees.get(getFIO(firstName, lastName, secondName));
        if (!employees.containsKey(employee.getFIO())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFIO());
        return employee;
    }
    public String getFIO(String firstName, String lastName, String secondName) {
        return firstName + lastName + secondName;
    }
    public Employee find(String firstName, String lastName, String secondName) {

        Employee employee = employees.get(getFIO(firstName, lastName, secondName));
        if (employee==null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
