package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/kata_jdbc";

    private static final String USER = "root";

    private static final String PASSWORD =
            System.getenv("KATA_DB_PASSWORD");

    private static SessionFactory sessionFactory;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            configuration.setProperty(
                    "hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver"
            );

            configuration.setProperty(
                    "hibernate.connection.url",
                    URL
            );

            configuration.setProperty(
                    "hibernate.connection.username",
                    USER
            );

            configuration.setProperty(
                    "hibernate.connection.password",
                    PASSWORD
            );

            configuration.setProperty(
                    "hibernate.dialect",
                    "org.hibernate.dialect.MySQL8Dialect"
            );

            configuration.setProperty(
                    "hibernate.show_sql",
                    "true"
            );

            configuration.setProperty(
                    "hibernate.hbm2ddl.auto",
                    "none"
            );

            configuration.addAnnotatedClass(User.class);

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }
}