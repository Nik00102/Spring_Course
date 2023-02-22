package hibernate_test2_OneToOne.oneToOneBidirectional;


import hibernate_test2_OneToOne.entityBidir.Detail;
import hibernate_test2_OneToOne.entityBidir.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        // all entities from package enityBidir
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            // create
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // open transaction

            /*Employee employee = new Employee("Nik", "Kirillov", "IT", 2500);
            Detail detail = new Detail("Moscow", "+79165475984", "kirillovnick@gmail.com");*/

            Employee employee = new Employee("Misha", "Smirnov", "HR", 3200);
            Detail detail = new Detail("London", "+55999999999", "mishanya@gmail.com");

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Ahtung!!!!!!!!!!!
            // it mandatory to do for both, if didn't do employee.setEmpDetail(detail)
            // if not in bd you didn't update foreign key
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.save(detail); // insert to bd

            session.getTransaction().commit(); // close transaction

            System.out.println("Done!!");

        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
