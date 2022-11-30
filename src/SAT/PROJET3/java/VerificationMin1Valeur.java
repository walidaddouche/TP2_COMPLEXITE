package SAT.PROJET3.java;

import SAT.PROJET1.java.Clause;
import SAT.PROJET1.java.Formule;

public class VerificationMin1Valeur implements Verification{
  Sudoku sudoku;

  public VerificationMin1Valeur(Sudoku sudoku){
    this.sudoku = sudoku;
  }

  public boolean effectuerVerification(){
    Formule formule = new Formule();
    for(int i = 0 ; i < sudoku.getTaillePuissance() ; i++){
      for(int j = 0 ; j < sudoku.getTaillePuissance() ; j++){
        for(int m = 0 ; m < sudoku.getTaillePuissance() ; m++){
          for(int n = 0 ; n < sudoku.getTaillePuissance() ; n++){
            if(m != n){
              Clause clause = new Clause();

            }
          }
        }
      }
    }
    return true;
  }
}
