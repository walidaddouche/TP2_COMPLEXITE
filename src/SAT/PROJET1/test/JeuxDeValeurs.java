package SAT.PROJET1.test;

import SAT.PROJET1.java.Litteral;
import SAT.PROJET1.java.Variables;

public class JeuxDeValeurs {

  static Litteral litteral1 = new Litteral(-1, getJeuDeVariables());
  static Litteral litteral2 = new Litteral(2, getJeuDeVariables());
  static Litteral litteral3 = new Litteral(-3, getJeuDeVariables());
  static Litteral litteral4 = new Litteral(4, getJeuDeVariables());


  static Variables getJeuDeVariables(){
    Variables variables = new Variables();
    variables.add(1);
    variables.add(-2);
    variables.add(-3);
    variables.add(-4);
    return variables;
  }



}
