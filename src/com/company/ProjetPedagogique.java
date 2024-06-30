package com.company;

import java.io.Serializable;

public class ProjetPedagogique extends Projet implements Serializable{
    private static final long serialVersionUID = 8425671220557120585L;
    String module;
    public static int nbProjetPedagogique;

    public void renseignerModules(String nomFichierRefNiveauDetude,String module) {
        //ReferentielAnneeDEtude RefNv =new ReferentielAnneeDEtude(nomFichierRefNiveauDetude);


        //this.ListeModuleConcerne.add(RefNv.recherchemd(nomFichierRefNiveauDetude,module).m);
        this.module=module;



    }
    public void renseigner_competences(String nomDuFichierCompetences,String s) {
        ReferentielCompetences compRef =new ReferentielCompetences(nomDuFichierCompetences);

        if((compRef.recherche(nomDuFichierCompetences,s).trouv)==true) {
            Competence cp=compRef.recherche(nomDuFichierCompetences,s).c;
            cp.checkercompetence();
            compRef.supprimer_competence(s);
            compRef.ajouter_competence(cp);

            this.Liste_comp_validee.add(compRef.recherche(nomDuFichierCompetences,s).c);

        }


    }


}