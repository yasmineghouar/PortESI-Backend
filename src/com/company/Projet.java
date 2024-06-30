package com.company;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Projet implements Serializable {
    private static final long serialVersionUID = 8425671220557120585L;

    String nom_projet;
    String description;
    ArrayList <Competence> Liste_comp_validee=new ArrayList<Competence>();


    static int  nb_projets; //s'incremente a chaque création d'un projet
    public void créerProjet(String nom_projet) {
        this.nom_projet=nom_projet;

    } //qu'on appellera au niveau de main
    public void décrir_projet (String description){// (fournir un descriptif détaillé)
        this.description=description;
    }
    public void renseigner_competences(String nomDuFichierCompetences,String nomDuFichierCompetencesAjoutés ,String s) {
        ReferentielCompetences compRef =new ReferentielCompetences(nomDuFichierCompetences);
        ListeCompetences_ajoutées compAjout =new ListeCompetences_ajoutées(nomDuFichierCompetencesAjoutés);

        if((compRef.recherche(nomDuFichierCompetences,s).trouv)==true) {
            Competence cp=compRef.recherche(nomDuFichierCompetences,s).c;
            cp.checkercompetence();
            compRef.supprimer_competence(s);
            compRef.ajouter_competence(cp);
            this.Liste_comp_validee.add(cp);

        }
        else if((compAjout.recherche(nomDuFichierCompetencesAjoutés,s).trouv)==true) {
            compAjout.recherche(nomDuFichierCompetencesAjoutés,s).c.checkercompetence();
            this.Liste_comp_validee.add(compAjout.recherche(nomDuFichierCompetencesAjoutés,s).c);

        }/*
        else {

            compAjout.ajouter_competence(s,type);
            this.Liste_comp_validee.add(compAjout.recherche(nomDuFichierCompetencesAjoutés,s).c);

        }*/

    }
    public void joindre_document() { // (exp attestation) qui va  valider les competences validées
    }
    public void afficher_projet() {
    }
    public void modifier() {       //concerne toutes les modifications du projet     (compétances [déchecker une compétance] / modules/nom du projet /Document....)
    }

}