package Entite;

public class Cours {
    private int idCour;
    private String nomCour;
    private String Duree;
    private String Intensite;
    private String Cible;
    private String Categorie;
    private String Objectif;
    private int Capacité;


    public int getCapacité() {
        return Capacité;
    }

    public void setCapacité(int capacité) {
        Capacité = capacité;
    }

    public int getIdCour() {
        return idCour;
    }

    public String getNomCour() {
        return nomCour;
    }

    public String getDuree() {
        return Duree;
    }

    public String getIntensite() {
        return Intensite;
    }

    public String getCible() {
        return Cible;
    }

    public String getCategorie() {
        return Categorie;
    }

    public String getObjectif() {
        return Objectif;
    }

    public void setIdCour(int idCour) {
        this.idCour = idCour;
    }

    public void setNomCour(String nomCour) {
        this.nomCour = nomCour;
    }

    public void setDuree(String duree) {
        Duree = duree;
    }

    public void setIntensite(String intensite) {
        Intensite = intensite;
    }

    public void setCible(String cible) {
        Cible = cible;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public void setObjectif(String objectif) {
        Objectif = objectif;
    }

    public Cours(String nomCour, String duree, String intensite, String cible, String categorie, String objectif, int capacité) {
        this.nomCour = nomCour;
        Duree = duree;
        Intensite = intensite;
        Cible = cible;
        Categorie = categorie;
        Objectif = objectif;
        Capacité = capacité;
    }


    public Cours() {

    }

    @Override
    public String toString() {
        return "Cours{" +
                "idCour=" + idCour +
                ", nomCour='" + nomCour + '\'' +
                ", Duree='" + Duree + '\'' +
                ", Intensite='" + Intensite + '\'' +
                ", Cible='" + Cible + '\'' +
                ", Categorie='" + Categorie + '\'' +
                ", Objectif='" + Objectif + '\'' +
                ", Capacité=" + Capacité +
                '}';
    }
}
