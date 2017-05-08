package com.chtuqu.justhibernate.ch1.jdbc;

import com.chtuqu.justhibernate.ch1.dto.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPersistor {

    private String insertSql = "INSERT INTO MOVIES (title, director, synopsis) VALUES (?,?,?);";
    private String selectSql = "SELECT * FROM MOVIES WHERE title = ?";

    void persist(Movie movie) {
        try {
            PreparedStatement pst = JdbcConnectionManager.getConnection().prepareStatement(insertSql);

            pst.setString(1, movie.getTitle());
            pst.setString(2, movie.getDirector());
            pst.setString(3, movie.getSynopsis());

            pst.execute();

            System.out.println("Movie persisted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void fetch(String title) {
        try {
            PreparedStatement pst = JdbcConnectionManager.getConnection().prepareStatement(selectSql);

            pst.setString(1, title);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Movie found: " + rs.getInt("ID") + ", Title: " + rs.getString("TITLE"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
