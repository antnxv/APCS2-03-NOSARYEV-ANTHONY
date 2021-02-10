public class QueenBoard{

  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int[] i: board){
      for (int j = 0; j < size; j ++){
        i[j] = 0;
      }
    }
  }

  //private boolean addQueen(int r, int c){}

  //private void removeQueen(int r, int c){}

  //public boolean solve(){}

  //public int countSolutions(){}

  //public String toString()
}
