package pro.sky.java.group.hwcollections.service;

import org.springframework.stereotype.Service;
import pro.sky.java.group.hwcollections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.group.hwcollections.exceptions.EmployeeNotFoundException;
import pro.sky.java.group.hwcollections.exceptions.EmployeeStorageIsFullException;
import pro.sky.java.group.hwcollections.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int SIZE = 10;

    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {

        this.employeeList = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if (employeeList.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            return employeeList.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            return employeeList.remove(employee);

        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employeeList.values());
    }
}
