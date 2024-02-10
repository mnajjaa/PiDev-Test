package Service;

import Entite.Cours;
import util.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourService {
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pst;
    public CourService() {
        connexion= DataSource.getInstance().getCnx();
    }

    public void addPst(Cours c){
        String requete="insert into cour (nomCour,Duree,Intensite,Cible,Categorie,Objectif,Capacité) values(?,?,?,?,?,?,?)";

        try {
            pst=connexion.prepareStatement(requete);
            pst.setString(1,c.getNomCour());
            pst.setString(2,c.getDuree());
            pst.setString(3,c.getIntensite());
            pst.setString(4,c.getCible());
            pst.setString(5,c.getCategorie());
            pst.setString(6,c.getObjectif());
            pst.setInt(7,c.getCapacité());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

        public void DeleteCours (int idCour) {
            String DELETE = "DELETE FROM cour WHERE idCour = ?";
            try (
                    PreparedStatement preparedStatement = connexion.prepareStatement(DELETE)) {
                preparedStatement.setInt(1, idCour);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }}


    public void UpdateCours(Cours cours) throws SQLException {
        String UPDATE = "UPDATE cour SET nomCour = ?, Duree = ?, Intensite = ?, Cible = ?, Categorie = ?, Objectif = ?, Capacité = ? WHERE idCour = ?";
        try (
             PreparedStatement preparedStatement = connexion.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, cours.getNomCour());
            preparedStatement.setString(2, cours.getDuree());
            preparedStatement.setString(3, cours.getIntensite());
            preparedStatement.setString(4, cours.getCible());
            preparedStatement.setString(5, cours.getCategorie());
            preparedStatement.setString(6, cours.getObjectif());
            preparedStatement.setInt(7, cours.getIdCour());
            preparedStatement.setInt(8, cours.getCapacité());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cours> consulterCours() {
        List<Cours> Cours = new ArrayList<>();
        // try (Connection connection = ConnexionDB.obtenirConnexion())
        String query = "SELECT * FROM cour";
        try (Statement statement = connexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Cours cr = new Cours();
                cr.setNomCour(resultSet.getString("nomCour"));
                cr.setCategorie(resultSet.getString("Categorie"));
                cr.setCible(resultSet.getString("Cible"));
                cr.setDuree(resultSet.getString("Duree"));
                cr.setIntensite(resultSet.getString("Intensite"));
                cr.setObjectif(resultSet.getString("Objectif"));
                cr.setCapacité(resultSet.getInt("Capacité"));
                Cours.add(cr);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Cours;
    }




    public List<Cours> filtrerCours(String Categorie, String Cible, String Objectif) {
        List<Cours> coursList = new ArrayList<>();
        String FILTER = "SELECT * FROM cour WHERE Categorie = ? OR Cible = ? OR Objectif = ?";
        try (
                PreparedStatement preparedStatement = connexion.prepareStatement(FILTER)) {
            preparedStatement.setString(1, Categorie);
            preparedStatement.setString(2, Cible);
            preparedStatement.setString(3, Objectif);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nomCour = resultSet.getString("nomCour");
                String duree = resultSet.getString("Duree");
                String intensite = resultSet.getString("Intensite");
                String cible = resultSet.getString("Cible");
                String categorie = resultSet.getString("Categorie");
                String objectif = resultSet.getString("Objectif");
                Integer Capacité = resultSet.getInt("Capacité");
                Cours cours = new Cours(nomCour, duree, intensite, Cible, Categorie, Objectif, Capacité);
                coursList.add(cours);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return coursList;
    }




}
