package kirillov.springboot_app_ii.service;

import kirillov.springboot_app_ii.dao.EmployeeRepository;
import kirillov.springboot_app_ii.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    // Spring сам открывает и закрывает транзакции

    @Override
    public List<Employee> getAllEmployees() {return employeeRepository.findAll();}

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteEmployee(int id) {employeeRepository.deleteById(id);}

    @Override
    public List<Employee> findEmployeesByName(String name) {return employeeRepository.findEmployeesByName(name);}
}
