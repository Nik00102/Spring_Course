package ru.nikkirillov.spring.rest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nikkirillov.spring.rest.configuration.MyConfig;
import ru.nikkirillov.spring.rest.entity.Employee;

import java.util.List;

/**
 * App!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> allEmployes = communication.getAllEmployees(); // получить список всех работников
        System.out.println(allEmployes);

        Employee empById = communication.getEmployee(1); // получить работника с id=1
        System.out.println(empById);

        Employee addEmp = new Employee("Света", "Соколова", "IT", 999); // update or save
        //addEmp.setId(12); //to update you need set id
        communication.saveEmployee(addEmp);

        //communication.deleteEmployee(13); // delete employee with id
    }
}
