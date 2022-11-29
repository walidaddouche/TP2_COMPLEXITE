package SAT.PROJET1.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VariablesTest {
  @Test
  void testExistenceVariableEtAdd() {
    Variables variables = new Variables();
    variables.add(0);
    variables.add(-2);
    variables.add(3);
    assertFalse(variables.testExistenceVariable(0));
    assertTrue(variables.testExistenceVariable(1));
    assertTrue(variables.testExistenceVariable(2));
    assertTrue(variables.testExistenceVariable(-2));
    assertFalse(variables.testExistenceVariable(5));
  }

  @Test
  void remove() {
    Variables variables = new Variables();
    variables.add(1);
    variables.add(-2);
    variables.add(3);
  }

  @Test
  void estVariableVraie(){
    Variables variables = new Variables();
    variables.add(1);
    variables.add(-2);
    variables.add(3);
    assertTrue(variables.estVariableVraie(1));
    assertFalse(variables.estVariableVraie(2));
    // Le signe devant la valeur n'a pas d'importe pour vérifier si une variable est vrai ou fausse dans ce cas.
    // La preuve :
    assertFalse(variables.estVariableVraie(-2));
    assertTrue(variables.estVariableVraie(-3));
  }

}