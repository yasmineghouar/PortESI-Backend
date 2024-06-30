package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
public class JsonFile {
    private FileWriter file;

    public JSONArray CreatJsonFile(){
        JSONArray jsonArray =new JSONArray();

        try {
            ReferentielAnneeDEtude anneeRef =new ReferentielAnneeDEtude("/R�ferentielAnneDetude.txt");

            ReferentielCompetences compRef =new ReferentielCompetences("/ReferentielCompetences.txt");
            compRef.Creer_fichier("/R�ferentielAnneDetude.txt" ,"/ReferentielCompetences.txt");
            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+"/ReferentielCompetences");
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
            while(fis.available() > 0) {
                Competence n = (Competence)ois.readObject();

                jsonArray.put(Util.convertCompetenceToJson(n))  ;
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
        // JSONObject jsonObject =new JSONObject();
        //jsonObject.put("competence",jsonArray);


        return jsonArray;}




}