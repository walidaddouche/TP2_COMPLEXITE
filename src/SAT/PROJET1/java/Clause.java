package SAT.PROJET1.java;

import java.util.ArrayList;

public class Clause {
    ArrayList<Literal> literals;


    public Clause(ArrayList<Literal> literals) {
        this.literals = literals;
    }

    public Clause(){
        literals = new ArrayList<>();
    }

    public void addLiteral(Literal literal){
        this.literals.add(literal);
    }

    public void removeLiteral(Literal literal){
        this.literals.remove(literal);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Literal literal: literals) {
            str.append(literal).append(" ⋂ ");
        }
        return str.length() == 0
                ? null
                : str.substring(0, str.length() - 2);
    }
}


