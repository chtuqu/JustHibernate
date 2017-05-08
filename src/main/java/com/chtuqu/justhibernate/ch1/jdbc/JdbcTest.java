package com.chtuqu.justhibernate.ch1.jdbc;

import com.chtuqu.justhibernate.ch1.dto.Movie;

public class JdbcTest {
    public static void main(String[] args) {
        JdbcPersistor persistor = new JdbcPersistor();
        Movie movie = createMovie();
        persistor.persist(movie);
        persistor.fetch("Fight Club");
    }

    private static Movie createMovie() {
        Movie movie = new Movie();
        movie.setTitle("Fight Club");
        movie.setDirector("David Fincher");
        movie.setSynopsis("First rule of Fight Club: You do not talk about Fight Club");
        return movie;
    }
}
