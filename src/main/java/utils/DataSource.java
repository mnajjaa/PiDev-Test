package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private  Connection cnx;
    private  String url = "jdbc:mysql://localhost:3306/S1";
    private  String login = "root";
    private  String pwd = "";

    private static DataSource connexion;

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getInstance(){
        if (connexion == null) {
            connexion = new DataSource();
        }
        return connexion;
    }

    public Connection getCnx() {
        return cnx;
    }









}
