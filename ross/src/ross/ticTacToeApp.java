package ross;

import java.util.Scanner;

public class ticTacToeApp {
  static final String X = "X";
  static final String O = "O";
  static final String N = " ";

  public static void main(String[] args) {
    String[] board = { X,X,O,
        N,O,N,
        O,N,N };

    // combinations to win: 
    int[][] wins = { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,6,8}, {0,4,8}, {2,4,6} };

    // count x's and o's to win
    int x=0, o=0;

    // find the winner by indexing the board array from the combinations to win array
    // In each combination to win, if all 3 are X's or O's, declare a winner

    for(int i=0; i<8; i++) {
      x=0; o=0;
      for(int j=0;j<3;j++) {
        if (board[wins[i][j]] == X) x++;          
        if (board[wins[i][j]] == O) o++;    
      }
      if (o==3 || x==3) 
        System.out.println(((x==3) ? "X" : "O") + " wins");
    }
  }
}

