package SAT.PROJET1;

import java.util.ArrayList;
import java.util.List;

public class Clause {
    ArrayList<Literal> literals;

    public Clause(ArrayList<Literal> literals) {
        this.literals = literals;
    }


    public Clause() {
        literals = new ArrayList<>();
    }

    public void addLiteral(Literal literal) {
        this.literals.add(literal);
    }
}





