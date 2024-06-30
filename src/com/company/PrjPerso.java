package com.company;


import java.util.ArrayList;

public class PrjPerso {
    String nom_projet;
    String description;
    String typeProjet;
    String [] Liste_comp_validee;


    public PrjPerso(String nom_projet,String typeProjet, String description, ArrayList<Competence> Liste_comp_validee){
        String[] tab =new String[Liste_comp_validee.size()];
        this.description=description;
        this.nom_projet=nom_projet;
        this.typeProjet=typeProjet;
        int i=0;
        for(Competence c:Liste_comp_validee){
            //  this.Liste_comp_validee[i]=c.contenu_compétence;
            tab[i]=c.contenu_compétence;
            i++;
        }
        this.Liste_comp_validee=tab;
    }
}