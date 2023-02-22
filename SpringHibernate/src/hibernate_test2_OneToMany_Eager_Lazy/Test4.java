package hibernate_test2_OneToMany_Eager_Lazy;




import hibernate_test2_OneToMany_Eager_Lazy.entity.Department;
import hibernate_test2_OneToMany_Eager_Lazy.entity.Employee;
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
            //Employee emp = session.get(Employee.class, 2);
            //session.delete(emp);

            //session.createQuery(Department.class, "delete ")

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Ahtung!!!!!!!!!!!
            // it mandatory to do for both, if didn't do employee.setEmpDetail(detail)
            // if not in bd you didn't update foreign key
            /*employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.save(detail); // insert to bd*/

            session.getTransaction().commit(); // close transaction

            System.out.println("Done!!");

        } finally {
            session.close();
            factory.close(); // need to close factory even exception appears
        }

    }
}
