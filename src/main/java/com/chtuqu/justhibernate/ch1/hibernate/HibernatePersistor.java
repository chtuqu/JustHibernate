package com.chtuqu.justhibernate.ch1.hibernate;

import com.chtuqu.justhibernate.ch1.dto.Movie;
import org.hibernate.Session;

public class HibernatePersistor {

    public void persist(Movie movie) {
        Session session = HibernateConnectionManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
    }

    public Movie query(int id) {
        Session session = HibernateConnectionManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Movie movie = session.load(Movie.class, id);
        System.out.println(movie);
        session.getTransaction().commit();
        return movie;
    }
}
