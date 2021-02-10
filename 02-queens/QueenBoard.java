public class QueenBoard{

  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int[] y: board){
      for (int x = 0; x < size; x ++){
        y[x] = 0;
      }
    }
  }

  public boolean addQueen(int r, int c){
    if (board[c][r] != 0) return false;
    for (int y = 0; y < board.length; y ++){
      for (int x = r; x < board.length; x ++){
        if (x == r || y == c || Math.abs(x-r) == Math.abs(y-c)){
          board[y][x] ++;
        }
      }
    }
    board[c][r] = -1;
    return true;
  }

  public void removeQueen(int r, int c){
    for (int y = 0; y < board.length; y ++){
      for (int x = r; x < board.length; x ++){
        if (x == r || y == c || Math.abs(x-r) == Math.abs(y-c)){
          board[y][x] --;
        }
      }
    }
    board[c][r] = 0;
  }

  //public boolean solve(){}

  //public int countSolutions(){}

  public String toString(){
    String str = "";
    for (int[] i: board){
      for (int j: i){
        if (j == -1) str += "Q ";
        else if (j > 0) str += j + " ";
        else str += "_ ";
      }
      str += "\n";
    }
    return str;
  }
}
