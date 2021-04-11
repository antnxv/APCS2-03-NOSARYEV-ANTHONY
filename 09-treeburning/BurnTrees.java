import java.util.*;
public class BurnTrees{
  private int[][]map;
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
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=TREE;
    start();//set the left column on fire.
  }

  //Determine if the simulation is still burning
  public boolean done(){
    for(int r = 0; r < map.length; r++){
      for(int c = 0; c < map[r].length; c ++){
        if (map[r][c] == FIRE) return false;
      }
    }
    return true;
  }

  //Advances round (contains all core logic)
  public void tick(){
    int[][] nmap = new int[map.length][map[0].length];
    for(int r = 0; r < nmap.length; r ++){
      for(int c = 0; c < nmap[r].length; c ++){
        if (map[r][c] == FIRE || map[r][c] == ASH){
          nmap[r][c] = ASH;
          continue;
        }else if (map[r][c] == TREE){
          if (r > 0 && map[r-1][c] == FIRE ||
            r < map.length-1 && map[r+1][c] == FIRE ||
            c > 0 && map[r][c-1] == FIRE ||
            c < map[r].length-1 && map[r][c+1] == FIRE){
            nmap[r][c] = FIRE;
          }else{
            nmap[r][c] = TREE;
          }
        }
      }
    }
    map = nmap;
    ticks++;
  }

  //Sets the trees in the left column of the forest on fire
  public void start(){
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
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

    System.out.println(b.animate(DELAY));//animate all screens and print the final answer
    //System.out.println(b.outputAll());//print all screens and the final answer
  }
}
