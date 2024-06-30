package com.company;

import org.json.JSONObject;
import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

    public static JSONObject getRequestBodyObject(HttpExchange exchange) throws IOException {
        InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
        BufferedReader br = new BufferedReader(isr);

        // From now on, the right way of moving from bytes to utf-8 characters:
        int b;
        StringBuilder buf = new StringBuilder(512);
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }
        JSONObject jsonObject = new JSONObject(buf.toString());
        return jsonObject;
    }

    public static JSONObject convertEtudiantToJson(Etudiant etudiant){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nom" , etudiant.getNom());
        jsonObject.put("prenom" , etudiant.getPrenom());
        jsonObject.put("adresse" , etudiant.getAdresse());
        jsonObject.put("Annee d'etude" , etudiant.getAnneeDEtude());
        return jsonObject;
    }
    public static JSONObject convertClubToJson(ClubESI club){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nomClub" , club.get_nom_club());
        jsonObject.put("description" , club.get_objectif_club());
        jsonObject.put("dateinscription" , club.get_date_inscription());
        jsonObject.put("jusqu'a" , club.get_date_quitter());
        jsonObject.put("projrealise" , club.get_projets());

        jsonObject.put("post" , club.get_post());




        return jsonObject;
    }

    public static JSONObject convertCompetenceToJson(Competence competence) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("contenuComp",competence.contenu_compétence );

        return jsonObject;
    }
}