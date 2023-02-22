package hibernate_test2_ManyToMany;

import hibernate_test2_ManyToMany.entity.Child;
import hibernate_test2_ManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_AddChildrenToSection {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            Section section1 = new Section("Football");
            Child child1 = new Child("Nik", 5);
            Child child2 = new Child("Masha", 6);
            Child child3 = new Child("Vitya", 7);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();


            session.save(section1);


            session.getTransaction().commit();

            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
