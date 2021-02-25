import java.util.*;
import java.io.*;
public class Maze{

  private char[][] maze;
  private boolean animate;

  public Maze(String filename) throws FileNotFoundException{
    File raw = new File(filename);
    Scanner line = new Scanner(raw);
    int height = 0;
    int width = 0;
    while (line.hasNextLine()){
      height ++;
      String curr = line.nextLine();
      if (curr.length() > width){
        width = curr.length();
      }
    }
    maze = new char[height][width];
    line = new Scanner(raw);
    for (int i = 0; i < height; i ++){
      String spot = line.nextLine();
      for (int j = 0; j < width; j ++){
        maze[i][j] = spot.charAt(j);
      }
    }
    animate = false;
  }

  private void wait(int millis){
    try{
      Thread.sleep(millis);
    }catch (InterruptedException e){
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    System.out.println("\033[2J");
  }

  public static void gotoTop(){
    System.out.println("\033[1;1H");
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < maze.length; i ++){
      for (int j = 0; j < maze[i].length; j ++){
        str += maze[i][j];
      }
      str += "\n";
    }
    return str;
  }

  public int solve(){
    if (animate){
      clearTerminal();
    }
    for (int i = 0; i < maze.length; i ++){
      for (int j = 0; j < maze[i].length; j ++){
        if (maze[i][j] == 'S'){
          return solve(i, j);
        }
      }
    }
    return -1;
  }

  public int solve(int row, int col){
    if (animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }
    int mR = row;
    int mC = col;
    for (int i = row-1; i <= row+1; i ++){
      for (int j = col-1; j <= col+1; j ++){
        if (!(i == row ^ j == col)){
          continue;
        }
        if (maze[i][j] == 'E'){
          mR = i;
          mC = j;
          break;
        }
        if (maze[i][j] == ' ' || (maze[i][j] == '@' && mR == row && mC == col)){
          mR = i;
          mC = j;
        }
      }
    }
    if (mR != row || mC != col){
      if (maze[mR][mC] == 'E'){
        maze[row][col] = '@';
        return 1;
      }
      if (maze[mR][mC] == ' '){
        maze[row][col] = '@';
        return solve(mR, mC) + 1;
      }else{
        maze[row][col] = '.';
        return solve(mR, mC) - 1;
      }
    }
    return -1;
  }
}
