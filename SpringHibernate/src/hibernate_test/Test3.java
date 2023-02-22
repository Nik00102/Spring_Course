package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // update
            Session session = factory.getCurrentSession(); // every time
            session.beginTransaction(); // open transaction

            // Get emp with id=1 and update salary for one man
            /*Employee emp = session.get(Employee.class, 1);
            emp.setSalary(2600);
            session.getTransaction().commit(); // close transaction*/

            // Update salary to all Elena's salary to 2800 for some people
            session.createQuery("update Employee set salary = 2800 where name = 'Elena'" ).executeUpdate();
            session.getTransaction().commit(); // close transaction


            System.out.println("Done!!");

        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
