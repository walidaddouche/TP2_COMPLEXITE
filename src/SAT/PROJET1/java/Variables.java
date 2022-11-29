package SAT.PROJET1.java;

import java.util.ArrayList;

public class Variables {
  ArrayList<Integer> variables;

  public Variables(){
    variables = new ArrayList<>();
  }

  public void add(int valeur){
    if(valeur == 0){
      valeur = 1;
    }
    if(!testExistenceVariable(valeur)){
      variables.add(valeur);
    }

  }

  public boolean testExistenceVariable(int value){
    for(int variable : variables){
      if(Math.abs(variable) == Math.abs(value))
        return true;
    }
    return false;
  }

  public boolean estVariableVraie(int value){
    for(int variable : variables){
      if(Math.abs(variable) == Math.abs(value))
        return variable > 0;
    }
    return false;
  }

  public ArrayList<Integer> getVariables() {
    return variables;
  }

  public void setVariables(ArrayList<Integer> variables) {
    this.variables = variables;
  }
}
