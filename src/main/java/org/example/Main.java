package org.example;

import Entite.Cours;
import Service.CourService;

import java.sql.SQLException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        Cours c1 = new Cours("Yoga", "10", "Fort", "Adulte", "muscle", "perdre poids", 25);
        Cours c2 = new Cours("BodyAttack", "2", "Fort", "Adulte", "Fun", "défoulement",20);
        Cours c3 = new Cours("BodyAttack", "2", "Fort", "Adulte", "Cardio", "Gagner de la force",15);
        Cours c4 = new Cours("BodyAttack", "2", "Fort", "Enfant", "Fun", "défoulement",10);
        Cours c5 = new Cours("BodyAttack", "2", "Fort", "Adulte", "Cardio", "défoulement",35);
        CourService CS = new CourService();


        //CS.addPst(c1);
        //CS.addPst(c2);
        //CS.addPst(c3);
        //CS.addPst(c4);
        //CS.addPst(c5);

        //CS.DeleteCours(8);
        //CS.DeleteCours(5);

        //CS.consulterCours().forEach(System.out::println);

        //update
        //Cours coursToUpdate = new Cours("Defoulement", "5", "Moyen", "Enfant", "Kids island", "S'amuser",10);
        //coursToUpdate.setIdCour(7); // Mettez l'ID du cours que vous souhaitez mettre à jour
        //CS.UpdateCours(coursToUpdate);


        //ps.readAll().forEach(System.out::println);

        // Filtrer les cours en fonction des critères spécifiés
        List<Cours> coursFiltres = CS.filtrerCours("kids island", "Adulte", "Gagner de la force");

        // Afficher les cours filtrés
        System.out.println("Cours filtrés : ");
        for (Cours cours : coursFiltres) {
            System.out.println(cours);
        }
    }
}