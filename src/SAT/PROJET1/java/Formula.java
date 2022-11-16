package SAT.PROJET1.java;

import java.util.Arrays;

public class Formula {
    Clause[] clauses;

    public Formula(Clause[] clauses){
        this.clauses = clauses;
    }

    public Formula(){
        this.clauses = clauses;
    }


    @Override
    public String toString() {
        return "Formula : " + Arrays.toString(clauses) ;
    }
}
