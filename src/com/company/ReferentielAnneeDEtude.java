package com.company;

import java.io.*;

@SuppressWarnings("unused")
public class ReferentielAnneeDEtude {
    public  ReferentielAnneeDEtude(String nomDuFichier) {

//----------------------------------------------------cycle sup specialités----------------------------------------------

        Competence c1 = new Competence(1,"Analyser les techniques de description multidimensionnelle (reduction, visualisation, clustering,…)",2);
        Competence c2 = new Competence(2,"Effectuer une modelisation statistique (regression, classification) sur une masse de donnees",2);
        Competence c3 = new Competence(3,"Mobiliser les outils pour traiter les donnees et interpreter les resultats",1);
        Module moduleANAD =new Module("Analyse et fouille de donnees","L’utilisation de l’analyse de donnees s’etend à des domaines tres vastes, //n"
                + "dont la reconnaissance de formes, Data mining, prediction, marketing, biostatistique………",new Competence[] {c1,c2,c3});

        Competence c4 = new Competence(4,"Etudier les paradigmes de programmation et les transformations de programmes",2);
        Competence c5 = new Competence(5,"Programmer un compilateur d'un langage vers une machine cible",1);
        Competence c6 = new Competence(6,"Décrire et analyser la semantique d'un langage",1);
        Competence c7 = new Competence(7,"Exploiter un outil de generation d'analyseur syntaxique et lexical en vue de concevoir un langage",1);
        Competence c8 = new Competence(8,"Effectuer une analyse lexicale et syntaxique d'un langage",2);

        Module moduleCOM =new Module("Compilation","-Ecrire une grammaire d’un langage de programmation et construire un analyseur syntaxique //n"
                + "pour ce langage à l’aide d’outils standard.\r\n"
                + "- Comprendre la description formalisee de la semantique operationnelle et de la semantique statique d’un langage\r\n"
                + "- programmer un compilateur d'un langage vers une machine cible",new Competence[] {c4,c5,c6,c7,c8});

        Competence c9 = new Competence(9,"Exploiter la theorie de files d'attentes pour modeliser un systeme",3);
        Competence c10 = new Competence(10,"Mettre en oeuvre la simulation d'un systeme",2);

        Module moduleFAS =new Module("File d'attente et Simulation","Etudier les differents modeles de files d'attente et calculer les parametres de performance//n"
                + "Apprendre les techniques de simulation",new Competence[] {c9,c10});


        Competence c11 = new Competence(11,"Analyser la qualite de service et les protocoles de sa mise en oeuvre dans un reseau informatique",1);
        Competence c12 = new Competence(12,"Mettre en place un reseau d'operateur base sur la technologie MPLS et ses variantes",1);
        Competence c13 = new Competence(13,"Identifier les technologies de mise en oeuvre d'infrastructure de transport au sein d'Internet",1);
        Competence c14 = new Competence(14,"Analyser la fonction de routage dynamique dans Internet",1);

        Module moduleRESA =new Module("Reseaux Avances","Comprendre le principe et la mise en ouvre du routage dynamique et le routage sur Internet\r\n"
                + "Mettre en place un reseau Provider base sur la technologie MPLS et ses variantes : VPN/MPLS et MPLS-TE\r\n"
                + "Decouvrir les aspects avances de l’adressage IPV6 notamment l’aspect mobilite\r\n"
                + "Sensibiliser les etudiants à l’importance de la qualite du service (QoS) dans les reseaux informatique.\r\n"
                + "Comprendre les nouvelles applications reseau : applications multimedias, temps reel en s’appuyant sur la Voix sur IP.\r\n"
                + "Comprendre les technologies utilisees pour realiser l'infrastructure de transport de paquets au sein de l'Internet et les approches actuelles pour assurer des communications de haute performance dans les reseaux etendus.\r\n"
                + "Introduire l’etudiant aux reseaux de telephonie mobiles",new Competence[] {c11,c12,c13,c14});

        Competence c15 = new Competence(15,"Etudier les classes de problemes et les differents type de resolution de problemes",2);
        Competence c16 = new Competence(16,"Etudier les structures de donnees et de fichiers et analyser l’efficacite des algorithmes",2);
        Competence c17 = new Competence(17,"Mettre en oeuvre differents paradigmes de programmation",1);
        Competence c18 = new Competence(18,"Etudier les paradigmes de programmation et les transformations de programmes",2);

        Module moduleTPRO =new Module(" Theorie de la Programmation","Connaitre les methodes de resolution de problemes\r\n"
                + "Introduire les algorithmes de l’intelligence artificielle\r\n"
                + "Savoir evaluer et comparer les performances des solutions algorithmiques\r\n"
                + "Etudier les classes de complexite, la reduction des problemes et la NP-completude\r\n"
                + "Connaitre les fondements et les theories sur lesquels repose la programmation \r\n"
                + "Apprendre à raisonner sur les programmes \r\n"
                + "Avoir une vue d'ensemble des paradigmes de programmation",new Competence[] {c15,c16,c17,c18});

        Competence c19 = new Competence(19,"Analyser et documenter l'architecture d'un logiciel",1);
        Competence c20 = new Competence(20,"Mettre en œuvre des modeles de deploiement tels que les conteneurs ou le cloud pour les architectures complexes",1);
        Competence c21 = new Competence(21,"Proposer et mettre en oeuvre des architectures à base de services et de micro-services",1);
        Competence c22 = new Competence(22,"Proposer et mettre en oeuvre une architecture à partir de styles architecturaux existants",1);

        Module moduleAL =new Module("Architectures Logicielles","Souligner les importances des architectures et leur impact sur le produit final\r\n"
                + "Definir la notion d'architecture et les points de vue architecturaux\r\n"
                + "Identifier les enjeux des choix architecturaux\r\n"
                + "Identifier les principaux styles architecturaux\r\n"
                + "Concevoir une architecture a partir des attributs de qualite\r\n"
                + "Concevoir une architecture en se basant sur les styles architecturaux\r\n"
                + "Documenter une architecture\r\n"
                + "Evaluer les caracteristiques des solutions architecturales\r\n"
                + "Evaluer les enjeux des services techniques (persistance, transactions) dans les architectures",new Competence[] {c19,c20,c21,c22});

        Competence c23 = new Competence(23,"Decliner les activites d'un processus d'apprentissage automatique",2);
        Competence c24 = new Competence(24,"Utiliser et développer des techniques d'apprentissage automatique.",1);

        Module moduleML =new Module("Machine learning","L'apprentissage machine est un processus qui permet à la machine d'apprendre automatiquement//n"
                + " sans etre explicitement programmee. Plusieurs domaines necessitent l'application de l'apprentissage automatiques parmi eux: la bioinformatique,//n"
                + " le marketing, les finances, la detection d'intrusion, tout type de prevision, reconnaissances palmaires, ...).\r\n"
                + "Apprentissage supervisee",new Competence[] {c23,c24});

        Competence c25 = new Competence(25,"Adopter une posture entrepreneuriale.",2);
        Competence c26 = new Competence(26,"Exploiter des outils pour elaborer un projet d'entreprise",1);
        Competence c27 = new Competence(27,"Défendre un projet d'entreprise",4);

        Module moduleENTP =new Module("Entreprenariat et creation d’entreprise","Ce cours s'adresse aux etudiants, de toutes les specialites, //n"
                + "qui desirent eventuellement devenir entrepreneurs. Toutefois, les etudiants doivent vouloir comprendre ce qu'est le metier //n"
                + "d'entrepreneur, jauger une intuition novatrice pour en definir finalement un projet de creation d'entreprise concret.\r\n"
                + "Pour cela, il est necessaire de developper des savoirs, des savoir-faire et des savoir-etre de base relies à //n"
                + "l'entrepreneur",new Competence[] {c25,c26,c27});

        Competence c28 = new Competence(28,"Programmer avec le langage procedural SQL",1);
        Competence c29 = new Competence(29,"Analyser l'architecture d'un SGBD relationnel",1);
        Competence c30 = new Competence(30,"Concevoir et mettre en oeuvre des bases de donnees multi-dimensionnelles",1);
        Competence c31 = new Competence(31,"Concevoir et mettre en oeuvre des bases de donnees semi-structurees",1);
        Competence c32 = new Competence(32,"Concevoir et mettre en oeuvre des bases de donnees non structurees",1);

        Module moduleBDDA =new Module("SGBD et Bases de Donnees Avancees","Ce cours permet à l’etudiant :\r\n"
                + "Comprendre l’architecture des SGBD relationnels et les differentes fonctionnalites essentielles d’un SGBD\r\n"
                + "D’approfondir ses connaissances des bases de donnees et d’en acquerir de nouvelles sur d’autres types de donnees//n"
                + " et de traitements de ces donnees notamment le NoSQL et les données semi-structurées.\r\n"
                + "S'initier vers les nouvelles tendances dans le domaine des bases de donnees.\r\n"
                + "Maitriser la programmation avancee SQL",new Competence[] {c28,c29,c30,c31,c32});

        Competence c33 = new Competence(33,"Experimenter differentes methodes d'optimisation pour resoudre des problemes combinatoires",1);
        Competence c34 = new Competence(34,"Analyser des methodes de resolution des problemes d’optimisation combinatoire",2);

        Module moduleOPT =new Module("Optimisation Combinatoire","L’optimisation combinatoire joue un role fondamental en recherche//n"
                + " operationnelle, en mathematiques discrete et en informatique. Les domaines d’application de l’optimisation //n"
                + "combinatoire sont multiples et varies tels que, l’ingenierie,  la telecommunication, les transports ou les sciences //n"
                + "sociales. Bien que les problemes d’optimisation combinatoires soient faciles a formuler, ils sont en general difficiles //n"
                + "à resoudre. Cette difficulte est liee au temps d’execution necessaire à la resolution de ce probleme. En effet, le fait //n"
                + "qu’un algorithme arrive à atteindre sa fin d’execution n’est pas d’un grand interet sur le plan operationnel si son temps//n"
                + " d’execution est tres grand",new Competence[] {c33,c34});

        Competence c35 = new Competence(35,"Configurer un pare-feu pour mettre en oeuvre une politique de securite et de protection",1);
        Competence c36 = new Competence(36,"Identifier des protocoles de communication securisee en reponse à une politique de securite",4);
        Competence c37 = new Competence(37,"Exploiter des outils logiciels pour mettre en oeuvre des mecanismes de securite de donnees",1);
        Competence c38 = new Competence(38,"Identifier les mecanismes cryptographiques permettant d'assurer des services de securite requis",4);
        Competence c39 = new Competence(39,"Securiser un systeme informatique",4);
        Competence c40 = new Competence(40,"Analyser les menaces et les vulnerabilites d'un systeme",2);

        Module moduleSSR =new Module("Securite Systemes et Reseaux","Sensibiliser l’etudiant aux problemes de securite informatique en//n"
                + " general et sur la securite des reseaux informatique en particulier.\r\n"
                + "Comprendre les risques lies aux failles des systemes et les applications.\r\n"
                + "Comprendre la necessité de la protection dans les systemes.\r\n"
                + "Illustrer les differents types d’attaques dans un reseau informatique et les contre mesures.\r\n"
                + "Montrer l’importance de l’authentification et l’utilisation des mecanismes cryptographiques pour l’assurer.\r\n"
                + "Comprendre les architectures securisees d’un reseau informatique.\r\n"
                + "Sensibiliser les etudiants sur l’importance du filtrage et le controle d’acces.",new Competence[] {c35,c36,c37,c38,c39});

        Competence c41 = new Competence(41,"Differencier un systeme reparti d'un systeme centralise et analyser ses fonctions",2);
        Competence c42 = new Competence(42,"Concevoir des applications reparties et mobiliser des algorithmes et API pour les mettre en oeuvre",1);

        Module moduleSYSR =new Module("Systemes Repartis","Introduire les concepts de base des systemes repartis.\r\n"
                + "A l’issue de ce module l’etudiant doit comprendre les avantages que les systemes repartis procurent par rapport//n"
                + " aux systèmes centralises.\r\n"
                + "L’etudiant doit être capable de comprendre et concevoir des applications reparties (distribuees)",new Competence[] {c41,c42});

        Competence c43 = new Competence(43,"Exploiter un formalisme de redaction de specifications fonctionnelles et techniques",2);
        Competence c44 = new Competence(44,"Identifier un contexte, identifier une problematique, et determiner des objectifs",2);
        Competence c45 = new Competence(45,"Analyser un cahier de charge",1);
        Competence c46 = new Competence(46,"Mettre en oeuvre les tests unitaires et d'integration d'un logiciel",1);
        Competence c47 = new Competence(47,"Mettre en oeuvre les tests fonctionnels pour la qualite des logiciels",1);
        Competence c48 = new Competence(48,"Planifier un projet (Diagramme Gantt prevu et reel)",1);
        Competence c49 = new Competence(49,"Rédiger des livrables (resultats) intermediaires et livrable final de qualite",4);
        Competence c50 = new Competence(50,"Adopter une posture professionnelle (Assuiduite &(Assiduite et serieux)",4);
        Competence c51 = new Competence(51,"Concevoir un systeme implementant des fonctionnalites selon un cahier de charge",2);
        Competence c52 = new Competence(52,"Développer une solution informatique (IHM / Jeu d'essai/ tests/ degre d'integration/ documentation technique)",1);
        Competence c53 = new Competence(53,"Synthetiser les elements principaux/essentiels/importants dans une presentation",4);
        Competence c54 = new Competence(54,"Valoriser le produit realise durant une demonstration",4);

        Module modulePRJS =new Module("Projet de specialite","Le Projet de specialite est un projet complementaire au premier qui a pour objectif//n"
                + " d’integrer les connaissances accumulees du semestre 8.\r\n"
                + "Gerer un vrai projet de developpement avec une methode agile\r\n"
                + "Creer une application mobile / web\r\n"
                + "Integrer les outils de gestion de configuration.",new Competence[] {c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54});

        Competence c55 = new Competence(55,"Exploiter diverses API pour mettre en œuvre des programmes paralleles",1);
        Competence c56 = new Competence(56,"Analyser les types d'architectures paralleles et identifier les differents//n"
                + " niveaux de parallelisme dans les architectures",2);
        Competence c57 = new Competence(57,"Developper des programmes performants sur des architectures paralleles et avancees.\r\n"
                + "",1);

        Module moduleHPC =new Module("Calcul Intensif"," Identifier les differentes architectures du HPC (MultiCoeurs, Cluster, Grilles et GPU).\r\n"
                + "- Lister les differentes applications du HPC\r\n"
                + "- Optimiser les programmes pour tirer avantage des caracteristiques de l’architecture des processeurs.\r\n"
                + "- Concevoir, Implementer et analyser des programmes paralleles avec memoire partagée en utilisant OpenMP.\r\n"
                + "- Concevoir, Implementer et analyser des programmes paralleles avec memoire distribuée en utilisant MPI.\r\n"
                + "- Implementer des programmes paralleles sur les GPUs en utilisant CUDA.",new Competence[] {c55,c56,c57});


        Competence c58 = new Competence(58,"Rediger correctement (Synthese, clarte, lisibilite, soins de l'orthographe et grammaire)",4);
        Competence c59 = new Competence(59,"Repondre aux questions avec aisance et precision",4);

        Module moduleSPE =new Module("Stage Pratique en Entreprise","L’objectif attendu des stagiaires est de participer à l’etude et l’analyse d’un probleme reel issu du milieu professionnel et éventuellement proposer des scénarii d’amélioration.\r\n"
                + "Sous-objectifs sur le plan apprentissage\r\n"
                + "Mise en pratique des notions apprises\r\n"
                + "Developper l’esprit d’analyse\r\n"
                + "Developper l’esprit de synthèse\r\n"
                + "Sous-objectifs sur le plan du developpement personnel\r\n"
                + "Experience de la vie\r\n"
                + "Respect des consignes académiques et professionnelles",new Competence[] {c58,c59,c44,c53});

        Competence c60 = new Competence(60,"Concevoir des applications simples et les embarquer sur des circuits reconfigurables (FPGA)",1);
        Competence c61 = new Competence(61,"Concevoir, developper et utiliser : des logiciels embarqués, des applicatifs temps reel//n"
                + " et des systemes embarques en utilisant une methodologie unifiee",1);
        Competence c62 = new Competence(62,"Analyser les contraintes des systemes temps-reels et embarques",1);
        Competence c63 = new Competence(63,"Identifier et analyser les composants et couches d'un systeme embarque",1);

        Module moduleSYSE =new Module("Systemes Embarques","Les objectifs de ce cours sont de familiariser l’etudiant avec//n"
                + " les systemes temps-reels et embarques :\r\n"
                + "il doit etre familiarise avec les trois couches composant ce type de systemes: l’architecture, le systeme d’exploitation //n"
                + "et l’applicatif.\r\n"
                + "il doit etre confronte aux contraintes des systemes temps-reels et embarques qui sont tres differentes de celles des systemes//n"
                + " habituellement utilisés par les ingenieurs informaticiens.\r\n"
                + "il doit etre en mesure de concevoir, developper et utiliser : des logiciels embarques, des applicatifs temps reel et des systemes//n"
                + " embarques en utilisant une methodologie unifiee",new Competence[] {c60,c61,c62,c63});

        Competence c64 = new Competence(64,"Concevoir, developper et evaluer des interfaces homme-machine",1);
        Competence c65 = new Competence(65,"Analyser et modeliser la fonction d'interaction homme-machine",3);

        Module moduleIHM =new Module("Interface Homme Machine","Sensibilisation des etudiants a la place des IHMs au sein d’une application interactive\r\n"
                + "• Introduire les concepts de base de l’interaction Homme-Machine (IHM) et donner une vision\r\n"
                + "complete de tous les aspects lies à l’IHM notamment les sciences cognitives et l’ergonomie.\r\n"
                + "• Maitriser la conception centree utilisateurs des IHMs, de l’analyse, la conception, le prototypage\r\n"
                + "jusqu’a l’evaluation des IHMs.\r\n"
                + "• Acquerir les competences necessaires pour le developpement des IHMs.",new Competence[] {c64,c65});

        Competence c66 = new Competence(66,"Exploiter la theorie des processus stochastiques pour resoudre des problemes d'estimation, //n"
                + "d'optimisation et d'apprentissage statistique",2);

        Module moduleMSS =new Module("Modeles Stochastiques et Simulation","De nombreux problemes numeriques en science, ingenierie,//n"
                + " finance et statistiques sont resolus, de nos jours, grace aux methodes de Monte Carlo.\r\n"
                + "Les methodes MCMC ( Monte Carlo Markov chain) sont des methodes recentes de simulation basees sur les chaines //n"
                + "de Markov et utilisees en statistique et en science des donnees. Ces methodes servent à generer des v.a. selon //n"
                + "des lois de probabilites ou estimer des quantite aleatoires ( lorsque les methodes standards ne sont plus utilisables).\r\n"
                + "La theorie des processus stochastiques est essentielle pour l’analyse des algorithmes d’exploration stochastique d’espaces //n"
                + "de solutions complexes et qui servent à resoudre des problemes d’estimation, d’optimisation et d’apprentissage //n"
                + "statistique ( L’algorithme de Robbins-Monro, recuit simule, l' echantillonneur de Gibbs, L’algorithme //n"
                + "de simulation de Metropolis-Hastings,..).",new Competence[] {c66,c10});

        Competence c67 = new Competence(67,"Mettre en oeuvre les techniques et algorithme de traitement de signal",1);

        Module moduleTSG =new Module("Traitement de Signal","Ce module presente les bases de la theorie du traitement du signal. Il leur permettra//n"
                + " d'acquerir les notions necessaires à la maitrise des algorithmes et architectures de traitement du signal et de l'image.//n"
                + " Ces notions trouvent leurs applications dans des domaines aussi varies que les telecommunications, le multimedia,//n"
                + " la robotique etc",new Competence[] {c67});

        Competence c68 = new Competence(68,"Effectuer une analyse spaciale des donnees geographiques",2);
        Competence c69 = new Competence(69,"Mettre en oeuvre l’acquisition, l’organisation et le stockage des images spatiales,//n"
                + " satellitaires ou collectees sur le terrain",4);
        Competence c70 = new Competence(70,"Modeliser les donnees geo-spatiales en 2D et 3D pour l’aide a la decision",3);

        Module moduleSIG =new Module("Systemes d'Information Geographiques","D’eclaircir la notion de SIG, puis de fournir une methode d’analyse//n"
                + " spatiale des donnees cartographiques.\r\n"
                + "D’etudier l’acquisition, l’organisation puis le stockage dans des bases de donnees specifiques des images satellites ou collectees//n"
                + " sur le terrain.\r\n"
                + "Modeliser les donnees géo-spatiales ou tout simplement géographiques en 2D et 3D pour l’aide à la decision",new Competence[] {c68,c69,c70});


        Module moduleSIGA =new Module("Systemes d'Information Geographiques Avances","Eclaircir la notion de positionnement spatial,//n"
                + " puis fournir une methode d’analyse spatiale des donnees cartographiques.\r\n"
                + "Etudier l’acquisition, l’organisation puis le stockage dans des bases de donnees specifiques des images Spatiales,//n"
                + " satellitaires ou collectees sur le terrain.\r\n"
                + "Modeliser les donnees géo-spatiales ou tout simplement geographiques en 2D et 3D pour l’aide e la decision",new Competence[] {c68,c69,c70});

        Competence c71 = new Competence(71,"Mettre en oeuvre une methodologie agile dans le developpement logiciel",2);
        Competence c72 = new Competence(72,"Mettre en oeuvre les outils necessaires pour automatiser les taches repetitives du developpement //n"
                + "et faciliter le travail en equipe",2);

        Module moduleOGL =new Module("Outils de Genie Logiciel","Acquerir à l’aide des outils, des competences dans l’utilisation des bonnes //n"
                + "pratiques du genie logiciel.\r\n"
                + "Utiliser des outils pour ameliorer la qualite d’un logiciel.\r\n"
                + "Maitriser les outils necessaires pour automatiser les taches repetitives du developpement et faciliter le travail//n"
                + " en equipe",new Competence[] {c46,c71,c72});

        Competence c73 = new Competence(73,"Analyser les risques dans un processus de developpement logiciel",2);
        Competence c74 = new Competence(74,"Estimer le cout et l'effort du developpement logiciel en s'appuyant sur une methodologie",2);

        Module moduleQL =new Module("Qualite Logicielle","Assurer la qualite logiciel se traduit par un ensemble d’activites à realiser//n"
                + " tout au long du cycle de vie de developpement d’un logiciel, et cela sur le plan organisationnel et le plan//n"
                + " developpement",new Competence[] {c46,c47,c73,c74});

        Competence c75 = new Competence(75,"Exploiter des feuilles de style et des langages de balisage et de script pour developper //n"
                + "des sites web hergonomiques et repondants aux besoins",1);
        Competence c76 = new Competence(76,"Exploiter des langages et bases de donnees pour developper des sites web dynamiques",1);

        Module moduleTDW =new Module("Techniques de Developpement Web","Apprendre les langages de base du developpement web HTML5, CSS3 et JavaScript,//n"
                + " JQuery, PHP7 et Python.\r\n"
                + "Preparer l’etudiant a developper des applications front-end et back-end.\r\n"
                + "Gerer un projet web de bout en bout",new Competence[] {c75,c76});

        Competence c77 = new Competence(77,"Concevoir et implementer une application mobile manipulant des donnees",1);
        Competence c78 = new Competence(78,"Concevoir et implementer une application mobile interactive et multimedias",1);
        Competence c79 = new Competence(79,"Exploiter un langage de programmation pour le developpement d'une application mobile",4);
        Competence c80 = new Competence(80,"Analyser un systeme d'exploitation mobile et son environnement de developpement",1);

        Module moduleTDM =new Module("Techniques de Developpement Mobile","Introduire les systemes d’exploitation mobiles et faire la difference avec les systemes d’architecture classiques\r\n"
                + "Presenter le systeme Android et son environnement de developpement\r\n"
                + "Introduire le langage de programmation Kotlin\r\n"
                + "Developper une interface mobile en utilisant les ressources et les dispositions\r\n"
                + "Concevoir et implementer une application mobile manipulant des fichiers\r\n"
                + "Concevoir et implementer une application mobile manipulant des donnees stockees sur une base de donnees locale\r\n"
                + "Concevoir et implementer une application mobile connectee à un backend\r\n"
                + "Concevoir et implementer une application mobile manipulant des elements multimedia (audio, video)\r\n"
                + "Concevoir et implementer une application mobile emettant des notifications\r\n"
                + "Concevoir et implementer une application mobile avec des services en arriere-plan\r\n"
                + "Concevoir et implementer une application mobile interagissant avec d’autres applications mobiles à travers//n"
                + " les fournisseurs de contenu ou les recepteurs d’evenements",new Competence[] {c77,c78,c79,c80});


        Module moduleTDM1 =new Module(" Techniques de Developpement Mobile 1","Introduire les systèmes d’exploitation mobiles et faire la difference//n"
                + " avec les systemes d’architecture classiques\r" +
                "\n"
                + "Presenter le systeme Android et son environnement de developpement\r\n"
                + "Introduire le langage de programmation Kotlin\r\n"
                + "Developper une interface mobile en utilisant les ressources et les dispositions",new Competence[] {c79,c80});

        Module moduleTDM2 =new Module(" Techniques de Developpement Mobile 2","Concevoir et implementer une application mobile manipulant des fichiers\r\n"
                + "Concevoir et implementer une application mobile manipulant des donnees stockees sur une base de donnees locale\r\n"
                + "Concevoir et implementer une application mobile connectee a un backend\r\n"
                + "Concevoir et implementer une application mobile manipulant des elements multimedia (audio, video)\r\n"
                + "Concevoir et implementer une application mobile emettant des notifications\r\n"
                + "Concevoir et implementer une application mobile avec des services en arriere-plan\r\n"
                + "Concevoir et implementer une application mobile interagissant avec d’autres applications mobiles a travers les fournisseurs //n"
                + "de contenu ou les recepteurs d’evenements",new Competence[] {c77,c78});

        Competence c81 = new Competence(81,"Lister les concepts fondamentaux de la realite virtuelle et la realite augmentee",2);
        Competence c82 = new Competence(82,"Decrire le fonctionnement des dispositifs d’entree et de sortie utilises dans les applications //n"
                + "de realite virtuelle et realite augmentee",2);
        Competence c83 = new Competence(83,"Expliquer les techniques graphiques utilisees dans les applications de realite virtuelle et réalite augmentee",2);
        Competence c84 = new Competence(84,"Developper des environnements virtuels et des techniques d'interaction 3D",1);

        Module moduleRV =new Module("Realite Virtuelle","A la fin du module, les etudiants demontreront les competences suivantes:\r\n"
                + "Lister les concepts fondamentaux de la realite virtuelle et la realite augmentee\r\n"
                + "Decrire le fonctionnement des dispositifs d’entree et de sortie utilises dans les applications de realite virtuelle et realite augmentee\r\n"
                + "Expliquer les techniques graphiques utilisees dans les applications de realite virtuelle et realite augmentee\r\n"
                + "Developper des environnements virtuels 3D\r\n"
                + "Developper des techniques d’interaction 3D\r\n"
                + "Developper des applications de realite virtuelle avec immersion\r\n"
                + "Developper des applications avec realite augmentee",new Competence[] {c81,c82,c83,c84});

        Competence c85 = new Competence(85,"Analyser la fonction de virtualisation des systemes",1);
        Competence c86 = new Competence(86,"Exploiter des plateformes de virtualisation",1);
        Competence c87 = new Competence(87,"Exploiter des plateformes de Cloud computing",1);

        Module moduleVCL =new Module("Virtualisation et Cloud","L'objectif principal de ce cours est de donner aux etudiants les bases//"
                + " de la virtualisation, veritable changement technologique des systemes d'exploitation modernes. De plus, la virtualisation//"
                + " est a la base d'une autre revolution technologique plus large, le Cloud computing, qui sera etudiee en tant que service //"
                + "novateur dans les infrastructures informatiques modernes.\r\n"
                + "L'objectif secondaire est l'utilisation des plateformes de virtualisation phares telles que Vmware, HyperV et Kvm, //"
                + "ainsi que les plateformes Cloud telles que Amazon et Openstack",new Competence[] {c85,c86,c87});
        Competence c133 = new Competence(88,"Analyser les techniques de traitement d'images et de reconnaissance de formes",2);
        Competence c134 = new Competence(89,"Experimeter des techniques de traitement d'images et de reconnaissance de formes sur des problemes concrets",1);

        Module moduleIMN =new Module("Images Numeriques","Ce cours nous permet d’acquerir les bases essentielles de traitement //n"
                + "et d’analyse des images numeriques et de la reconnaissance des formes. Des exemples concrets seront mis en œuvre//n"
                + " a travers des TP et de mini-projets.",new Competence[] {c133,c134});

        NiveauDEtude niveau2csSIQ =new NiveauDEtude("2Cs_SIQ",new Module[] {moduleANAD,moduleCOM,moduleFAS,moduleRESA,moduleTPRO,moduleAL,moduleML,moduleENTP,moduleBDDA,moduleOPT,moduleSSR,moduleSYSR,modulePRJS,moduleHPC,moduleSPE,moduleSYSE,moduleIHM,moduleMSS,moduleTSG,moduleSIG,moduleSIGA,moduleOGL,moduleQL,moduleTDW,moduleTDM,moduleTDM1,moduleTDM2,moduleRV,moduleVCL});

        Module moduleFASI =new Module("File d'attente et Simulations","Etudier les differents modeles de files d'attente et calculer les parametres de performance//n"
                + "Apprendre les techniques de simulation",new Competence[] {c9,c10});

        Module moduleIPLS =new Module(" Ingenierie des protocoles et logiciels securises","Analyser les failles de securite d’une architecture logicielle //n"
                + "et des protocoles de communication.\r\n"
                + "Introduire la securite dans le cycle de vie de l’ingenierie logicielle\r\n"
                + "Concevoir et mettre en œuvre des applications informatiques securisees//n"
                + " dans divers domaines (Web, Commerce electronique)",new Competence[] {c40,c39,c37,c36});

        Competence c88 = new Competence(90,"Adopter une posture de leader et sponsor d'un projet",4);
        Competence c89 = new Competence(91,"Mettre en oeuvre un plan de conduite de changement",2);
        Competence c90 = new Competence(92,"Mettre en oeuvre un plan de communication",1);
        Competence c91 = new Competence(93,"Analyser, concevoir et realiser une formation pour des adultes",2);
        Competence c92 = new Competence(94,"Resoudre les conflits",4);

        Module moduleMPSI =new Module("Management du changement dans les projets de systemes d'information","L’echec de la mise en oeuvre des systemes //n"
                + "d’information est souvent dû à des causes humaines et organisationnelles et non pas techniques. La mise en oeuvre d’un SI //n"
                + "doit etre accompagnee d’une demarche de conduite de changement afin d’attenuer les resistances humaines et augmenter les chances //n"
                + "de reussite du nouveau SI.\r\n"
                + "Une demarche de conduite de changement inclut une politique de communication interne et externe, une formation des futurs utilisateurs //n"
                + "du SI, un appui de la direction sponsor du nouveau projet.",new Competence[] {c88,c89,c90,c91,c92});

        Competence c93 = new Competence(95,"Definir une politique de securite",4);
        Competence c94 = new Competence(96,"Exploiter des outils d'analyse de risques de secuirte informatique",1);
        Competence c95 = new Competence(97,"Organiser la securite d'un système d'information au sein de l'entreprise",3);
        Competence c96 = new Competence(98,"Analyser les menaces et les vulnerabilités d'un systeme",2);

        Module moduleMSSI =new Module("Ingenierie et management de la securite des systemes d'information","Permettre aux etudiants de maitriser//n"
                + " les concepts lies à l’ingénierie et au management de la securite des systemes d’information et de participer à la mise en place //n"
                + "pertinente d’une politique de securite au sein de l’entreprise.",new Competence[] {c93,c94,c95,c96});

        Competence c97 = new Competence(99,"Analyser l'integration de systemes d'information de gestion",2);
        Competence c98 = new Competence(100,"Identifier et modeliser des processus metiers",3);
        Competence c99 = new Competence(101,"Elaborer des solutions d’integration à travers les technologies d’ERP et d’EAI",1);
        Competence c100 = new Competence(102,"Mettre en relief les benefices et les freins qui peuvent se presenter à l'integration des systemes d'information de gestion",4);

        Module modulePGI =new Module("Progiciels de gestion intsssssegree","Faire assimiler les concepts lies à l’integration des systemes d’Information de gestion.\r\n"
                + "Maitriser la modelisation de processus metiers (identification, modelisation)\r\n"
                + "Detailler les solutions d’integration a travers les technologies d’ERP et d’EAI et saisir les benefices attendus et toutes les questions liees//n"
                + " a leur mise en place",new Competence[] {c97,c98,c99,c100});

        Competence c101 = new Competence(103,"Traduire un algorithme dans un langage de programmation et le commenter",1);

        Module modulePYT =new Module("Langage de programmation Python","Developper des applications avec Python",new Competence[] {c101});

        Competence c102 = new Competence(104,"Analyser les modeles sous-jacents aux systemes d'information d'aide à la decision",3);
        Competence c103 = new Competence(105,"Exploiter les methodes et outils d'aide à la decision",3);

        Module moduleSIAD =new Module("Systeme d'information d'aide à la decision: methodes et outils","Etude approfondie des concepts et modeles//n"
                + " sous-jacents aux systemes d'information d’aide à la decision. Un accent particulier sera mis sur le developpement de methodes //n"
                + "pour la conception de SIAD.\r\n"
                + "Etude approfondie des principaux outils d’aide à la decision dont les Tableaux de Bords, SIAD, Entrepots de donnees,//n"
                + " Datamining.",new Competence[] {c102,c103});

        Competence c104 = new Competence(106,"Mettre en oeuvre, deployer et utiliser des systemes d'information cooperatifs en entreprise",1);
        Competence c105 = new Competence(107,"Analyser le travail cooperatif et identifier les TIC contribuant à l'avantage cooperatif",4);

        Module moduleSIC =new Module("Systemes d'information cooperatifs","Le travail cooperatif, fait l'objet d'un champ d'etude pluridisciplinaire //n"
                + "appele CSCW (Computer Supported Cooperative Work). Cette discipline etudie les mecanismes individuels et collectifs du travail//n"
                + " de groupe et recherche comment les technologies de l'information et de la communication peuvent faciliter //n"
                + "ce travail",new Competence[] {c104,c105});

        Competence c106 = new Competence(108,"Enumerer les principaux impacts des TIC/ numerique sur les organisations",4);
        Competence c107 = new Competence(109,"Utiliser une demarche d'analyse strategique appliquee aux TIC",2);
        Competence c108 = new Competence(110,"Enumerer et comparer les principaux scenario de structuration des TIC dans une organisation",4);
        Competence c109 = new Competence(111,"Decrire les principaux indicateurs du tableau de bord du DSI",1);
        Competence c110 = new Competence(112,"Rattacher les referentiels de ITGovernance aux differentes activites de la DSI",2);

        Module moduleTICO =new Module("Technologies de l'information et de la communication en organisation","De nos jours,//n"
                + " presque aucune entreprise ou organisation ne se passe de l’aide de l’informatique, des T.I.C//n"
                + " (Technologies de l'information et de la communication) voire du numerique de façon generale. Ils jouent ainsi un role //n"
                + "primordial comme support a leur bonne gestion. Ils sont devenus progressivement un facteur d'innovation et de transformation//n"
                + " des organisations. La bonne gouvernance des TIC par les DSI prend toute son importance",new Competence[] {c106,c107,c108,c109,c110});

        Competence c111 = new Competence(113,"Mettre en oeuvre un projet d'urbanisation d'un systeme d'information",2);
        Competence c112 = new Competence(114,"Identifier et modeliser des processus metiers",3);
        Competence c113 = new Competence(115,"Analyser un systeme d'information selon une demarche systemique",2);

        Module moduleURSI =new Module("Urbanisation des systemes d'information","Acquerir les connaissances \"de base\" relatives à l'urbanisation //n"
                + "des systemes d'information\r\n"
                + "Acquerir des connaissances plus approfondies dans le domaine de la conduite et le management de projets d'urbanisation//n"
                + " des systemes d'information\r\n"
                + "Prendre en charge la definition et la mise en place d'une solution globale permettant d'integrer les contraintes //n"
                + "et les evolutions technologiques tout en prenant en compte les systemes d'information existants et l'emergence de nouvelles//n"
                + " technologies aptes a degager de la valeur pour l'organisation concernee",new Competence[] {c106,c111,c112,c113});

        Competence c114 = new Competence(116,"Effectuer une analyse de l'existant et/ou une etude bibliographique",2);
        Competence c115 = new Competence(117,"Mettre en oeuvre les techniques de collecte des besoins",4);
        Competence c116 = new Competence(118,"Analyser et articuler les types de faisabilites",1);
        Competence c117 = new Competence(119,"Planifier des plans de secours afin de prendre en charge les risques entourant un projet",2);

        Module modulePRJST =new Module("Projet de specialite","Permettre aux etudiants de travailler en equipe projet autour d’une problematique Systeme d’information et une complexite donnee.\r\n"
                + "Objectifs sur le plan enseignement\r\n"
                + "Comprehension globale du SI\r\n"
                + "Differentiation standard/specifique\r\n"
                + "Integration des notions de ROI\r\n"
                + "Objectifs sur le plan de la conduite de projet\r\n"
                + "Experience du cycle de vie de projet\r\n"
                + "Exercice des roles : //nmaitre d’ouvrage / maitre d’oeuvre (client/ //n"
                + "fournisseur)",new Competence[] {c114,c115,c116,c117,c43,c44,c45,c46,c47,c48,c49,c50,c53,c54});

        Competence c118 = new Competence(120,"Decrire l’apport de la normalisation, la certification et l’accreditation pour l'entreprises",3);
        Competence c119 = new Competence(121,"Decrire une demarche qualite et identifier ses atouts pour l'entreprise",3);
        Competence c120 = new Competence(122,"Adopter une demarche qualite et utiliser ses principaux outils",2);

        Module moduleAQUA =new Module(" Assurance qualite","Apprehender l'intéret de la demarche \"qualite \" dans le domaine des sciences//n"
                + " et technologies, pour avoir soi-meme confiance et inspirer confiance dans les actions engagees et les decisions prises//n"
                + " pour l'analyse, la conception, la production et l’evaluation de processus et projets, particulierement dans le contexte //n"
                + "des processus IT et/ou projetsIT).",new Competence[] {c118,c119,c120});


        Competence c121 = new Competence(123,"Elaborer un plan directeur informatique",2);

        Module moduleASI =new Module("Analyse des Systemes d'Information","Montrer l’importance d’Initier, preciser et prioriser les projets des systemes//n"
                + " d'information dans le cadre d’une demarche de planification de systeme d’information\r\n"
                + "Etude approfondie des premieres etapes de tout projet systeme d’information que sont l’initialisation et l’analyse.\r\n"
                + "Analyser et articuler les types faisabilites afin de réussir le lancement du projet systeme//n"
                + " d’information Communiquer efficacement avec les diverses parties prenantes de l'organisation pour recueillir//n"
                + " des informations en utilisant une variete de techniques.",new Competence[] {c116,c121,c115,c114,c44,c45});

        Competence c122 = new Competence(124,"Analyser la fonction d'audit et decrire une demarche d'audit d'un systeme d'information",2);
        Competence c123 = new Competence(125,"Exploiter les outils et referentiels d'audit et porter un jugement objectif sur un systeme d'information",1);

        Module moduleAUSI =new Module("Audit de systemes d'information","Ce cours donne les notions de base sur l’audit et la demarche generale//n"
                + " d’audit plus particulierement l’'audit des systemes d'information tant dans sa dimension strategique, tactique qu'operationnelle.\r\n"
                + "Le cours porte autant sur les missions d'audit interne que d'audit externe à travers ses differentes phases.\r\n"
                + "L'enjeu est d’ameliorer la capacite d'evaluation d'un systeme d'information en totalite ou en partie. Il vise à presenter les referentiels//n"
                + " de base utilises par les auditeurs avec un accent particulier sur COBIT et ITIL. ",new Competence[] {c122,c123});

        Module moduleBDA =new Module("Bases de donnees avancees","Ce cours permet à l’etudiant d’approfondir ses connaissances des bases de données//n"
                + " et d’en acquerir de nouvelles sur d’autres types de donnees et de traitements de ces donnees notamment le decisionnel //n"
                + "et les donnees semi-structurees. ",new Competence[] {c28,c30,c31,c32});

        Competence c124 = new Competence(126,"Utiliser et developper des methodes d'apprentissage automatique pour l'analyse de big data",1);
        Competence c125 = new Competence(127,"Caracteriser un systeme de grandes masses de donnees et decrire son environnement de developpement",2);
        Competence c126 = new Competence(128,"Decliner les activites d'un processus d'analyse de grandes masses de donnees (generation, acquisition, analyse,..)",2);
        Competence c127 = new Competence(129,"Mobiliser des outils et technologies pour le developpement de projets de big data analytique",1);

        Module moduleBDM =new Module("Big data mining","Se familiariser avec le big data et son environnement de developpement.\r\n"
                + "Se familiariser avec le processus d'analyse des big data (generation, acquisition, analyse,..\r\n"
                + "L'utilisation et le developpement de methodes liees à l'apprentissage automatique pour l'analyse des big data.\r\n"
                + "Extraire de l'information pertinente efficacement de ces donnees en un temps raisonnable;\r\n"
                + "Develloper des projets Big data analytique avec toute la technologie associee sur de grand datasets.",new Competence[] {c124,c125,c126,c127});

        Competence c128 = new Competence(130,"Concevoir et mettre en oeuvre des systemes d'aide à la decision",1);

        Module moduleBI =new Module("Business Intelligence","Ce cours permet à l’etudiant d’acquerir de nouvelles connaissances sur les systemes //n"
                + "decisionnels.\r\n"
                + "A l’issue du cours, l’etudiant sera en mesure de :\r\n"
                + "Assimiler la notion de Business Intelligence et son architecture\r\n"
                + "Comprendre les requetes analytiques OLAP\r\n"
                + "Se familiariser avec les outils d’analyse, de Reporting et ETL\r\n"
                + "Developper des projets BI",new Competence[] {c128,c30});


        NiveauDEtude niveau2csSIT =new NiveauDEtude("2Cs_SIT",new Module[] {moduleFASI,moduleIPLS,moduleMPSI,moduleMSSI,modulePGI,modulePYT,moduleSIAD,moduleSIC,moduleTICO,moduleURSI,modulePRJST,moduleENTP,moduleSIG,moduleANAD,moduleAL,moduleTDM,moduleIHM,moduleSPE,moduleTDW,moduleAQUA,moduleASI,moduleAUSI,moduleBDA,moduleBDM,moduleBI});

        Competence c129 = new Competence(131,"Appliquer une methodologie pendant le cycle de developpement logiciel",2);

        Module moduleMA =new Module("Methodes Agiles","Les objectifs de ce module sont de :\r\n"
                + "Presenter les principes generaux agiles bases sur le manifeste agile\r\n"
                + "Introduire les principales methodes existantes :\r\n"
                + "eXtreme Programming\r\n"
                + "Scrum\r\n"
                + "Kanban\r\n"
                + "Discuter des principales pratiques agiles et leur application a savoir :\r\n"
                + "Pratiques d’organisation\r\n"
                + "Pratiques de collaboration\r\n"
                + "Pratiques de livraison\r\n"
                + "Pratiques de planification\r\n"
                + "Pratiques de developpement",new Competence[] {c129,c71,c72});

        Competence c130 = new Competence(132,"Proposer une conception orientee objet pour un probleme metier",2);
        Competence c131 = new Competence(133,"Appliquer et mettre en oeuvre les patrons de conception",2);

        Module modulePDC =new Module("Patrons de conception","Le but de ce module est d’introduire les patrons de conception ainsi que de lister les patrons//n"
                + " les plus connus de la litterature. Il s’agit aussi d’appliquer ces patrons dans des contextes reels afin de resoudre des problemes//n"
                + " particuliers.",new Competence[] {c128,c30,c130,c131});

        Competence c132 = new Competence(134,"Exploiter un framework pour developper efficacement un site web dynamique, hergonomique et securise",1);

        Module modulePDJ =new Module("Python et Developpement Web Full Stack avec Django","Objectifs: \r\n"
                + "Developper des site web dynamiques, hergonomiques et securises.\r\n"
                + "\r\n"
                + "Contenu: \r\n"
                + "Langage de programmation Python\r\n"
                + "Elements syntaxiques du langage Python\r\n"
                + "Instructions de controle, structures de donnees natives, listes et dictionnaires\r\n"
                + "Le modele Oriente Objet dans Python\r\n"
                + "Framework Django\r\n"
                + "Implementation du modele MVC dans Django \r\n"
                + "Implementation d'une base de donnees dans le Modele Django\r\n"
                + "Le backend d''administration\r\n"
                + "Vues, Templates et Routage d'URL\r\n"
                + "Les vues generiques: CreateView, UpdateView, DeleteView, ListView\r\n"
                + "Les formulaires\r\n"
                + "Les filtres\r\n"
                + "Le modele de securite dans Django : authentification, et gestion des permissions\r\n"
                + "Envoie de Mail\r\n"
                + "Le middleware messaging et interaction\r\n"
                + "Packages utiles : tables2, select2, crispy, DateTimePicker, tablib\r\n"
                + "Framework Bootstrap\r\n"
                + "Le modele de grille\r\n"
                + "Elements de base\r\n"
                + "Composants integres\r\n"
                + "Travaux Pratiques\r\n"
                + "Ecriture d'algorithmes en langage Python\r\n"
                + "Developpement d'un site web dynamique, hergonomique et securise avec Python Django / Bootstrap",new Competence[] {c75,c76,c132});



        NiveauDEtude niveau2csSIL =new NiveauDEtude("2Cs_SIL",new Module[] {moduleANAD,moduleCOM,moduleIHM,moduleAL,moduleIPLS,moduleSIGA,moduleTPRO,moduleOGL,moduleQL,modulePRJS,moduleBDDA,moduleBDM,moduleHPC,moduleMA,moduleML,modulePDC,modulePDJ,moduleSPE,moduleTDM1,moduleTDM2,moduleTDW});

        Module moduleCRP =new Module("Complexite et Resolution de Probleme","Maitriser les aspects theoriques et pratiques lies a la complexite //n"
                + "et la resolution de problemes.\r\n"
                + "Introduire le domaine de l’intelligence artificielle",new Competence[] {c15,c16,c34});

        Competence c135 = new Competence(135,"Apprehender les enjeux des donnees gouvernementales ouvertes pour renforcer l’intelligence gouvernementale",2);
        Competence c136 = new Competence(136,"Analyser le potentiel du Crowdsourcing/Crowfunding pour une plus grande participation citoyenne",3);

        Module moduleSGOV =new Module("Smart Government","Expliquer les enjeux de la transformation digitale dans les organisations de façon generale.\r\n"
                + "Analyser les meilleures pratiques liees au developpement de projets e-governement dans divers OP.\r\n"
                + "Aligner les des systemes d’information de type e-governement aux politiques publiques.\r\n"
                + "Apprehender les enjeux du mouvement (Open Government) et les donnees gouvernementales ouvertes(OGD) pour renforcer l’intelligence gouvernementale.\r\n"
                + "Analyser le potentiel du Crowdsourcing/Crowfunding pour une plus grande participation citoyenne.",new Competence[] {c135,c136,c106,c108});



        NiveauDEtude niveau2csSID =new NiveauDEtude("2Cs_SID",new Module[] {moduleANAD,moduleBDDA,moduleBI,moduleCRP,moduleIMN,moduleML,moduleRV,moduleSGOV,moduleSPE,moduleTSG});


        //------------------------------cycle prepa tranc commun----------------------------------------------



        Competence a1=new Competence(137,"Analyser une fonction reelle a une variable reelle",1);
        Module moduleANA1=new Module("Analyse mathematique 1","Le theme central est le concept de fonction reelle a une variable reelle. Le programme est organise autour de trois objectifs :\r\n"
                + "Consolidation des acquis du calcul differentiel et integral vus au secondaire.\r\n"
                + "Etude du comportement asymptotique.\r\n"
                + "Introduction de nouvelles techniques d’integration.",new Competence[] {a1});

        Competence a2=new Competence(138,"Identifier et analyser des structures algebriques",1);
        Competence a3=new Competence(139,"Analyser un polynome à une indeterminee a coefficients dans un anneau",1);
        Module moduleALG1=new Module("Algebre 1","Consolider les acquis du secondaire concernant l’algebre generale.\r\n"
                + "Acquerir les techniques de decomposition des fractions rationnelles.\r\n"
                + "Exploiter les resultats obtenus pour l’etude des structures lineaires dans les unites algebre2 et analyse2.",new Competence[] {a2,a3});
        //alg1
        Competence a4=new Competence(140,"Construire une analyse à partir de l’enonce d’un probleme",2);
        Competence a5=new Competence(141,"Deboguer un programme et verifier un algorithme",1);
        Competence a6=new Competence(142,"Proposer un decoupage modulaire en procedures et/ou fonctions et le justifier",1);
        Competence a7=new Competence(143,"Identifier les structures algorithmiques statiques adequate pour construire un algorithme a partir de l’analyse d’un probleme",2);
        Competence a9=new Competence(144,"programmation en pascal(vous pouvez ajouter une fiche descriptive pour montrer la valorisation de cette competence a travers des TPs)",1);
        Competence a34=new Competence(145,"Confectionner un dossier technique de programmation\r\n"
                + "",2);
        Module moduleALSDS=new Module("Algorithmique et Structures de Donnees Statiques","Acquisition d’une demarche methodologique axee//n"
                + " sur la modularite permettant la conception et la realisation d’un petit logiciel utilisant des objets elementaires//n"
                + " et des donnees structurees statiques (tableaux a une et a deux dimensions, chaines de caracteres, ensembles, //n"
                + "enregistrements)",new Competence[] {a4,a5,a6,a7,c101,a9,a34});
        //ALSDS
        Competence a10=new Competence(146,"Ecrire les nombres dans differentes representations et effectuer des calculs selon une algebre",1);
        Competence a11=new Competence(147,"Exploiter les methodes de synthese de systemes logiques combinatoires et sequentiels",2);
        Competence a12=new Competence(148,"Concevoir des circuits combinatoires et sequentiels",1);
        Competence a13=new Competence(149,"Analyser les composants d'un ordinateur et leurs fonctions",4);
        Module moduleARCHI1=new Module("Architectures des ordinateurs 1","Vulgariser l’ensemble des concepts de base d’un ordinateur ;\r\n"
                + "Connaitre la representation des nombres ;\r\n"
                + "Connaitre les principaux composants d’un ordinateur ;\r\n"
                + "Connaitre les methodes de synthese de systemes logiques combinatoires et sequentiels ;\r\n"
                + "Acquerir une connaissance de bas niveau de la programmation.",new Competence[] {a10,a11,a12,a13});
        //ARCHI1
        Competence a14=new Competence(150,"Ecouter et inferer le sens d'un discours en anglais",1);
        Competence a15=new Competence(151,"Ecrire en anglais dans un style academique",2);
        Competence a16=new Competence(152,"Acquerir le vocabulaire de l`anglais specifique à l`informatique",3);
        Competence a17=new Competence(153,"S'exprimer correctement, en considerant le niveau de maitrise de la langue",3);
        Module moduleANG1=new Module("Anglais 1","This is an ESP (English for Specific Purposes) course aimed at the improvement of the students’ language skills in the context of computing and information technology.",new Competence[] {a14,a15,a16,a17});
        //ANGLAIS1
        Competence a18=new Competence(154,"Utiliser efficacement les outils de la bureautiquebureautiques (Word, Powerpoint, Excel,..",3);
        Competence a19=new Competence(155,"Utiliser efficacement les outils de recherche d’information pertinente (collecte, tri) devant l’heterogeneite des sources documentaire",1);
        Competence a20=new Competence(156,"Effectuer une communication par e-mail et gerer efficacement sa messagerie.",3);
        Module moduleBWEB=new Module("Bureautique et Web"," \r\n"
                + "L’etudiant doit etre capable de :\r\n"
                + "utiliser efficacement les outils de la bureautique (Word, Powerpoint, Excel,..)\r\n"
                + "maitriser les specificites de la communication par e-mail, gerer efficacement sa messagerie.\r\n"
                + "utiliser efficacement les outils de recherche d’information pertinente (collecte, tri) devant l’heterogeneite des sources sur documentaires (livres, revues, internet, ..)",new Competence[] {a18,a19,a20});
        //BEWEB
        Module moduleTEE=new Module("Technique d'expression ecrite","Les objectifs recherches :\r\n"
                + "une maitriser des fondamentaux de la communication ecrite\r\n"
                + "l’acquisition de methodes et outils facilitant la realisation de ses ecrits.\r\n"
                + "L’amelioration de la qualite redactionnelle de divers types de documents",new Competence[] {c58});
        //TEE
        //a60 commun archi2 sys1
        Competence a60=new Competence(157,"Analyser les mecanismes de base permettant a un ordinateur de communiquer (entrees/sorties,(entrees/sorties, interruptions)",1);
        Competence a22=new Competence(158,"Analyser les fonctions d'un systemes d'exploitation",1);
        Competence a23=new Competence(159,"Exploiter les fonctions de gestion de la memoire virtuelle et de stockage dans un systeme multi-programme",1);
        Module moduleSYST1=new Module("Instroduction au Systeme d'exploitation 1","Initier les etudiants a la pratique du systeme Unix.\r\n"
                + "A la fin du cours l’étudiant doit etre capable de travailler dans un environnement Unix (au niveau utilisateur) et installer un systeme Unix (Linux)",new Competence[] {a60,a22,a23});
        //SYST1
        Competence a24=new Competence(160,"Determiner le courant et la tension dans un circuit electrique comprenant des sources de tension continue, des condensateurs et des resistances,",1);
        Competence a25=new Competence(161,"Determiner le courant et la tension dans un circuit en regime alternatif",1);
        Competence a26=new Competence(162,"Determiner les caracteristiques d’un circuit par la representation quadripolaire",2);
        Competence a27=new Competence(163,"Realiser une analyse et un trace du diagramme Bode",4);
        Module moduleELECT=new Module("Electricite","L’objectif de cet enseignement est l’introduction des notions de bases liees à l’electricite permettant d’aborder les cours d’electronique.\r\n"
                + "A l’issue de ce cours, l’etudiant sera capable de :\r\n"
                + "determiner le courant et la tension dans un circuit electrique comprenant des sources de tension continue, des condensateurs et des resistances,\r\n"
                + "determiner le courant et la tension dans un circuit en regime alternatif,\r\n"
                + "savoir appliquer les lois et les theoremes fondamentaux de l’electricite,\r\n"
                + "determiner les caracteristiques d’un circuit par la representation quadripolaire.\r\n"
                + "Savoir realiser une analyse et un trace du diagramme Bode.",new Competence[] {a24,a25,a26,a27});
        //ELECT
        Competence a28=new Competence(164,"Exploiter l'algebre lineaire et calcul matriciel dans la modelisation et resolution de problemes",1);
        Module moduleALG2=new Module("Algebre 2","Le programme est organise autour de deux objectifs :\r\n"
                + "Etude des concepts fondamentaux relatifs aux espaces vectoriels de dimension finie telles que base, dimension, rang, et apprendre à l’etudiant le procede de l’echelonnement qui lui sera tres utile par la suite.\r\n"
                + "Apprendre l’algebre lineaire et assimiler les bases du calcul matriciel afin d’acquerir des connaissances suffisantes pour aborder l’UEF12",new Competence[] {a28});
        //ALG2
        Competence a52=new Competence(165,"Developper en series entieres des fonctions usuelles de l’analyse dans le but de mettre en oeuvre des algorithmes d’approximation des nombres",1);
        Competence a29=new Competence(166,"Utiliser des methodes de resolution des EDO",1);//commun alg3 ana2
        Module moduleANA2=new Module("Analyse 2","Etudier les concepts elementaires relatifs aux suites numeriques et suites de fonctions, en vue de fournir un cadre coherent pour l’etude des series numeriques.\r\n"
                + "Etablir les criteres de convergence des series et definir les modes usuels de convergence des series de fonctions et les exploiter afin d’etudier la conservation de la continuite et la derivabilite et l’integration par passage a la limite.\r\n"
                + "Determiner les developpements en series entieres des fonctions usuelles de l’analyse dans le but de mettre en oeuvre des algorithmes d’approximation des nombres.\r\n"
                + "-Donner des methodes de resolution des EDO en vue de les utiliser dans les autres disciplines.",new Competence[] {a52,a29});
        //ANA2
        //Competence a7 pas a30=new Competence("Identifier les structures algorithmiques statiques et dynamiques adéquate pour construire un algorithme à partir de l’analyse d’un problème",2);
        //Competence a5 pas a31=new Competence("Déboguer un programme et vérifier un algorithme",1);
        //Competence a6 pas a32=new Competence("Proposer un découpage modulaire en procédures et/ou fonctions et le justifier",false);
        //Competence a8 pas a33=new Competence("Traduire un algorithme dans un langage de programmation et le commenter",1);
        //a34

        Module moduleALSDD=new Module("Algorithmique et Structure de donnees dynamique"," \r\n"
                + "Ce module aborde les aspects fondamentaux de la science informatique. Parmi les objectifs, nous pouvons citer :\r\n"
                + "- Maitriser les structures de donnees de base\r\n"
                + "- Savoir appliquer et implementer les structures de donnees de base\r\n"
                + "- Introduire les structures de donnees avancees\r\n"
                + "- Concevoir des algorithmes efficaces\r\n"
                + "- Analyser et mesurer la complexite des algorithmes",new Competence[] {a7,a5,a6,c101,a34,c16});
        //ALSDD
        Competence a35=new Competence(167,"Interpreter le principe de la conduction dans les semi-conducteurs et dans les jonctions PN",1);
        Competence a36=new Competence(168,"Identifier les caracteristiques de fonctionnements des composants electroniques (diodes, transistors bipolaires, transistors a effet de champ)",4);
        Competence a37=new Competence(169,"Utiliser des composants electroniques dans des applications concretes : redressement, ecretages, stabilisations, amplifications, commutations, portes logiques.",1);
        Module moduleELECF1=new Module("Electronique fondamentale 1","Le principal objectif de ce cours est l’etude du fonctionnement des composants electroniques tels que les diodes, les transistors bipolaires et les transistors a effet de champ ainsi que leurs applications.",new Competence[] {a35,a36,a37});
        //ELCF1
        Competence a38=new Competence(170,"Analyser l'execution d'un programme en langage machine sur une architecture de Von Neumann\r\n"
                + "",1);
        Competence a39=new Competence(171,"Ecrire des programmes en langage assembleur",1);
        //a22 commun entre sys1 et SYS2
        Module moduleSYST2=new Module("Introduction aux systemes d'exploitation 2"," \r\n"
                + "Permettre la comprehension :\r\n"
                + "du fonctionnement de la machine ;\r\n"
                + "l’execution des programmes en langage machine ;\r\n"
                + "A la fin de ce module, l’etudiant est capable d’ecrire des programmes en langage machine.",new Competence[] {a38,a39,a22});
        //SYS2
        Competence a40=new Competence(172,"Enumerer les hypotheses de la mecanique classique",4);
        Competence a41=new Competence(173,"Identifier un objet assimilable à un point materiel",4);
        Competence a42=new Competence(174,"Formaliser le mouvement d'un point materiel dans differents systemes de coordonnees",3);
        Competence a43=new Competence(175,"Calculer les vitesses et accelerations d'un mobile pour une trajectoire quelconque",1);
        Competence a44=new Competence(176,"Formaliser des actions exterieures s'exerçant sur un point materiel",3);
        Competence a45=new Competence(177,"Ecrire et resoudre des equations de la dynamique regissant le mouvement d'un point materiel",1);
        Module moduleMECA=new Module("Mecanique du point"," \r\n"
                + "L'objectif principal de ce cours est d'introduire aux methodes d'etude et de modelisation des phenomenes physiques en vue d’analyses et de conceptions basees notamment sur la simulation par ordinateur.",new Competence[] {a40,a41,a42,a43,a44,a45});
        //MECA
        Competence a46=new Competence(178,"Adapter la force de la voix, le regard et la posture dans une communication",1);
        Competence a47=new Competence(179,"Effectuer une communication orale de qualite (prononciation, articulation, volume, debit, intonation, posture, aisance, presence)",3);
        Competence a48=new Competence(180,"Adapter la communication à l'auditoire",3);
        Competence a49=new Competence(181,"Gerer le stress",3);
        Competence a50=new Competence(182,"Effectuer une communication verbale et non-verbale",2);
        Module moduleTEO=new Module("Techniques d'expression orale"," \r\n"
                + "Developper son aisance relationnelle en toutes circonstances.\r\n"
                + "Gagner en efficacite dans sa fonction par une meilleure communication.\r\n"
                + "Mettre la communication au service de son action.",new Competence[] {a46,a47,a48,a49,a50});
        //TEO
        NiveauDEtude niveau1Cpi=new NiveauDEtude("1CPI",new Module[] {moduleANA1,moduleALG1,moduleALSDS,moduleTEE,moduleTEO,moduleMECA,moduleELECT,moduleELECF1,moduleSYST1,moduleARCHI1,moduleANG1,moduleALSDD,moduleSYST2,moduleBWEB,moduleALG2,moduleANA2});
        //1CPI

        //Competence a 29 et a28 pas a51=new Competence("Exploiter l'algèbre linéaire et calcul matriciel dans la modélisation et résolution de problèmes",1);commun alg3 alg2
        Module moduleALG3=new Module("Algebre 3"," \r\n"
                + "L’objectif principal est d’introduire le concept de determinant dans son cadre naturel qui est l’algebre multilineaire. Cet outil permet de resoudre certains problemes tels que la reduction des endomorphismes et la resolution des systemes lineaires.",new Competence[] {a28,a29});
        //ALG3
        //a52
        Competence a53=new Competence(183,"Analyser des topologies de IR² et IR³",1);
        Module moduleANA3=new Module("Analyse 3","Etablir les criteres de convergence des series et definir les modes usuels de convergence des series de fonctions et les exploiter afin d’etudier la conservation de la continuite et la derivabilite et l’integration par passage a la limite.\r\n"
                + "Determiner les developpements en series entieres des fonctions usuelles de l’analyse dans le but de mettre en oeuvre des algorithmes d’approximation des nombres.\r\n"
                + "Decouvrir quelques concepts topologiques de IR2 et IR3.\r\n"
                + "Etendre les notions de limite, continuite et differentiabilite des fonctions de IRm dans IR et les generaliser a des fonctions de IRm vers IRn.",new Competence[] {a52,a53});
        //ANA3
        Competence a54=new Competence(184,"Concevoir des structures de fichiers efficaces et repondant aux besoins de tout type d'applications, y compris le cas des donnees volumineuses et massives.",3);
        Competence a55=new Competence(185,"Identifier les differents types d’organisation des fichiers et effectuer un choix d'organisation repondant aux besoins des applications",2);
        //a56
        Competence a57=new Competence(186,"Differencier les technologies de stockage",3);
        Module moduleSFSD=new Module("Structure Fichiers et Structures de Donnees"," \r\n"
                + "Cette matiere aborde les aspects fondamentaux de la science informatique. Elle fait suite au module ALSDD dans tous ses aspects. Elle traite de l’organisation interne des donnees fournissant a l’etudiant des bases solides le rendant capable de concevoir des structures de fichiers adaptables aux nouveaux besoins des applications",new Competence[] {a54,a55,c16,a57});
        //SFSD
        //a13 COMMUN ARCHI1 et ARCHI2 Competence a58=new Competence("Analyser les composants d'un ordinateur et leurs fonctions",false);
        Competence a59=new Competence(187,"Concevoir des circuits a base de composants memoires, dans le but de resoudre des problemes particuliers de stockage, et de recuperation de l’information",1);
        //a60
        //Competence a38 pas a61=new Competence("Analyser l'exécution d'un programme en langage machine sur une architecture de Von Neumann",false);
        Competence a62=new Competence(188,"Analyser le fonctionnement de l'unite de controle",1);
        Module moduleARCHI2=new Module("Architecture des ordinateurs 2"," \r\n"
                + "A l’issue de ce cours, l’etudiant doit etre capable de concevoir un calculateur elementaire.\r\n"
                + "Il doit en particulier :\r\n"
                + "connaitre le role de chaque composant dans le chemin de donnees d’un calculateur.\r\n"
                + "maitriser le cheminement de l’information dans les circuits de base et connaitre le fonctionnement de l’unite de controle (sequenceur).\r\n"
                + "comprendre les mécanismes de base permettant a un calculateur de communiquer (entrees/sorties et systemes d’interruption).",new Competence[] {a13,a59,a60,a38,a62});
        //ARCHI2
        //Competence a16 pas a63=new Competence("Acquérir le vocabulaire de l`anglais spécifique à l`informatique",false);
        //Competence a15 pas a64=new Competence("Ecrire en anglais dans un style académique",false);
        //Competence a14 pas a65=new Competence("Ecouter et inférer le sens d'un discours en anglais",false);
        //Competence a17 a66=new Competence("S’exprimer correctement, en considérant le niveau de maitrise de la langue",false);
        Module moduleANG2=new Module("Anglais 2"," \r\n"
                + "The objective of this UE is:\r\n"
                + "\r\n"
                + "Develop a variety of language skills.\r\n"
                + "Acquire a specific computing knowledge.\r\n"
                + "Develop and widen students’ terminology in computing and information technology.\r\n"
                + "Concentrate on grammatical constructions which are typical of technical English",new Competence[] {a14,a15,a16,a17});
        //ANGLAIS2
        Competence a67=new Competence(189,"Identifier le rôle de l'entreprise dans l'économie d'une nation",3);
        Competence a68=new Competence(190,"Analyser les missions et responsabilites de chacune des grandes fonctions (operationnelles et de soutien) de l’entreprise",3);
        Module moduleECON=new Module("Economie","L’etudiant doit etre capable de comprendre le role de l’entreprise dans l’activite economique d’une nation et l’aborder comme un systeme ouvert.\r\n"
                + "L’etudiant doit aussi etre capable d’analyser les missions et responsabilites de chacune des grandes fonctions (operationnelles et de soutien) de l’entreprise.",new Competence[] {a67,a68});
        //ECON
        Competence a69=new Competence(191,"Effectuer une description statistique sur une masse de donnees",3);
        Competence a70=new Competence(192,"Modeliser un phénomène aleatoire avec une loi de probabilite",3);
        Module modulePRST1=new Module("Probabilites et statistiques 1"," \r\n"
                + "Dans la partie(1) de ce Module, on presentera les donnees sous une forme brute, en les reduisant a quelques resumes graphiques et parametres caracteristiques.\r\n"
                + "Dans la partie (2), et apres les rappels d’analyse combinatoires, on introduit les principes generaux du calcul des probabilites, en montrant les possibilites d’utilisation de l’algebre des ensembles, les differentes lois de probabilites usuelles sont ensuite etudiees et leurs conditions d’applications examinees.",new Competence[] {a69,a70});
        //PRST1
        Competence a71=new Competence(193,"Concevoir et analyser un circuit de production de signaux analogiques et numeriques",3);
        Competence a72=new Competence(194,"Concevoir et analyser des circuits d'acquisition de donnees",3);
        Module moduleELECF2=new Module("Electronique fondamentale 2","Le but de ce cours est de familiariser les etudiants avec les fonctions electroniques a base de circuits integres. Il traite des fonctions analogiques et numeriques pour les communications ainsi que pour le traitement du signal continu et discret. Il s’articule autour des notions suivantes : amplification, generations des signaux analogiques et numeriques, conversion A/N et NA et la modulation.",new Competence[] {a71,a72});
        //ELECF2
        Competence a73=new Competence(195,"Resoudre des equations à derivees partielles",1);
        Competence a74=new Competence(196,"Analyser la geometrie des courbes et des surfaces",1);
        Competence a75=new Competence(197,"Exploiter les resultats des fonctions a plusieurs variables pour traiter certains problemes d’optimisation sans ou avec contraintes",1);
        Module moduleANA4=new Module("Analyse 4"," \r\n"
                + "L’objectif de cette UE est :\r\n"
                + "Exploiter les resultats des fonctions a plusieurs variables pour traiter certains problemes d’optimisation sans ou avec contraintes.\r\n"
                + "Definir l’integrale de Riemann en dimensions 2 et 3.\r\n"
                + "Apprendre a resoudre des equations differentielles en appliquant la transformee de Laplace.\r\n"
                + "Apprendre a calculer la transformee de Fourier ainsi que la transformee de Fourier inverse d'une fonction dans le but de resoudre certaines equations //n"
                + "differentielles et eventuellement des equations integrales.",new Competence[] {a73,a74,a75});
        //ANA4
        Competence a76=new Competence(198,"Concevoir et programmer une application avec un langage oriente objet",1);

        Competence a78=new Competence(199,"Developper des interfaces graphiques avec un langage de programmation orientee objet",1);
        Module modulePOO=new Module("Programmation Orientee Objet","Introduire les concepts de base de la programmation objet. Les notions de classes,//"
                + " objets/instances, envoi de messages doivent etre assimilees, ainsi que la decomposition d'un probleme en ces termes",new Competence[] {a76,c130,a78});
        //POO
        Competence a79=new Competence(200,"Analyser des ondes electromagnetiques",1);
        Competence a80=new Competence(201,"Analyser la propagation de rayons lumineux",1);
        Module moduleOOE=new Module("Optique et Ondes electromagnetiques","Etude d'Optique et des Ondes electromagnetiques",new Competence[] {a79,a80});
        //OOE
        Competence a81=new Competence(202,"Analyser l'esperance et la convergence d'un phenomene aleatoire",1);
        Competence a82=new Competence(203,"Interroger une population et estimer les resultats d'un sondage a partir d'un echantillon",1);
        Module modulePRST2=new Module("Probabilites et Statistiques 2","La partie A permettra a l’etudiant de bien s’armer pour aborder d’autres notions et themes des probabilites et statistiques plus approfondies.\r\n"
                + "La partie(B) introduit à la statistique inductive qui grace à l’assimilation des observations experimentales aux lois theoriques et l’application des tests, fournit des elements de decision.",new Competence[] {a81,a82});
        //PRST2
        Competence a83=new Competence(204,"Exploiter une logique propositionnelle pour formaliser l'enonce d'un probleme",3);
        Competence a84=new Competence(205,"Utiliser la theorie des modeles ou de lra demonstration pour montrer la satisfiabilite de l'enonce d'un probleme",3);
        Module moduleLOGM=new Module("Logique Mathematique"," \r\n"
                + "A l’issue du cours, l’etudiant doit savoir faire la difference entre syntaxe et semantique, savoir formaliser l’enonce d’un probleme et savoir utiliser la theorie des modeles ou la theorie de la demonstration pour montrer la satisfiabilite (non satisfiabilite) de cet enonce. L’etudiant doit egalement maitriser les proprietes de consistance et de completude d’un systeme logique.",new Competence[] {a83,a84});
        //LOGM
        Competence a87=new Competence(206,"Adopter une posture professionnelle (Assiduite et serieux)",3);
        Competence a88=new Competence(207,"S'organiser et travailler en equipe en vue de realiser un projet commun",2);
        Competence a89=new Competence(208,"Synthetiser les elements principaux/essentiels/importants dans une presentation",3);
        //Competence a50 pas a90=new Competence("Effectuer une communication orale de qualité (prononciation, articulation, volume, débit, intonation, posture, aisance, présence)",false);
        Module modulePRJP=new Module("Projet Pluridisciplinaire"," \r\n"
                + "Le projet se deroule durant le second semestre de la deuxieme annee. Il consiste en la conception et la realisation d’un projet en informatique qui se deroule dans les memes conditions que celles d’une entreprise. Il est decrit à travers un cahier des charges precis il peut porter sur des themes tres varies. Il est propose par un ou plusieurs enseignants qui jouent le role de «client» et il doit couvrir au moins deux disciplines. Il est encadre par un enseignant qui peut etre en meme temps le «client».\r\n"
                + "Le groupe de projet, compose de 4 etudiants au minimum et de 6 au maximum, selon la taille du projet et sous la responsabilite d’un chef de projet nomme parmi les membres du groupe, doit se comporter comme une veritable equipe. Outre le contenu technique, qui consistera en l’application des connaissances acquises pour la mise en oeuvre du cycle de developpement d’un petit logiciel , l’accent sera mis sur l’acquisition et l’application des aspects organisationnels et relationnels entre les membres du groupe , de l’encadreur et du «client» :\r\n"
                + "analyse et decoupage du travail,\r\n"
                + "repartition des charges de travail entre les membres du groupe par le chef de projet,\r\n"
                + "circulation de l’information entre les membres du groupe,\r\n"
                + "mise en place d’un planning de travail,\r\n"
                + "expose hebdomadaire de l’avancement du projet,\r\n"
                + "delivrance des livrables fixes dans la fiche de projet,\r\n"
                + "redaction d’un rapport final\r\n"
                + "et exposedu travail réalise.",new Competence[] {a50,c48,c49,a87,a89});
        //PRJP
        Competence a91=new Competence(209,"Analyser et codifier une information",2);
        Competence a92=new Competence(210,"Discerner les types de systèmes et identifier leurs fonctions",3);
        Competence a93=new Competence(211,"Discerner les types de systemes d'information et identifier leur role dans l'organisation",1);
        Module moduleSINF=new Module("Introduction aux systemes d'information"," \r\n"
                + "L’etudiant doit etre capable de comprendre le concept de systeme afin de mieux l’utiliser en modelisation des situations complexes\r\n"
                + "L’etudiant doit etre capable de percevoir le role fondamental de l’information ainsi que les principaux outils d’analyse pour une meilleure qualite de l’information.\r\n"
                + "Il doit percevoir l’importance des systemes d’information de l’entreprise , Une economie de service, une economie de l’information voire creation de la valeur.",new Competence[] {a91,a92,a93});
        //SINF
        Competence a94=new Competence(212,"Acquerir le vocabulaire de l`anglais specifique à l`informatique",3                    );
        //Competence a15 pas a95=new Competence("Ecrire en anglais dans un style académique",false);
        //Competence a14 pas a96=new Competence("Ecouter et inférer le sens d'un discours en anglais",false);
        //Competence a17 pas a97=new Competence("S’exprimer correctement, en considérant le niveau de maitrise de la langue",false);
        Module moduleANG3=new Module("Anglais 3","Move to more sophisticated and complex issues concerning computer technology.\r\n"
                + "Develop and widen students’ terminology in computing and information technology.\r\n"
                + "Understand and discuss basic ideas about security on the Net.\r\n"
                + "Making predictions.\r\n"
                + "Improve their Letter-writing skills.",new Competence[] {a94,a14,a15,a17});
        //ANGLAIS3
        NiveauDEtude niveau2Cpi=new NiveauDEtude("2CPI",new Module[] {moduleSFSD,moduleARCHI2,moduleANA3,moduleALG3,moduleELECF2,modulePRST1,modulePRST2,modulePOO,modulePRJP,moduleOOE,moduleSINF,moduleLOGM,moduleECON,moduleANG3,moduleANA4});
        //2CPI


        //Competence a16 pas a98=new Competence("Acquérir le vocabulaire de l`anglais spécifique à l`informatique",false);
        Competence a99=new Competence(213,"Organiser et participer avec succes à un entretien d`embauche",3);
        Competence a100=new Competence(214,"Rediger efficacement en anglais : Courriels, CV, articles scientifiques, etc.",3);
        //Competence a17 pas a101=new Competence("S’exprimer correctement, en considérant le niveau de maitrise de la langue",false);
        Module moduleLANG1=new Module("Langue anglaise 1","Le module d’Anglais destine aux classes des 1CS est conçu en tenant compte des contextes et situations lies à l`informatique et fournira aux etudiants les connaissances, les competences et les capacites afin de maitriser un anglais operationnel au niveau requis, et qui permettra aux etudiants de mieux s’exprimer dans cette langue. Les approches pedagogiques les plus recentes, telles que l’approche communicative et l’approche actionnelle, focalisent sur les competences à acquerir dans tout apprentissage des langues (en l’occurrence les productions et comprehension orales et ecrites).",new Competence[] {a16,a99,a100,a17});
        //lang1
        Competence a102=new Competence(215,"Exploiter les methodes numeriques pour modeliser des systemes complexes lineaires non lineaires",3);
        Competence a103=new Competence(216,"Programmer des methodes numeriques pour modeliser des systemes complexes",1);
        Module moduleANUM=new Module("Analyse Numerique","L'analyse numerique est l'etude des methodes permettant d'evaluer numeriquement des nombres, des fonctions .... C’est un outil essentiel pour l'ingenieur. La modelisation de la majorite des situations reelles (le classement des pages web, le traitement d’images, l’optimisation de formes, le transfert de la chaleur, les écoulements …) conduit à des problèmes dont la résolution mathématique exacte  est impossible vu leur complexité numérique. On est donc conduit à chercher des solutions approchées par des algorithmes numériques que l'on programme sur ordinateur.",new Competence[] {a102,a103});
        //ANUM
        //Competence a76 pas  a105=new Competence("Concevoir et programmer une application avec un langage orienté objet",false);

        Competence a107=new Competence(217,"Modeliser une conception orientee objet en utilisant le diagramme de classes UML.",2);

        Module moduleIGL=new Module("Introduction au génie logiciel"," \r\n"
                + "Les objectifs de ce module sont de :\r\n"
                + "Sensibiliser à l’importance du déroulement des activites de developpement de maniere methodologique\r\n"
                + "Decouverte des methodologies de developpement (classiques et agiles) et les differentes activites de developpement\r\n"
                + "Utiliser la methodologie UP comme cadre permettant de presenter en detail les activites d’expression de besoin, d’analyse, de conception et de tests\r\n"
                + "Utiliser UML pour la modelisation a travers les differentes activites de developpement\r\n"
                + "Initier aux bonnes et mauvaises pratiques de conception\r\n"
                + "Initier a la formalisation des activites de tests a travers les cas de test",new Competence[] {c43,c130,a107,c22,c21,c129,c47});
        //IGL
        Competence a112=new Competence(218,"Analyser le fonctionnement d'un processus metier.",2);
        Competence a113=new Competence(219,"Analyser les organisations et fonctions de l'entreprise.",2);
        Module moduleORGA=new Module("Analyse des organisations","A travers ce cours, nous nous donnons pour objectifs :\r\n"
                + "d’elargir le champ de connaissances des etudiants par la theorie des organisations vues en tant que systemes socio-techniques et de là, toute la dynamique qui les régit.\r\n"
                + "d’etudier l’influence de la decision dans les organisations\r\n"
                + "de developper chez l'etudiant des habiletes d'analyse et d'intervention au sein d'organisations et la comprehension de grandes fonctions de l’entreprise.\r\n"
                + "A l’issue de ce cours, les etudiants seront capables :\r\n"
                + "d’analyser et de comprendre les grands courants de pensee en organisation\r\n"
                + "de prendre du recul par rapport a une vision unique et simpliste de la complexite de la vie en entreprise et en organisation et aiguiser leur regard critique.\r\n"
                + "de comprendre le fonctionnement d’un processus metier",new Competence[] {a112,a113});
        //ORGA
        Competence a114=new Competence(220,"Mettre en oeuvre et configurer un reseau local",1);
        Competence a115=new Competence(221,"Analyser les fonctions d'un reseau local",1);
        Module moduleRES1=new Module("Reseaux 1"," \r\n"
                + "A l’issue de ce cours, l’etudiant aura acquis les connaissances de base à la comprehension des reseaux locaux : leurs technologies, leurs architectures, les protocoles y afferents.\r\n"
                + "Il saura definir une architecture de reseau local avec un plan d’adressage IP.",new Competence[] {a114,a115});
        //RES1
        Competence a116=new Competence(222,"Exploiter la programmation lineaire pour modeliser et chercher une solution a un probleme",3);
        Competence a117=new Competence(223,"Exploiter la theorie des graphes pour modeliser un systeme de systemes complexe",3);
        Module moduleRO=new Module("Recherche Operationnelle: graphes et algorithmes","La premiere partie de ce cours se propose de rendre compte des trois composantes qui s’entremelent en theorie des graphes : Resolution des problemes, mathematiques discretes et algorithmiques. La deuxieme partie de ce cours s’interesse a la programmation lineaire qui est un des domaines les plus utilises de la RO. Elle permet de traiter un vaste ensemble de problemes d’optimisation dans des contextes divers comme la gestion de stocks, flux de transport, distribution de taches a des personnels, recherche de plans de fabrication etc. . . La modelisation de ces problemes debouche sur des equations ou inequations lineaires (exprimant les differentes contraintes) dont on cherche les solutions permettant d’optimiser une fonction economique elle-meme lineaire.",new Competence[] {a116,a117});
        //RO
        Competence a118=new Competence(224,"Exploiter les fonctions d'un systeme d'exploitation multi-tâches par la programmation",1);
        Competence a119=new Competence(225,"Analyser les fonctions d'un systemes d'exploitation",1);
        Competence a120=new Competence(226,"Analyser les mecanismes de base permettant a un ordinateur de communiquer (entrees/sorties,(entrees/sorties, interruptions).",1);
        Module moduleSYS1=new Module("Systemes d'exploitation 1","L'objectif de ce cours est de permettre aux etudiants de comprendre les concepts de base des systemes d'exploitation centralises, leur structure et leur fonctionnement et de maitriser leur utilisation grace aux travaux pratiques.",new Competence[] {a118,a119,a120});
        //SYS1
        Module moduleTHP=new Module("Theorie des langages de programmation et applications","Ce cours presente les fondements des langages//n"
                + " de programmation et developpe les phases d’analyse lexicale et syntaxique d’un compilateur. Les etudiants sauront, //n"
                + "a l’issue du semestre, realiser un analyseur lexical et un analyseur syntaxique.",new Competence[] {c7,c8});
        //THP
        //Competence a17 pas a123=new Competence("S’exprimer correctement, en considérant le niveau de maitrise de la langue",false);
        //Competence a100 pas a124=new Competence("Rédiger efficacement en anglais : Courriels, CV, articles scientifiques, etc",false);
        //Competence a16 pas a125=new Competence("Acquérir le vocabulaire de l`anglais spécifique à l`informatique",false);
        Module moduleLANG2=new Module("Langue anglaise 2","- Communications ecrites et orales portant sur des themes du domaine de l’informatique a delivrer sous forme d’exposés.\r\n"
                + "- Confection d’un cours (d’anglais) portant sur un aspect de la grammaire anglaise a delivrer",new Competence[] {a16,a17,a100});
        //LANG2
        Competence a130=new Competence(227,"Determiner les types de mecanismes d’accelerations permettant d’ameliorer les performances des programmes",3);
        Competence a131=new Competence(228,"Evaluer l'impact des choix d’architectures generales et specialisees sur l'execution d'un programme",3);
        Module moduleARCH=new Module("Architecture"," \r\n"
                + "Ce cours permet a l’etudiant de comprendre la relation entre la performance et la structure des differents composants //n"
                + "fonctionnels d’un processeur. A l’issue de ce cours, l’etudiant comprendra comment l’architecture d’un processeur affecte la //n"
                + "performance des programmes executes sur la machine. Le cours presente les techniques proposees pour ameliorer la performance //n"
                + "d’un processeur en realisant souvent des compromis sur la structure des differents composants tels que la frequence d’horloge//n"
                + " du CPU, la taille memoire, la mémoire cache, etc. Les techniques presentees sont: la hierarchie memoire, le pipeline,//n"
                + " les architectures RISC, superscalaires, multicores et paralleles.",new Competence[] {c55,c56,c57,a130,a131});
        //ARCH
        Competence a132=new Competence(229,"Traduire un modele entite/association vers un schema relationnel, le normaliser et le manipuler avec l'algebre relationnelle",3);
        Competence a133=new Competence(230,"Utiliser SQL pour definir et manipuler des donnees relationnelles",1);
        Competence a134=new Competence(231,"Concevoir une Base de Donnees relationnelle",3);
        Module moduleBDD=new Module("Bases de donnees"," \r\n"
                + "Le cours de bases de donnees permet l’introduction du domaine de la conception et de la manipulation des donnees ainsi que l’utilisation des technologies relatives au domaine. A l’issue du cours, l’etudiant sera en mesure de :\r\n"
                + "- concevoir une base de donnees partant d'une realite donnee avec le modele entite/association et le diagramme de classes d’UML ;\r\n"
                + "- traduire un modele entite/association vers un schema relationnel, le normaliser et le manipuler avec l'algebre relationnelle ;\r\n"
                + "- creer la base de donnees correspondante au schema relationnel, manipuler la structure de la base avec le DDL et interroger des donnees avec le DML.",new Competence[] {a132,a133,a134});
        //BDD
        Competence a136=new Competence(232,"Exploiter un outil de gestion de projet afin de quantifier les ressources en temps, materiels, moyens humains et en financement",1);
        //Competence a85 pas a137=new Competence("Planifier un projet (Diagramme Gantt prévu et réel)",false);
        Module moduleCPROJ=new Module("Conduite de projets"," \r\n"
                + "Quel que soit le secteur d’activite, les activites à effectuer sont, de plus en plus souvent, organisees en projets. Afin de maitriser efficacement ces projets, les entreprises font evoluer leur organisation en adoptant le mode projet, ou le metier de Chef de Projet (Project Manager) devient essentiel.\r\n"
                + "L’objectif de ce module est de permettre aux etudiants d’acquerir une vision globale de tout projet (cycle de vie, demarche, FCS, techniques&outils logiciels support). Les exemples porteront particulierement sur les projets informatiques ou TIC.\r\n"
                + "A l'issue des TD/TP, l'etudiant aura acquis les compétences lui permettant:\r\n"
                + "- d'utiliser efficacement un outil de gestion de projet sur des cas pratiques afin de quantifier les ressources en temps, materiels, moyens humains et en financements necessaires au bon deroulement d’un projet. \r\n"
                + "- d'assimiler via des cas pratiques (mises en situation), l'importance de la reunion en mode projet ainsi que l'introduction de la culture analyse des risques tres tot dans le projet",new Competence[] {c48,c117,a136});
        //CPROJ
        Competence a138=new Competence(233,"Concevoir un systeme d'information en considerant les objectifs metiers selon une methodologie",3);
        Module moduleMCSI=new Module("Methodologies d'analyse et conception de systemes d'information","L’objectif de ce cours est de //n"
                + "fournir les bases methodologiques necessaires à l’analyse et la conception de systemes d'information d'entreprise.//n"
                + " Ce cours presente une methode systemique en cascade (MERISE 2, SADT, ,..). A l’issue de ce cours, l’étudiant//n"
                + " maitrisera les outils necessaires a l’analyse d’un systeme.",new Competence[] {a138,c113,c114});
        //MCSI
        //Competence a89 pas a142=new Competence("Synthétiser les éléments principaux/essentiels/importants dans une présentation",false);
        //Competence a135 pas a144=new Competence("Planifier des plans de secours afin de prendre en charge les risques entourant un projet",false);
        //Competence a136 a145=new Competence("Exploiter un outil de gestion de projet afin de quantifier les ressources en temps, matériels, moyens humains et en financement",false);
        //Competence a86 a146=new Competence("Rédiger des livrables (résultats) intermédiaires et livrable final de qualité",false);
        Module modulePROJ=new Module("Projet"," \r\n"
                + "Le projet est proposé à un groupe de 6 étudiants. Il est encadré par deux enseignants internes. Il a pour objectifs d'allier différentes disciplines pour apporter des solutions à un problème concret et d’aider l’étudiant à mieux comprendre l’intérêt pratique de certains modules.",new Competence[] {c54,a89,c51,c117,a136,c49});
        //PROJET 1CS
        Competence a147=new Competence(234,"Identifier et analyser les protocoles et architecture d'Internet",3);
        Competence a148=new Competence(235,"Configurer et administrer un reseau informatique",4);
        Module moduleRES2=new Module("Reseaux 2"," \r\n"
                + "Ce cours vise a faire connaître le reseau mondial Internet et les technologies associees. L’etudiant apprendra a configurer, a concevoir et a analyser l’architecture d’un reseau informatique. Le cours attache un interet particulier a la couche transport et a certains protocoles de la couche application, le DNS et HTTP notamment.",new Competence[] {a147,a148});
        //RES2
        Module moduleSEC=new Module("Introduction a la securite informatique"," \r\n"
                + "Sensibiliser l’etudiant aux problemes de securite informatique.\r\n"
                + "Presenter les aspects fondamentaux de la securite informatique.\r\n"
                + "Savoir realiser des analyses de risque.\r\n"
                + "Comprendre le role et les limites de la cryptographie dans la protection de l’information\r\n"
                + "Familiariser l’etudiant avec les aspects de la cryptographie.\r\n"
                + "Decouvrir le fonctionnement des primitives cryptographiques\r\n"
                + "Apprendre a les utiliser correctement et raisonner sur la securite (garantir un ou plusieurs services de la securite.)\r\n"
                + "Savoir utiliser quelques outils cryptographiques pour realiser un service de securite.\r\n"
                + "Identifier et corriger les failles possibles aussi bien au niveau utilisation d’un systeme d’exploitation qu’au niveau construction d’un logiciel.",new Competence[] {c37,c38,c39,c40});
        //SEC
        Competence a153=new Competence(236,"Exploiter les fonctions de gestion de la memoire virtuelle et de stockage dans un systeme multiprogramme.multiprogramme.",1);
        Competence a154=new Competence(237,"Analyser les fonctions d'un systemes d'exploitation",1);
        Module moduleSYS2=new Module("Système d'exploitation 2","L'objectif de ce cours est de permettre aux etudiants de comprendre les concepts de base des systemes d'exploitation centralises, leur structure et leur fonctionnement et de maitriser leur utilisation grace aux travaux pratiques.",new Competence[] {a153,a154});
        //SYS2
        NiveauDEtude niveau1Cs=new NiveauDEtude("1CS",new Module[] {moduleSYS1,moduleRES1,moduleANUM,moduleRO,moduleORGA,moduleIGL,moduleTHP,moduleLANG1,moduleARCH,moduleSYS2,moduleRES2,moduleMCSI,moduleBDD,moduleSEC,moduleCPROJ,modulePROJ,moduleLANG2});
        //1CS


        //---------------------------------------------master et pfe-----------------------------------------------

        Competence c137=new Competence(238,"Realiser et presenter un bilan qualitatif selon des criteres de : cout, securité, performances, fiabilite, satisfaction usager, deploiement",1);
        Competence c138=new Competence(239,"Respecter de la charte de redaction du memoire ( couverture, nombre de pages, plan, references bibliographiques,,,,,)",2);
        Competence c139=new Competence(240,"Equilibrer les chapitres du rapport",2);
        Competence c140=new Competence(241,"Presenter un sujet et la problematique et formuler les objectifs et hypotheses",2);
        Competence c141=new Competence(242,"Utliser une methodologie et/ou des techniques dans les regles de l'art",3);
        Competence c142=new Competence(243,"Synthetiser et effectuer une analyse critique, et adopter une rigueur dans l'argumentation (etude quantitative)",2);
        Competence c143=new Competence(244,"Respecter le temps alloue ( par diapo, global) et clarte de la presentation  (lisiblite, enchaînements, illustration, ... )",3);

        Module modulePFE=new Module("Elaboration du Memoire d'Ingenieur","Le projet a pour double objectif suivant :\r\n"
                + "Immerger l’etudiant dans un environnement socio-economique et le familiariser avec les contraintes et les exigences de l’entreprise à travers le stage ;\r\n"
                + "Donner à l’etudiant les competences requises pour :\r\n"
                + "Analyser les besoins du projet\r\n"
                + "Etudier l’existant\r\n"
                + "Concevoir une solution efficace\r\n"
                + "Mettre en oeuvre la solution\r\n"
                + "Evaluer la solution mise en oeuvre et effectuer une etude comparative par rapport a des solutions existantes\r\n"
                + "Faire une synthese des tests effectues en presentant les points forts et les points faibles//n"
                + " de la solution.",new Competence[] {c44,c114,c137,c138,c139,c140,c141,c142,c58,c48,c54,c53,c52,c51,c50,c49,c143,c59,a47});

        NiveauDEtude niveau3csSIQ =new NiveauDEtude("3Cs_SIQ",new Module[] {modulePFE});
        NiveauDEtude niveau3csSIT =new NiveauDEtude("3Cs_SIT",new Module[] {modulePFE});
        NiveauDEtude niveau3csSIL =new NiveauDEtude("3Cs_SIL",new Module[] {modulePFE});
        NiveauDEtude niveau3csSID =new NiveauDEtude("3Cs_SID",new Module[] {modulePFE});

        Competence c144=new Competence(245,"Exploiter des outils de recherche bibliographique",3);
        Competence c145=new Competence(246,"Mettre en oeuvre un travail de recherche selon une methodologie",2);
        Competence c146=new Competence(247,"Elaborer une bibliographie en respectant une norme de citation",1);
        Competence c147=new Competence(248,"Effectuer une communication scientifique orale",2);
        Competence c148=new Competence(249,"Elaborer un support de communication synthetique et pertinent",3);
        Competence c149=new Competence(250,"Elaborer un support de communication bien organise",3);
        Competence c150=new Competence(251,"Mettre en oeuvre un support de communication avec un visuel clair",3);


        Module moduleEMM=new Module("Elaboration du memoire de Master","Le memoire a les objectifs suivants :\r\n"
                + "o Initier l’etudiant a aborder une thematique de recherche;\r\n"
                + "o Donner à l’etudiant les compétences requises pour :\r\n"
                + "- Effectuer une etude bibliographique sur le domaine\r\n"
                + "- Analyser et comprendre un probleme de recherche\r\n"
                + "- Synthetiser les differentes approches existantes et mener une etude comparative, la discuter et apporter des conclusions\r\n"
                + "- Rediger un rapport synthetique et presenter les travaux de manière orale.\r\n"
                + "- Participer a un debat, repondre aux questions et defendre la demarche adoptee en argumentant de maniere //n"
                + "convaincante.",new Competence[] {c44,c114,c144,c145,c146,c147,c139,c140,c142,c58,c53,c59,a47,a18,c148,c149,c150});

        Competence c151=new Competence(252,"Effectuer une recherche dans des ressources documentaires diverses",1);
        Competence c152=new Competence(253,"Rediger un article en adoptant un style scientifique et academique",2);


        Module moduleGPS=new Module("Gestion de projets scientifiques", "Clarifier la demarche projet scientifique et introduction de projet collectif (travail en\r\n"
                + "groupe)",new Competence[] {c44,c114,c45,c144,c145,c146,c151,c152,c48,a136,c117,a88});

        Competence c153=new Competence(254,"Respecter des pratiques ethiques durant un travail de recherche",2);
        Competence c154=new Competence(255,"Effectuer une synthese bibliographique et ressortir des verrous scientifiques",2);

        Module moduleIMR=new Module("Initiation à la methodologie de recherche","Introduction à la methodologie de recherche\r\n"
                + "Faire comprendre l’ethique de la recherche\r\n"
                + "Sensibiliser à la recherche utile",new Competence[] {c145,c153,c154});

        Module moduleRDCR=new Module("Recherche documentaire et communication de recherche","",new Competence[] {c144,c146,c151,c152,c147});

        NiveauDEtude niveauMSIQ =new NiveauDEtude("MSIQ",new Module[] {moduleEMM,moduleGPS,moduleIMR,moduleRDCR});
        NiveauDEtude niveauMSIT =new NiveauDEtude("MSIT",new Module[] {moduleEMM,moduleGPS,moduleIMR,moduleRDCR});
        NiveauDEtude niveauMSIL =new NiveauDEtude("MSIL",new Module[] {moduleEMM,moduleGPS,moduleIMR,moduleRDCR});
        NiveauDEtude niveauMSID =new NiveauDEtude("MSID",new Module[] {moduleEMM,moduleGPS,moduleIMR,moduleRDCR});


        try {
            String home = System.getProperty("user.home");
            FileOutputStream fos = new FileOutputStream(home+nomDuFichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);//objet qui sait ecrire des flux d'octets sur un fichier
            oos.writeObject(niveau1Cpi);
            oos.writeObject(niveau2Cpi);
            oos.writeObject(niveau1Cs);
            oos.writeObject(niveau2csSIQ);
            oos.writeObject(niveau2csSIT);
            oos.writeObject(niveau2csSIL);
            oos.writeObject(niveau2csSID);
            oos.writeObject(niveau2csSIQ);
            oos.writeObject(niveau3csSIQ);
            oos.writeObject(niveau3csSIT);
            oos.writeObject(niveau3csSIL);
            oos.writeObject(niveau3csSID);
            oos.writeObject(niveauMSIQ);
            oos.writeObject(niveauMSIT);
            oos.writeObject(niveauMSIL);
            oos.writeObject(niveauMSID);


//oos.writeObject(c2);
            oos.close();
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }









    public Rech recherchenv(String nomDuFichiernvetude,String niv){
        NiveauDEtude n=null;
        boolean trv=false;
        try {
            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+"/RéferentielAnneDetude.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
            while((fis.available() > 0)&&(trv==false)) {
                n = (NiveauDEtude)ois.readObject();
                if(n.niveauDetude.compareTo(n.niveauDetude)==0)
                {trv=true;}
            }
            if(trv==false) {
                n=null;
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
        Rech rechnv=new Rech(n,trv);
        return rechnv;

    }


/////////////////////////////////////////////////////TEST

    public Rechmod recherchemd(String nomDuFichiernvetude,String modulle){
        Module mm=null;
        boolean t=false;
        try {
            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+"/RéferentielAnneDetude.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
            while(fis.available() > 0) {
                NiveauDEtude n = (NiveauDEtude) ois.readObject();
                if(n.recherchemodule(modulle).trouv){
                    mm=n.recherchemodule(modulle).m;
                    t=n.recherchemodule(modulle).trouv;
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
        Rechmod rechmodule=new Rechmod(mm,t);
        return rechmodule;}



    ////////////////////////////////////////////////////////////////////
    public Recherche recherchecm(String nomDuFichiernvetude,String modulle,String cmp){
        Competence mm=null;
        boolean t=false;
        try {
            String home = System.getProperty("user.home");
            FileInputStream fis = new FileInputStream(home+"/RéferentielAnneDetude.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);//objet qui sait ecrire des flux d'octets sur un fichier
            while(fis.available() > 0) {
                NiveauDEtude n = (NiveauDEtude)ois.readObject();
                if(n.recherchemodule(modulle).trouv){
                    mm=n.recherchecompetence(cmp,modulle).c;
                    t=n.recherchecompetence(cmp,modulle).trouv;
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
        Recherche rechcme=new Recherche(mm,t);
        return rechcme;}






}