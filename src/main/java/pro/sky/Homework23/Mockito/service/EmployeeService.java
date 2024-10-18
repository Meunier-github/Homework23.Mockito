package pro.sky.Homework23.Mockito.service;

import org.apache.coyote.BadRequestException;
import pro.sky.Homework23.Mockito.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName,String lastName,String secondName,int departement,int salary);

    Employee remove(String firstName,String lastName,String secondName);

    Employee find(String firstName,String lastName,String secondName);

    Collection<Employee> getAll();

}
