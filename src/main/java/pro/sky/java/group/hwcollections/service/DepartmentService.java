package pro.sky.java.group.hwcollections.service;

import org.springframework.stereotype.Service;
import pro.sky.java.group.hwcollections.exceptions.EmployeeNotFoundException;
import pro.sky.java.group.hwcollections.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public double maxSalary(int deptId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() = deptId)
                .map(Employee::getSalary)
                .max(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    public double minSalary(int deptId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() = deptId)
                .map(Employee::getSalary)
                .min(Comparator.comparingDouble(o -> o))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    public List<Employee> findAllByDept(int deptId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() = deptId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> groupByDept(int departmentId) {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
