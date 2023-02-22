package hibernate_test2_OneToMany_Bi;



import hibernate_test2_OneToMany_Bi.entity.Department;
import hibernate_test2_OneToMany_Bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test3 {
    public static void main(String[] args) {
        // all entities from package enityBidir
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            // get worker and view department
            session = factory.getCurrentSession();

            session.beginTransaction(); // open transaction
            Employee emp = session.get(Employee.class, 1);
            System.out.println(emp.getDepartment());
            System.out.println(emp);

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
