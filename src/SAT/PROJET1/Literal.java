package SAT.PROJET1;

public class Literal {

    /**
     *  @param sommet qui sert à identifier le literal
     */

    public final int sommet;

    /** @param value de type boolean qui représente la valeur du littéral
     * false → le littéral = 0
     * true → le littéral = 1
     */

    boolean value;



    public Literal(int sommet) {
        this.sommet = sommet;
    }


    public void setValue(boolean value) {
        this.value = value;
    }


    public int getValue() {
        if(value) return 1;
        else return 0;

    }

    /**
     * une methode to string afin de verifier si le literal qu'on a créé est bien celui attendu
     * @return
     */

    @Override
    public String toString() {
        if (sommet < 0)
            return "¬x" + -1 * sommet;
        return "x" + sommet ;
    }



}
