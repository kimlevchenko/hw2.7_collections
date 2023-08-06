package pro.sky.java.group.hwcollections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.group.hwcollections.model.Employee;
import pro.sky.java.group.hwcollections.service.DepartmentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/department")

public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public double max(@RequestParam int departmentId) {
        return service.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public double min(@RequestParam int departmentId) {
        return service.minSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> findAll(@RequestParam int departmentId) {
        return service.findAllByDept(departmentId);
    }

    @GetMapping("/all")
    public Collection<Employee> findAllByDept(@RequestParam int departmentId) {
        return (Collection<Employee>) service.groupByDept(departmentId);
    }
}
