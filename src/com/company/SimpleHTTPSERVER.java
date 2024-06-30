package com.company;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.InetSocketAddress;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;


public class SimpleHTTPSERVER {
    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8084), 0);

        Etudiant etudiant = new Etudiant();
        ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/ReferentielAnneeDEtude.txt");
        ReferentielCompetences compRef = new ReferentielCompetences("/ReferentielCompetences");
        //compRef.Creer_fichier("/ReferentielAnneDetude.txt", "/ReferentielCompetences");
        ListeCompetences_ajoutées liste=new ListeCompetences_ajoutées("/ListeCompetences_ajoutées.txt");
//  liste.creerFIchier("/ListeCompetences_ajoutées.txt");
        ListeProjetPersonnel list =new ListeProjetPersonnel("/ListeProjetPersonnel.txt");
        ListeProjetPedagogique listee =new ListeProjetPedagogique("/ListeProjetPedagogiquee.txt");
        ListeProjetClub listeee =new ListeProjetClub("/ListeProjetClub.txt");
//        Endpoint /signup
        server.createContext("/signup", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String responseText = "Hello World! from our framework-less REST API\n";
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(responseText.getBytes());
                output.flush();
            }
            // POST REQUEST
            else if ("POST".equals(exchange.getRequestMethod())) {
                JSONObject finalResponse = new JSONObject();

                JSONObject requestJsonBody = Util.getRequestBodyObject(exchange);
                String uname = requestJsonBody.getString("uname");
                String password = requestJsonBody.getString("password");
                //Etudiant etudiant = new Etudiant();
                int isSuccesfullyConnected = etudiant.login(uname, password);

//                String responseText = "Hello World! from our framework-less REST API\n";
                if (isSuccesfullyConnected == 1) {//true
                    System.out.println("CONNECTED !");
                    finalResponse.put("success", true);
                    finalResponse.put("error", "null");
                    finalResponse.put("etudiant", Util.convertEtudiantToJson(etudiant));
//                        responseJson.put("success", true);
//                        String etudiantJson = JsonConverter.toJSON(etudiant);
//                        responseJson.put("data" , etudiantJson);
//                        responseJson.put("error" , "null");
//                        response = JsonConverter.toJSON(etudiant);

                } else {
                    finalResponse.put("success", false);
                    if (isSuccesfullyConnected == 0) {
                        finalResponse.put("error", "Mot de passe oublié !");
                    } else {
                        finalResponse.put("error", "Vous n'etes pas encore inscris!");
                    }

                    finalResponse.put("etudiant", "null");
                }


                exchange.sendResponseHeaders(200, finalResponse.toString().getBytes().length);
                exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
                OutputStream output = exchange.getResponseBody();
                output.write(finalResponse.toString().getBytes());
                output.flush();

            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

        // Endpoint /inscription
        server.createContext("/inscription", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String responseText = "Hello World! from our framework-less REST API\n";
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(responseText.getBytes());
                output.flush();
            }
            // POST REQUEST
            else if ("POST".equals(exchange.getRequestMethod())) {
                JSONObject finalResponse = new JSONObject();

                JSONObject requestJsonBody = Util.getRequestBodyObject(exchange);
                String nom = requestJsonBody.getString("nom");
                String prenom = requestJsonBody.getString("prenom");
                String uname = requestJsonBody.getString("uname");
                String password = requestJsonBody.getString("password");
                String anneeDetude = requestJsonBody.getString("anneeDetude");               //  Etudiant etudiant = new Etudiant();
                int isSuccesfullyinscris = etudiant.inscription(nom, prenom, uname, password, anneeDetude);

//                String responseText = "Hello World! from our framework-less REST API\n";
                if (isSuccesfullyinscris == 2) {//TRUE INSCRIPTION VALIDEE
                    System.out.println("Inscris !");
                    finalResponse.put("success", true);
                    finalResponse.put("error", "null");
                    finalResponse.put("etudiant", Util.convertEtudiantToJson(etudiant));


                } else {
                    finalResponse.put("success", false);
                    if (isSuccesfullyinscris == 0) {
                        finalResponse.put("error", "Veuillez insérer une adresse mail de l'ESI ."); //soit il a inscrit avec adresse qui n'est pas de  l'ESI , soit deja inscris
                    } else if (isSuccesfullyinscris == 1) { //DEJA INSCRIS
                        finalResponse.put("error", "Déja inscris!");
                    } else if (isSuccesfullyinscris == 3) {
                        finalResponse.put("error", "Cette adresse est déja utilisée!");
                        finalResponse.put("etudiant", "null");
                    } else if (isSuccesfullyinscris == 4) {
                        finalResponse.put("error", "Veuillez insérer un nom qui ne contient pas de chiffres!");
                        finalResponse.put("etudiant", "null");
                    } else if (isSuccesfullyinscris == 5) {//==5
                        finalResponse.put("error", "Veuillez inserer un prenom qui ne contient pas de chiffres");
                        finalResponse.put("etudiant", "null");
                    } else {
                        finalResponse.put("error", "Veuillez inserer une Année comme: 1CPI ,2CPI ,1CS ,2Cs_SIT, 2Cs_SIL ,2Cs_SID , 2Cs_SIQ , MSIQ , MSIT , MSIL , MSID , 3Cs_SIQ , 3Cs_SIT , 3Cs_SIL, 3Cs_SID");
                        finalResponse.put("etudiant", "null");
                    }

                }


                exchange.sendResponseHeaders(200, finalResponse.toString().getBytes().length);
                exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
                OutputStream output = exchange.getResponseBody();
                output.write(finalResponse.toString().getBytes());
                output.flush();

            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
            compRef.Creer_fichier("/ReferentielAnneDetude.txt", "/ReferentielCompetences");

        }));
        /*******************************************************************/

        //        Endpoint /lesClubs

        server.createContext("/lesClubs", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");
                String[] strings = new String[20];
                try {
                    int ii = 0;
                    ListeClub clubs = new ListeClub();
                    clubs.Creer_fichier_clubs("/listeClubs.dat");
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/listeClubs.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ClubESI n = (ClubESI) ois.readObject();


                        strings[ii] = n.get_nom_club();
                        ii++;
                        strings[ii] = n.get_objectif_club();
                        ii++;
                    }
                    //cpt++;


                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write(gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


        /*************************************************/
        //Endpoint /mesClubs
        server.createContext("/mesClubs", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                String[] strings = new String[11];
                ArrayList<ClubESI> mesClubs = new ArrayList<ClubESI>();
                mesClubs = etudiant.getMes_clubs();
                int i = 0;
                for (ClubESI clb : mesClubs) {
                    strings[i] = clb.get_nom_club();
                    System.out.println(strings[i]);
                    i++;
                }
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
                /*InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");
                String[] strings =new String[10] ;
                try {
                    int ii = 0;
                    ListeClub clubs = new ListeClub();
                    clubs.Creer_fichier_clubs("/listeClubs.dat");
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/listeClubs.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ClubESI n = (ClubESI) ois.readObject();

                        if (n.get_fairePartie_club()) strings[ii]=n.get_nom_club();
                        ii++;
                    }
                    //cpt++;
                    Gson gson = new Gson();
                    // Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
*/

            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


        /**************************************************/

        //Endpoint /unClub
        server.createContext("/MonClub1", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(0).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(0).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(0).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(0).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(0).get_post();
                strings[5] = etudiant.getMes_clubs().get(0).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


//Endpoint /unClub
        server.createContext("/MonClub2", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(1).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(1).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(1).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(1).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(1).get_post();
                strings[5] = etudiant.getMes_clubs().get(1).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

        server.createContext("/MonClub3", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(2).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(2).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(2).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(2).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(2).get_post();
                strings[5] = etudiant.getMes_clubs().get(2).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

        server.createContext("/MonClub4", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(3).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(3).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(3).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(3).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(3).get_post();
                strings[5] = etudiant.getMes_clubs().get(3).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

        server.createContext("/MonClub5", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(4).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(4).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(4).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(4).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(4).get_post();
                strings[5] = etudiant.getMes_clubs().get(4).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
        server.createContext("/MonClub6", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(5).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(5).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(5).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(5).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(5).get_post();
                strings[5] = etudiant.getMes_clubs().get(5).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

        server.createContext("/MonClub7", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(6).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(6).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(6).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(6).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(6).get_post();
                strings[5] = etudiant.getMes_clubs().get(6).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


        server.createContext("/MonClub8", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(7).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(7).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(7).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(7).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(7).get_post();
                strings[5] = etudiant.getMes_clubs().get(7).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


        server.createContext("/MonClub9", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(8).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(8).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(8).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(8).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(8).get_post();
                strings[5] = etudiant.getMes_clubs().get(8).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


        server.createContext("/MonClub10", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");


                String[] strings = new String[6];

                strings[0] = etudiant.getMes_clubs().get(9).get_nom_club();
                strings[1] = etudiant.getMes_clubs().get(9).get_date_inscription();
                strings[2] = etudiant.getMes_clubs().get(9).get_date_quitter();
                strings[3] = etudiant.getMes_clubs().get(9).get_objectif_club();
                strings[4] = etudiant.getMes_clubs().get(9).get_post();
                strings[5] = etudiant.getMes_clubs().get(9).get_projets();
                System.out.println(strings[0]);
                System.out.println(strings[1]);
                System.out.println(strings[2]);
                System.out.println(strings[3]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/**********************/
        /*server.createContext("/ModuleALSDS", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                try{
                ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/ReferentielAnneeDEtude.dat");
                String home = System.getProperty("user.home");
                String[] strings = new String[10];
                FileInputStream fis = new FileInputStream(home +"/ReferentielAnneeDEtude.dat");
               boolean trouv=false;
                ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
               System.out.println("avant while");
                while (fis.available()>0 && !trouv) {

                   if(n.niveauDetude=="1CP") {
                       System.out.println("avant if");
                       if (m.nomModule == "Algorithmique et Structures de Donnees Statiques") {
                           System.out.println("apres if");
                           trouv = true;
                           strings[0] = m.nomModule;
                           System.out.println(m.nomModule);

                           strings[1] = m.descriptif;
                           strings[2] = m.competencesModule[0].contenu_compétence;
                           strings[3] = m.competencesModule[0].contenu_compétence;
                           strings[4] = m.competencesModule[0].contenu_compétence;
                           strings[5] = m.competencesModule[0].contenu_compétence;
                           strings[6] = m.competencesModule[0].contenu_compétence;
                           strings[7] = m.competencesModule[0].contenu_compétence;
                           //strings[8] = m.competencesModule[0].contenu_compétence;
                       }
                   }
                }

                Gson gson = new Gson();


// Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(strings).getBytes());
                output.flush();
                ois.close();
                fis.close();
                //System.out.println(cpt);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }






        }else{
            exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

        }
        exchange.close();
    }));
*/

/********************************
 server.createContext("/ModuleALSDS", (exchange -> {

 // GET REQUEST
 if ("GET".equals(exchange.getRequestMethod())) {
 InputStream req = exchange.getRequestBody();
 try{

 String[] strings = new String[10];


 String nv = "1CPI";
 String modu="Algorithmique et Structures de Donnees Statiques";
 //String comp="Analyser une fonction réelle à une variable réelle";
 ReferentielAnneeDEtude anneeRef =new ReferentielAnneeDEtude("/RéferentielAnneDetude.txt");

 if(anneeRef.recherchenv("/RéferentielAnneDetude.txt",nv ).trv==true) {
 System.out.println((anneeRef.recherchenv("/RéferentielAnneDetude.txt",nv ).n.niveauDetude));

 }
 if(anneeRef.recherchemd("/RéferentielAnneDetude.txt", modu).trouv==true) {
 System.out.println((anneeRef.recherchemd("/RéferentielAnneDetude.txt",modu ).m.nomModule));
 while((anneeRef.recherchemd("/RéferentielAnneDetude.txt",modu ).m.nomModule.)
 }


 Gson gson = new Gson();

 // Serialization


 exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
 OutputStream output = exchange.getResponseBody();
 output.write( gson.toJson(strings).getBytes());
 output.flush();
 // ois.close();
 //  fis.close();
 //System.out.println(cpt);
 } catch (FileNotFoundException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }






 }else{
 exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

 }
 exchange.close();
 }));






 /********************************************************/
//Endpoint /unClub
        server.createContext("/RejoindreClub", (exchange -> {

            // POST REQUEST
            if ("POST".equals(exchange.getRequestMethod())) {

                JSONObject finalResponse = new JSONObject();
                boolean trouv = false;
                try {
                    Gson gson = new Gson();
                    ListeClub clubs = new ListeClub();
                    clubs.Creer_fichier_clubs("/listeClubs.dat");

                    JSONObject requestJsonBody = Util.getRequestBodyObject(exchange);

                    String nomClub = requestJsonBody.getString("nomClub");
                    String post = requestJsonBody.getString("post"); //plusieurs postes : tableaux

                    String dateinscription = requestJsonBody.getString("dateinscription");


                    String projrealise = requestJsonBody.getString("projrealise"); //plusieurs projets: tableaux


                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/listeClubs.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    ClubESI n = new ClubESI();

                    while (fis.available() > 0 && trouv == false) {
                        n = (ClubESI) ois.readObject();

                        if (n.get_nom_club().equals(nomClub)) {

                            trouv = true;

                            n.ajouter_post(post);


                            n.ajouter_projets(projrealise);

                            etudiant.rejoindreClub(n, dateinscription);

                        }
                    }
                    if (trouv == true) {//true


                        finalResponse.put("success", true);
                        finalResponse.put("error", "null");
                        finalResponse.put("Club", Util.convertClubToJson(n));
//

                    } else {
                        System.out.println("Club non trouvé");
                        finalResponse.put("success", false);
                        finalResponse.put("error", "Club non trouvé");
                        finalResponse.put("Club", "null");
                    }

                    /**********************/
                    exchange.sendResponseHeaders(200, finalResponse.toString().getBytes().length);
                    exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
                    OutputStream output = exchange.getResponseBody();
                    output.write(finalResponse.toString().getBytes());
                    output.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /***********************/


                /**********************/

            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


/*********************************************************/

        //        Endpoint /les Compétences technique

        server.createContext("/lesCompetencestech", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                try {

                    //ReferentielCompetences competences = new ReferentielCompetences("/ReferentielCompetences1.dat");
                    //competences.Creer_fichier("/ReferentielAnneeDEtude1.dat", "/ReferentielCompetences1.dat");
                    String home = System.getProperty("user.home");
                    String[] strings = new String[154];
                    int ii = 0;
                    FileInputStream fis = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (ii < 154) {
                        Competence n = (Competence) ois.readObject();
                        if (n.type_compétence == 1) {

                            strings[ii] = n.contenu_compétence;
                            System.out.println(strings[ii]);
                            ii++;
                            System.out.println(ii);

                        } else
                            ii++;
                    }

                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");
                /*String[] strings =new String[20] ;
                try {
                    int ii = 0;
                    LiseClub clubs = new ListeClub();
                    clubs.Creer_fichier_clubs("/listeClubs.dat");
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/listeClubs.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ClubESI n = (ClubESI) ois.readObject();



                        strings[ii]=n.get_nom_club();
                        ii++;
                        strings[ii]=n.get_objectif_club();
                        ii++;
                    }
                    //cpt++;



                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

        /*********************************************************/
        //        Endpoint /les Compétences méthodologiques

        server.createContext("/lesCompetencesmeth", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                try {

                    //ReferentielCompetences competences = new ReferentielCompetences("/ReferentielCompetences2.dat");
                    //competences.Creer_fichier("/ReferentielAnneeDEtude2.dat", "/ReferentielCompetences2.dat");
                    String home = System.getProperty("user.home");
                    String[] strings = new String[154];
                    int ii = 0;
                    FileInputStream fis = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (ii < 154) {
                        Competence n = (Competence) ois.readObject();
                        if (n.type_compétence == 2) {

                            strings[ii] = n.contenu_compétence;
                            System.out.println(strings[ii]);
                            ii++;
                            System.out.println(ii);

                        } else
                            ii++;
                    }

                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");
                /*String[] strings =new String[20] ;
                try {
                    int ii = 0;
                    LiseClub clubs = new ListeClub();
                    clubs.Creer_fichier_clubs("/listeClubs.dat");
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/listeClubs.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ClubESI n = (ClubESI) ois.readObject();



                        strings[ii]=n.get_nom_club();
                        ii++;
                        strings[ii]=n.get_objectif_club();
                        ii++;
                    }
                    //cpt++;



                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

/*********************************************************/
        //        Endpoint /les Compétences de modelisation

        server.createContext("/lesCompetencesmod", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                try {

                    //ReferentielCompetences competences = new ReferentielCompetences("/ReferentielCompetences3.dat");
                    //competences.Creer_fichier("/ReferentielAnneeDEtude3.dat", "/ReferentielCompetences3.dat");
                    String home = System.getProperty("user.home");
                    String[] strings = new String[154];
                    int ii = 0;
                    FileInputStream fis = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (ii < 154) {
                        Competence n = (Competence) ois.readObject();
                        if (n.type_compétence == 3) {

                            strings[ii] = n.contenu_compétence;
                            System.out.println(strings[ii]);
                            ii++;
                            System.out.println(ii);

                        } else
                            ii++;
                    }

                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");
                /*String[] strings =new String[20] ;
                try {
                    int ii = 0;
                    LiseClub clubs = new ListeClub();
                    clubs.Creer_fichier_clubs("/listeClubs.dat");
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/listeClubs.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ClubESI n = (ClubESI) ois.readObject();



                        strings[ii]=n.get_nom_club();
                        ii++;
                        strings[ii]=n.get_objectif_club();
                        ii++;
                    }
                    //cpt++;



                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

/*********************************************************/
        //        Endpoint /les Compétences operationnel

        server.createContext("/lesCompetencesoper", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                try {

                    //ReferentielCompetences competences = new ReferentielCompetences("/ReferentielCompetences4.dat");
                    //competences.Creer_fichier("/ReferentielAnneeDEtude4.dat", "/ReferentielCompetences4.dat");
                    String home = System.getProperty("user.home");
                    String[] strings = new String[154];
                    int ii = 0;
                    FileInputStream fis = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (ii < 154) {
                        Competence n = (Competence) ois.readObject();
                        if (n.type_compétence == 4) {

                            strings[ii] = n.contenu_compétence;
                            System.out.println(strings[ii]);
                            ii++;
                            System.out.println(ii);

                        } else
                            ii++;
                    }

                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");
                /*String[] strings =new String[20] ;
                try {
                    int ii = 0;
                    LiseClub clubs = new ListeClub();
                    clubs.Creer_fichier_clubs("/listeClubs.dat");
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/listeClubs.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait lire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ClubESI n = (ClubESI) ois.readObject();



                        strings[ii]=n.get_nom_club();
                        ii++;
                        strings[ii]=n.get_objectif_club();
                        ii++;
                    }
                    //cpt++;



                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    //System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


/*******************************************
 /*******************************************************/

//Endpoint /unClub
        server.createContext("/MonProfil", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/listeClubs.dat");
                String[] stringsEtud = new String[3];
                stringsEtud[0] = etudiant.getNom();//nom de l'étudiant
                stringsEtud[1] = etudiant.getPrenom();
                stringsEtud[2] = etudiant.getAnneeDEtude();

                System.out.println(stringsEtud[0]);
                System.out.println(stringsEtud[1]);
                System.out.println(stringsEtud[2]);
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(stringsEtud).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(stringsEtud).getBytes());
                output.flush();
               /* try {

                    File f = new File("Registration.txt");
                    Scanner content = new Scanner(f);

                    while (content.hasNextLine()) {
                        String data = content.nextLine();//extraire la ligne du fichier

                        String[] words = data.split(" ");//espacer la chaine en tableaux de mots


                        String[] stringsEtud =new String[2] ;
                       stringsEtud[0]=words[0];
                        stringsEtud[0]=words[1];


                        Gson gson = new Gson();
                        // Serialization
                        // ==> ["abc", "def", "ghi"]

                        exchange.sendResponseHeaders(200,  gson.toJson(stringsEtud).getBytes().length);
                        OutputStream output = exchange.getResponseBody();
                        output.write( gson.toJson(stringsEtud).getBytes());
                        output.flush();


                    }
                }
                catch (FileNotFoundException e) {


                    System.out.println("Vous n'etes pas encore inscrit ! ");
                    e.printStackTrace();
                }*/

            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
        /**/
        server.createContext("/changerMotDePasse", (exchange -> {
            if ("POST".equals(exchange.getRequestMethod())) {
                JSONObject finalResponse = new JSONObject();

                JSONObject requestJsonBody = Util.getRequestBodyObject(exchange);
                String uname = requestJsonBody.getString("uname");
                String password = requestJsonBody.getString("password");
                String newPass = requestJsonBody.getString("newPass");
                int changedPass = etudiant.changermotdepasse(uname, password, newPass);
                if (changedPass == 0) { //true
                    System.out.println("Mot de passe changé !");
                    finalResponse.put("success", true);
                    finalResponse.put("error", "null");
                    finalResponse.put("etudiant", Util.convertEtudiantToJson(etudiant));
                } else if (changedPass == 1) {
                    finalResponse.put("error", "Votre mot de passe est incorrect!");
                } else if (changedPass == 2) {
                    finalResponse.put("error", "votre adresse est incorrecte !");
                } else {
                    finalResponse.put("error", "Vous n'etes pas encore inscrit !");
                }

                exchange.sendResponseHeaders(200, finalResponse.toString().getBytes().length);
                exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
                OutputStream output = exchange.getResponseBody();
                output.write(finalResponse.toString().getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));
/***********************************************/

/**********************************/
        //Endpoint /mesClubs
        server.createContext("/mesModules", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                String[] strings = new String[50];
                try {

                    String home = System.getProperty("user.home");

                    //int ii = 0;
                    FileInputStream fis = new FileInputStream(home + "/ReferentielAnneeDEtude.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    while (fis.available() > 0) {
                        NiveauDEtude cl = (NiveauDEtude) ois.readObject();
                        String annee = etudiant.getAnneeDEtude();
                        System.out.println(annee);
                        String niveau = cl.niveauDetude;
                        System.out.println(niveau);
                        if (annee.equals(niveau)) {
                            for (int j = 0; j < cl.modules.length; j++) {
                                System.out.println(cl.modules[j].nomModule);
                                strings[j] = cl.modules[j].nomModule;

                            }
                        }


                    }

                    ois.close();
                    fis.close();
                    //  return clubss;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();

            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
        /***/

/**********************************/
        //Endpoint /mesClubs
        server.createContext("/mesCompétences", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                String[] strings = new String[80];
                try {

                    String home = System.getProperty("user.home");

                    //int ii = 0;
                    FileInputStream fis = new FileInputStream(home + "/ReferentielAnneeDEtude.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    while (fis.available() > 0) {
                        NiveauDEtude cl = (NiveauDEtude) ois.readObject();
                        String annee = etudiant.getAnneeDEtude();

                        String niveau = cl.niveauDetude;
                        int k = 0;//parcourir le tableau
                        if (annee.equals(niveau)) {
                            for (int j = 0; j < cl.modules.length; j++) {
                                System.out.println(cl.modules[j].nomModule);
                                System.out.println(" apres uf");
                                for (int jj = 0; jj < cl.modules[j].competencesModule.length; jj++) {

                                    strings[k] = cl.modules[j].competencesModule[jj].contenu_compétence;
                                    k++;
                                    System.out.println(cl.modules[j].competencesModule[jj].contenu_compétence);
                                }
                            }
                        }


                    }

                    ois.close();
                    fis.close();
                    //  return clubss;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200, gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(gson.toJson(strings).getBytes());
                output.flush();

            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

        /********************************************************/
        server.createContext("/getComp", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String[] strings =new String[255] ;
                try {
                    int cpt = 0;
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        Competence n = (Competence) ois.readObject();
                        strings[cpt]=n.contenu_compétence;
                        cpt++;
                        System.out.println(n.contenu_compétence);

                    }
                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    ois.close();
                    fis.close();
                    System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));


/*******************************************************/

        server.createContext("/ModuleALSDS", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String[] strings=new String[30];
                int str=2;
                try{

                    String home = System.getProperty("user.home");

                    //int ii = 0;
                    FileInputStream fis = new FileInputStream(home +"/ReferentielAnneeDEtude.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    while(fis.available() > 0) {
                        NiveauDEtude cl = (NiveauDEtude)ois.readObject();
                        String annee = "1CPI";
                        System.out.println(annee);
                        String niveau=cl.niveauDetude;
                        System.out.println(niveau);
                        if(annee.equals(niveau)){
                            int j=0;
                            while(j<cl.modules.length && !(cl.modules[j].nomModule.equals("Algorithmique et Structures de Donnees Statiques"))){//TQ je n'ai pas terminé labouble des modules
                                System.out.println(cl.modules[j].nomModule);
                                // strings[j]=cl.modules[j].nomModule;
                                j++;
                                System.out.println("whiiiiiiiiiile");
                            }
                            System.out.println("fin while");
                            if(cl.modules[j].nomModule.equals("Algorithmique et Structures de Donnees Statiques")){
                                System.out.println("ifff");
                                strings[0]=cl.modules[j].nomModule;
                                System.out.println(cl.modules[j].nomModule);
                                strings[1]=cl.modules[j].descriptif;
                                System.out.println(cl.modules[j].descriptif);
                                int c=0;
                                while(c < cl.modules[j].competencesModule.length){
                                    strings[str]=cl.modules[j].competencesModule[c].contenu_compétence;
                                    System.out.println(cl.modules[j].competencesModule[c].contenu_compétence);
                                    c++;
                                    str++;
                                }
                            }
                        }



                    }

                    ois.close();
                    fis.close();
                    //  return clubss;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                } catch(IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(strings).getBytes());
                output.flush();





            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/*******************************************************/
/********************************/
        server.createContext("/ModuleANAD", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String[] strings=new String[30];
                int str=2;
                try{

                    String home = System.getProperty("user.home");

                    //int ii = 0;
                    FileInputStream fis = new FileInputStream(home +"/ReferentielAnneeDEtude.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    while(fis.available() > 0) {
                        NiveauDEtude cl = (NiveauDEtude)ois.readObject();
                        String annee = "2Cs_SIT";

                        String niveau=cl.niveauDetude;

                        if(annee.equals(niveau)){
                            int j=0;
                            while(j<cl.modules.length && !(cl.modules[j].nomModule.equals("Analyse et fouille de donnees"))){//TQ je n'ai pas terminé labouble des modules
                                System.out.println(cl.modules[j].nomModule);

                                j++;

                            }

                            if(cl.modules[j].nomModule.equals("Analyse et fouille de donnees")){

                                strings[0]=cl.modules[j].nomModule;

                                strings[1]=cl.modules[j].descriptif;
                                System.out.println(cl.modules[j].descriptif);
                                int c=0;
                                while(c < cl.modules[j].competencesModule.length){
                                    strings[str]=cl.modules[j].competencesModule[c].contenu_compétence;
                                    System.out.println(cl.modules[j].competencesModule[c].contenu_compétence);
                                    c++;
                                    str++;
                                }
                            }
                        }



                    }

                    ois.close();
                    fis.close();
                    //  return clubss;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                } catch(IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(strings).getBytes());
                output.flush();





            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

/*******************************************************/
        server.createContext("/getMyComp", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/Rï¿½ferentielAnneDetude.txt");
                //ListeCompetences_ajoutées liste=new ListeCompetences_ajoutées("/ListeCompetences_ajoutées.txt");
                //VersionedClass[] tab =new VersionedClass[10] ;

                //ReferentielCompetences compRef = new ReferentielCompetences("/ReferentielCompetences");
                // compRef.Creer_fichier("/Rï¿½ferentielAnneDetude.txt", "/ReferentielCompetences");
                String home = System.getProperty("user.home");
                int cpt = 0;

                try {
                    FileInputStream fis = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        Competence n = (Competence) ois.readObject();
                        if(n.compétence_validée) {

                            VersionedClass versionedObject = new VersionedClass(n.contenu_compétence,n.type_compétence);
                            // tab[cpt] = versionedObject;

                            cpt++;
                            System.out.println(n.contenu_compétence);
                        }
                    }
                    ois.close();
                    fis.close();
                    // liste.creerFIchier("/ListeCompetences_ajoutées.txt");

                    //test de l'ajout
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try{
                    //ListeCompetences_ajout�es ref=new ListeCompetences_ajout�es("/ListeCompetences_ajout�es.txt");

                    FileInputStream fos = new FileInputStream(home+"/ListeCompetences_ajoutées.txt");
                    ObjectInputStream oos = new ObjectInputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
                    while(fos.available() > 0) {
                        Competence n = (Competence)oos.readObject();
                        // VersionedClass versionedObject = new VersionedClass(n.contenu_compétence,n.type_compétence);
                        //tab[cpt] = versionedObject;

                        cpt++;
                        System.out.println(n.contenu_compétence);

                    }
                    oos.close();
                    fos.close();
                    System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                VersionedClass[] tab =new VersionedClass[cpt] ;
                int inc=0;
                try{

                    FileInputStream fs = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream os = new ObjectInputStream(fs);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fs.available() > 0) {
                        Competence n = (Competence) os.readObject();
                        if(n.compétence_validée) {
                            VersionedClass versionedObject = new VersionedClass(n.contenu_compétence,n.type_compétence);
                            tab[inc] = versionedObject;
                            inc++;
                            System.out.println(n.contenu_compétence);
                        }
                    }
                    os.close();
                    fs.close();
                    //   liste.creerFIchier("/ListeCompetences_ajoutées.txt");

                    //test de l'ajout

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //ListeCompetences_ajout�es ref=new ListeCompetences_ajout�es("/ListeCompetences_ajout�es.txt");
                try{
                    FileInputStream f = new FileInputStream(home+"/ListeCompetences_ajoutées.txt");
                    ObjectInputStream o = new ObjectInputStream(f);//objet qui sait ecrire des flux d'octets sur un fichier
                    while(f.available() > 0) {
                        Competence n = (Competence)o.readObject();
                        VersionedClass versionedObject = new VersionedClass(n.contenu_compétence,n.type_compétence);
                        tab[inc] = versionedObject;

                        inc++;
                        System.out.println(n.contenu_compétence);

                    }
                    o.close();
                    f.close();




                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(tab).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(tab).getBytes());
                    output.flush();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/*******************************************************/
        server.createContext("/getCompClub", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String home = System.getProperty("user.home");

                int cpt = 0;
                try {
                    FileInputStream fis = new FileInputStream(home + "/ListeCompetences_ajoutées.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        Competence n = (Competence) ois.readObject();
                        cpt++;

                    }
                    ois.close();
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Competence[] strings =new Competence[cpt] ;

                int inc = 0;

                try {

                    FileInputStream f = new FileInputStream(home+"/ListeCompetences_ajoutées.txt");
                    ObjectInputStream o = new ObjectInputStream(f);//objet qui sait ecrire des flux d'octets sur un fichier
                    while(f.available() > 0) {
                        Competence n = (Competence)o.readObject();
                        strings[inc]=n;

                        inc++;

                    }
                    o.close();
                    f.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                } catch(IOException e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();

// Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(strings).getBytes());
                output.flush();
                System.out.println(cpt);


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/*******************************************************/
        server.createContext("/StatistiquesCompetences", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String[] strings=new String[3];
                int cmp=0;
                int cmpp=0;
                int prs=0;
                int pdg=0;
                int pclb =0;

                int cmpT=0;
                try{

                    // ListeCompetences_ajoutées competencesAjoutees = new ListeCompetences_ajoutées("ListeCompetences_ajoutées.dat");
                    // competencesAjoutees.creerFIchier("ListeCompetences_ajoutées.dat");
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home +"/ListeCompetences_ajoutées.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    while(fis.available() > 0) {
                        Competence cl = (Competence)ois.readObject();

                        cmpT++;
                    }
                    //   System.out.println(cmpT);
                    String res ;
                    double hh=cmpT*100;
                    hh=hh/(255+cmpT);//pourcentage de competences Ajoutées
                    DecimalFormat df=new DecimalFormat("0.00");
                    res=df.format(hh);
                    strings[0]=(res)+"%";//statistiques compétences ajoutés
                    ois.close();
                    fis.close();
                    System.out.println(res);

                    home = System.getProperty("user.home");
                    FileInputStream fis2 = new FileInputStream(home +"/ReferentielCompetences");
                    ObjectInputStream ois2 = new ObjectInputStream(fis2);

                    while(fis2.available() > 0) {
                        Competence cl = (Competence)ois2.readObject();
                        if(cl.compétence_validée){
                            cmpp++;
                        }




                    }
                    String ress ;
                    double hhh=cmpp*100;
                    hhh=hhh/(255+cmpT);//pourcentage de competences Ajoutées
                    DecimalFormat dff=new DecimalFormat("0.00");
                    ress=dff.format(hhh);
                    strings[1]=(ress)+"%";//statistiques compétences ajoutés
                    fis2.close();
                    ois2.close();
                    System.out.println(cmpp);

                    //ListeProjetPersonnel listeProjetPersonnel = new ListeProjetPersonnel("/ListeProjetPersonal.txt");
                    // listeProjetPersonnel.creerFIchier("listeProjetPersonnel.dat");
                    home = System.getProperty("user.home");
                    FileInputStream fis3 = new FileInputStream(home +"/ListeProjetPersonnel.txt");
                    ObjectInputStream ois3 = new ObjectInputStream(fis3);
                    while(fis3.available() > 0) {
                        ProjetPersonnel prsn = (ProjetPersonnel)ois3.readObject();

                        prs++;
                    }
                    fis3.close();
                    ois3.close();
                    System.out.println(prs);

                    //ListeProjetPedagogique listeProjetPedagogique = new ListeProjetPedagogique("/ListeProjetPedagogiquee.txt");
                    home = System.getProperty("user.home");
                    FileInputStream fis4 = new FileInputStream(home +"/ListeProjetPedagogiquee.txt");
                    ObjectInputStream ois4 = new ObjectInputStream(fis4);
                    while(fis4.available() > 0) {
                        ProjetPedagogique prsn = (ProjetPedagogique) ois4.readObject();

                        pdg++;
                    }
                    fis4.close();
                    ois4.close();
                    System.out.println(pdg);

                    //ListeProjetClub listeProjetClub = new ListeProjetClub("/ListeProjetClub.txt");
                    home = System.getProperty("user.home");
                    FileInputStream fis5 = new FileInputStream(home +"/ListeProjetClub.txt");
                    ObjectInputStream ois5 = new ObjectInputStream(fis5);
                    while(fis5.available() > 0) {
                        ProjetClub prsn = (ProjetClub) ois5.readObject();

                        pclb++;
                    }
                    fis5.close();
                    ois5.close();


                    int projets=pclb+prs+pdg;//somme de tous les projets
                    System.out.println(projets);
                    String resss =String.valueOf(projets);
                    System.out.println(resss);


                    strings[2]=resss;




                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                } catch(IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                // Serialization
                // ==> ["abc", "def", "ghi"]
                // exchange.sendResponseHeaders(200,;
                exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(strings).getBytes());
                output.flush();





            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));

/*******************************************************/
        server.createContext("/getCompPerso", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();

                int cpt = 0;
                try {
                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/ListeCompetences_ajoutées.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        Competence n = (Competence) ois.readObject();
                        cpt++;

                    }
                    ois.close();
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Competence[] strings =new Competence[cpt+255] ;
                int inc = 0;

                try {

                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home + "/ReferentielCompetences");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        Competence n = (Competence) ois.readObject();
                        strings[inc]=n;
                        inc++;
                        System.out.println(n.contenu_compétence);

                    }
                    ois.close();
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                    try {
                        String home = System.getProperty("user.home");

                        FileInputStream f = new FileInputStream(home + "/ListeCompetences_ajoutées.txt");
                        ObjectInputStream o = new ObjectInputStream(f);//objet qui sait ecrire des flux d'octets sur un fichier
                        while (f.available() > 0) {
                            Competence n = (Competence) o.readObject();
                            strings[inc]=n;

                            cpt++;

                        }
                        o.close();
                        f.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Gson gson = new Gson();


// Serialization
                    // ==> ["abc", "def", "ghi"]

                    exchange.sendResponseHeaders(200,  gson.toJson(strings).getBytes().length);
                    OutputStream output = exchange.getResponseBody();
                    output.write( gson.toJson(strings).getBytes());
                    output.flush();
                    System.out.println(cpt);


            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/*******************************************************/
        server.createContext("/addProjectClub", (exchange -> {
            if("POST".equals(exchange.getRequestMethod())) {
                JSONObject finalResponse =  new JSONObject();
                Gson gson = new Gson();
                JSONObject requestJsonBody =Util.getRequestBodyObject(exchange);
                JSONArray tabComp = requestJsonBody.getJSONArray("tabComp");
                String nom = requestJsonBody.getString("nom");
                String descriptif = requestJsonBody.getString("descriptif");
                String club = requestJsonBody.getString("club");
                // JSONArray modules = requestJsonBody.getJSONArray("modules");

                System.out.println(nom);
                //System.out.println(descriptif);

                ProjetClub projet=new ProjetClub();
                for(int n=0; n<tabComp.length() ;n++) {
                    JSONObject obj=tabComp.getJSONObject(n);
                    projet.renseigner_competences("/ReferentielCompetences","/ListeCompetences_ajoutées.txt",obj.get("competence").toString());
                    // System.out.println(obj.get("competence").toString());

                }
                projet.renseignerClub(club);
                projet.créerProjet(nom);
                projet.décrir_projet(descriptif);
               /* for(int n=0; n<modules.length() ;n++) {
                    JSONObject module=modules.getJSONObject(n);
                    projet.renseignerModules("/Rï¿½ferentielAnneDetude.txt",module.get("module").toString());
                  //  System.out.println(module.get("module").toString());


                }*/
                projet.renseignerClub(club);


                listeee.ajouter_projetClub(projet);

                //  test de l'ajout

                listeee.afficher("/ListeProjetClub.txt");


            }
            else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/********************************************************/
        server.createContext("/getProjetPedagogique", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/Rï¿½ferentielAnneDetude.txt");
                //ListeCompetences_ajoutées liste=new ListeCompetences_ajoutées("/ListeCompetences_ajoutées.txt");
                //VersionedClass[] tab =new VersionedClass[10] ;

                //ReferentielCompetences compRef = new ReferentielCompetences("/ReferentielCompetences");
                // compRef.Creer_fichier("/Rï¿½ferentielAnneDetude.txt", "/ReferentielCompetences");
                String home = System.getProperty("user.home");
                int cpt = 0;

                try {
                    FileInputStream fis = new FileInputStream(home + "/ListeProjetPedagogiquee.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ProjetPedagogique n = (ProjetPedagogique) ois.readObject();
                        cpt++;
                        System.out.println(n.nom_projet);
                    }

                    ois.close();
                    fis.close();
                    // liste.creerFIchier("/ListeCompetences_ajoutées.txt");

                    //test de l'ajout
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                PrjPdeago[] tab =new PrjPdeago[cpt] ;
                int inc=0;
                try{

                    FileInputStream fs = new FileInputStream(home + "/ListeProjetPedagogiquee.txt");
                    ObjectInputStream os = new ObjectInputStream(fs);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fs.available() > 0) {
                        ProjetPedagogique n = (ProjetPedagogique) os.readObject();
                        PrjPdeago p=new PrjPdeago(n.nom_projet,n.module,n.description,n.Liste_comp_validee);
                        tab[inc] = p;
                        inc++;
                        System.out.println(n.nom_projet);
                    }

                    os.close();
                    fs.close();
                    //   liste.creerFIchier("/ListeCompetences_ajoutées.txt");

                    //test de l'ajout

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                Gson gson = new Gson();


// Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200,  gson.toJson(tab).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(tab).getBytes());
                output.flush();



            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/******************************************************/
        server.createContext("/getProjetPersonnel", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                // ReferentielAnneeDEtude anneeRef = new ReferentielAnneeDEtude("/Rï¿½ferentielAnneDetude.txt");
                //ListeCompetences_ajoutées liste=new ListeCompetences_ajoutées("/ListeCompetences_ajoutées.txt");
                //VersionedClass[] tab =new VersionedClass[10] ;

                //ReferentielCompetences compRef = new ReferentielCompetences("/ReferentielCompetences");
                // compRef.Creer_fichier("/Rï¿½ferentielAnneDetude.txt", "/ReferentielCompetences");
                String home = System.getProperty("user.home");
                int cpt = 0;

                try {
                    FileInputStream fis = new FileInputStream(home + "/ListeProjetPersonnel.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ProjetPersonnel n = (ProjetPersonnel) ois.readObject();
                        cpt++;
                        //System.out.println(n.nom_projet);
                    }

                    ois.close();
                    fis.close();
                    // liste.creerFIchier("/ListeCompetences_ajoutées.txt");

                    //test de l'ajout
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                PrjPerso[] tab =new PrjPerso[cpt] ;
                int inc=0;
                try{

                    FileInputStream fs = new FileInputStream(home + "/ListeProjetPersonnel.txt");
                    ObjectInputStream os = new ObjectInputStream(fs);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fs.available() > 0) {
                        ProjetPersonnel n = (ProjetPersonnel) os.readObject();
                        PrjPerso p=new PrjPerso(n.nom_projet,n.typeProjet,n.description,n.Liste_comp_validee);
                        tab[inc] = p;
                        inc++;
                        //   System.out.println(n.nom_projet);
                        System.out.println(p.Liste_comp_validee[0]);

                    }

                    os.close();
                    fs.close();
                    //   liste.creerFIchier("/ListeCompetences_ajoutées.txt");

                    //test de l'ajout

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                Gson gson = new Gson();


// Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200,  gson.toJson(tab).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(tab).getBytes());
                output.flush();



            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/******************************************************/
        server.createContext("/getProjetClub", (exchange -> {

            // GET REQUEST
            if ("GET".equals(exchange.getRequestMethod())) {
                InputStream req = exchange.getRequestBody();
                String home = System.getProperty("user.home");
                int cpt = 0;

                try {
                    FileInputStream fis = new FileInputStream(home + "/ListeProjetClub.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fis.available() > 0) {
                        ProjetClub n = (ProjetClub) ois.readObject();
                        cpt++;
                        //System.out.println(n.nom_projet);
                    }

                    ois.close();
                    fis.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                PrjPerso[] tab =new PrjPerso[cpt] ;
                int inc=0;
                try{

                    FileInputStream fs = new FileInputStream(home + "/ListeProjetClub.txt");
                    ObjectInputStream os = new ObjectInputStream(fs);//objet qui sait ecrire des flux d'octets sur un fichier
                    while (fs.available() > 0) {
                        ProjetClub n = (ProjetClub) os.readObject();
                        PrjPerso p=new PrjPerso(n.nom_projet,n.club,n.description,n.Liste_comp_validee);
                        tab[inc] = p;
                        inc++;
                        //   System.out.println(n.nom_projet);
                        System.out.println(p.Liste_comp_validee[0]);

                    }

                    os.close();
                    fs.close();
                    //   liste.creerFIchier("/ListeCompetences_ajoutées.txt");

                    //test de l'ajout

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                Gson gson = new Gson();


// Serialization
                // ==> ["abc", "def", "ghi"]

                exchange.sendResponseHeaders(200,  gson.toJson(tab).getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write( gson.toJson(tab).getBytes());
                output.flush();



            }else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/******************************************************/

        server.createContext("/addProjectPedagogique", (exchange -> {
            if("POST".equals(exchange.getRequestMethod())) {
                JSONObject finalResponse =  new JSONObject();
                Gson gson = new Gson();
                // ReferentielCompetences compRef = new ReferentielCompetences("/ReferentielCompetences");
                // compRef.Creer_fichier("/Rï¿½ferentielAnneDetude.txt", "/ReferentielCompetences");


                JSONObject requestJsonBody =Util.getRequestBodyObject(exchange);
                String nom = requestJsonBody.getString("nom");
                String descriptif = requestJsonBody.getString("descriptif");

                System.out.println(nom);
                System.out.println(descriptif);

                JSONArray tabComp = requestJsonBody.getJSONArray("tabComp");
                // JSONArray modules = requestJsonBody.getJSONArray("modules");
                String module = requestJsonBody.getString("module");

                ProjetPedagogique projet=new ProjetPedagogique();
                for(int n=0; n<tabComp.length() ;n++) {
                    JSONObject obj=tabComp.getJSONObject(n);
                    String cmp=  obj.get("competence").toString();

                    projet.renseigner_competences("/ReferentielCompetences",cmp);
                    System.out.println(obj.toString());

                }

                projet.créerProjet(nom);
                projet.décrir_projet(descriptif);
       /* for(int n=0; n<modules.length() ;n++) {
            JSONObject module=modules.getJSONObject(n);
            projet.renseignerModules("/Rï¿½ferentielAnneDetude.txt",module.get("module").toString());
          //  System.out.println(module.get("module").toString());


        }*/
                projet.renseignerModules("/Rï¿½ferentielAnneDetude.txt",module);


                listee.ajouter_projetPedagogique(projet);

                //  test de l'ajout

                listee.afficher("/ListeProjetPedagogiquee.txt");


            }
            else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/******************************************************/
        server.createContext("/addProjectPersonnel", (exchange -> {
            if("POST".equals(exchange.getRequestMethod())) {
                JSONObject finalResponse =  new JSONObject();

                System.out.println("success");
                // list.afficher("/ListeProjetPersonnel.txt");

                Gson gson = new Gson();
                // ReferentielCompetences compRef = new ReferentielCompetences("/ReferentielCompetences");
                //compRef.Creer_fichier("/Rï¿½ferentielAnneDetude.txt", "/ReferentielCompetences");

                JSONObject requestJsonBody =Util.getRequestBodyObject(exchange);
                JSONArray tabComp = requestJsonBody.getJSONArray("tabComp");
                String nom = requestJsonBody.getString("nom");
                String descriptif = requestJsonBody.getString("descriptif");

                String typeProjet = requestJsonBody.getString("typeProjet");

                ProjetPersonnel projet=new ProjetPersonnel();

                projet.créerProjet(nom);
                projet.renseignerTypeProjet(typeProjet);
                projet.décrir_projet(descriptif);

                for(int n=0; n<tabComp.length() ;n++) {
                    JSONObject obj=tabComp.getJSONObject(n);
                    String cmp=  obj.get("competence").toString();

                    int type = obj.getInt("type");
                    projet.renseigner_competences("/ReferentielCompetences","/ListeCompetences_ajoutées.txt",cmp);
                }
                // System.out.println(nom);
                // System.out.println(descriptif);
                //System.out.println(typeProjet);
       /*for(int n=0; n<tabComp.length() ;n++) {
            JSONObject obj=tabComp.getJSONObject(n);
            int type = obj.getInt("type");
          String cmp=  obj.get("competence").toString();
            System.out.println(cmp);
            System.out.println(type);

        }*/

                list.ajouter_projetPersonnel(projet);

                //test de l'ajout

                list.afficher("/ListeProjetPersonnel.txt");

                finalResponse.put("success",true);
                exchange.sendResponseHeaders(200, finalResponse.toString().getBytes().length);
                exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
                OutputStream output = exchange.getResponseBody();
                output.write(finalResponse.toString().getBytes());
                output.flush();



            }
            else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/******************************************************/
        server.createContext("/addCompetence", (exchange -> {
            if("POST".equals(exchange.getRequestMethod())) {
                JSONObject finalResponse =  new JSONObject();


                JSONObject requestJsonBody =Util.getRequestBodyObject(exchange);
                String competence = requestJsonBody.getString("competence");
                int type = requestJsonBody.getInt("type");
                String rep=liste.ajouter_competence(competence,type);
                System.out.println(rep);
                //test de l'ajout

                try {
                    int cpt=0;
                    //ListeCompetences_ajout�es ref=new ListeCompetences_ajout�es("/ListeCompetences_ajout�es.txt");

                    String home = System.getProperty("user.home");
                    FileInputStream fis = new FileInputStream(home+"/ListeCompetences_ajoutées.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
                    while(fis.available() > 0) {
                        Competence n = (Competence)ois.readObject();
                        cpt++;
                        System.out.println(n.contenu_compétence);

                    }
                    ois.close();
                    fis.close();
                    System.out.println(cpt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                } catch(IOException e) {
                    e.printStackTrace();
                }
                finalResponse.put("reponse",rep);

                exchange.sendResponseHeaders(200, finalResponse.toString().getBytes().length);
                exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
                OutputStream output = exchange.getResponseBody();
                output.write(finalResponse.toString().getBytes());
                output.flush();
                /*
                finalResponse.put("reponse",rep);
                exchange.sendResponseHeaders(200, rep.getBytes().length);
                exchange.getResponseHeaders().put("Content-Type", Collections.singletonList("application/json"));
                OutputStream output = exchange.getResponseBody();
                output.write(rep.getBytes());
                output.flush();*/
/*
                exchange.sendResponseHeaders(200, rep.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(rep.getBytes());
                output.flush();
*/


            }
            else{
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed

            }
            exchange.close();
        }));
/******************************************************/
        server.setExecutor(null); // creates a default executor
        server.start();

    }
}