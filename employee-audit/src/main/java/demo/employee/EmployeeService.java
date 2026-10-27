package demo.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String name, String department) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Employee name is required");
        }

        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException(
                "Department is required");
        }

        Employee employee =
            new Employee(name.trim(), department.trim());

        employees.add(employee);

        return employee;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}