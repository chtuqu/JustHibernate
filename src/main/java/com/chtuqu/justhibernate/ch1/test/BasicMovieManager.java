package com.chtuqu.justhibernate.ch1.test;

import com.chtuqu.justhibernate.ch1.dto.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class BasicMovieManager {
    private SessionFactory sessionFactory;

    private void initSessionFactory() {
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }

        /*Movie movie = new Movie();
        movie.setId(2);
        movie.setTitle("Jaws");
        movie.setDirector("Steven Spielberg");
        movie.setSynopsis("Story of a great white shark");

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();*/

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Movie movie = session.load(Movie.class, 1);

        System.out.println(movie);
        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        BasicMovieManager movieManager = new BasicMovieManager();
        movieManager.initSessionFactory();
    }
}
