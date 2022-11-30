package SAT.PROJET1.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class LectureVariables {
  Variables variables;

  public LectureVariables(String cheminFichierVariables) throws Exception {
    try{
      File fichier = new File(cheminFichierVariables);
      FileReader lecteurFichier = new FileReader(fichier);
      BufferedReader lecteur = new BufferedReader(lecteurFichier);
      String ligne;

      // Seul la première ligne est prise en compte, les autres sont ignorés
      if((ligne = lecteur.readLine()) != null){
        String[] valeursLigne = ligne.split(" ");
        if(testerExistenceDoublons(valeursLigne)){
          throw new Exception("Fichier lecture variables : Il existe des variables en doublons dans le fichier, merci" +
              "de les retirer dans le fichier 'resources/formule-variables.txt");
        }

        variables = new Variables();
        for(String valeur : valeursLigne){
          variables.add(Integer.parseInt(valeur));
        }
      }
      else{
        throw new Exception("Fichier lecture variables : Le fichier est vide");
      }
    }
    catch(IOException e){
      throw new IOException("Fichier lecture variables : Fichier non reconnu, vérifier le chemin que vous avez renseigné !");
    }
  }


  private boolean testerExistenceDoublons(String[] premiereLigne){
    HashSet<Integer> variablesExistantes = new HashSet<>();
    for (String s : premiereLigne) {
      if (variablesExistantes.contains(Math.abs(Integer.parseInt(s)))) {
        return true;
      } else {
        variablesExistantes.add(Math.abs(Integer.parseInt(s)));
      }
    }
    return false;
  }

  public Variables getVariables(){
    return variables;
  }

}
