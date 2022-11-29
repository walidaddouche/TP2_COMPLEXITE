package SAT.PROJET1.test;

import SAT.PROJET1.java.Clause;
import SAT.PROJET1.java.Formule;
import SAT.PROJET1.java.Litteral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FormuleTest {

    @Test
    void addClause(){
        Formule formule = new Formule();

        Clause clause1 = new Clause();
        clause1.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(3, JeuxDeValeurs.getJeuDeVariables()));

        Clause clause2 = new Clause();
        clause2.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause2.addLiteral(new Litteral(2, JeuxDeValeurs.getJeuDeVariables()));

        formule.addClause(clause1);
        formule.addClause(clause2);

        assertEquals(2, formule.getClauses().size());
        assertEquals(3, formule.getClauses().get(0).getLitteraux().size());
        assertEquals(2, formule.getClauses().get(1).getLitteraux().size());
    }

    @Test
    void removeLiteral() {
        Formule formule = new Formule();

        Clause clause1 = new Clause();
        clause1.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(3, JeuxDeValeurs.getJeuDeVariables()));

        Clause clause2 = new Clause();
        clause2.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause2.addLiteral(new Litteral(2, JeuxDeValeurs.getJeuDeVariables()));

        formule.addClause(clause1);
        formule.addClause(clause2);
        formule.removeClause(clause1);

        assertEquals(1, formule.getClauses().size());
        assertEquals(2, formule.getClauses().get(0).getLitteraux().size());
    }

    @Test
    void evaluer() {
        Formule formule1 = new Formule();
        Formule formule2 = new Formule();
        Formule formule3 = new Formule();

        Clause clause1 = new Clause();
        clause1.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(3, JeuxDeValeurs.getJeuDeVariables()));

        Clause clause2 = new Clause();
        clause2.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause2.addLiteral(new Litteral(2, JeuxDeValeurs.getJeuDeVariables()));

        Clause clause3 = new Clause();
        clause3.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));

        formule1.addClause(clause1);
        formule1.addClause(clause2);

        formule2.addClause(clause2);
        formule2.addClause(clause3);

        formule3.addClause(clause1);
        formule3.addClause(clause3);

        assertFalse(formule1.evaluer());
        assertFalse(formule2.evaluer());
        assertTrue(formule3.evaluer());
    }

    @Test
    void testToString() {
        Formule formule = new Formule();

        Clause clause1 = new Clause();
        clause1.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(-2, JeuxDeValeurs.getJeuDeVariables()));
        clause1.addLiteral(new Litteral(3, JeuxDeValeurs.getJeuDeVariables()));

        Clause clause2 = new Clause();
        clause2.addLiteral(new Litteral(-1, JeuxDeValeurs.getJeuDeVariables()));
        clause2.addLiteral(new Litteral(2, JeuxDeValeurs.getJeuDeVariables()));

        formule.addClause(clause1);
        formule.addClause(clause2);

        assertEquals("(¬1 U ¬2 U 3) ∩ (¬1 U 2)", formule.toString());
    }
}