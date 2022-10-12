package SAT.PROJET1;

import java.io.FileNotFoundException;
import java.util.*;


class Graph {
    public static class Edge {
        public int source;
        public int destination;
        public String label;


        public Edge(int from, int to) {
            this.source = from;
            this.destination = to;
            this.label = Integer.toString(from);
        }

        @Override
        public String toString() {
            return
                    source +
                            " -> " + destination + "\n"
                    ;
        }
    }


    private int cardinal;
    private ArrayList<LinkedList<Edge>> incidency;

    // Constructor a partir d'une formule
    public Graph(Formule formule) {
        this.cardinal = formule.NombreDeLiterals * 2;
        // il y'aura forcement 2x nombre de litteral vu qu'on utilise le litteral et sa negation
        this.incidency = new ArrayList<LinkedList<Edge>>(this.cardinal);
        for (int i = 0; i < cardinal; i++) {
            incidency.add(i, new LinkedList<Edge>());
        }
        for (Arcs arc : formule.arcs) {
            this.addArc(arc.getFrom() - 1, arc.getTo() - 1);
            // vu que ma methode retroune des arcs de 1 jusque le nombre de litteral x 2
            // et pour pas me compliquer la tache le sommet 1 sera a l'index 0 , 2 a l'index 1 etc etc
        }
    }

    Graph(int cardinal) {
        this.cardinal = cardinal;
        incidency = new ArrayList<>(cardinal);
        for (int i = 0; i < cardinal; ++i)
            incidency.add(i, new LinkedList<>());

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(cardinal).append("\n");
        for (int i = 0; i < cardinal; i++) {
            for (Edge e : incidency.get(i)) {
                result.append(e.source).append(" -> ").append(e.destination).append("\n");
            }
        }
        return result.toString();
    }

    public int order() {
        return this.cardinal;
    }

    public Graph getTranspose() {
        // genere un graphe Transposé
        // on parcourt les sommets du graphe et on inverse les arcs si par exemple on a 1-> 2 on la transforme en 2->1
        Graph graph = new Graph(this.cardinal);
        for (int i = 0; i < cardinal; i++) {
            for (Edge e : incidency.get(i)) {
                graph.addArc(e.destination, e.source);
            }
        }
        return graph;
    }

    void addArc(int v, int w) {
        incidency.get(v).addLast(new Edge(v, w));
    }

    void DFSUtil(int v, boolean[] visited) {
        // LE PARCOURS EN PROFONDEUR
        // Marquer le nœud courant comme visité et le printer // C'est utile pour la methode printSCC qui va printer tous les composantes connexes
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        // repeter la methode pour tous les sommets adjacents a ce sommet
        Iterator<Edge> i = incidency.get(v).iterator();
        while (i.hasNext()) {
            n = i.next().destination;
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }


    void fillOrder(int v, boolean[] visited, Stack stack) {
        // marque le noeud comme visité
        visited[v] = true;

        // répèter pour tous les sommets adjacents à ce sommet
        Iterator<Edge> i = incidency.get(v).iterator();
        while (i.hasNext()) {
            int n = i.next().destination;
            if (!visited[n])
                fillOrder(n, visited, stack);
        }

        // Tous les sommets accessibles depuis v sont déjà traités,
        // pousser v vers la pile
        stack.push(new Integer(v));
    }

    // la fonction main qui print tous les composantes connexes du graphe
    void printSCCs() {
        System.out.println("Les Composantes connexes de ce graphe");
        Stack stack = new Stack();

        // Marque tous les sommets comme non visités (Pour le premier parcours en profondeur du graphe original)
        boolean[] visited = new boolean[order()];
        for (int i = 0; i < order(); i++)
            visited[i] = false;

        // Remplir les sommets de la pile apres que le sommet soit visita
        for (int i = 0; i < order(); i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        // Cree le graphe transposé
        Graph gr = getTranspose();

        // Marque tous les sommets comme non visités Pour le deuxième parcours en profondeur du graphe transposé
        for (int i = 0; i < order(); i++)
            visited[i] = false;

        // Traiter maintenant tous les sommets dans l'ordre défini par la pile
        while (!stack.empty()) {
            // Pop un sommet de la pile
            int v = (int) stack.pop();

            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                // il fait le DFS POUR LE sommet v et grace au Graphe transposé le parcours en profondeur a partir de
                // ce sommet donnera une des composantes connexe du graphe Original
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        // TEST DE LA METHODE QUI PRINT TOUTES LES COMPOSANTES CONNEXES DES GRAPHES sur des EXEMPLES
        /*
        Graph g1 = new Graph(5);

        g1.addArc(1, 0);
        g1.addArc(0, 2);
        g1.addArc(2, 1);
        g1.addArc(0, 3);
        g1.addArc(3, 4);

        g1.printSCCs();
        System.out.println("----------------------------------------------------------------------------");

        Graph g2 = new Graph(4);
        g2.addArc(0, 1);
        g2.addArc(1, 2);
        g2.addArc(2, 3);
        g2.printSCCs();
        System.out.println("----------------------------------------------------------------------------");

        Graph g3 = new Graph(7);
        g3.addArc(0, 1);
        g3.addArc(1, 2);
        g3.addArc(2, 0);
        g3.addArc(1, 3);
        g3.addArc(1, 4);
        g3.addArc(1, 6);
        g3.addArc(3, 5);
        g3.addArc(4, 5);
        g3.printSCCs();
        System.out.println("----------------------------------------------------------------------------");

        Graph g4 = new Graph(11);
        g4.addArc(0, 1);
        g4.addArc(0, 3);
        g4.addArc(1, 2);
        g4.addArc(1, 4);
        g4.addArc(2, 0);
        g4.addArc(2, 6);
        g4.addArc(3, 2);
        g4.addArc(4, 5);
        g4.addArc(4, 6);
        g4.addArc(5, 6);
        g4.addArc(5, 7);
        g4.addArc(5, 8);
        g4.addArc(5, 9);
        g4.addArc(6, 4);
        g4.addArc(7, 9);
        g4.addArc(8, 9);
        g4.addArc(9, 8);
        g4.printSCCs();
        System.out.println("----------------------------------------------------------------------------");

        Graph g5 = new Graph(5);
        g5.addArc(0, 1);
        g5.addArc(1, 2);
        g5.addArc(2, 3);
        g5.addArc(2, 4);
        g5.addArc(3, 0);
        g5.addArc(4, 2);
        g5.printSCCs();
        System.out.println("----------------------------------------------------------------------------");


         */
        Formule formule = new Formule("src/SAT/PROJET1/formule-2-sat.txt");
        System.out.println(formule);
        Graph graph = new Graph(formule);

        //graph.printSCCs();


    }


}
