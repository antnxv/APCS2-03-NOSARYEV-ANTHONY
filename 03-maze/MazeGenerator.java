import java.util.*;
import java.io.*;
public class MazeGenerator{

  public static void generate(char[][] maze){
    int rows = 0;
    int cols = 0;
    for (int i = 0; i < maze.length; i ++){
      rows ++;
      for (int j = 0; j < maze[i].length; j ++){
        if (j+1 > cols) cols = j+1;
      }
    }
    generate(maze, rows, cols, rows/2, cols/2);
  }
  
  public static void generate(char[][] maze, int rows,  int cols, int startrow, int startcol){
    if (startrow != 0 & startrow != rows-1 & startcol != 0 & startcol != cols-1 &
        maze[startrow][startcol] != ' '){
      int opens = 0;
      for (int i = startrow-1; i <= startrow+1; i ++){
        for (int j = startcol-1; j <= startcol+1; j ++){
          if (!(i == startrow ^ j == startcol)){
            continue;
          }
          if (maze[i][j] == ' '){
            opens ++;
          }
        }
      }
      if (opens <= 1){
        maze[startrow][startcol] = ' ';
        String dirs = "0123";
        while (dirs.length() > 0){
          int spot = (int)(dirs.length()*Math.random());
          switch (dirs.charAt(spot)){
            case '0': generate(maze, rows, cols, startrow, startcol+1);
                    break;
            case '1': generate(maze, rows, cols, startrow+1, startcol);
                    break;
            case '2': generate(maze, rows, cols, startrow, startcol-1);
                    break;
            case '3': generate(maze, rows, cols, startrow-1, startcol);
                    break;
          }
          if (spot == dirs.length()-1){
            dirs = dirs.substring(0, spot);
          }else{
            dirs = dirs.substring(0, spot) + dirs.substring(spot+1);
          }
        }
      }
    }
  }

  public static void printMaze(char[][] maze){
    String str = "";
    for (int i = 0; i < maze.length; i ++){
      for (int j = 0; j < maze[i].length; j ++){
        str += maze[i][j];
      }
      str += "\n";
    }
    System.out.println(str);
  }
}
