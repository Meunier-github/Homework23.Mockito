package pro.sky.Homework23.Mockito.service;

import pro.sky.Homework23.Mockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public double getEmployeeSalarySum(int department);

    public double getEmployeeSalaryMin(int department);

    public double getEmployeeSalaryMax(int department);

    public List<Employee> getAll(int department);

    public Map<Integer, List<Employee>> getAll();



}
