package SAT.PROJET1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Formule {

    public int NombreDeLiterals;
    private int NombreDeClauses;
    public ArrayList<Arcs> arcs;
    Literal[] literalArray;

    Formule(String path) throws FileNotFoundException {
        Integer[] params = getParams(path);
        this.literalArray = new Literal[params[0] * 2];
        this.NombreDeClauses = params[1];
        this.NombreDeLiterals = params[0];
        this.literalArray = getLiteral(params[0], path);
        this.arcs = genArcs();
    }

    /* Cette methode retourne depuis le fichier text les deux premiers
        parametres dans un tableau qui sont le nombre de litteraux + le nombre de clause
        qui sont les deux premier INTEGERS DU FICHIER TEXT
     */
    public Integer[] getParams(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(path));
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        Integer[] params = new Integer[2];
        params[0] = scanner.nextInt(); // a l'index 0 on a le nombre de litterals
        params[1] = scanner.nextInt();// a l'index 1 on a le nombre de clauses
        return params;
    }
    // cette methode retorune tous les litterals du fichier text
    public static ArrayList<Integer> getAllIntFromString(String str) {
        /*
        cette methode
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] stringArrayList = str.split(" ");
        for (String string : stringArrayList) {
            if (!Objects.equals(string, "0"))
                arrayList.add(Integer.parseInt(string));
        }
        return arrayList;
    }
    // Cette methode retourne un tableau de litteral qui sont dans chaque ligne du fichier text
    // (chaque ligne du fichier txt forme une clause )
    // ou chaque litteral contient le second literal avec lequel il forme une clause
    public Literal[] getLiteral(int NumberDeLiteral, String path) throws FileNotFoundException {
        Literal[] Literals = new Literal[2 * NumberDeLiteral + 1];
        Scanner scanner = new Scanner(new FileReader(path));
        int index1 = 0, index2 = 0;
        Stack<Integer> Indexs = new Stack<>();
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        scanner.nextLine(); // la premiere ligne d'entier contient le nombre de clause et de literal dont on a pas besoin
        while (scanner.hasNextLine()) {
            for (Integer lit : getAllIntFromString(scanner.nextLine())) {
                /* on utilise la methode getAllIntFromString qui retoune un Arraylist pour capturer
                les deux litterals de chaque ligne et ignorer le 0 et donc on aura une liste qui contient 2 Integer

                 */
                if (lit > 0) {
                    index1 = lit;
                    Indexs.add(index1);
                    if (Literals[index1] == null) {
                        Literals[index1] = new Literal(lit);
                    }
                } else if (lit < 0) {
                    index2 = -1 * lit + NumberDeLiteral;
                    Indexs.add(index2);
                    if (Literals[index2] == null) {
                        Literals[index2] = new Literal(lit);
                    }
                }
            }
            Literals[Indexs.pop()].addNeighbour(Literals[Indexs.pop()]);

        }
        return Literals;

    }
    // cette methode genere les ARCS depuis le tableau des litterals
    // en exemple si le litteral 1 et le litteral 2 forme une clause
    // on va ajouter dans ce tabeau l arc -1 -> 2 && -2 -> 1 etc etc
    public ArrayList<Arcs> genArcs() {
        ArrayList<Arcs> arcs = new ArrayList<>();
        for (Literal literal : this.literalArray) {
            if (literal != null && !literal.getLiteralRelation().isEmpty()) {
                for (Literal lit : literal.getLiteralRelation()) {
                    arcs.add(new Arcs(genArcFromLiteral(-1 * lit.getSommet()), genArcFromLiteral(literal.getSommet())));
                    arcs.add(new Arcs(genArcFromLiteral(-1 * literal.getSommet()), genArcFromLiteral(lit.getSommet())));
                }
            }
        }
        return arcs;
    }

    public int genArcFromLiteral(int use) {
        if (use < 0) {
            return -1  * use + this.NombreDeLiterals;
        }
        return use;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        for (Literal literal : this.literalArray) {
            if (literal != null)
                for (Literal literal1 : literal.getLiteralRelation())
                    stringBuilder.append("( ").append(literal).append(" ∧ ").append(literal1).append(" ) , ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }



}