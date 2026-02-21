package tn.esprit.spring;
import tn.esprit.spring.TeachingUI;


public class Module {
    private String matricule;
    private String nom;
    private int coefficient;
    private int volumeHoraire;
    private TypeModule typeM;
private TeachingUI teachingUI;
    public Module(){}
    // Constructeur
    public Module(String matricule, String nom, int coefficient, int volumeHoraire, TypeModule type) {
        this.matricule = matricule;
        this.nom = nom;
        this.coefficient = coefficient;
        this.volumeHoraire = volumeHoraire;
        this.typeM = type;
    }
    public Module(String matricule, String nom, int coefficient, int volumeHoraire, TypeModule type,TeachingUI teachingUI) {
        this.matricule = matricule;
        this.nom = nom;
        this.coefficient = coefficient;
        this.volumeHoraire = volumeHoraire;
        this.typeM = type;
        this.teachingUI=teachingUI;
    }

    public enum TypeModule {
        TRANSVERSAL,
        PROFESSIONNEL,
        RECHERCHE
    }

    // Getters et Setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(int volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public TypeModule getTypeM() {
        return typeM;
    }

    public void setTypeM(TypeModule typeM) {
        this.typeM = typeM;
    }

    public TeachingUI getTeachingUI() {
        return teachingUI;
    }

    public void setTeachingUI(TeachingUI teachingUI) {
        this.teachingUI = teachingUI;
    }


}