package hibernate_test2_OneToOne.oneToOneUnidirectional;

import hibernate_test2_OneToOne.entityUnidir.Detail;
import hibernate_test2_OneToOne.entityUnidir.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test3 {
    public static void main(String[] args) {
        // all entities from package enityUnidir
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            // delete
            session.beginTransaction(); // open transaction

            Employee emp = session.get(Employee.class, 2); // get from bd

            session.delete(emp); // delete

            session.getTransaction().commit(); // close transaction

            System.out.println("Done!!");

        } finally {
            session.close();
            factory.close(); // need to close factory even exception appears
        }

    }
}
