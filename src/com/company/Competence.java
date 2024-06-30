package com.company;

import java.io.Serializable;



public class Competence implements Serializable{
    private static final long serialVersionUID = 8425671220557120585L;

    String contenu_compétence;
    int type_compétence; //1-technique
    //2-Méthodologique
    //3-Modélisation
    //4-Opérationnel
    //5-soft skills
    //6-hard skills.
    double  stat_ESI_somme;


    double stat_Club_somme;
    double stat_Perso_somme;
    boolean compétence_validée;
    public static int nbCompetences;
    public static int nbCompetencesTech;
    public static int nbCompetencesMet;
    public static int nbCompetencesMod;
    public static int nbCompetencesOp;
    public static int nbCompetencesSoft;
    public static int nbCompetencesHard;



    int id;
    public Competence(String contenu_compétence, int type_compétence,double  stat_ESI_somme, double stat_Club_somme,double stat_Perso_somme,boolean compétence_validée)
    {
        this.contenu_compétence=contenu_compétence;
        this.type_compétence = type_compétence;
        this.stat_ESI_somme = stat_ESI_somme;
        this.stat_Club_somme = stat_Club_somme;
        this.stat_Perso_somme = stat_Perso_somme;
        this.compétence_validée = compétence_validée;

    }

    public Competence(String contenu_compétence, int type_compétence) {
        this.contenu_compétence=contenu_compétence;
        this.type_compétence = type_compétence;

    }


    public Competence(int id,String contenu_compétence, int type_compétence) {
        this.contenu_compétence=contenu_compétence;
        this.type_compétence = type_compétence;
        this.id=id;
    }

    public Competence(String contenu_compétence) {
        this.contenu_compétence=contenu_compétence;

    }


    public void checkercompetence() {
        this.compétence_validée=true;
        Competence.nbCompetences++;
        if (this.type_compétence==1) {
            Competence.nbCompetencesTech++;

        }else if(this.type_compétence==2) {
            Competence.nbCompetencesMet++;

        }else if (this.type_compétence==3) {
            Competence.nbCompetencesMod++;
        }else if (this.type_compétence==4) {
            Competence.nbCompetencesOp++;
        }else if (this.type_compétence==5) {
            Competence.nbCompetencesSoft++;
        }else {
            Competence.nbCompetencesHard++;
        }
    }

    public void decheckercompetence() {
        this.compétence_validée=false;
        Competence.nbCompetences--;
        if (this.type_compétence==1) {
            Competence.nbCompetencesTech--;

        }else if(this.type_compétence==2) {
            Competence.nbCompetencesMet--;

        }else if (this.type_compétence==3) {
            Competence.nbCompetencesMod--;
        }else if (this.type_compétence==4) {
            Competence.nbCompetencesOp--;
        }else if (this.type_compétence==5) {
            Competence.nbCompetencesSoft--;
        }else {
            Competence.nbCompetencesHard--;
        }

    }
    public boolean competenceequal(String cp) {

        if(this.contenu_compétence.equals(cp)) {return true;}
        else {return false;}

    }
   /*
   @Override
   public String toString() {
      return this.contenu_compétence+" : "+this.type_compétence;
   }*/

}
