package SAT.PROJET1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class Formula {

    Clause[] clauses;
    Literal[] literals;
    int nL;
    int nC;


    Formula(Literal[] literals, Clause[] clauses, int nL, int nC) {
        this.clauses = clauses;
        this.literals = literals;
        this.nC = nC;
        this.nL = nL;
    }

    public void setClauses(Clause[] clauses) {
        this.clauses = clauses;
    }

    public static Formula initializeLiterals(String path) throws FileNotFoundException {
        FileReader fileLiteral = new FileReader(path);
        Scanner literalsScanner = new Scanner(fileLiteral);

        while (!literalsScanner.hasNextInt()) {
            literalsScanner.next();
        }

        int nL = literalsScanner.nextInt(); //  le nombre de literals

        int nC = literalsScanner.nextInt(); //  le nombre de clauses

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

        return new Formula(literals, clauses, nL, nC);
    }


    private void setLiteralsValues(Formula formula,String path) throws FileNotFoundException {
        int value;
        FileReader fileValue = new FileReader(path);
        Scanner valuesScanner = new Scanner(fileValue);


        while (valuesScanner.hasNextInt()) {
            value = valuesScanner.nextInt();
            if (value > 0) {
                literals[value].setValue(true);
                literals[value + nL].setValue(false);
            } else {
                literals[-value + nL].setValue(true);
                literals[-value].setValue(false);
            }
        }

        var result = false;
        Boolean[] resultArray = new Boolean[clauses.length - 1];
        var x = 0;
        for (Clause clause : clauses) {
            for (Literal literal1 : clause.literals) {
                result = literal1.value || result;
            }
            resultArray[x] = result;
            result = false;
        }


        formula.setClauses(clauses);


    }

    public static Formula getFormula(String path) throws FileNotFoundException {
        Formula f = initializeLiterals(path);

        f.setLiteralsValues(f,path);

        return f;
    }




    public boolean isSatisfiable() {
        for (Clause clause : clauses) {
            if (!clause.isSatisfiable())
                return false;
        }
        return true;
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Clause clause : clauses) {
            for (Literal literal : clause.literals) {
                str.append(literal).append(" = ").append(literal.getValue()).append(", ");
            }
        }
        str.deleteCharAt(str.length() - 2);

        str.append("\n");
        str.append("{ ");
        for (Clause clause : clauses) {
            for (Literal literal : clause.literals) {
                str.append(literal).append(" ⋂ ");
            }
            str.deleteCharAt(str.length() - 2);
            str.append(", ");
        }

        str.deleteCharAt(str.length() - 2);

        str.append("}");

        return str.toString();
    }

    public static void main(String[] args) {
        try {
            Formula formula = getFormula("src/SAT/PROJET1/formule-2-sat.cnf");
            System.out.println(formula.clauses[0].literals);


        }catch (Exception e ){
            e.printStackTrace();
        }
    }


}