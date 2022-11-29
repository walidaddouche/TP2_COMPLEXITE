package SAT.PROJET1.java;

public class Litteral {
    private int variable;
    private boolean estVrai; // Indiquer si la variable vaut 0 ou 1 (sans prendre en compte son signe "-" devant s'il y est).
    // 0 = false et 1 = true


    public Litteral(int variable, boolean estVrai) {
        if(variable == 0){
            this.variable = 1;
        }
        else{
            this.variable = variable;
        }
        this.variable = variable;
        this.estVrai = estVrai;
    }


    public Litteral(int variable) {
        this(variable, true);
    }

    public boolean getEtat(){
        return estVrai;
    }

    public void setEtat(boolean estVrai) {
        this.estVrai = estVrai;
    }

    public int getVariable() {
        return variable;
    }

    public void setVariable(int variable) {
        if(variable == 0)
            System.err.println("Un litteral ne peut pas être représentée par 0");
        else
            this.variable = variable;
    }

    public boolean evaluer(){
        boolean estPositif = variable >= 0;
        if(!estVrai)
            estPositif = !estPositif;
        return estPositif;
    }


    public boolean compareLiteral(Litteral literal2){
        return (variable == literal2.variable) && (estVrai == literal2.estVrai);
    }

    @Override
    public String toString() {
        int variableAffichage = variable;
        boolean estPositif = true;
        if(variable < 0) {
            estPositif = false;
            variableAffichage = Math.abs(variable) ;
        }
        if(!estVrai)
            estPositif = !estPositif;
        if(estPositif)
            return "" + variableAffichage;
        return "¬" + variableAffichage;
    }

}