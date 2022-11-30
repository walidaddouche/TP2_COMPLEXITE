package SAT.PROJET1.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LectureFNC {
  Formule formule;
  int nombreClauses;
  int nombreVariables;


  public LectureFNC(String cheminFichierFNC) throws Exception {
    try{
      File fichier = new File(cheminFichierFNC);
      FileReader lecteurFichier = new FileReader(fichier);
      BufferedReader lecteur = new BufferedReader(lecteurFichier);
      //StringBuffer lecteurLignes = new StringBuffer();
      String ligne;
      if((ligne = lecteur.readLine()) != null){
       String[] premiereLigne = ligne.split(" ");
       if(!(Objects.equals(premiereLigne[0], "p") &&
               Objects.equals(premiereLigne[1], "cnf") &&
               (Integer.parseInt(premiereLigne[2]) > 0) &&
               (Integer.parseInt(premiereLigne[3]) > 0) &&
               (premiereLigne.length == 4))){
         throw new Exception("Fichier lecture clauses : La première ligne doit uniquement avoir les paramètres suivants \r\n" +
                 "p cnf <nombre_variables> <nombre_clauses>");
       }
      }
      else{
        throw new Exception("Fichier lecture clauses : Il doit y avoir obligatoirement la première ligne, qui correspond  \r\n" +
                "p cnf <nombre_variables> <nombre_clauses>");
      }
    }
    catch(IOException e){
      throw new IOException("Fichier lecture clauses : Fichier non reconnu, vérifier le chemin que vous avez renseigné !");
    }
    //TODO Tester existence fichier pour chemin donné

    //TODO Lire première ligne : vérifier si p cnf existent
    //TODO Lire première ligne : stocker nbClauses
    //TODO Lire première ligne : stocker nbVariables
    //TODO Lire lignes suivantes et créer clauses
    //TODO Vérifier si variable > nbVariable

    //TODO Vérifier nb de clauses lues par rapport à nombreClauses
  }


}
