package SAT.PROJET1;

import java.util.ArrayList;
import java.util.List;

public class Clause {
    ArrayList<Literal> literals = new ArrayList<>() ;



    public Clause(ArrayList<Literal> literals) {
        this.literals = literals;
    }

    public Clause(){
        literals = new ArrayList<>();
    }

    public void addLiteral(Literal literal){
        this.literals.add(literal);
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


