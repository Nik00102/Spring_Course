package hibernate_test2_OneToMany_Bi;



import hibernate_test2_OneToMany_Bi.entity.Department;
import hibernate_test2_OneToMany_Bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test4 {
    public static void main(String[] args) {
        // all entities from package enityBidir
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            // delete worker
            session = factory.getCurrentSession();

            session.beginTransaction(); // open transaction
            Department emp = session.get(Department.class, 5);
            session.delete(emp);


            session.getTransaction().commit(); // close transaction

            System.out.println("Done!!");

        } finally {
            session.close();
            factory.close(); // need to close factory even exception appears
        }

    }
}
