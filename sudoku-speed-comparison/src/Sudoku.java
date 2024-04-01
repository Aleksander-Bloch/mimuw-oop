import java.util.Arrays;

public class Sudoku {
    private int[][] board;
    final int PUZZLE_SIZE = 9;
    final int EMPTY_CELL = 0;
    final int BOX_SIZE = 3;

    public Sudoku(int[][] sudokuBoard) {
        board = Arrays.copyOfRange(sudokuBoard, 0, sudokuBoard.length);
    }

    private boolean isValidRow(int row, int digit) {
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            if(board[row][i] == digit) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(int column, int digit) {
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            if(board[i][column] == digit) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBox(int row, int column, int digit) {
        int boxRow = row - (row % BOX_SIZE);
        int boxColumn = column - (column % BOX_SIZE);

        for(int i = 0; i < BOX_SIZE; i++) {
            for(int j = 0; j < BOX_SIZE; j++) {
                if (board[boxRow + i][boxColumn + j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidDigit(int row, int column, int digit) {
        return  isValidRow(row, digit) &&
                isValidColumn(column, digit) &&
                isValidBox(row, column, digit);
    }

    public boolean solveSudoku() {
        int row = 0;
        int column = 0;
        boolean emptyCellFound = false;

        for (int i = 0; i < PUZZLE_SIZE && !emptyCellFound; i++) {
            for (int j = 0; j < PUZZLE_SIZE && !emptyCellFound; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    row = i;
                    column = j;
                    emptyCellFound = true;
                }
            }
        }

        if(!emptyCellFound) {
            return true;
        }

        for (int digit = 1; digit <= PUZZLE_SIZE; digit++) {
            if (isValidDigit(row, column, digit)) {
                board[row][column] = digit;

                if(solveSudoku()) {
                    return true;
                }

                board[row][column] = EMPTY_CELL;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("+");
        stringBuilder.append("-".repeat(3 * PUZZLE_SIZE + 2));
        stringBuilder.append("+");
        stringBuilder.append("\n");

        for (int i = 0; i < PUZZLE_SIZE; i++) {
            stringBuilder.append("|");
            for (int j = 0; j < PUZZLE_SIZE; j++) {
                stringBuilder.append(" ").append(board[i][j]).append(" ");
                if (j % 3 == 2) {
                    stringBuilder.append("|");
                }
            }
            stringBuilder.append("\n");
            if (i % 3 == 2) {
                stringBuilder.append("+");
                stringBuilder.append("-".repeat(3 * PUZZLE_SIZE + 2));
                stringBuilder.append("+");
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
