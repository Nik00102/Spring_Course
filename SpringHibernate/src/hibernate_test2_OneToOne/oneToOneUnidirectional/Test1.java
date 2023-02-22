package hibernate_test2_OneToOne.oneToOneUnidirectional;

import hibernate_test2_OneToOne.entityUnidir.Detail;
import hibernate_test2_OneToOne.entityUnidir.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        // all entities from package enityUnidir
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

            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 2000);
            Detail detail = new Detail("St Petersburg", "+7999999999", "olejka@gmail.com");

            employee.setEmpDetail(detail);

            session.save(employee); // insert to bd

            session.getTransaction().commit(); // close transaction

            System.out.println("Done!!");

        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
