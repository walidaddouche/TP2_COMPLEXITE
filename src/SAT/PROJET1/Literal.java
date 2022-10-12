package SAT.PROJET1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Literal {
    private int sommet;


    public Literal(int sommet) {this.sommet = sommet;}




    @Override
    public String toString() {
        if (sommet < 0)
            return "¬x" + -1 * sommet;
        return "x" + sommet;
    }

    public static void main(String[] args) {
        int nC = 2; int nL = 6+2;  // Nombre de clauses et nombre de literals
        Literal[] literals = new Literal[nL-1];
        for (int i = 1; i < nL/2; i++) {
            System.out.println(i);
            literals[i] = new Literal(i);
        }
        int j = nL/2 - 1;
        for (int i =  nL/2; i < nL-1; i++) {
            literals[i] = new Literal(-(i - j));
        }
        System.out.println(Arrays.toString(literals));
        for (int i = 1; i < nL - 1; i++) {
        }


    }
}