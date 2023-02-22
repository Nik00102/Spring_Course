package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // create
            // read 1
            Session session = factory.getCurrentSession(); // every time
            session.beginTransaction(); // open transaction
            Employee emp = session.get(Employee.class, 1); // get this emp from bd
            session.getTransaction().commit(); // close transaction
            System.out.println(emp);

            // read full list
            session = factory.getCurrentSession(); // every time
            session.beginTransaction(); // open transaction

            List<Employee> list = session.createQuery("from Employee")
                    .getResultList(); // get this empList from bd

            for (Employee e : list)
                System.out.println(e);
            session.getTransaction().commit(); // close transaction

            // read list of employees with name=Elena && salary>2000
            session = factory.getCurrentSession(); // every time
            session.beginTransaction(); // open transaction

            List<Employee> list1 = session.createQuery("from Employee where name= 'Elena' and salary > 2000")
                    .getResultList(); // get this empList from bd

            for (Employee e : list1)
                System.out.println(e);
            session.getTransaction().commit(); // close transaction


        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
