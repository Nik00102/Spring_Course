package kirillov.springboot_app_ii.dao;


import kirillov.springboot_app_ii.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeesByName(String name);
}
