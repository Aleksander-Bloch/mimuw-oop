import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int PUZZLE_SIZE = 9;
        int[][] sudokuBoard = new int[PUZZLE_SIZE][PUZZLE_SIZE];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            for (int j = 0; j < PUZZLE_SIZE; j++) {
                sudokuBoard[i][j] = scanner.nextInt();
            }
        }

        Sudoku sudoku = new Sudoku(sudokuBoard);
        boolean isSolved = sudoku.solveSudoku();

        if (isSolved) {
            System.out.println("\nFOUND SOLUTION\n");
            System.out.println(sudoku);
        }
        else {
            System.out.println("\nNO SOLUTION");
        }
    }
}
