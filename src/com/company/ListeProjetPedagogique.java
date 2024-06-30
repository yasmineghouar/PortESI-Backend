package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ListeProjetPedagogique {

    public String nomDuFichierProjetPedagogique;


    public ListeProjetPedagogique (String nomDuFichierProjetPedagogique) {
        this.nomDuFichierProjetPedagogique=nomDuFichierProjetPedagogique;
    }
    public void creerFIchier(String nomDuFichierProjetPedagogique) {
        try {
            String home = System.getProperty("user.home");
            FileOutputStream fos = new FileOutputStream(home+nomDuFichierProjetPedagogique);
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


    public void ajouter_projetPedagogique(ProjetPedagogique projet) {
        try {


            String home = System.getProperty("user.home");
            File fich=new File(home+this.nomDuFichierProjetPedagogique);
            if(fich.length()>0) {
                List <ProjetPedagogique>tab=new ArrayList<ProjetPedagogique>();
                FileInputStream fis = new FileInputStream(home+this.nomDuFichierProjetPedagogique);
                ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                while(fis.available() > 0) {
                    ProjetPedagogique ccc = (ProjetPedagogique)ois.readObject();
                    tab.add(ccc);
                }
                tab.add(projet);
                ois.close();
                fis.close();
                FileOutputStream fos = new FileOutputStream(home+this.nomDuFichierProjetPedagogique);
                ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                for (ProjetPedagogique cpp :tab) {
                    oos.writeObject(cpp);
                }
                oos.close();
                fos.close();
            }else {
                FileOutputStream fos = new FileOutputStream(home+this.nomDuFichierProjetPedagogique);
                ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                oos.writeObject(projet);
                oos.close();
                fos.close();
            }
            Projet.nb_projets++;
            ProjetPedagogique.nbProjetPedagogique++;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }  }



    //afficher mes projets de clubs


    public void afficher(String nomFichier) {
        ListeProjetPedagogique liste =new ListeProjetPedagogique(nomFichier);
        // liste.creerFIchier("/ListeProjetClub.txt");
        //ListeCompetences_ajoutées ref=new ListeCompetences_ajoutées("/ListeCompetences_ajoutées.txt");*/
        try {
            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+nomFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
            while(fis.available() > 0) {
                ProjetPedagogique n = (ProjetPedagogique)ois.readObject();
                System.out.println("le projet:"+n.nom_projet);
                System.out.println("description:"+n.description);
                System.out.println("module concernes:");

                System.out.println(n.module);


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
            List <ProjetPedagogique>tab=new ArrayList<ProjetPedagogique>();

            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+this.nomDuFichierProjetPedagogique);
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
            while(fis.available() > 0) {

                ProjetPedagogique c = (ProjetPedagogique)ois.readObject();
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
            FileOutputStream fos = new FileOutputStream(home+this.nomDuFichierProjetPedagogique);
            ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
            for (ProjetPedagogique cp :tab) {
                oos.writeObject(cp);
            }

            oos.close();
            fos.close();
            Projet.nb_projets--;
            ProjetPedagogique.nbProjetPedagogique--;

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }


    }

    //****************************************************************************************************************















}