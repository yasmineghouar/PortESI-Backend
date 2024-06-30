package com.company;

import java.io.Serializable;
public class NiveauDEtude implements Serializable{
    private static final long serialVersionUID = 8425671220557120585L;
    String niveauDetude;
    Module [] modules;
    public NiveauDEtude(String niveauDEtude,Module [] modules)
    {
        this.niveauDetude=niveauDEtude;
        this.modules = modules;
    }



    public void afficherNiveau() {
        System.out.println("Niveau:"+this.niveauDetude+":");
        System.out.println("----------------");
        for(int i=0;i<this.modules.length;i++) {
            this.modules[i].afficherModule();
        }
    }
    public Rechmod recherchemodule(String md) {
        boolean trouv=false;
        Module modul = null;
        int i=0;
        while((i<this.modules.length)&&(trouv==false)) {
            if(this.modules[i].moduleequal(md)) {
//this.modules[i].afficherModule();
                modul=modules[i];
                trouv=true;
            }
            else {i++;}
        }
        if(trouv==false) {modul=null;}
        Rechmod rechmodule=new Rechmod(modul,trouv);
        return rechmodule;
    }

    public Recherche recherchecompetence(String cm,String md) {
        boolean trv = false;
        Competence cmp=null;
        int i=0;
        int j=0;
        while((i<this.modules.length)&&(trv==false)) {
            if(this.modules[i].moduleequal(md)) {
                while((j<this.modules[i].competencesModule.length)&&(trv==false)) {
                    if(this.modules[i].competencesModule[j].contenu_compétence.compareTo(cm)==0) {
                        cmp=this.modules[i].competencesModule[j];
                        trv=true;
                    }
                    else {j++;}
                }
            }
            else {i++;}
        }
        Recherche rechcmp=new Recherche(cmp,trv);
        return rechcmp;
    }


}