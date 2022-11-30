package SAT.PROJET1.test;

import SAT.PROJET1.java.LectureFNC;
import SAT.PROJET1.java.LectureVariables;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LectureFNCTest {

    @Test
    void lectureFichier() throws Exception {
        LectureVariables lectureVariables = new LectureVariables("resources/formule-variables.txt");
        LectureFNC lectureFNC = new LectureFNC("resources/formule-sat.txt", lectureVariables.getVariables());
    }
}