package com.company;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReferentielCompetences {
    @SuppressWarnings("unused")
    private String nomDuFichierCompetences;
    public ReferentielCompetences(String nomDuFichierCompetences) {
        this.nomDuFichierCompetences=nomDuFichierCompetences;
    }
    public void Creer_fichier(String nomDuFichierAnnee ,String nomDuFichierCompetences) {
        try {
            List <Integer>tab=new ArrayList<Integer>();
            //tab.add(null);

            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+nomDuFichierAnnee);
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
            FileOutputStream fos = new FileOutputStream(home+nomDuFichierCompetences);
            ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
            while(fis.available() > 0) {
                boolean trouve=false;
                NiveauDEtude c = (NiveauDEtude)ois.readObject();
                for(int i=0; i <c.modules.length; i++) {//parcourir les modules
                    for(int j=0; j<c.modules[i].competencesModule.length;j++) {

                        trouve=false;
                        Competence co=c.modules[i].competencesModule[j];//recuperer chaque compétence du module i du niveau d'etude actuel et l'inserer dans le fichier des compétences

                        for(int k:tab) {
                            if(k==co.id) {
                                trouve=true;
                            }
                        }
   /*if(trouve==false){
      System.out.println("vrai");
   }*/
                        if(trouve==false) {
                            tab.add(co.id);
                            //System.out.println(co.id);
                            oos.writeObject(co);

                        }
                    }

                }
//System.out.println(compteur);
//oos.writeObject(c.modules);
//oos.close();
            }


            //System.out.println(tab.get(255));
//System.out.println(compteur);
            oos.close();
            ois.close();
            fis.close();
            fos.close();
//oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }



//*********************************

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

    }


    public void ajouter_competence (Competence cp) {
        try {
            String home = System.getProperty("user.home");
            cp.checkercompetence();
            File fich=new File(home+this.nomDuFichierCompetences);
            if(fich.length()>0) {

                List <Competence>tab=new ArrayList<Competence>();

                FileInputStream fis = new FileInputStream(home+this.nomDuFichierCompetences);
                ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichie
                while(fis.available() > 0) {
                    Competence c = (Competence)ois.readObject();
                    tab.add(c);

                }
                tab.add(cp);
                ois.close();
                fis.close();

                FileOutputStream fos = new FileOutputStream(home+nomDuFichierCompetences);
                ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                for (Competence cpp :tab) {
                    oos.writeObject(cpp);
                }
                oos.close();
                fos.close();}


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }  }


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







}



