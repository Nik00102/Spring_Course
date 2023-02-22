package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // delete
            Session session = factory.getCurrentSession(); // every time
            session.beginTransaction(); // open transaction

            // Get emp with id=2 and delete man
           /* Employee emp = session.get(Employee.class, 2);
            session.delete(emp);
            session.getTransaction().commit(); // close transaction*/

            // Delete all Elena's from table
            session.createQuery("delete Employee where name = 'Elena'" ).executeUpdate();
            session.getTransaction().commit(); // close transaction


            System.out.println("Done!!");

        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
