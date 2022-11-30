import SAT.PROJET3.java.Sudoku;

public class Main {
    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku("src/SAT/PROJET3/java/sudoku2.txt");
        sudoku.verificationSudoku();
    }
}