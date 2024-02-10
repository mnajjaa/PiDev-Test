package org.example;

import entities.Personne;
import service.PersonneService;
import utils.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        Personne p1 = new Personne("mrad", "Shem");
        PersonneService ps = new PersonneService();
        //ps.add(p1);
        //ps.addPst(p1);
    ps.readAll().forEach(e->System.out.println(e));


    }
}