import java.util.Arrays;

public class MyHeap{
  private static void pushDown(int[] data, int size, int index){
    int ni;
    if (2*index+2 == size && data[2*index+1] > data[index])
      ni = 2*index+1;
    else if (2*index+2 < size &&
      (data[2*index+1] > data[index] || data[2*index+2] > data[index]))
      ni = (data[2*index+1] > data[2*index+2]) ? 2*index+1 : 2*index+2;
    else return;
    int temp = data[ni];
    data[ni] = data[index];
    data[index] = temp;
    pushDown(data, size, ni);
  }

  public static void buildHeap(int data[]){
    int index = data.length-1;
    while (index >= 0){
      pushDown(data, data.length, index);
      index --;
    }
  }

  private static void remove(int[] data, int size){
    int temp = data[0];
    data[0] = data[size-1];
    data[size-1] = temp;
    size --;
    pushDown(data, size, 0);
  }

  public static void heapsort(int[] data){

  }
}
// children: 2n+1 (left) and 2n+2 (right)
// parent: (n-1)//2 or just (n-1)/2 since ints always floor divide
// n full levels makes 2^n -1 elements
// node is right-most when index+2 is a power of 2
