public class TTT {

    private int[][] winningPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, //rows
            {0,3,6}, {1,4,7}, {2,5,8}, //columns
            {0,4,8}, {2,4,6} //cross
    };
    //p1 -> 0
    //p2 -> 1
    //empty -> 2
    private int gameState[] = {2,2,2,2,2,2,2,2,2};
    private boolean currentPlayer;
    private int playerRoundCount = 0;
}
