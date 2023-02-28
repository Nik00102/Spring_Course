package ru.nikkirillov.springboot.springboot_app.dao;

/*import org.hibernate.Session;
import org.hibernate.query.Query;*/ // если используем сессии Session то раскомментировать
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import ru.nikkirillov.springboot.springboot_app.entity.Employee;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@EnableAutoConfiguration
public class EmployeeDAOImpl implements EmployeeDAO{
    /*@Autowired
    private SessionFactory sessionFactory;*/ // использовали до этого, когда использовали чистый Hibernate, а в данном примере взяли JPA
    @Autowired
    private EntityManager entityManager; // entityManager служит для связи entity с бд и создается автоматически

    // все что связано с Session относится к Hibernate, и так тоже можно делать

    @Override
    public List<Employee> getAllEmployees() {
        /*Session session = entityManager.unwrap(Session.class);

        //List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList(); //ниже расшифровка

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();*/

        Query query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();

        return employees;
    }

    // id != 0 значит работник уже есть и поэтому выполняем uddate
    // id==0 значит сохраняем нового
    // метод save() всегда создает нового работника
    // saveOrUpdate() если нужно обновляет
    @Override
    public void saveEmployee(Employee employee) {
        /*Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);*/

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        /*Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);*/

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        /*Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id); // устанавливаем в запросе параметр
        query.executeUpdate(); // метод обновления и удаления*/

        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id); // устанавливаем в запросе параметр
        query.executeUpdate(); // метод обновления и удаления
    }
}
