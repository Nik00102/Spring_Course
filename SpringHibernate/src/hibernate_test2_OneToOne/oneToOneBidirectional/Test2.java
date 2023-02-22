package hibernate_test2_OneToOne.oneToOneBidirectional;


import hibernate_test2_OneToOne.entityBidir.Detail;
import hibernate_test2_OneToOne.entityBidir.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        // all entities from package enityBidir
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            // get
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // open transaction


            Detail detail = session.get(Detail.class, 3);

            System.out.println(detail.getEmployee());

            session.getTransaction().commit(); // close transaction

            System.out.println("Done!!");

        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
