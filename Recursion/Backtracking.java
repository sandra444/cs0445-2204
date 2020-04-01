import java.util.Arrays;

public class Backtracking {
  private static final int N_DIGITS = 4;
  private static final int BOARD_SIZE = 8;
  private static final int SUDOKU_BOARD_SIZE = 9;
  public static void main(String[] args){
    new Backtracking();
  }

  public Backtracking(){
    nQueens();
    //pinCrack();
  }

  public void pinCrack(){
    solvePIN(0, "");
  }

  private void solvePIN(int digitNo, String pin){
    if(digitNo >= N_DIGITS){
      System.out.println(pin);
      System.out.println("-------");
      //System.exit(0);//one solution only
      return;//all solutions
    }

    for(int i=0; i<=9; i++){//possible choices
      if(isValidPin(digitNo, pin, i)){//is valid?
        pin = pin + i;//apply the choice
        solvePIN(digitNo + 1, pin);//recurse on the next decision
        pin = pin.substring(0, pin.length()-1);//undo the choice
      }
    }
  }

  private boolean isValidPin(int digitNo, String pin, int i){
    if(i == 0 && pin.indexOf('0') != -1){
      return false;
    }
    return true;
  }

  public void nQueens(){
    Character[][] board = new Character[BOARD_SIZE][BOARD_SIZE];
    for(int i=0; i<BOARD_SIZE; i++){
      for(int j=0; j<BOARD_SIZE; j++){
        board[i][j] = '-';
      }
    }
    solveNQueens(0, board);
  }

  private void solveNQueens(int queenNo, Character[][] board){
    if(queenNo == BOARD_SIZE){
      printBoard(board);
      System.out.println("---------------------");
      System.exit(0);
      //return;
    }

    for(int i=0; i<BOARD_SIZE; i++){
      if(isValidNQueens(queenNo, board, i)){
        board[i][queenNo] = 'Q';
        solveNQueens(queenNo+1, board);
        board[i][queenNo] = '-';
      }
    }
  }

  private boolean isValidNQueens(int queenNo,
                                        Character[][] board, int row){
      //check the row
      for(int col=0; col<queenNo; col++){
        if(board[row][col].equals('Q')){
          return false;
        }
      }

      //check the column (already taken care of by design)

      //check the left diagonal
      int r = row+1;
      int c = queenNo-1;
      while(r <= BOARD_SIZE-1 && c >= 0){
        if(board[r][c].equals('Q')){
          return false;
        }
        r++;
        c--;
      }

      //check the right diagonal
      r = row-1;
      c = queenNo-1;
      while(r >= 0 && c >= 0){
        if(board[r][c].equals('Q')){
          return false;
        }
        r--;
        c--;
      }

      return true;
  }

  private <T> void printBoard(T[][] board){
    for(int i=0; i<board.length; i++){
      System.out.println(Arrays.toString(board[i]));
    }
  }

  private void solveSudoku(int row, int col, Integer[][] board){
    if(row == SUDOKU_BOARD_SIZE){
      printBoard(board);
      System.exit(0);
      //return;
    }

    for(int i=1; i<=9; i++){
      if(isValidSudoku(row, col, board, i)){
        board[row][col] = i;
        if(col == SUDOKU_BOARD_SIZE-1){
          solveSudoku(row+1, 0, board);
        } else {
          solveSudoku(row, col+1, board);
        }
        board[row][col] = 0;
      }
    }
  }

  private boolean isValidSudoku(int row, int col, Integer[][] board, int i){
    //check the row
    for(int c=0; c<col; c++){
      if(board[row][c].equals(i)){
        return false;
      }
    }

    //check the column
    for(int r=0; r<row; r++){
      if(board[r][col].equals(i)){
        return false;
      }
    }

    //TODO: check the 3x3 box


    return true;
  }


}
