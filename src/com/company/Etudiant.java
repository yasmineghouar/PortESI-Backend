package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Character;
public class Etudiant {
    private String adresse;
    private File photo;
    private String nom;
    private String Prenom;
    private String motDePasse;
    private String anneeDEtude;
    private ArrayList<ClubESI> mes_clubs = new ArrayList<ClubESI>();
    public String getAdresse() {
        return adresse;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public String getNom() {
        return nom;
    }
    public String getAnneeDEtude(){return anneeDEtude;}
    public void setAnneeDEtude(String anneeDEtude){
        this.anneeDEtude=anneeDEtude;
    }
    public String getPrenom() {
        return Prenom;
    }
    public ArrayList<ClubESI> getMes_clubs() {
        return mes_clubs;
    }
    public File getPhoto(){
        return this.photo;
    }

    public void setMes_clubs(ArrayList<ClubESI> mes_clubs) {
        this.mes_clubs = mes_clubs;
    }

    public void rejoindreClub(ClubESI club , String date){
        club.rejoindre_club(date);
        mes_clubs.add(club);
    }
    public int login(String Uname, String Pass)
    {
//il faut programmer une methode pour comparer ladresse et le mot de passe
        //extraire mot

        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;


        try {

            File f = new File("Registration.txt");
            Scanner content = new Scanner(f);

            while (content.hasNextLine()) {
                String data = content.nextLine();//extraire la ligne du fichier

                String[] words = data.split(" ");//espacer la chaine en tableaux de mots


                if (Uname.equals(words[2])) {//verifier si l'adresse existe
                    if (Pass.equals(words[3])) {
                        //si on a trouvé l'adresse verifier le mot de passe
                        System.out.println("Connexion réussie!");
                        System.out.println("Bienvenue dans Port'ESI !");

                        this.nom = words[0];
                        this.adresse = Uname;

                        this.Prenom = words[1];
                        this.anneeDEtude=words[4];

                        return 1;//TRUE CONNEXION VALIDEE
                    } else {//l'adresse est trouvé mais ce n'est pas le meme mot de passe
                        System.out.println("Mot de pass incorrect !");
                        return 0;//FALSE MOT DE PASSE INCORRECT
                    }
                }
            }


            System.out.println("Connexion échouée !");
            return 2; // Vous n'etes pas inscris

        }
        catch (FileNotFoundException e) {


            System.out.println("Vous n'etes pas encore inscrit ! ");
            e.printStackTrace();
        }


        return 2;
    }

    public int inscription(String nom, String prenom, String Uname, String Pass, String AnneeDEtude) throws FileNotFoundException
    {


        nom=nom.trim();

        if(!control_nom(nom)){
            System.out.println(("Veuillez insérez un nom qui ne contient pas de chiffres !"));
            return 4; //FALSE : NON INSCRIS ( nom DE L'ESI)
        }
        prenom=prenom.trim();
        if(!control_nom(prenom)){
            System.out.println(("Veuillez insérez un prenom qui ne contient pas de chiffres !"));
            return 5; //FALSE : NON INSCRIS ( nom DE L'ESI)
        }
        Uname=Uname.trim();
        if (!authenthficiation_mail(Uname)){
            System.out.println(("Veuillez insérer une adresse mail de l'ESI !"));
            return 0; //FALSE : NON INSCRIS ( ADRESSE NON DE L'ESI)
        }

        Pass=Pass.trim();
        AnneeDEtude=AnneeDEtude.trim();
        if(!control_annee(AnneeDEtude)){
            System.out.println(("Veuillez insérer: 1CP ou 2CP ou 1CS ou 2CS ou 3CS !"));
            return 6;//FALSE Il faut inserer l'annee comme 1CP ou 2CP ou 1CS ou 2CS ou 3CS !
        }

        //extraire et comparer adresse
        String x=nom+" "+prenom+" "+Uname+" "+Pass+" "+AnneeDEtude;

        File f = new File("Registration.txt");
        Scanner content = new Scanner(f);
        while (content.hasNextLine()) {//tant que le fichier n'est pas terminé
            String data = content.nextLine();//je reçois la ligne du fichier

            String[] words = data.split(" ");//espacer les
            for (String word : words) {
                //System.out.println(word);
                if(word.equals(Uname)){
                    System.out.println("Cette adresse mail est déja utilisée!");
                    return 3;//False: Cette adresse mail est déja utilisée!
                }
            }




            if(data.equals(x))
            {
                System.out.println("Deja inscrit !");
                content.close();
                return 1;    ////FALSE : NON INSCRIS Car DEJA INSCRIS
            }

        }
        content.close();
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("Registration.txt", true));
            out.write(nom+" "+prenom+" "+Uname+" "+Pass+" "+AnneeDEtude+"\n");
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception levée lors de l'inscription" + e);
        }

        System.out.println("Inscription Validée!");

