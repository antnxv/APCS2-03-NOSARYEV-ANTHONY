import java.util.*;
public class BurnTreesFrontier{
  private int[][]map;
  private Frontier frontier;
  private int ticks;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;

  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }

  //Initialize the simulation.
  public BurnTreesFrontier(int width,int height, double density){
    map = new int[height][width];
    frontier = new Frontier();
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=TREE;
    start();//set the left column on fire.
  }

  //Determine if the simulation is still burning
  public boolean done(){
    return frontier.size() == 0;
  }

  //Advances round (contains all core logic)
  public void tick(){
    int s = frontier.size();
    while (s > 0){
      s--;
      int[] spot = frontier.remove();
      int r = spot[0];
      int c = spot[1];
      map[r][c] = ASH;
      if (r > 0 && map[r-1][c] == TREE){
        map[r-1][c] = FIRE;
        int[] f = {r-1, c};
        frontier.add(f);
      }
      if (r < map.length-1 && map[r+1][c] == TREE){
        map[r+1][c] = FIRE;
        int[] f = {r+1, c};
        frontier.add(f);
      }
      if (c > 0 && map[r][c-1] == TREE){
        map[r][c-1] = FIRE;
        int[] f = {r, c-1};
        frontier.add(f);
      }
      if (c < map[r].length-1 && map[r][c+1] == TREE){
        map[r][c+1] = FIRE;
        int[] f = {r, c+1};
        frontier.add(f);
      }
    }
    ticks ++;
  }

  //Sets the trees in the left column of the forest on fire
  public void start(){
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        int[] f = {i, 0};
        frontier.add(f);
        map[i][0]=FIRE;
      }
    }
  }

  public int getTicks(){
    return ticks;
  }

  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==FIRE)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==ASH)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }

  public static void main(String[]args)  throws InterruptedException{
    int WIDTH = 20;
    int HEIGHT = 20;
    int DELAY = 200;
    double DENSITY = .7;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);

    //System.out.println(b.run());
    System.out.println(b.animate(DELAY));//animate all screens and print the final answer
    //System.out.println(b.outputAll());//print all screens and the final answer
  }
}
