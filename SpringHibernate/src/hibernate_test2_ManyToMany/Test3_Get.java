package hibernate_test2_ManyToMany;

import hibernate_test2_ManyToMany.entity.Child;
import hibernate_test2_ManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3_Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Section section1 = session.get(Section.class, 1);
            System.out.println(section1.getChildren());

            session.getTransaction().commit();

            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
