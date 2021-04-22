public class MyHeap{
  private static void pushDown(int[] data, int size, int index){
    if (2*index+2 == size && data[2*index+1] > data[index]){
      int temp = data[2*index+1];
      data[2*index+1] = data[index];
      data[index] = temp;
      pushDown(data, size, 2*index+1);
      return;
    }
    if (2*index+1 < size && data[2*index+1] > data[index] ||
        2*index+2 < size && data[2*index+2] > data[index]){
      int ni = (data[2*index+1] > data[2*index+2]) ? 2*index+1 : 2*index+2;
      int temp = data[ni];
      data[ni] = data[index];
      data[index] = temp;
      pushDown(data, size, ni);
    }
  }

  public static void buildHeap(int data[]){
    //filler
  }
}
// children: 2n+1 (left) and 2n+2 (right)
// parent: (n-1)//2 or just (n-1)/2 since ints always floor divide
