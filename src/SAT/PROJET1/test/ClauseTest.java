package SAT.PROJET1.test;

import SAT.PROJET1.java.Clause;
import SAT.PROJET1.java.Litteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClauseTest {


    @Test
    void addLiteral(){
        Clause clause = new Clause();
        clause.addLiteral(JeuxDeValeurs.litteral1);
        clause.addLiteral(JeuxDeValeurs.litteral2);
        clause.addLiteral(JeuxDeValeurs.litteral3);
        clause.addLiteral(JeuxDeValeurs.litteral4);
    }

    @Test
    void removeLiteral() throws Exception {
        Clause clause = new Clause();
        clause.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));
        clause.addLiteral(new Litteral(3, JeuxDeValeurs.getJeuDeVariables()));
        clause.removeLiteral(-2);

        assertEquals(2, clause.getLitteraux().size());
        assertNotNull(clause.getLitteral(-1));
        assertNull(clause.getLitteral(-2));
        assertNotNull(clause.getLitteral(3));
    }

    @Test
    void evaluer() throws Exception {
        Clause clause1 = new Clause();
        clause1.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(3, JeuxDeValeurs.getJeuDeVariables()));
        assertTrue(clause1.evaluer());

        Clause clause2 = new Clause();
        clause2.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause2.addLiteral(new Litteral(2, JeuxDeValeurs.getJeuDeVariables()));
        assertFalse(clause2.evaluer());

    }

    @Test
    void testToString() throws Exception {
        Clause clause1 = new Clause();
        clause1.addLiteral(new Litteral(1, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(-3, JeuxDeValeurs.getJeuDeVariables()));
        assertEquals("(1 U ¬2 U ¬3)", clause1.toString());

    }
}