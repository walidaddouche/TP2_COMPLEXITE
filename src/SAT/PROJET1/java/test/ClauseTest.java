package SAT.PROJET1.java.test;

import SAT.PROJET1.java.Clause;
import SAT.PROJET1.java.Litteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class ClauseTest {

    Litteral litteral1 = new Litteral(3);
    Litteral litteral2 = new Litteral(-2);
    Litteral litteral3 = new Litteral(-5, false);
    Litteral litteral4 = new Litteral(8, false);
    Litteral litteral5 = new Litteral(-20);
    Litteral litteral6 = new Litteral(14, false);


    @Test
    void addLiteral() throws Exception {
        Clause clause = new Clause();
        clause.addLiteral(new Litteral(3));
    }

    @Test
    void removeLiteral() throws Exception {
        Clause clause = new Clause();
        clause.addLiteral(new Litteral(3));
        clause.addLiteral(new Litteral(-2));
        clause.addLiteral(new Litteral(5, false));
        clause.removeLiteral(5);
        assertEquals(2, clause.getLitteraux().size());
        assertNull(clause.getLitteral(5));
        assertNotNull(clause.getLitteral(3));
        assertNotNull(clause.getLitteral(-2));
    }

    @Test
    void evaluer() {
        Clause clause1 = new Clause();
        clause1.addLiteral(new Litteral(-2));
        clause1.addLiteral(new Litteral(-1));
        clause1.addLiteral(new Litteral(3));
        Clause clause2 = new Clause();
        clause2.addLiteral(new Litteral(2));
        clause2.addLiteral(new Litteral(1));
        clause2.addLiteral(new Litteral(-4));
        clause2.addLiteral(new Litteral(3));

    }

    @Test
    void testToString() {

    }
}