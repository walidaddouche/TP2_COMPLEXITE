package SAT.PROJET1.test;

import SAT.PROJET1.java.Litteral;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class LitteralTest {

    @Test
    void evaluer() {
        // Pour rappel :
        // x1 = 1
        // x2 = x3 = x4 = 0
        Litteral litteral1 = new Litteral(1, JeuxDeValeurs.getJeuDeVariables());
        Litteral litteral2 = new Litteral(2, JeuxDeValeurs.getJeuDeVariables());
        Litteral litteral3 = new Litteral(-2, JeuxDeValeurs.getJeuDeVariables());
        Litteral litteral4 = new Litteral(4, JeuxDeValeurs.getJeuDeVariables());
        assertTrue(litteral1.evaluer());
        assertFalse(litteral2.evaluer());
        assertTrue(litteral3.evaluer());
        assertFalse(litteral4.evaluer());
    }

    @Test
    void testToString() {
        Litteral litteral1 = new Litteral(1, JeuxDeValeurs.getJeuDeVariables());
        Litteral litteral2 = new Litteral(2, JeuxDeValeurs.getJeuDeVariables());
        Litteral litteral3 = new Litteral(-2, JeuxDeValeurs.getJeuDeVariables());
        assertEquals("1", litteral1.toString());
        assertEquals("2", litteral2.toString());
        // Dans ce cas, on est confronté à une double négation, donc cela revient à être un nombre positif
        assertEquals("¬2", litteral3.toString());
    }
}