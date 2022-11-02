package SAT.PROJET1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Literal {
    public final int sommet;
    boolean value;


    public Literal(int sommet) {
        this.sommet = sommet;
    }


    public void setValue(boolean value) {
        this.value = value;
    }

    public String getSommet(){
        if(sommet < 0 ){
            return  "¬x" + -1 * sommet;
        }
        return  "x" +  sommet;


    }

    public int getValue() {
        if(value) return 1;
        else return 0;

    }


    @Override
    public String toString() {
        if (sommet < 0)
            return "¬x" + -1 * sommet; //+ " = " + value;
        return "x" + sommet ;//+ " = " + value;
    }



}
