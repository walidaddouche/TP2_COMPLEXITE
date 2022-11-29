package SAT.PROJET1.java.test;

import SAT.PROJET1.java.Litteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LitteralTest {
    Litteral[] litterauxDeTest() {
        Litteral litteral1 = new Litteral(3);
        Litteral litteral2 = new Litteral(-2);
        Litteral litteral3 = new Litteral(-5, false);
        Litteral litteral4 = new Litteral(8, false);
        return new Litteral[]{litteral1, litteral2, litteral3, litteral4};
    }

    @Test
    void compare() {
        Litteral litteral1 = new Litteral(3);
        Litteral litteral2 = new Litteral(-2);
        Litteral litteral3 = new Litteral(3, true);
        assertTrue(litteral1.compareLiteral(litteral3));
        assertFalse(litteral3.compareLiteral(litteral2));
    }


    @Test
    void evaluer() {
        Litteral[] litteraux = litterauxDeTest();
        assertTrue(litteraux[0].evaluer());
        assertFalse(litteraux[1].evaluer());
        assertTrue(litteraux[2].evaluer());
        assertFalse(litteraux[3].evaluer());
    }

    @Test
    void testToString() {
        Litteral[] litteraux = litterauxDeTest();
        assertEquals("3", litteraux[0].toString());
        assertEquals("¬2", litteraux[1].toString());
        assertEquals("5", litteraux[2].toString());
        assertEquals("¬8", litteraux[3].toString());

    }
}