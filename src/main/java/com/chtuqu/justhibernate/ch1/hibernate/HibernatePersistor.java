package com.chtuqu.justhibernate.ch1.hibernate;

import com.chtuqu.justhibernate.ch1.dto.Movie;
import org.hibernate.Session;

public class HibernatePersistor {

    public void persist(Movie movie) {
        Session session = HibernateConnectionManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
        session.close();
    }

    public Movie query(int id) {
        Session session = HibernateConnectionManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, id);
        session.getTransaction().commit();
        session.close();
        return movie;
    }
}