        this.nom=nom;
        this.Prenom=prenom;
        this.adresse=Uname;
        this.motDePasse=Pass;
        this.anneeDEtude=AnneeDEtude;
        return 2; //TRUE: INSCRIS!

    }

    public boolean authenthficiation_mail(String mail) {
        String esi = "@esi.dz";
        int n = 7; // nbre de caract�res
        int length = mail.length();
        String result = mail.substring(length -n, length);
        if(result.equals(esi)) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean control_nom(String nom){
        for(int i=0; i<nom.length();i++){
            char charac = nom.charAt(i);//extraite caractere par caractere
            if(Character.isDigit(charac)){//si un chiffre existe
                return false;
            }
        }
        return true;
    }
    public boolean control_annee(String annee){
        String[] annees={"1CPI", "2CPI","1CS","2Cs_SIT","2Cs_SIL"
                ,"2Cs_SID","2Cs_SIQ","MSIQ","MSIT","MSIL","MSID"," 3Cs_SIQ","3Cs_SIT","3Cs_SIL","3Cs_SID"};


        System.out.println(annee);
        int i=0;
        boolean trouv=false;
        while(i<15 && !trouv){
            System.out.println(annees[i]);
            if(annee.equals(annees[i])){
                trouv=true;

            }
            i++;
        }
        if(trouv==true){
            return true;
        }else{
            return false;
        }
    }
    public int changermotdepasse (String Uname,String Pass,String newPass) {


        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;

        try{

            File f=new File("Registration.txt");
            Scanner content=new Scanner(f);

            while(content.hasNextLine()){
                String data=content.nextLine();
                String[] words=data.split(" ");//espacer la chaine en tableaux de mots

                if(Uname.equals(words[2])) //verifier si l'adresse existe
                {
                    if(Pass.equals(words[3])){

                        data = words[0]+" "+words[1]+" "+Uname+" "+newPass+" "+words[4];
                        this.nom = words[0];
                        this.Prenom = words[1];
                        this.adresse = Uname;
                        this.anneeDEtude=words[4];

                        /*********************/

                        String inputFileName = "registration.txt";
                        String outputFileName = "...";
                        String lineToRemove = words[0]+" "+words[1]+" "+words[2]+" "+words[3]+" "+words[4];

                        try {
                            File inputFile = new File(inputFileName);
                            File outputFile = new File(outputFileName);
                            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                                String line = null;
                                while ((line = reader.readLine()) != null) {
                                    if (!line.equals(lineToRemove)) {
                                        writer.write(line);
                                        writer.newLine();
                                    }
                                }
                            }


                            if (inputFile.delete()) {
                                //Renommer le fichier
                                if (!outputFile.renameTo(inputFile)) {
                                    throw new IOException("Could not rename " + outputFileName + " to " + inputFileName);
                                }
                            } else {
                                throw new IOException("Could not delete original input file " + inputFileName);
                            }
                        } catch (IOException ex) {

                            ex.printStackTrace();
                        }
                        /*******************/
                        //on change le mot de passe
                        try {
                            BufferedWriter out = new BufferedWriter(new FileWriter("Registration.txt", true));
                            out.write(data+"\n");
                            out.close();
                        }
                        catch (IOException e) {
                            System.out.println("exception levée lors de changement du mo de passe" + e);
                        }

                        System.out.println("votre mot de passe est changé");
                        this.motDePasse=newPass;
                        return 0; //true
                    }
                    else{
                        System.out.println("votre mot de passe est incorrect !");
                        return 1; //false : mot de passe incorrect
                    }
                }
            }
            System.out.println("votre adresse est incorrecte !");
            return 2; //false : adresse incorrecte

        }
        catch (FileNotFoundException e) {


            System.out.println("Vous n'etes pas encore inscrit ! ");
            e.printStackTrace();
        }
        return 3; //erreur

    }


    public static void main(String[] args) throws FileNotFoundException{//programme proncipale de Inscription:

  /* try {

         File obj = new File("Registration.txt");

          if (obj.createNewFile())
          {
            System.out.println("Le fichier est cr�e.");
          }

        }
        catch (IOException e)
        {
          System.out.println("An error occurred.");
          e.printStackTrace();

        }*/

   /* int choice;
    Scanner sc=new Scanner(System.in);
    System.out.println("1. Inscription. ");
    System.out.println("2. Se connecter. ");

    System.out.println("Entrez votre choix :");
    choice=sc.nextInt();
    sc.nextLine();

    if(choice==1)
    {
        Etudiant  user = new Etudiant();
        user.inscription();
    }
    else if(choice==2)
    {
        Etudiant user = new Etudiant();
        user.login();
    }
    else
    {
        System.out.println("Rechoisir une option :");
    }
    sc.close();*/
        Etudiant  user = new Etudiant();
        //int b= user.inscription("gaga","ii","ki_boudjadi@esi.dz","iiga");
        //int b2 = user.login("ki_boudjadi@esi.dz","hehe");
        int a = user.changermotdepasse("kw_kanounnn@esi.dz","kanoun" , "siso");
        System.out.println(a);
    }
}