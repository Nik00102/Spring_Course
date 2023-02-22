package ru.nikkirillov.spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nikkirillov.spring.mvc_hibernate_aop.entity.Employee;



import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private SessionFactory sessionFactory;

    // Spring сам открывает и закрывает транзакции

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

        //List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList(); //ниже расшифровка

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    // id != 0 значит работник уже есть и поэтому выполняем uddate
    // id==0 значит сохраняем нового
    // метод save() всегда создает нового работника
    // saveOrUpdate() если нужно обновляет
    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }
}
