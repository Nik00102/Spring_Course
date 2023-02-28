package ru.nikkirillov.springboot.springboot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nikkirillov.springboot.springboot_app.dao.EmployeeDAO;
import ru.nikkirillov.springboot.springboot_app.entity.Employee;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    // Spring сам открывает и закрывает транзакции
    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {employeeDAO.deleteEmployee(id);}
}
