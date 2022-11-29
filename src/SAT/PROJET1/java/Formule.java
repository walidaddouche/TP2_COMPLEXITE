package SAT.PROJET1.java;

import java.util.ArrayList;

public class Formule {
    ArrayList<Clause> clauses;


    public Formule(){
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

    public boolean evaluer(){
        int nombreClausesVraies = 0;
        for(int i = 0 ; i < clauses.size() ; i++){
            if(clauses.get(i).evaluer()){
                nombreClausesVraies++;
            }
        }

        return nombreClausesVraies == clauses.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(int i = 0 ; i < clauses.size()-1 ; i++){
            str.append(clauses.get(i)).append(" ∩ ");
        }
        str.append(clauses.get(clauses.size()-1));

        return str.length() == 0
            ? null
            : str.substring(0, str.length());
    }
}
