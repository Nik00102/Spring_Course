package ru.nikkirillov.spring.mvc_hibernate_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nikkirillov.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import ru.nikkirillov.spring.mvc_hibernate_aop.entity.Employee;
import ru.nikkirillov.spring.mvc_hibernate_aop.service.EmployeeService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    // чтобы view смог отобразить значение полей, необходимо в параметрах присутствие модели
    // и добавить в модель аттрибут allEmps (view будет использовать этот аттрибут)
    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    // добавить в модель аттрибут employee (view будет использовать этот аттрибут)
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }
}
