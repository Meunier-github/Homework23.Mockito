package pro.sky.Homework23.Mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Homework23.Mockito.service.DepartmentService;
import pro.sky.Homework23.Mockito.model.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalary(@PathVariable Integer id) {
        return departmentService.getEmployeeSalaryMin(id);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalary(@PathVariable Integer id) {
        return departmentService.getEmployeeSalaryMax(id);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSumSalary(@PathVariable Integer id) {
        return departmentService.getEmployeeSalarySum(id);
    }


    @GetMapping(value = "/{id}/employees")
    public List<Employee> getAll(@PathVariable Integer id) {
        return departmentService.getAll(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }


}
