import java.util.Scanner;

public class TicTacToe
{
    //board array + constants that define it
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int row = 0;
        int col = 0;
        String P1 = "Player 1";
        String P2 = "Player 2";
        String player1 = "X";
        String player2 = "O";

        String currentPlayer = player1;
        String currentPlayerString = "";
        int moveNumber = 0;

        do {
            moveNumber = 0;
            clearBoard();
            display();

            for (int x = 0; x < 9; x++) {
                if (x % 2 == 0) {
                    currentPlayer = player1;
                    currentPlayerString = P1;
                } else {
                    currentPlayer = player2;
                    currentPlayerString = P2;
                }
                System.out.printf("\n%s - it is your turn.\n", currentPlayerString);

                do {
                    row = SafeInput.getRangedInt(in, "Enter your row coordinate", 1 - 1, 3 - 1);
                    col = SafeInput.getRangedInt(in, "Enter your column coordinate", 1 - 1, 3 - 1);
                } while (!isValidMove(row, col));
                moveNumber += 1;
                board[row][col] = currentPlayer;
                display();

                if (moveNumber >= 5) {
                    if (isWin(currentPlayer)) {
                        System.out.printf("%s wins!", currentPlayerString);
                        break;
                    } else if (moveNumber >= 7) {
                        if (isTie()) {
                            System.out.println("Tie!");
                            break;
                        }
                    }
                }
            }

            if (player1.equals("X")) {
                player1 = "O";
                player2 = "X";
            } else {
                player1 = "X";
                player2 = "O";
            }

        } while (SafeInput.getYNConfirm(in, "Would you like to play again?"));
    }


    //sets all the board elements to a space
    private static void clearBoard()
    {
        for(int x = 0; x < ROW; x++) {
            for (int c = 0; c < COL; c++) {
                board[x][c] = " ";
            }
        }
    }

    //shows the Tic Tac Toe game used as part of the prompt for the user's move choice
    private static void display()
    {
        String displayBoard = "";
        for(int x = 0; x < ROW; x++)
        {
            for (int c = 0; c < COL; c++)
            {
                if(c == COL - 1)
                {
                    displayBoard += board[x][c];
                } else {
                    displayBoard += board[x][c] + "|";
                }
            }
            if(x != ROW - 1)
            {
                displayBoard += "\n-+-+-\n";
            }
        }
        System.out.println(displayBoard);
    }

    // returns true if there is a space at the given proposed move coordinates which means it is a legal move
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" ")) // is it a space?
            retVal = true;
        return retVal;
    }

    // checks for col win
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; //no col win
    }

    // checks for row win
    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }

    // checks for a diagonal win for the specified player
    private static boolean isDiagonalWin(String player)
    {
        if((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)))
        {
            return true;
        } else {
            return false;
        }
    }

        // checks to see if there is a win state on the current board for the specified player
        // this method in turn calls 3 additional methods that break down the 3 kinds of possible wins
        private static boolean isWin(String player)
        {
            if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
            {
                return true;
            } else {
                return false;
            }
        }

        // start tie methods
        private static boolean tieRows()
        {
            int countX = 0;
            int countO = 0;
            int numDeadWinVectors = 0;

            for(int x = 0; x < ROW; x++)
            {
                countX = 0;
                countO = 0;
                for(int c = 0; c < COL; c++)
                {
                    if(board[x][c].equals(" X "))
                    {
                        countX++;
                    } else if(board[x][c].equals(" O "))
                    {
                        countO++;
                    }
                    if(countX >= 1 && countO >= 1)
                    {
                        numDeadWinVectors++;
                    }
                }
            }
            if(numDeadWinVectors >= 3)
            {
                return true;
            } else {
                return false;
            }
        }

        private static boolean tieCols()
        {
            int countX = 0;
            int countO = 0;
            int numDeadWinVectors = 0;

            for(int x = 0; x < ROW; x++)
            {
                countX = 0;
                countO = 0;
                for(int c = 0; c < COL; c++)
                {
                    if(board[c][x].equals(" X "))
                    {
                        countX++;
                    } else if(board[c][x].equals(" O "))
                    {
                        countO++;
                    }
                    if(countX >= 1 && countO >= 1)
                    {
                        numDeadWinVectors++;
                    }
                }
            }

            if(numDeadWinVectors >= 3)
            {
                return true;
            } else {
                return false;
            }
        }

        private static boolean tieDiagonalDown()
        {
            int countX = 0;
            int countO = 0;

            for(int x = 0; x < ROW; x++)
            {
                if(board[x][x].equals(" X "))
                {
                    countX++;
                } else if(board[x][x].equals(" O "))
                {
                    countO++;
                }
            }
            if(countX >= 1 && countO >= 1)
            {
                return true;
            } else {
                return false;
            }
        }

        private static boolean tieDiagonalUp()
        {
            int countX = 0;
            int countO = 0;

            if(board[0][2].equals(" X "))
            {
                countX++;
            } else if(board[0][2].equals(" O "))
            {
                countO++;
            }
            if(board[1][1].equals(" X "))
            {
                countX++;
            } else if(board[1][1].equals(" O "))
            {
                countO++;
            }
            if(board[2][0].equals(" X "))
            {
                countX++;
            } else if(board[2][0].equals(" O "))
            {
                countO++;
            }
            if(countX >= 1 && countO >= 1)
            {
                return true;
            } else {
                return false;
            }
        }

        //checks for tie condition: all spaces on board are filled OR there is an X and an O in every win vector
        private static boolean isTie()
        {
            int count = 0;
            if(tieRows())
            {
                count++;
            }
            if(tieCols())
            {
                count++;
            }
            if(tieDiagonalDown())
            {
                count++;
            }
            if(tieDiagonalUp())
            {
                count++;
            }
            if(count >= 3)
            {
                return true;
            }
            return false;
        }


    /**
     *  1. Clear the board, move count to 0 and set the player to X (X always moves first)
     *  2. Show the board, get the coordinates for the move (1-3) for row and col
     *  3. Convert the player move to the array indices (0-2) by subtracting 1
     *  4. Loop through #2 and #3 until the converted player coordinates are a valid move
     *  5. Record the move on the board and increment the move counter
     *  6. If appropriate, check for a win or tie (after move 5)
     *  7. If there is a win or a tie, announce it. Prompt the players to play again or exit
     *  8. Toggle the player for the next move (i.e. X becomes O, O becomes X)
     */

    }

