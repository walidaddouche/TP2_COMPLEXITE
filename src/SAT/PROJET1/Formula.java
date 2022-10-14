package SAT.PROJET1;

import java.util.Arrays;

public class Formula {
    Clause[] clauses;

    Formula(Clause[] clauses){
        this.clauses = clauses;
    }


    @Override
    public String toString() {
        return "Formula : " + Arrays.toString(clauses) ;
    }
}
