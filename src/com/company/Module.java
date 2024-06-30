package com.company;

import java.io.Serializable;
public class Module implements Serializable{
    private static final long serialVersionUID = 8425671220557120585L;


    String nomModule;
    String descriptif;
    Competence[] competencesModule;

    public Module(String nomModule,String descriptif,Competence[] competencesModule) {
        this.nomModule=nomModule;
        this.descriptif=descriptif;
        this.competencesModule=competencesModule;
    }

    public void afficherModule() {
        System.out.println();
        System.out.println(this.nomModule);
        System.out.println();
        System.out.println("descriptif: "+this.descriptif);
        System.out.println("les competences visé:");
        for(int j=0;j<this.competencesModule.length;j++) {
            System.out.println("-"+this.competencesModule[j].contenu_compétence);
        }
    }
    public String getmodule() {
        return(nomModule);
    }

    public boolean moduleequal(String mdl) {
        if(this.nomModule.compareTo(mdl)==0) {return true;
        }
        else {return false;}
    }
}

