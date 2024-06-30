package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class ListeClub {
    private String nom_fichier;
    static private FileOutputStream foss;
    static private ObjectOutputStream ooss;

    public void Creer_fichier_clubs(String nom_fichier){//m�thode qui permet de cr�er le fichier



        ClubESI ETIC = new ClubESI("ETIC","active dans le domaine d'entrepreneuriat , le nombre de ses événements atteint 59, ils s'agissent principalement du Salon de l'emploi ,Training Camp",false);
        ClubESI CSE = new ClubESI("CSE","active dans le domaine scientifique et technologique, le nombre de ses événements est 97 tel que Hack IT",true);
        ClubESI shellmates = new ClubESI("shellmates"," active dans le domaine de la sécurité informatique. Le nombre de ses événements d�passe les cinquante , les plus connus sont Hack It",false);
        ClubESI CACE = new ClubESI("CACE","alleger la vie estudiantine à travers de nombreux événements tel que Yennayer et des formations pertinentes aux arts.",false);
        ClubESI sourire_a_l_innocence = new ClubESI("sourire_a_l_innocence","dans le domaine de charité, ses événements sont au nombre de 32, principalement Qoufat Ramadan,organisé chaque année pour aider les familles pauvres.",false);
        ClubESI GDG= new ClubESI("GDG"," active dans le domaine du Développement des produits technologiques, son événement le plus important est DevFest",false);
        ClubESI Sport_and_entertainment= new ClubESI("Sport and entertainment","active dans le domaine sportif, il organise des entrainements, compétitions et des séances de sport pour l'amélioration de la créativit� de l��tudiant",false);
        ClubESI    ECOTECH = new ClubESI("ECOTECH","active dans le domaine Ecologie-technologie , ses buts principaux se résument dans le recyclage et comment pr�server la nature.",false);
        ClubESI    code_and_share = new ClubESI("code_and_share","active dans le domaine de la programmation, son fameux événement est KidsCanCode",false);
        ClubESI School_of_AI_ALgiers = new ClubESI("School of AI ALgiers","active dans l'intelligence artificielle,Ses événements majeurs sont AI2E,HAIck Algeria'.",false);
        try {
            String home = System.getProperty("user.home");
            foss = new FileOutputStream(home+nom_fichier);
            ooss = new ObjectOutputStream(foss);//objet qui sait ecrire des flux d'octets sur un fichier
            ooss.writeObject(ETIC);
            ooss.writeObject(CSE);
            ooss.writeObject(shellmates);
            ooss.writeObject(CACE);
            ooss.writeObject(sourire_a_l_innocence);
            ooss.writeObject(GDG);
            ooss.writeObject(Sport_and_entertainment);
            ooss.writeObject(ECOTECH);
            ooss.writeObject(code_and_share);
            ooss.writeObject(School_of_AI_ALgiers);

      /*ooss.close();
      foss.close();  */
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    //ajout d'un nouveau club � l'ESI
    public void ajouter_club(String nom_fichier) {

        Scanner sc = new Scanner(System.in);
        System.out.println("-Veuillez ins�rer le nom du club � ins�rer:");

        String nom = sc.nextLine();

        System.out.println("-Veuillez ins�rer le descriptif du club � ins�rer:");
        //sc.nextLine();//on vide la ligne d'avant avant de lire une autre
        String descriptif = sc.nextLine();

        ClubESI clb = new ClubESI(nom,descriptif,false);//creer un nouveau objet de type ClubESI

        try {

            ooss.writeObject(clb);//ecrire le club ajout� dans le fichier ListeClubs
            ooss.close();
            foss.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();

    }

    //Recherche d'un nouveau club � l'ESI
    public ClubESI Rech_club(String nom_fichier, String nomClubRech)
    {
        ClubESI cl = new ClubESI("","",false);
        try {
            boolean trouv=false;

            String home = System.getProperty("user.home");
            FileInputStream fiss = new FileInputStream(home+nom_fichier);
            ObjectInputStream oiss = new ObjectInputStream(fiss); //objet qui sait lire des flux d'octets sur un fichier
            while(fiss.available() > 0 && trouv!=true) {
                cl = (ClubESI)oiss.readObject();

                if(nomClubRech.equals(cl.get_nom_club())){
                    trouv=true;


                }

            }//fin while






            oiss.close();
            fiss.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return cl;
    }// fin recherche club

    public ArrayList<ClubESI> afficher_liste_clubs(String nom_fichier) {//afficher les clubs de l'esi
        try {

            String home = System.getProperty("user.home");
            FileInputStream fiss = new FileInputStream(home+nom_fichier);
            ObjectInputStream oiss = new ObjectInputStream(fiss); //objet qui sait lire des flux d'octets sur un fichier
            ArrayList<ClubESI> clubss = new ArrayList<ClubESI>();
            while(fiss.available() > 0) {
                ClubESI cl = (ClubESI)oiss.readObject();
                System.out.println(cl);
                clubss.add(cl);
            }

            oiss.close();
            fiss.close();
            return clubss;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void afficher_mes_clubs(String nom_fichier) {
        try {
            String home = System.getProperty("user.home");
            FileInputStream fiss = new FileInputStream(home+nom_fichier);
            ObjectInputStream oiss = new ObjectInputStream(fiss); //objet qui sait lire des flux d'octets sur un fichier
            while(fiss.available() > 0) {
                ClubESI cl = (ClubESI)oiss.readObject();
                if (cl.partieClub()==true) {
                    System.out.println(cl);}
            }

            oiss.close();
            fiss.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void supprimer_club(String nom_fichier, String clSupp) {//supprimer un club de la liste des clubs

        try {
            List <ClubESI>tab=new ArrayList<ClubESI>();

            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+nom_fichier);

            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier


            while(fis.available() > 0) {

                ClubESI cl = (ClubESI)ois.readObject();
                if(cl.get_nom_club().compareTo(clSupp)!=0 ) {

                    tab.add(cl);

                }

            }

            ois.close();
            fis.close();
            FileOutputStream fos = new FileOutputStream(home+nom_fichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
            for (ClubESI cp :tab) {
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