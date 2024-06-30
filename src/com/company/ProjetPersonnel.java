package com.company;

import java.io.Serializable;

public class ProjetPersonnel extends Projet implements  Serializable {
    private static final long serialVersionUID = 8425671220557120585L;
    static int  nb_projetsPersonnels; //s'incremente a chaque création d'un projet

    public String typeProjet;

    public void renseignerTypeProjet(String typeProjet) {
        this.typeProjet=typeProjet;
    }
}