package SAT.PROJET1.java;

public class Litteral {
    private int variable;

    Variables ensembleVariables;


    public Litteral(int variable, Variables ensembleVariables) {
        if(variable == 0){
            this.variable = 1;
        }
        else{
            this.variable = variable;
        }
        this.ensembleVariables = ensembleVariables;
    }


    public boolean getEtat(){
        return ensembleVariables.estVariableVraie(variable);
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
        if(!getEtat())
            estPositif = !estPositif;
        return estPositif;
    }


    @Override
    public String toString() {
        int variableAffichee = Math.abs(variable);
        if(variable < 0) {
            return "¬" + Math.abs(variableAffichee);
        }
        return "" + variableAffichee;
    }

}