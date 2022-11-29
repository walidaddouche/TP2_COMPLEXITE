package SAT.PROJET1.java;

import java.util.ArrayList;

public class Variables {
  ArrayList<Integer> variables;

  public Variables(){
    variables = new ArrayList<>();
  }

  public void add(int valeur){
    //TODO gérer doublons
    if(valeur == 0){
      valeur = 1;
    }
    variables.add(valeur);
  }

  public boolean testExistenceVariable(int index){
    for(int variable : variables){
      if(Math.abs(variable) == Math.abs(index))
        return true;
    }
    return false;
  }

  public boolean estVariableVraie(int value){
    return value > 0;
  }

  public ArrayList<Integer> getVariables() {
    return variables;
  }

  public void setVariables(ArrayList<Integer> variables) {
    this.variables = variables;
  }
}
