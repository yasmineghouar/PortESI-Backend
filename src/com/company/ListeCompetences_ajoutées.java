package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListeCompetences_ajoutées {
    private String nomDuFichierCompetences;


    //**************************************************************************************

    public ListeCompetences_ajoutées(String nomDuFichierCompetences) {
        this.nomDuFichierCompetences=nomDuFichierCompetences;}


    public void creerFIchier(String nomDuFichierCompetences) {
        try {
            String home = System.getProperty("user.home");
            FileOutputStream fos = new FileOutputStream(home+nomDuFichierCompetences);
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    //*************************************************************************************

    public void supprimer_competence (String s) {
        try {
            List <Competence>tab=new ArrayList<Competence>();

            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+nomDuFichierCompetences);
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
            while(fis.available() > 0) {

                Competence c = (Competence)ois.readObject();
                if(c.contenu_compétence.compareTo(s)!=0 ) {

                    tab.add(c);
                    //System.out.println("vrai");
                }

            }



            ois.close();
            fis.close();
            FileOutputStream fos = new FileOutputStream(home+nomDuFichierCompetences);
            ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
            for (Competence cp :tab) {
                oos.writeObject(cp);
            }

            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }


    }

    //****************************************************************************************************************


    public String ajouter_competence (String s,int type) {
        String rep ="";
        if (s.compareTo("")==0){
            rep ="Cette competence est vide";
        }
        else {
            try {
                String home = System.getProperty("user.home");


                Competence cp = new Competence(s, type);
                cp.checkercompetence();
                File fich = new File(home + this.nomDuFichierCompetences);
                if (fich.length() > 0) {

                    List<Competence> tab = new ArrayList<Competence>();

                    FileInputStream fis = new FileInputStream(home + this.nomDuFichierCompetences);
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    boolean trouv = false;
                    while (fis.available() > 0) {
                        Competence c = (Competence) ois.readObject();
                        tab.add(c);
                        if (c.contenu_compétence.compareTo(s) == 0) {
                            trouv = true;
                        }
                    }
                    tab.add(cp);
                    ois.close();
                    fis.close();
                    if (!trouv) {
                        FileOutputStream fos = new FileOutputStream(home + nomDuFichierCompetences);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                        for (Competence cpp : tab) {
                            oos.writeObject(cpp);
                        }
                        oos.close();
                        fos.close();
                    } else {
                        rep = "la competence existe deja";
                    }
                } else {
                    FileOutputStream fos = new FileOutputStream(home + nomDuFichierCompetences);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                    oos.writeObject(cp);
                    oos.close();
                    fos.close();
                }
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }
        }return rep;
//    System.out.println(rep);
    }



    public Recherche recherche(String nomDuFichierCompetences,String s) {
        Competence c = null ;
        boolean trouv=false;

        try {

            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+nomDuFichierCompetences);
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
            while((fis.available() > 0)&&(trouv==false)) {

                c = (Competence)ois.readObject();
                if(s.compareTo(c.contenu_compétence)==0) {
                    trouv=true;
                }
            }
            if(trouv==false) {
                c = null;
            }

            ois.close();
            fis.close();
//oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        Recherche recherche=new Recherche(c,trouv);

        return recherche;

    }}