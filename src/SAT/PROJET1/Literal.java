package SAT.PROJET1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Literal {
    private int sommet;


    public Literal(int sommet) {
        this.sommet = sommet;
    }


    @Override
    public String toString() {
        if (sommet < 0)
            return "¬x" + -1 * sommet;
        return "x" + sommet;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Nombre de clauses et nombre de literals

        FileReader fileReader = new FileReader("src/SAT/PROJET1/formule-2-sat.txt");
        Scanner scanner = new Scanner(fileReader);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int nL = scanner.nextInt(); //  le nombre de literals

        int nC = scanner.nextInt(); //  le nombre de clauses

        Literal[] literals = new Literal[nL * 2 + 1];
        Clause[] clauses = new Clause[nC];

        for (int i = 0; i < nC; i++) {
            clauses[i] = new Clause();

        }

        for (int i = 1; i <= nL; i++) {
            literals[i] = new Literal(i);
        }
        for (int i = nL + 1; i < nL * 2 + 1; i++) {
            literals[i] = new Literal(-(i - nL));
        }

        scanner.nextLine();
        int literal;
        int i = 0;
        while (scanner.hasNextLine()) {
            while (scanner.hasNextInt()) {
                literal = scanner.nextInt();
                if (literal > 0) {
                    clauses[i].addLiteral(literals[literal]);
                } else if (literal < 0) {
                    clauses[i].addLiteral(literals[(-literal + nL)]);
                }
                else  {
                    i++;
                    break;
                }


            }
        }
        Formula formula = new Formula(clauses);

    }

}