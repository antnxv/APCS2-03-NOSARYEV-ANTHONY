import java.util.*;
import java.io.*;

public class AntDriver{
  public static void main(String[] args){
    System.out.println("");
    for (String i: args){
      try{
        USACO a = new USACO();
        if (i.charAt(0) == 'B'){
          System.out.println(i+": "+a.bronze("lvls/bronze"+i.substring(1)+".dat"));
        }else if (i.charAt(0) == 'S'){
          System.out.println(i+": "+a.silver("lvls/silver"+i.substring(1)+".dat"));
        }
      }catch (FileNotFoundException e){
      }
    }
  }
}
