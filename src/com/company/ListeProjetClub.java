package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListeProjetClub {
    public String nomDuFichierProjetClub;


    public ListeProjetClub (String nomDuFichierProjetClub) {
        this.nomDuFichierProjetClub=nomDuFichierProjetClub;
    }
    public void creerFIchier(String nomDuFichierProjetClub) {
        try {
            String home = System.getProperty("user.home");
            FileOutputStream fos = new FileOutputStream(home+nomDuFichierProjetClub);
            fos.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ajouter projet


    public void ajouter_projetClub(ProjetClub projet) {


        String home = System.getProperty("user.home");
        File fich=new File(home+this.nomDuFichierProjetClub);
        if(fich.length()>0) {
            try {
                List <ProjetClub>tab=new ArrayList<ProjetClub>();
                FileInputStream fis = new FileInputStream(home+this.nomDuFichierProjetClub);
                ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                while(fis.available() > 0) {
                    ProjetClub ccc = (ProjetClub)ois.readObject();
                    tab.add(ccc);
                }
                tab.add(projet);
                ois.close();
                fis.close();


                FileOutputStream fos = new FileOutputStream(home+this.nomDuFichierProjetClub);
                ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                for (ProjetClub cpp :tab) {
                    oos.writeObject(cpp);
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
        }else {
            try{
                FileOutputStream fos = new FileOutputStream(home+this.nomDuFichierProjetClub);
                ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                oos.writeObject(projet);
                oos.close();
                fos.close();
            }  catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
            Projet.nb_projets++;
            ProjetClub.nb_projetsClub++;

        }

    }


    //afficher mes projets de clubs


    public void afficher(String nomFichier) {
        ListeProjetClub liste =new ListeProjetClub(nomFichier);
        // liste.creerFIchier("/ListeProjetClub.txt");
        //ListeCompetences_ajoutées ref=new ListeCompetences_ajoutées("/ListeCompetences_ajoutées.txt");*/
        try {
            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+nomFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
            while(fis.available() > 0) {
                ProjetClub n = (ProjetClub)ois.readObject();
                System.out.println("le projet:"+n.nom_projet);
                System.out.println("description:"+n.description);
                System.out.println("le club concerné:"+n.club);
                System.out.println("les competences acquises:");

                for(Competence c:n.Liste_comp_validee) {
                    System.out.println(c.contenu_compétence);
                }
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    //suppression d'un projet



    public void supprimerProjet (String s) {
        try {
            List <ProjetClub>tab=new ArrayList<ProjetClub>();

            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+this.nomDuFichierProjetClub);
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
            while(fis.available() > 0) {

                ProjetClub c = (ProjetClub)ois.readObject();
                if(c.nom_projet.compareTo(s)!=0 ) {

                    tab.add(c);
                    //System.out.println("vrai");
                }
                else {
                    for(Competence cm:c.Liste_comp_validee) {
                        cm.decheckercompetence();

                    }
                }

            }



            ois.close();
            fis.close();
            FileOutputStream fos = new FileOutputStream(home+this.nomDuFichierProjetClub);
            ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
            for (ProjetClub cp :tab) {
                oos.writeObject(cp);
            }

            oos.close();
            fos.close();
            Projet.nb_projets--;
            ProjetClub.nb_projetsClub--;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }


    }

    //****************************************************************************************************************


}