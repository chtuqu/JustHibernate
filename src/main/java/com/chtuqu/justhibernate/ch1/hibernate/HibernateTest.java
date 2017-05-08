package com.chtuqu.justhibernate.ch1.hibernate;

import com.chtuqu.justhibernate.ch1.dto.Movie;

public class HibernateTest {
    public static void main(String[] args) {
        HibernatePersistor persistor = new HibernatePersistor();

        int id = 1001;
        Movie movie = createMovie(id);

        persistor.persist(movie);

        movie = persistor.query(id);
//        System.out.println(movie);
    }

    private static Movie createMovie(int id) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle("Fight Club");
        movie.setDirector("David Fincher");
        movie.setSynopsis("First rule of Fight Club: You do not talk about Fight Club");
        return movie;
    }
}
