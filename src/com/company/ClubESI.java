package com.company;
import java.util.ArrayList;
import java.io.Serializable;
public class ClubESI implements  Serializable{
    private static final long serialVersionUID = 8425671220557120585L;
    private String nom_club;
    private String objectif_club;
    private String date_inscription;
    private String date_quitter;
    //private ArrayList<String> post ;
    private String post;
    private  String projets;

    private ArrayList<String> evenements;
    private boolean fairePartieDuClub;
    private boolean quitterLeClub=false;
    private Competence[] competences_club;


    //constructeurs
    public ClubESI(String nom_club, String objectif_club,boolean fairePartieDuClub) {
        this.nom_club=nom_club;
        this.objectif_club=objectif_club;
        this.fairePartieDuClub=fairePartieDuClub;

    }
    public ClubESI(){

    }

    //m�thodes
    public boolean partieClub() {
        return fairePartieDuClub;
    }
    public void rejoindre_club(String date_inscription)
    {

        //si l'étudiant rejoint un club
        this.fairePartieDuClub=true; //rejoindre le club
        this.date_inscription=date_inscription;
    }

    public void quitter_club() {
        // si l'étudiant quitte un club
        this.quitterLeClub= true; //quitter le club
    }

    public void affichage_club() {
        System.out.println("-Le club: "+nom_club);
        System.out.println("-L'objectif du club:"+objectif_club);
        System.out.println("-Date d'inscription: "+date_inscription);
        System.out.println("-Le post: "+post);
        if (fairePartieDuClub==true) {
            System.out.println("-Faire partie du Club : Oui");
        }
        else {
            System.out.println("-Faire partie du Club : Non");
        }

        if (quitterLeClub==true) {
            System.out.println("-A quitter le club : Oui");
        }
        else {
            System.out.println("-A quitter le club : Non");
        }

    }
    public void modifier_club(String nomclub,String objectifclub,String dateinscription,String poste,boolean fairePartieClub,boolean quitterClub,Competence[] competencesclubs){
        this.nom_club=nomclub;
        this.objectif_club=objectifclub;
        this.date_inscription=dateinscription;
        this.post=poste;
        this.fairePartieDuClub=fairePartieClub;
        this.quitterLeClub=quitterClub;
        this.competences_club=competencesclubs;
    }
    // retourne le nom du club
    public String get_nom_club() {
        return this.nom_club;
    }
    public String get_objectif_club(){return this.objectif_club;}
    public boolean get_fairePartie_club(){return this.fairePartieDuClub;}
    public String get_date_inscription(){return this.date_inscription;}
    public boolean get_quitter_club(){return this.quitterLeClub;}
    public String get_date_quitter(){
        if (this.quitterLeClub==true){
            return this.date_quitter;}
        else{
            return "Aujourd'hui";
        }
    }
    public String get_post(){
        return this.post;
    }
    public void ajouter_post(String post){

        this.post=post;

    }
    public void ajouter_projets(String projets){
        this.projets=projets;
        //this.projets.add(projets);
        //String[] tab=new String[this.projets.length()];
        //this.projets[this.projets.length()]=projets;
    }
    public String get_projets(){
        return this.projets;
    }


    @Override
    public String toString() {
        return this.nom_club+":  "+this.objectif_club+"\n";
    }

}