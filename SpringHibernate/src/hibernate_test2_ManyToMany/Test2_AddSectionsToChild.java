package hibernate_test2_ManyToMany;

import hibernate_test2_ManyToMany.entity.Child;
import hibernate_test2_ManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2_AddSectionsToChild {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            Section section1 = new Section("Volley");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");

            Child child1 = new Child("Igor", 10);

            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);

            session.beginTransaction();


            session.save(child1);


            session.getTransaction().commit();

            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
