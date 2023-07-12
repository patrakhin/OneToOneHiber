package org.example;

import org.example.model.Passport;
import org.example.model.Person_OtO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person_OtO.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            /*Person_OtO person_otO = new Person_OtO("Test person", 30);
            Passport passport = new Passport(12345);
            person_otO.setPassport(passport);
            session.save(person_otO);*/

            /*Person_OtO person_otO = new Person_OtO("Test person2", 35);
            Passport passport = new Passport(55555);
            person_otO.setPassport(passport);
            session.save(person_otO);*/

            /*Person_OtO person_otO = session.get(Person_OtO.class, 1);
            System.out.println(person_otO.getPassport().getPassportNumber());

            Passport passport = session.get(Passport.class, 1);
            System.out.println(passport.getPerson_otO().getName());*/

            //change pass number some man
            /*Person_OtO person_otO1 = session.get(Person_OtO.class, 2);
            person_otO1.getPassport().setPassportNumber(77777);*/

            //some man delete
            /*Person_OtO person_otO2 = session.get(Person_OtO.class, 2);
            session.remove(person_otO2);*/

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
