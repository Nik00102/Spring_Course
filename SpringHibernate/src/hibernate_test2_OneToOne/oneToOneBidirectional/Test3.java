package hibernate_test2_OneToOne.oneToOneBidirectional;


import hibernate_test2_OneToOne.entityBidir.Detail;
import hibernate_test2_OneToOne.entityBidir.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test3 {
    public static void main(String[] args) {
        // all entities from package enityBidir
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            // Delete both Detail and Employee

            // If you want delete only Detail without Employee
            // so change cascade = {CascadeTYPE.Persist, CascadeType.Refresh} and code will be
            //
            // Detail detail = session.get(Detail.class, 3);
            // detail.getEmployee().setEmpDetail(null); // you need to break relation with foreign key!!!!!!!
            // session.delete(detail);


            Session session = factory.getCurrentSession();
            session.beginTransaction(); // open transaction


            Detail detail = session.get(Detail.class, 3);

            session.delete(detail);

            session.getTransaction().commit(); // close transaction

            System.out.println("Done!!");

        } finally {
            factory.close(); // need to close factory even exception appears
        }

    }
}
