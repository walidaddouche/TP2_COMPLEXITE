package SAT.PROJET1.java;

import java.util.ArrayList;

public class FormuleV2 {
    ArrayList<Clause> clauses;

    public FormuleV2(ArrayList<Clause> clauses){
        this.clauses = clauses;
    }

    public FormuleV2(){
        this.clauses = new ArrayList<>();
    }

    public Clause addClause(Clause clause){
        clauses.add(clause);
        return clause;
    }

    public Clause removeClause(Clause clause){
        clauses.remove(clause);
        return clause;
    }

    public ArrayList<Clause> getClauses(){
        return clauses;
    }

    @Override
    public String toString() {
        return "Formule : " + clauses.toString() ;
    }
}
