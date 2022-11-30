package SAT.PROJET1.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LectureFNC {
  Formule formule;
  Variables variables;
  int nombreClauses;
  int nombreVariables;


  public LectureFNC(String cheminFichierFNC, Variables variables) throws Exception {
    this.variables = variables;
    try{
      File fichier = new File(cheminFichierFNC);
      FileReader lecteurFichier = new FileReader(fichier);
      BufferedReader lecteur = new BufferedReader(lecteurFichier);
      String ligne;
      if((ligne = lecteur.readLine()) != null){
       String[] premiereLigne = ligne.split(" ");
       verificationPremiereLigne(premiereLigne);
       nombreVariables = Integer.parseInt(premiereLigne[2]);
       nombreClauses = Integer.parseInt(premiereLigne[3]);
      }
      else{
        throw new Exception("Fichier lecture clauses : Il doit y avoir obligatoirement la première ligne, qui correspond \r\n" +
                "p cnf <nombre_variables> <nombre_clauses>");
      }
      formule = new Formule();

      while((ligne = lecteur.readLine()) != null){
        String[] valeursLigne = ligne.split(" ");
        verificationClauses(valeursLigne);
        Clause clause = genererClause(valeursLigne);
        formule.addClause(clause);
      }

      if(!testerCoherenceClauses()){
        throw new Exception("Le nombre de clauses renseignées dans le fichier ne correspond pas au nombre de clause initialement souhaité");
      }
      if(!testerCoherenceVariables()){
        throw new Exception("Le nombre de variables est incohérent entre le fichier 'formule-sat.txt' et 'formule-variables.txt'");
      }

    }
    catch(IOException e){
      throw new IOException("Fichier lecture clauses : Fichier non reconnu, vérifier le chemin que vous avez renseigné !");
    }
  }

  private void verificationPremiereLigne(String[] premiereLigne) throws Exception {
    if(!(Objects.equals(premiereLigne[0], "p") &&
        Objects.equals(premiereLigne[1], "cnf") &&
        (Integer.parseInt(premiereLigne[2]) > 0) &&
        (Integer.parseInt(premiereLigne[3]) > 0) &&
        (premiereLigne.length == 4))){
      throw new Exception("Fichier lecture clauses : La première ligne doit uniquement avoir les paramètres suivants \r\n" +
          "p cnf <nombre_variables> <nombre_clauses>");
    }
  }

  private void verificationClauses(String[] valeursLigne) throws Exception {
    if(!Objects.equals(valeursLigne[valeursLigne.length - 1], "0")){
        throw new Exception("Fichier lecture clauses : Une clause doit obligatoirement se terminer par un '0'");
    }
    if(valeursLigne.length < 2){
        throw new Exception("Une clause doit obligatoirement avoir au moins un littéral et se terminer par un '0'");
    }
  }

  private Clause genererClause(String[] valeursLigne) throws Exception {
    Clause clause = new Clause();
    for(int i = 0 ; i < valeursLigne.length-1 ; i++){
      if(testerExistenceZeroDansClause(Integer.parseInt(valeursLigne[i]))){
        throw new Exception("La clause " + valeursLigne.toString() + " contient une valeur 0 alors que cela est interdit." +
        " Excepté pour la dernière valeur qui marque la fin de la clause.");
      }
      clause.addLiteral(new Litteral(Integer.parseInt(valeursLigne[i]), variables));
    }
    return clause;
  }

  private boolean testerExistenceZeroDansClause(int valeur){
    return valeur == 0;
  }

  private boolean testerCoherenceVariables(){
    return nombreVariables == variables.getVariables().size();
  }
  private boolean testerCoherenceClauses(){
    return nombreClauses == formule.getClauses().size();
  }



}
