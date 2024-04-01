#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define PUZZLE_SIZE 9
#define BOX_SIZE 3
#define EMPTY_CELL 0

typedef int SudokuBoard[PUZZLE_SIZE][PUZZLE_SIZE];

void loadSudokuBoard(SudokuBoard s) {
    for (int i = 0; i < PUZZLE_SIZE; i++) {
        for (int j = 0; j < PUZZLE_SIZE; j++) {
            if(scanf("%d", &(s[i][j])) != 1) {
                fprintf(stderr, "Invalid input");
                exit(1);
            }
        }
    }
}

void printFrame(void) {
    putchar('+');

    for (int i = 0; i < 3 * PUZZLE_SIZE + 2; i++) {
        putchar('-');
    }

    putchar('+');
    putchar('\n');
}

void printSudokuBoard(SudokuBoard s) {
    printFrame();

    for (int i = 0; i < PUZZLE_SIZE; i++) {
        putchar('|');
        for (int j = 0; j < PUZZLE_SIZE; j++) {
            printf(" %d ", s[i][j]);
            if (j % 3 == 2) {
                putchar('|');
            }
        }
        putchar('\n');
        if (i % 3 == 2) {
            printFrame();
        }
    }
}

bool findEmptyCell(SudokuBoard s, int *row, int *column) {
    for (int i = 0; i < PUZZLE_SIZE; i++) {
        for (int j = 0; j < PUZZLE_SIZE; j++) {
            if (s[i][j] == EMPTY_CELL) {
                *row = i;
                *column = j;
                return true;
            }
        }
    }
    return false;
}

bool isValidRow(SudokuBoard s, int row, int digit) {
    for (int i = 0; i < PUZZLE_SIZE; i++) {
        if(s[row][i] == digit) {
            return false;
        }
    }
    return true;
}

bool isValidColumn(SudokuBoard s, int column, int digit) {
    for (int i = 0; i < PUZZLE_SIZE; i++) {
        if(s[i][column] == digit) {
            return false;
        }
    }
    return true;
}

bool isValidBox(SudokuBoard s, int row, int column, int digit) {
    int boxRow = row - (row % BOX_SIZE);
    int boxColumn = column - (column % BOX_SIZE);

    for(int i = 0; i < BOX_SIZE; i++) {
        for(int j = 0; j < BOX_SIZE; j++) {
            if (s[boxRow + i][boxColumn + j] == digit) {
                return false;
            }
        }
    }
    return true;
}

bool isValidDigit(SudokuBoard s, int row, int column, int digit) {
    return  isValidRow(s, row, digit) &&
            isValidColumn(s, column, digit) &&
            isValidBox(s, row, column, digit);
}

bool solveSudoku(SudokuBoard s) {
    int row = 0;
    int column = 0;

    if (!findEmptyCell(s, &row, &column)) {
        return true;
    }

    for (int digit = 1; digit <= PUZZLE_SIZE; digit++) {
        if (isValidDigit(s, row, column, digit)) {
            s[row][column] = digit;

            if(solveSudoku(s)) {
                return true;
            }

            s[row][column] = EMPTY_CELL;
        }
    }

    return false;
}

int main(void) {
    SudokuBoard s;
    loadSudokuBoard(s);

    bool isSolved = solveSudoku(s);
    if (isSolved) {
        printf("\nFOUND SOLUTION\n\n");
        printSudokuBoard(s);
    }
    else {
        printf("NO SOLUTION\n");
    }

    return 0;
}
