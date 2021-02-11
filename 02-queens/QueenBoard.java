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
    if (board[0][0] != 0) throw new IllegalStateException("board must be empty");
    return solve(0, 0);
  }

  public boolean solve(int r, int c){
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

  public int countSolutions(){
    if (board[0][0] != 0) throw new IllegalStateException("board must be empty");
    return countSolutions(0, 0, 0);
  }

  public int countSolutions(int r, int c, int t){
    if (c == board.length){
      return 1;
    }
    if (r == board.length){
      if (c == 0){
        for (int[] y: board){
          for (int x: y){
            x = 0;
          }
        }
      }
      return t;
    }
    if (addQueen(r, c)){
      t += countSolutions(0, c+1, 0);
      removeQueen(r, c);
    }
    t += countSolutions(r+1, c, 0);
    return t;
  }

  public String toString(){
    String str = "";
    for (int[] i: board){
      for (int j: i){
        if (j == -1) str += "Q ";
        //else if (j > 0) str += j + " "; // debug: shows blockage multitude
        else str += "_ ";
      }
      str += "\n";
    }
    return str;
  }
}
