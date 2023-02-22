package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // create
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Alex", "Ivanov", "Adninistration", 2500);
            session.beginTransaction(); // open transaction
            session.save(employee); // insert to bd
            session.getTransaction().commit(); // close transaction

            System.out.println(employee);

        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
