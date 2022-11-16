package SAT.PROJET3.java;

import java.io.*;

//

//

/*
Représenter solution :
Ex si on a que 2 ou 9 pour une case spécifique, on la représente de cette manière :
-Vij1 ^ Vij2 ^ -Vij3 ^ -Vij4 ^ -Vij5 ^ -Vij6 ^ -Vij7 ^ -Vij8 ^ -Vij9  V
-Vij1 ^ -Vij2 ^ -Vij3 ^ -Vij4 ^ -Vij5 ^ -Vij6 ^ -Vij7 ^ -Vij8 ^ Vij9

 */

public class Sudoku {
    int[][] grille;

    public Sudoku(String fileSudoku) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileSudoku));
        String currentLine;
        int tailleZone = Integer.parseInt(reader.readLine());
        int tailleSudoku = (int) Math.pow(tailleZone,2);
        grille = new int[tailleSudoku][tailleSudoku];

        int index = 0;
        while((currentLine = reader.readLine()) != null){
            String[] valeursLignes = currentLine.split(" ");
            for(int i = 0 ; i < grille.length ; i++){
                grille[index][i] = Integer.parseInt(valeursLignes[i]);
            }
            if(grille[index].length < tailleSudoku){
                throw new Exception("Le sudoku n'a pas assez de lignes pour atteindre la taille demandé, qui est de " + tailleSudoku);
            }
            else if(grille[index].length > tailleSudoku){
                throw new Exception("Le sudoku dépasse le nombre de colonnes autorisé");
            }
            index++;
        }
        if(index < tailleSudoku){
            throw new Exception("Le sudoku n'a pas assez de lignes pour atteindre la taille demandé, qui est de " + tailleSudoku);
        }
        else if(index > tailleSudoku){
            throw new Exception("Le sudoku dépasse le nombre de lignes autorisé");
        }
    }

    public void verificationSudoku(){
        for(int i = 0 ; i < grille.length ; i++){
            for(int j = 0 ; j < grille.length ; j++){
                if(grille[i][j] == 0){

                }
            }
        }
    }

}
