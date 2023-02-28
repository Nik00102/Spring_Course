package ru.nikkirillov.springboot.springboot_app.dao;

import ru.nikkirillov.springboot.springboot_app.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
