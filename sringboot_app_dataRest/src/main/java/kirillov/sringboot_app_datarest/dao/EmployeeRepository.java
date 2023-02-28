package kirillov.sringboot_app_datarest.dao;

import kirillov.sringboot_app_datarest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
