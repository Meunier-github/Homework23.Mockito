package pro.sky.Homework23.Mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Homework23.Mockito.model.Employee;
import pro.sky.Homework23.Mockito.service.EmployeeService;

import java.util.Collection;

@RestController()
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName") String firstName,
                        @RequestParam(value = "lastName") String lastName,
                        @RequestParam(value = "secondName") String secondName,
                        @RequestParam(value = "department") Integer department,
                        @RequestParam(value = "salary") Integer salary) {

        return employeeService.add(firstName, lastName, secondName,department,salary);

    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "secondName") String secondName) {
        return employeeService.remove(firstName, lastName,secondName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName") String firstName,
                         @RequestParam(value = "lastName") String lastName,
                         @RequestParam(value = "secondName") String secondName) {

        return employeeService.find(firstName, lastName,secondName);
    }

    @GetMapping(path = "/print")
    public Collection<Employee> print() {
        return employeeService.getAll();
    }



}
