package SAT.PROJET1.java;

import java.util.ArrayList;

public class Clause {
    ArrayList<Litteral> litteraux;


    public Clause(){
        this.litteraux = new ArrayList<>();
    }

    public void addLiteral(Litteral litteral){
        this.litteraux.add(litteral);
    }

    public void removeLiteral(Litteral litteral){
        litteraux.remove(litteral);
    }

    public void removeLiteral(int variable){
        for(Litteral litteral : litteraux){
            if(litteral.getVariable() == variable){
                litteraux.remove(litteral);
                return;
            }
        }
    }


    public boolean evaluer(){
        int nombreLitterauxVrai = 0;
        for (Litteral litteral : litteraux) {
            if (litteral.evaluer()) {
                nombreLitterauxVrai++;
            }
        }
        return nombreLitterauxVrai >= 1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("(");

        for(int i = 0 ; i < litteraux.size()-1 ; i++){
            str.append(litteraux.get(i)).append(" U ");
        }
        str.append(litteraux.get(litteraux.size()-1));

        str.append(")");
        return str.length() == 0
                ? null
                : str.substring(0, str.length());
    }

    public ArrayList<Litteral> getLitteraux() {
        return litteraux;
    }

    public Litteral getLitteral(int variable) {
        for(Litteral litteral : litteraux){
            if(litteral.getVariable() == variable){
                return litteral;
            }
        }
        return null;
    }

    public void setLitteraux(ArrayList<Litteral> litteraux) {
        this.litteraux = litteraux;
    }
}


