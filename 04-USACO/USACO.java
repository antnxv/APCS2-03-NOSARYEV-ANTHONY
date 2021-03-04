import java.util.*;
import java.io.*;

public class USACO{
  public int bronze(String filename) throws FileNotFoundException{
    Scanner data = new Scanner(new File(filename));
    int R = data.nextInt();
    int C = data.nextInt();
    int E = data.nextInt();
    int N = data.nextInt();
    int[][] map = new int[R][C];
    for (int i = 0; i < R; i ++){
      for (int j = 0; j < C; j ++){
        map[i][j] = data.nextInt();
      }
    }
    for (int z = 0; z < N; z ++){
      int R_s = data.nextInt()-1;
      int C_s = data.nextInt()-1;
      int D_s = data.nextInt();
      int max = 0;
      for (int y = R_s; y < R_s+3; y ++){
        for (int x = C_s; x < C_s+3; x ++){
          if (y >= 0 && y < R && x >= 0 && x < C && map[y][x] > max){
            max = map[y][x];
          }
        }
      }
      for (int y = R_s; y < R_s+3; y ++){
        for (int x = C_s; x < C_s+3; x ++){
          if (y >= 0 && y < R && x >= 0 && x < C && map[y][x] > max-D_s){
            map[y][x] = max-D_s;
          }
        }
      }
    }
    int S = 0;
    for (int y = 0; y < R; y ++){
      for (int x = 0; x < C; x ++){
        if (map[y][x] < E){
          S += E - map[y][x];
        }
      }
    }
    return S*5184; // 36 sq ft in sq inches
  }

  public long silver(String filename){ // NO RECURSION!
    return 0;
    /**With more available steps, paths ripple:

    Mark trees as -1, don't add to updated paths for neighbours

    1 :1

    0 1 0
    1 0 1  :2
    0 1 0

    0 0 1 0 0
    0 1 0 1 0
    1 0 2 0 1 :3
    0 1 0 1 0
    0 0 1 0 0

    0 0 0 1 0 0 0
    0 0 2 0 2 0 0
    0 2 0 4 0 2 0
    1 0 4 0 4 0 1
    0 2 0 4 0 2 0
    0 0 2 0 2 0 0
    0 0 0 1 0 0 0
    **/

  }
}
