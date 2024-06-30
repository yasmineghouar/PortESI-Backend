package com.company;

import java.util.ArrayList;

public class PrjPdeago {
    String nom_projet;
    String description;
    String [] Liste_comp_validee;
    String module;
    public PrjPdeago(String nom_projet,String module, String description, ArrayList <Competence>  Liste_comp_validee){
        String[] tab =new String[Liste_comp_validee.size()];
        this.description=description;
        this.nom_projet=nom_projet;
        this.module=module;
        int i=0;
        for(Competence c:Liste_comp_validee){
            //  this.Liste_comp_validee[i]=c.contenu_compétence;
            tab[i]=c.contenu_compétence;
            i++;
        }
        this.Liste_comp_validee=tab;
    }
}