package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.exemple.demo.consumer.contract.dao.VoieDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.postgres.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:postgres://localhost:5432/p6", "postgres", "p6");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }

    public VoieDao getVoieDao() {
        return new VoieDaoImpl(this);
    }
}