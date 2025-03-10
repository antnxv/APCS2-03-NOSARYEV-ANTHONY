import java.util.ArrayDeque;

public class Frontier{
  private ArrayDeque<int[]> frontier;

  public Frontier(){
    frontier = new ArrayDeque<int[]>();
  }

  public int size(){
    return frontier.size();
  }

  public void add(int[] location){
    frontier.offer(location);
  }

  public int[] remove(){
    return frontier.poll();
  }
}
