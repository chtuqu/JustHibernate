package com.chtuqu.justhibernate.ch1.hibernate;

import com.chtuqu.justhibernate.ch1.dto.Movie;

public class HibernateTest {
    public static void main(String[] args) {
        HibernatePersistor persistor = new HibernatePersistor();

        Movie movie = createMovie("Fight Club", "David Fincher", "First rule of Fight Club: You do not talk about Fight Club");

        persistor.persist(movie);
        movie = persistor.query(Movie.class, movie.getId());
        System.out.println(movie);
        HibernateConnectionManager.getSessionFactory().close();
    }

    private static Movie createMovie(String title, String director, String synopsis) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setSynopsis(synopsis);
        return movie;
    }
}
