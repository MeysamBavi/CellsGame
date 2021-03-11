public class Cells {
    private int rows;
    private int cols;
    private char[][] cellsTable;
    private boolean turn = false;
    private int forWin;
    //player 1
    private char p1;
    //player 2
    private char p2;
    private boolean weHaveAWinner = false;
    private Cells(int rows, int cols, char player1, char player2) {
        this.rows = rows;
        this.cols = cols;
        forWin = 4;
        if (player1 != player2) {
            p1 = player1;
            p2 = player2;
        } else {
            p1 = 'x';
            p2 = 'o';
        }
        cellsTable = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cellsTable[i][j] = ' ';
            }
        }
    }
    public Cells() {
        this(6,7,'x','o');
    }

    public Cells(char player1, char player2) {
        this(6, 7, player1, player2);
    }

    private Cells(int rows, int cols) {
        this(rows, cols, 'x', 'o');
    }

    void printTable() {
        for (int i = 0; i < rows; i++) {
            int j = 0;
            System.out.print(cellsTable[i][j]);
            for (j = 1; j < cols; j++) {
                System.out.print("|" + cellsTable[i][j]);
            }
            System.out.println();
            for (int k = 0; k < 2*cols - 1 && i < rows - 1; k++) {
                System.out.print(k%2==0 ? '-' : '+');
            }
            if (i < rows - 1) {
                System.out.println();
            }
        }
        for (int i = 0; i < cols; i++) {
            System.out.print(i+1 + " ");
        }
        System.out.println();
    }
    public char getTurn() {
        return (turn ? p2 : p1);
    }
    public boolean checkWinner() {
        //4 in a row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j + forWin - 1 < cols; j++) {

                for (int k = 1; k < forWin; k++) {
                    if (cellsTable[i][j] == ' ' || cellsTable[i][j+k] == ' ') {
                        break;
                    }
                    if (cellsTable[i][j]!=cellsTable[i][j+k]) {
                        break;
                    } else if (k==forWin-1) {
                        weHaveAWinner = true;
                        return true;
                    }
                }
            }
        }

        //4 in a column
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j + forWin - 1 < rows; j++) {

                for (int k = 1; k < forWin; k++) {
                    if (cellsTable[j][i] == ' ' || cellsTable[j+k][i] == ' ') {
                        break;
                    }
                    if (cellsTable[j][i]!=cellsTable[j+k][i]) {
                        break;
                    } else if (k==forWin-1) {
                        weHaveAWinner = true;
                        return true;
                    }
                }
            }
        }

        //4 in backslash
        for (int i = 0; i + forWin - 1 < rows; i++) {
            for (int j = 0; j + forWin - 1 < cols ; j++) {

                for (int k = 1; k < forWin; k++) {
                    if (cellsTable[i][j] == ' ' || cellsTable[i+k][j+k] == ' ') {
                        break;
                    }
                    if (cellsTable[i][j]!=cellsTable[i+k][j+k]) {
                        break;
                    } else if (k==forWin-1) {
                        weHaveAWinner = true;
                        return true;
                    }
                }
            }
        }

        //4 in slash
        for (int i = 0; i + forWin - 1 < rows; i++) {
            for (int j = forWin - 1; j < cols; j++) {

                for (int k = 1; k < forWin; k++) {
                    if (cellsTable[i][j] == ' ' || cellsTable[i+k][j-k] == ' ') {
                        break;
                    }
                    if (cellsTable[i][j]!=cellsTable[i+k][j-k]) {
                        break;
                    } else if (k==forWin-1) {
                        weHaveAWinner = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean play(int column) {
        if (column >= cols || column < 0) {
            return false;
        }
        for (int i = rows-1; i >= 0; i--) {
            if (cellsTable[i][column] == ' ') {
                cellsTable[i][column] = getTurn();
                turn = !turn;
                return true;
            }
        }
        return false;
    }

    public char getWinner() {
        if (weHaveAWinner) {
            return (turn ? p1 : p2);
        }
        return '\0';
    }

}
