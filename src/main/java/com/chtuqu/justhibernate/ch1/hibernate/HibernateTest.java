package com.chtuqu.justhibernate.ch1.hibernate;

import com.chtuqu.justhibernate.ch1.dto.Movie;

public class HibernateTest {
    public static void main(String[] args) {
        HibernatePersistor persistor = new HibernatePersistor();

        Movie movie = createMovie();

        persistor.persist(movie);
        movie = persistor.query(movie.getId());
//        System.out.println(movie);
        HibernateConnectionManager.getSessionFactory().close();
    }

    private static Movie createMovie() {
        Movie movie = new Movie();
        movie.setTitle("Fight Club");
        movie.setDirector("David Fincher");
        movie.setSynopsis("First rule of Fight Club: You do not talk about Fight Club");
        return movie;
    }
}
