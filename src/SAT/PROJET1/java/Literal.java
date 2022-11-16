package SAT.PROJET1.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Literal {
    private int sommet;
    private int value;


    public Literal(int sommet) {
        this.sommet = sommet;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        if (sommet < 0)
            return "¬x" + -1 * sommet + " = " + value;
        return "x" + sommet + " = " + value;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Nombre de clauses et nombre de literals

        FileReader fileLiteral = new FileReader("src/SAT/PROJET1/java/resources/formule-2-sat.txt");
        FileReader fileValue = new FileReader("src/SAT/PROJET1/java/resources/reformule_comp.txt");

        Scanner literalsScanner = new Scanner(fileLiteral);
        Scanner valuesScanner = new Scanner(fileValue);

        while (!literalsScanner.hasNextInt()) {literalsScanner.next();}

        int nL = literalsScanner.nextInt(); //  le nombre de literals

        int nC = literalsScanner.nextInt(); //  le nombre de clauses

        Literal[] literals = new Literal[nL * 2 + 1];
        Clause[] clauses = new Clause[nC];

        for (int i = 0; i < nC; i++) {clauses[i] = new Clause();}
        for (int i = 1; i <= nL; i++) {literals[i] = new Literal(i);}
        for (int i = nL + 1; i < nL * 2 + 1; i++) {literals[i] = new Literal(-(i - nL));}

        literalsScanner.nextLine();
        int literal;
        int i = 0;
        while (literalsScanner.hasNextLine()) {
            while (literalsScanner.hasNextInt()) {
                literal = literalsScanner.nextInt();
                if (literal > 0) {
                    clauses[i].addLiteral(literals[literal]);
                } else if (literal < 0) {
                    clauses[i].addLiteral(literals[(-literal + nL)]);
                } else {
                    i++;
                    break;
                }

            }
        }

        int value ;
        while (valuesScanner.hasNextInt()){
            value = valuesScanner.nextInt();
            if(value > 0){
                literals[value].setValue(1);
                literals[value+nL].setValue(0);
            }
            else  {
                literals[-value+nL].setValue(1);
                literals[-value].setValue(0);
            }
        }

        System.out.println(Arrays.toString(literals));
    }
}