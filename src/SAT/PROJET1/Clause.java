package SAT.PROJET1;

import java.util.ArrayList;

public class Clause {
    /**
     * la Classe Clause représente un Objet de type Clause qui a comme paramétre @param literals
     */

    /**
     * @param literals qui content tout les littérales de la clause
     */
    ArrayList<Literal> literals;

    /**
     * Clause crée avec une liste de literals vide
     */
    public Clause() {
        literals = new ArrayList<>();
    }

    /**
     *
     * @param literal ajouter un literal a la clause
     */

    public void addLiteral(Literal literal) {
        this.literals.add(literal);
    }


    /**
     * isSatisfiable() vérifie si la clause est Satisfaisable
     * une clause est satisfaisable si tout ses littérales sont egal à 1 ;
     */

    public boolean isSatisfiable(){
        for (Literal literal: literals) {
            if(!literal.value){
                return false;
            }
        }
        return true;
    }
}





