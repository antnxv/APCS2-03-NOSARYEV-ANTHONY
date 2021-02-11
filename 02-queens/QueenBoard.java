public class QueenBoard{

  private int[][] board;

  public QueenBoard(int length){
    board = new int[length][length];
    for (int[] y: board){
      for (int x: y){
        x = 0;
      }
    }
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0) return false;
    for (int y = 0; y < board.length; y ++){
      for (int x = c; x < board.length; x ++){
        if (x == c || y == r || Math.abs(x-c) == Math.abs(y-r)){
          board[y][x] ++;
        }
      }
    }
    board[r][c] = -1;
    return true;
  }

  private void removeQueen(int r, int c){
    for (int y = 0; y < board.length; y ++){
      for (int x = c; x < board.length; x ++){
        if (x == c || y == r || Math.abs(x-c) == Math.abs(y-r)){
          board[y][x] --;
        }
      }
    }
    board[r][c] = 0;
  }

  public boolean solve(){
    return solve(0, 0);
  }

  public boolean solve(int r, int c){
    if (board[0][0] != 0) throw new IllegalStateException("board must be empty");
    if (c == board.length) return true;
    if (r == board.length){
      if (c == 0){
        for (int[] y: board){
          for (int x: y){
            x = 0;
          }
        }
      }
      return false;
    }
    if (addQueen(r, c)){
      if (solve(0, c+1)){
        return true;
      }else{
        removeQueen(r, c);
        return solve(r+1, c);
      }
    }
    return solve(r+1, c);
  }

  //public int countSolutions(){}

  public String toString(){
    String str = "";
    for (int[] i: board){
      for (int j: i){
        if (j == -1) str += "Q ";
        //else if (j > 0) str += j + " ";
        else str += "_ ";
      }
      str += "\n";
    }
    return str;
  }
}
