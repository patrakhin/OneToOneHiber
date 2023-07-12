package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.example.model.Passport;
import org.example.model.Person_OtO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        /*Configuration configuration = new Configuration().addAnnotatedClass(Person_OtO.class).addAnnotatedClass(Passport.class);*/

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        /*Session session = sessionFactory.getCurrentSession();*/

        /*try {
            session.beginTransaction();

            *//*Person_OtO person_otO = new Person_OtO("Test person", 30);
            Passport passport = new Passport(12345);
            person_otO.setPassport(passport);
            session.save(person_otO);*//*

            *//*Person_OtO person_otO = new Person_OtO("Test person2", 35);
            Passport passport = new Passport(55555);
            person_otO.setPassport(passport);
            session.save(person_otO);*//*

            *//*Person_OtO person_otO = session.get(Person_OtO.class, 1);
            System.out.println(person_otO.getPassport().getPassportNumber());

            Passport passport = session.get(Passport.class, 1);
            System.out.println(passport.getPerson_otO().getName());*//*

            //change pass number some man
            *//*Person_OtO person_otO1 = session.get(Person_OtO.class, 2);
            person_otO1.getPassport().setPassportNumber(77777);*//*

            //some man delete
            *//*Person_OtO person_otO2 = session.get(Person_OtO.class, 2);
            session.remove(person_otO2);*//*

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }*/

        //try with resources
        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            /*Movie movie = new Movie("Pulp fiction", 1994);
            Actor actor1 = new Actor("Harley Keitel", 81);
            Actor actor2 = new Actor("Samuel L. Jackson", 72);

            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.save(movie);
            session.save(actor1);
            session.save(actor2);*/

            /*Movie movie = session.get(Movie.class, 1);
            System.out.println(movie.getActors());*/

            /*Movie movie = new Movie("Reservoir Dogs", 1992);
            Actor actor = session.get(Actor.class, 1);

            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));

            actor.getMovies().add(movie);
            session.save(movie);*/

            //actors film delete
            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }
    }
}
