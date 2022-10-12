package SAT.PROJET1;

import java.util.ArrayList;

public class Literal {
    private int sommet;
    private ArrayList<Literal> literalRelation;
    // cette liste contient tout les litteraux qui sont en relation avec ce litteral


    public Literal(int sommet) {
        this.sommet = sommet;
        this.literalRelation = new ArrayList<>();
    }


    public ArrayList<Literal> getLiteralRelation() {
        return literalRelation;
    }


    public int getSommet() {
        return sommet;
    }


    public void addNeighbour(Literal literal) {
        // il ajoute un literal dans sa liste de Relation
        // ce qui veut dire que ce litteral avec this forment une clause
        for (Literal ignored : this.getLiteralRelation()) {
            // Vérifie si le literal qu'on souhaite ajouter n'est pas a l'intérieur
            if (ignored.getSommet() == literal.getSommet())
                return;
        }
        this.literalRelation.add(literal);
    }


    @Override
    public String toString() {
        if (sommet < 0)
            return "¬x" + -1 * sommet;
        return "x" + sommet;
    }
}