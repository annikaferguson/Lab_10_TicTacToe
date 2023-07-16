import java.util.Scanner;

public class TicTacToe
{
    //board array + constants that define it
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    //sets all the board elements to a space
    private static void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " "; //make this cell a space
            }
        }
    }

    //shows the Tic Tac Toe game used as part of the prompt for the user's move choice
    private static void display()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " | ";
            }
        }
    }

    // returns true if there is a space at the given proposed move coordinates which means it is a legal move
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" ")) // is it a space?
            retVal = true;
        return retVal;
    }

    // checks to see if there is a win state on the current board for the specified player
    // this method in turn calls 3 additional methods that break down the 3 kinds of possible wins
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
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
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                {
                    return true;
                } else if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                {
                    return true;
                }
            }
        }
        return false; //no diagonal win
    }

    /*checks for tie condition: all spaces on board are filled OR there is an X and an O in every win vector
    private static boolean isTie()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                if(!isColWin() && !isRowWin() && !isDiagonalWin()) // board full
                {
                    return true;
                }
            }
        }
    } */

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

    //methods over, begin coding game
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String player1 = "";
        String player2 = "";

        player1 = "X";


    }
}
