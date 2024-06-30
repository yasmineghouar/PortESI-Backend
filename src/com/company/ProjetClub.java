package com.company;

import java.io.Serializable;

public class ProjetClub extends Projet implements Serializable {
    private static final long serialVersionUID = 8425671220557120585L;

    public String club;
    static int  nb_projetsClub; //s'incremente a chaque création d'un projet

    public void renseignerClub(String club) {
        this.club=club;
    }
}