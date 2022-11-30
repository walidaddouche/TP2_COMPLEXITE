package SAT.PROJET1.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LectureVariablesTest {
  @Test
  void lectureFichier() throws Exception {
    LectureVariables lectureVariables = new LectureVariables("resources/formule-variables.txt");
  }


  @Test
  void contenuVariables() throws Exception {
    LectureVariables lectureVariables = new LectureVariables("resources/formule-variables.txt");
    assertEquals(3, lectureVariables.getVariables().getVariables().size());
    assertEquals(1, lectureVariables.getVariables().getVariables().get(0));
    assertEquals(-2, lectureVariables.getVariables().getVariables().get(1));
    assertEquals(-3, lectureVariables.getVariables().getVariables().get(2));
  }

}