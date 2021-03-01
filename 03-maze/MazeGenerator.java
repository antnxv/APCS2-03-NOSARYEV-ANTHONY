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

  }
}
